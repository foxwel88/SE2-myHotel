package org.client.bldriver;

import java.util.Date;

import org.client.blstub.User_stub;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.CreditOperation;
import org.common.utility.UserType;

public class Userblservice_driver {
	
	public static void main(String[] args){
		User_stub stub = new User_stub();
		System.out.println(stub.login("123","111111111111111111"));
		System.out.println(stub.logout("321"));
		System.out.println(stub.add(new UserVO(UserType.CUSTOMER.getString(), "123", "123", "123", "312", "ce", 1.1, new Date(), "2142ew", 5, 6.6, "sad")));
		System.out.println(stub.findbyID("qfw"));
		System.out.println(stub.findbyUserName("sfd"));
		System.out.println(stub.modifyPassword("das", "sac", "hjm"));
		System.out.println(stub.modify(new UserVO(UserType.CUSTOMER.getString(), "123", "123", "123", "312", "ce", 1.1, new Date(), "2142ew", 5, 6.6, "sad")));
		System.out.println(stub.addCreditRecord (new CreditRecordVO(new Date(), "sdf", 1.8, 9.9, CreditOperation.RECHARGE.getString())));
		System.out.println(stub.findCreditRecord("ouiy"));
	}
}
