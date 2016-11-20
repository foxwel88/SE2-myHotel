package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class UserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1767049142801881395L;

	public String type;
	
	public String userName;
	
	public String name;
	
	public String ID;
	
	public String passWord;
	
	public String phoneNumber;
	
	public double credit;
	
	public Date birthday;
	
	public String companyName;
	
	public String hotelAddress;
	
	public ResultMessage resultMessage;
	
	public UserVO(String type, String userName, String name, String ID, String passWord,
			String phoneNumber, double credit, Date birthday, String companyName, String hotelAddress) {
		this.type = type;
		this.userName = userName;
		this.name = name;
		this.ID = ID;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.credit = credit;
		this.birthday = birthday;
		this.companyName = companyName;
		this.hotelAddress = hotelAddress;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public UserVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
