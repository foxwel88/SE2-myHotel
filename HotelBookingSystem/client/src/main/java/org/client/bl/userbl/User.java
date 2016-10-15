package org.client.bl.userbl;

import java.util.ArrayList;

import org.client.bl.userblservice.Userblservice;

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

	public ArrayList<CreditRecordVO> findCreditRecord(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
