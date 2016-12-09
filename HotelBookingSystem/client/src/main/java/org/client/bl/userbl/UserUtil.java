package org.client.bl.userbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.promotionbl.PromotionController;
import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.LevelVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

/**
 * userbl模块的工具类
 * @author gyue
 * @version 2016/12/8 gyue
 *
 */
public class UserUtil {
	
	private static UserUtil userUtil;
	
	private User user;
	
	private CreditRecord creditRecord;
	
	
	private UserUtil() {
		user = new User();
		creditRecord = new CreditRecord();
	}
	
	public static UserUtil getInstance() {
		if (userUtil == null) {
			userUtil = new UserUtil();
		}
		return userUtil;
	}
	
	public ResultMessage add(UserVO vo) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		user = user.initbyVO(vo);
		UserPO po = user.getUserPO();
		ResultMessage message = null;
		try {
			message = dao.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return message;
	}
	
	public UserVO findbyID(String ID) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		UserPO po = null;
		try {
			po = dao.findbyID(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new UserVO(ResultMessage.CONNECTION_FAIL);
		}
		if (po == null) {
			return new UserVO(ResultMessage.NOT_EXIST);
		}
		user = user.initbyPO(po);
		return user.getUserVO();
	}
	
	public UserVO findbyUserName(String userName) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		UserPO po = null;
		try {
			po = dao.findbyUserName(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new UserVO(ResultMessage.CONNECTION_FAIL);
		}
		if (po == null) {
			return new UserVO(ResultMessage.NOT_EXIST);
		}
		user = user.initbyPO(po);
		return user.getUserVO();
	}
	
	public ResultMessage addCreditRecord (CreditRecordVO vo) {
		// 增加用户属性的信用值
		ResultMessage message = null;
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		String id = vo.userId;
		UserVO userVO = findbyID(id);
		UserPO userPO = null;
		user = user.initbyVO(userVO);
		userPO = user.changeCredit(vo.change);
		try {
			message = dao.modify(userPO);
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		if (message != ResultMessage.SUCCESS) {
			return message;
		}
		
		//增加信用记录
		creditRecord = creditRecord.initbyVO(vo);
		CreditRecordPO po = creditRecord.getCreditRecordPO(vo);
		try {
			message = dao.addCreditRecord(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		//如果增加信用记录失败，删除刚刚增加的用户的信用值
		if (message != ResultMessage.SUCCESS) {
			userPO = user.changeCredit(-2 * vo.change);
			try {
				message = dao.modify(userPO);
			} catch (RemoteException e1) {
				e1.printStackTrace();
				return ResultMessage.CONNECTION_FAIL;
			}
			if (message != ResultMessage.SUCCESS) {
				return message;
			}
			return ResultMessage.WRONG_VALUE;
		}
		
		return message;
	}
	
	public List<CreditRecordVO> findCreditRecord(String ID) {
		CreditRecordList list = new CreditRecordList();
		list.initList(ID);
		return list.getVOs();
	}
	
	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		ResultMessage message = null;
		UserVO vo = null;
		UserPO po = null;
		//检查旧密码是否正确
		try {
			message = dao.Check(userName, oldPassword);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		if (message != ResultMessage.SUCCESS) {
			return message;
		}
		//修改密码
		vo = findbyUserName(userName);
		user = user.initbyVO(vo);
		po = user.modifyPassword(newPassword);
		try {
			message = dao.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return message;
	}
	
	public ResultMessage modify(UserVO vo) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		UserPO po = null;
		user = user.initbyVO(vo);
		po = user.modify(vo);
		ResultMessage message = null;
		try {
			message = dao.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return message;
	}
	
	public UserLevelVO getLevel(String userName) {
		UserVO userVO = findbyUserName(userName);
		if (userVO.resultMessage != ResultMessage.SUCCESS) {
			return new UserLevelVO(ResultMessage.NOT_EXIST);
		}
		
		Promotionblservice promotionbl = PromotionController.getInstance();
		LevelVO levelVO = promotionbl.showLevel();
		int level = 0;
		double credit = userVO.credit;
		while (credit >= levelVO.credits.get(level)) {
			level++;
		}
		return new UserLevelVO(credit, level);
	}

	public ResultMessage deleteUser(String userName) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		try {
			return dao.deleteUser(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}

}
