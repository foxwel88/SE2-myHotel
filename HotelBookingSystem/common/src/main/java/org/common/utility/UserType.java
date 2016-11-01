package org.common.utility;

public enum UserType {
	CUSTOMER("客户"), HOTELMANAGER("酒店工作人员"), WEBMANAGER("网站管理人员"), WEBMARKETER("网站营销人员"); 
	
	private String s;
	
	private UserType(String s) 
	{
		this.s = s;
	}
	
	public String getString() 
	{
		return s;
	}
	
	public UserType getType(String ss) 
	{
		if (ss.equals("客户")) return UserType.CUSTOMER;
		if (ss.equals("酒店工作人员")) return UserType.HOTELMANAGER;
		if (ss.equals("网站管理人员")) return UserType.WEBMANAGER;
		if (ss.equals("网站营销人员")) return UserType.WEBMARKETER;
		return null;
	}
}
