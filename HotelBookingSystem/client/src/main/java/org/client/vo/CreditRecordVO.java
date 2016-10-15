package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.CreditOperation;

public class CreditRecordVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973211069096098122L;

	public Date date;
	
	public String orderID;
	
	public double change;
	
	public double result;
	
	public CreditOperation op;
	
	public CreditRecordVO(Date date, String orderID, double change, double result, CreditOperation op){
		this.date = date;
		this.orderID = orderID;
		this.change = change;
		this.result = result;
		this.op = op;
	}
}
