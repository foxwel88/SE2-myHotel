package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.CreditOperation;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

public class User_stub implements Userblservice {
	UserVO customer = new UserVO(UserType.CUSTOMER.getString(),
			"Tom","汤姆","1234567890","456","132323232323",
			100,new Date(),null,2,10,null);
	
	UserVO webMarketer = new UserVO(UserType.WEBMARKETER.getString(),
			"Tom","TOM","1234567890","456","132323232323",
			100,new Date(),null,2,10,null);
	
	UserVO webManager = new UserVO(UserType.WEBMANAGER.getString(),
			"Tom","TOM","1234567890","456","132323232323",
			100,new Date(),null,2,10,null);
	
	UserVO hotelManager = new UserVO(UserType.HOTELMANAGER.getString(),
			"Tom","TOM","1234567890","456","132323232323",
			100,new Date(),null,2,10,null);
	
	public ResultMessage login(String userName, String password) {
		// TODO Auto-generated method stub
		if ((userName.equals("123") || userName.equals("hotelManager") || userName.equals("webManager")
				|| userName.equals("webMarketer")) && password.equals("456")) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.WRONG_PASSWORD;
		}
	}

	public ResultMessage logout(String ID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public UserVO findbyID(String ID) {
		// TODO Auto-generated method stub
		
		return customer;
	}

	public UserVO findbyUserName(String userName) {
		// TODO Auto-generated method stub
		switch(userName) {
			case "123" :
				return customer;
			case "webManager" :
				return webManager;
			case "webMarketer" :
				return webMarketer;
			case "hotelManager" :
				return hotelManager;
			
		}
		return null;
	}

	public ResultMessage modifyPassword(String userName, 
			String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ArrayList<CreditRecordVO> findCreditRecord(String ID) {
		// TODO Auto-generated method stub
		CreditRecordVO vo1 = new CreditRecordVO(new Date(),
				"13232323232323232323", "1234567890", 100, 200, 
				CreditOperation.RECHARGE.getString()); 
		CreditRecordVO vo2 = new CreditRecordVO(new Date(),
				"13232323232323232323", "1234567890", 100, 200, 
				CreditOperation.RECHARGE.getString()); 
		ArrayList<CreditRecordVO> vo = new ArrayList<CreditRecordVO>();
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

}
