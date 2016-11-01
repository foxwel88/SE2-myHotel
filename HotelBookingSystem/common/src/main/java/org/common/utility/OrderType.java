package org.common.utility;

public enum OrderType {

	UNEXECUTED("1"), EXECUTED("2"), CANCELED("3"), ABNORMAL("异常订单");
	private String s;
	private OrderType(String ss) {
		this.s = ss;
	}
	
	public String getstring()
	{
		return s;
	}
	
	public OrderType gettype(String ss)
	{
		if(ss.equals("异常订单"))
		return OrderType.ABNORMAL;
		return null;
	}
}
