package org.client.bl.userbl;

import java.util.List;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class UserController implements Userblservice {
	
	private static UserController controller;
	
	private UserController() {
		
	}
	
	public static UserController getInstance() {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}

	public ResultMessage login(String userName, String password) {
		return Account.getInstance().login(userName, password);
	}

	public ResultMessage logout(String ID) {
		return Account.getInstance().logout(ID);
	}

	public ResultMessage add(UserVO vo) {
		return UserUtil.getInstance().add(vo);
	}

	public UserVO findbyID(String ID) {
		return UserUtil.getInstance().findbyID(ID);
	}

	public UserVO findbyUserName(String userName) {
		return UserUtil.getInstance().findbyUserName(userName);
	}

	public ResultMessage modifyPassword(String userName,
			String oldPassword, String newPassword) {
		return null;
	}

	public ResultMessage modify(UserVO vo) {
		return null;
	}

	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return UserUtil.getInstance().addCreditRecord(vo);
	}

	public List<CreditRecordVO> findCreditRecord(String ID) {
		return UserUtil.getInstance().findCreditRecord(ID);
	}
	
}
