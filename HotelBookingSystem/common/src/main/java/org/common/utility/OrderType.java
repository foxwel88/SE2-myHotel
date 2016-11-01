package org.common.utility;

public enum OrderType {

	UNEXECUTED("未执行订单"), EXECUTED("已执行订单"), CANCELED("已撤销订单"), ABNORMAL("异常订单");
	
	private String s;
	
	private OrderType(String s) 
	{
		this.s = s;
	}
	
	public String getString() 
	{
		return s;
	}
	
	public OrderType getType(String ss) 
	{
		if (ss.equals("未执行订单")) return OrderType.UNEXECUTED;
		if (ss.equals("已执行订单")) return OrderType.EXECUTED;
		if (ss.equals("已撤销订单")) return OrderType.CANCELED;
		if (ss.equals("异常订单")) return OrderType.ABNORMAL;
		return null;
	}
}
