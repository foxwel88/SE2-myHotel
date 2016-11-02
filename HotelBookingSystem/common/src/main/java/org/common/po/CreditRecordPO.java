package org.common.po;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.CreditOperation;

public class CreditRecordPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7475283577458918690L;

	public Date date;
	
	public String orderID;
	
	public String userId;
	
	public double change;
	
	public double result;
	
	public CreditOperation op;
	
	public CreditRecordPO(Date date, String orderID, double change, double result, CreditOperation op, String userId){
		this.date = date;
		this.orderID = orderID;
		this.change = change;
		this.result = result;
		this.op = op;
		this.userId = userId;
	}
}
