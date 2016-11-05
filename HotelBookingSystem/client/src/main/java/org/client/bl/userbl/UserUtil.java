package org.client.bl.userbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
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
		user = user.initbyVO(vo);
		UserPO po = user.getUserPO();
		ResultMessage message = null;
		try {
			message = RMIHelper.getInstance().getUserDataServiceImpl().add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public UserVO findbyID(String ID) {
		UserPO po = null;
		try {
			po = RMIHelper.getInstance().getUserDataServiceImpl().findbyID(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		user = user.initbyPO(po);
		return user.getUserVO();
	}
	
	public UserVO findbyUserName(String userName) {
		UserPO po = null;
		try {
			po = RMIHelper.getInstance().getUserDataServiceImpl().findbyUserName(userName);
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
}
