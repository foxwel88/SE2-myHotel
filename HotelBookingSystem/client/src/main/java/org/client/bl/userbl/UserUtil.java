package org.client.bl.userbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

public class UserUtil {
	
	private static UserUtil userUtil;
	
	private User user;
	
	private UserUtil() {
		user = new User();
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
		}
		user = user.initbyPO(po);
		return user.getUserVO();
	}
	
	public ResultMessage addCreditRecord (CreditRecordVO vo) {
		return null;
	}
	
	public List<CreditRecordVO> findCreditRecord(String ID) {
		CreditRecordList list = new CreditRecordList();
		list.initList(ID);
		return list.getVOs();
	}
	
	public ResultMessage modifyPassword(String userName, String oldPassWord, String newPassWord) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		ResultMessage message = null;
		UserVO vo = null;
		UserPO po = null;
		//检查密码是否正确
		try {
			message = dao.Check(userName, oldPassWord);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (message != ResultMessage.SUCCESS) {
			return message;
		}
		//检查新密码格式
		if (!checkPasswordFormat(newPassWord)) {
			return ResultMessage.WRONGFORMAT;
		}
		//修改密码
		vo = findbyUserName(userName);
		user = user.initbyVO(vo);
		po = user.modifyPassword(newPassWord);
		try {
			message = dao.modify(po);
		} catch (RemoteException e) {
			e.printStackTrace();
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
		}
		return message;
	}
	
	private boolean checkPasswordFormat(String password) {
		if (password.length() <= 6) {
			return false;
		}
		for (int i = 0; i < password.length(); ++i) {
			char ch = password.charAt(i);
			if (!(('0' <= ch && ch <= '9') || ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'))) {
				return false;
			}
		}
		return true;
	}
}
