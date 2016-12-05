package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class CommentVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7340680975558493014L;

	public String userName;
	
	public String hotelAdrress;
	
	public Date date;
	
	public double rank;
	
	public String comment;
	
	public ResultMessage resultMessage;
	
	public CommentVO(String UserName, String hotelAdrress, Date date, double rank, String comment) {
		this.userName = UserName;
		this.hotelAdrress = hotelAdrress;
		this.date = date;
		this.rank = rank;
		this.comment = comment;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public CommentVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
