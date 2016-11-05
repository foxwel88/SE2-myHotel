package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class CreditRecordVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973211069096098122L;

	public Date date;
	
	public String orderID;
	
	public String userId;
	
	public double change;
	
	public double result;
	
	public String op;
	
	public ResultMessage resultMessage;
	
	public CreditRecordVO(Date date, String orderID, String userID, double change, double result, String op) {
		this.date = date;
		this.orderID = orderID;
		this.userId = userID;
		this.change = change;
		this.result = result;
		this.op = op;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public CreditRecordVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
