package org.client.bl.userbl;

import java.util.List;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class UserController implements Userblservice {

	public ResultMessage login(String userName, String password) {
		// TODO Auto-generated method stub
		return Account.getInstance().login(userName, password);
	}

	public ResultMessage logout(String ID) {
		// TODO Auto-generated method stub
		return Account.getInstance().logout(ID);
	}

	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().add(vo);
	}

	public UserVO findbyID(String ID) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().findbyID(ID);
	}

	public UserVO findbyUserName(String userName) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().findbyUserName(userName);
	}

	public ResultMessage modifyPassword(String userName,
			String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().modifyPassword(userName, oldPassword, newPassword);
	}

	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().modify(vo);
	}

	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().addCreditRecord(vo);
	}

	public List<CreditRecordVO> findCreditRecord(String ID) {
		// TODO Auto-generated method stub
		return UserUtil.getInstance().findCreditRecord(ID);
	}
	
}
