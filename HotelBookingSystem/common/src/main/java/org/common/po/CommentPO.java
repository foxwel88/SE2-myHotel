package org.common.po;

import java.io.Serializable;
import java.util.Date;

public class CommentPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 395760586893993456L;

	public String UserName;
	
	public String hotelAdress;
	
	public Date date;
	
	public int rank;
	
	public String comment;
	
	public CommentPO(String UserName, String hotelAdress, Date date, int rank, String comment){
		this.UserName = UserName;
		this.hotelAdress = hotelAdress;
		this.date = date;
		this.rank = rank;
		this.comment = comment;
	}
}
