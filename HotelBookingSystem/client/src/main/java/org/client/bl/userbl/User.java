package org.client.bl.userbl;

import java.util.List;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class User implements Userblservice{

	public ResultMessage login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage logout(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO findbyID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO findbyUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CreditRecordVO> findCreditRecord(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
