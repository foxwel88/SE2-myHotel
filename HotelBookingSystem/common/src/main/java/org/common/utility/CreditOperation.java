package org.common.utility;

public enum CreditOperation {
	FINISHORDER("执行订单"), EXCEPTIONORDER("恢复异常订单"), CANCELORER("撤销订单"), RECHARGE("信用充值"), ABNORMALORDER("异常订单");
	
	private String s;
	
	private CreditOperation(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public static CreditOperation getType(String ss) {
		if (ss.equals("执行订单")) {
			return CreditOperation.FINISHORDER;
		}
		if (ss.equals("恢复异常订单")) {
			return CreditOperation.EXCEPTIONORDER;
		}
		if (ss.equals("撤销订单")) {
			return CreditOperation.CANCELORER;
		}
		if (ss.equals("信用充值")) {
			return CreditOperation.RECHARGE;
		}
		if (ss.equals("异常订单")) {
			return CreditOperation.ABNORMALORDER;
		}
		return null;
	}
}
