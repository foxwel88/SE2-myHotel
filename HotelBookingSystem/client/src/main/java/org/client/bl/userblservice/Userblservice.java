package org.client.bl.userblservice;

import java.util.ArrayList;

import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public interface Userblservice {
	public ResultMessage login(String userName, String password);
	
	public ResultMessage logout(String ID);
	
	public ResultMessage add(UserVO vo);
	
	public UserVO findbyID(String ID);
	
	public UserVO findbyUserName(String userName);
	
	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword);
	
	public ResultMessage modify(UserVO vo);
	
	public ResultMessage addCreditRecord (CreditRecordVO vo);
	
	public ArrayList<CreditRecordVO> findCreditRecord(String ID);
	
	
}
