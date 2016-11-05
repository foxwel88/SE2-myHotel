package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class CommentVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7340680975558493014L;

	public String UserName;
	
	public String hotelAdress;
	
	public Date date;
	
	public int rank;
	
	public String comment;
	
	public ResultMessage resultMessage;
	
	public CommentVO(String UserName, String hotelAdress, Date date, int rank, String comment) {
		this.UserName = UserName;
		this.hotelAdress = hotelAdress;
		this.date = date;
		this.rank = rank;
		this.comment = comment;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public CommentVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
