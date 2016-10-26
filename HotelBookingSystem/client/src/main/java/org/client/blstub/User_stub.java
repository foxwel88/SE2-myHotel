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
	UserVO uservo=new UserVO(UserType.CUSTOMER,"Tom","汤姆","1234567890","1111111111","132323232323",100,new Date(),null,2,10,null);
	
	public ResultMessage login(String userName, String password) {
		// TODO Auto-generated method stub
		if (userName.equals("123")&&password.equals("111111111111111111")) 
		{
			return ResultMessage.SUCCESS;
		}else return ResultMessage.WRONGPASSWORD;
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
		
		return uservo;
	}

	public UserVO findbyUserName(String userName) {
		// TODO Auto-generated method stub
		return uservo;
	}

	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword) {
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
		CreditRecordVO vo1=new CreditRecordVO(new Date(), "13232323232323232323", 100, 200, CreditOperation.RECHARGE); 
		CreditRecordVO vo2=new CreditRecordVO(new Date(), "13232323232323232323", 100, 200, CreditOperation.RECHARGE); 
		ArrayList<CreditRecordVO> vo=new ArrayList<CreditRecordVO>();
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

}
