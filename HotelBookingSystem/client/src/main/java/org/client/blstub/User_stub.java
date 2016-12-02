package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.utility.CreditOperation;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

public class User_stub implements Userblservice {
	@SuppressWarnings("deprecation")
	Date date = new Date("1997/1/1");
	
	UserVO personalCustomer = new UserVO(UserType.PERSONALCUSTOMER.getString(),
			"Tom","汤姆","0000000001","456","132323232323",
			100,date,null,null,null);
	
	UserVO companyCustomer = new UserVO(UserType.COMPANYCUSTOMER.getString(),
			"Tony","托尼","0000000011","456","13989829292",
			500,date,"南京大学",null, null);
	
	UserVO webMarketer = new UserVO(UserType.WEBMARKETER.getString(),
			"Bob","鲍勃","0000000021","456","132323232323",
			100,new Date(),null,null, null);
	
	UserVO webManager = new UserVO(UserType.WEBMANAGER.getString(),
			"Sam","山姆","0000000111","456","132323232323",
			100,new Date(),null,null, null);
	
	UserVO hotelManager = new UserVO(UserType.HOTELMANAGER.getString(),
			"Mac","苹果","0000012345","456","13515571828",
			100,new Date(),null, "123", "南京大学大酒店");
	
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
		
		return personalCustomer;
	}

	public UserVO findbyUserName(String userName) {
		// TODO Auto-generated method stub
		switch(userName) {
			case "123" :
				return personalCustomer;
			case "webManager" :
				return webManager;
			case "webMarketer" :
				return webMarketer;
			case "hotelManager" :
				return hotelManager;
		}
		if (userName.equals("Tom")) {
			return personalCustomer;
		}
		if (userName.equals("Tony")) {
			return companyCustomer;
		}
		if (userName.equals("Bob")) {
			return webMarketer;
		}
		if (userName.equals("Sam")) {
			return webManager;
		}
		if (userName.equals("Mac")) {
			return hotelManager;
		}
		UserVO vo = new UserVO(ResultMessage.NOT_EXIST);
		return vo;
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
		ArrayList<CreditRecordVO> vo = new ArrayList<>();
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

	@Override
	public UserLevelVO getLevel(String ID) {
		// TODO Auto-generated method stub
		UserLevelVO levelvo = new UserLevelVO(200, 1);
		return levelvo;
	}

	@Override
	public String getNewID() {
		// TODO Auto-generated method stub
		return "0000012314";
	}

}
