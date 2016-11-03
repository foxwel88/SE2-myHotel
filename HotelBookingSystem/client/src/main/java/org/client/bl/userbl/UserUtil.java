package org.client.bl.userbl;

import java.util.List;

import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class UserUtil {
	
	private static UserUtil userUtil;
	
	private UserUtil(){}
	
	public static UserUtil getInstance() {
		if(userUtil == null) {
			userUtil = new UserUtil();
		}
		return userUtil;
	}
	
	public ResultMessage add(UserVO vo) {
		return null;
	}
	
	public UserVO findbyID(String ID) {
		return null;
	}
	
	public UserVO findbyUserName(String userName) {
		return null;
	}
	
	public ResultMessage addCreditRecord (CreditRecordVO vo) {
		return null;
	}
	
	public List<CreditRecordVO> findCreditRecord(String ID) {
		CreditRecordList list = new CreditRecordList();
		list.initList(ID);
		return list.getVOs();
	}
	
	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword){
		return null;
	}
	
	public ResultMessage modify(UserVO vo){
		return null;
	}
}
