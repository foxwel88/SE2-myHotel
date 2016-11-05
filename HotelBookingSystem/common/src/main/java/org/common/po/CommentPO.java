package org.common.po;

import java.io.Serializable;
import java.util.Date;

public class CommentPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 395760586893993456L;

	public String userName;
	
	public String hotelAddress;
	
	public Date date;
	
	public int rank;
	
	public String comment;
	
	public CommentPO(String UserName, String hotelAddress, Date date, int rank, String comment) {
		this.userName = UserName;
		this.hotelAddress = hotelAddress;
		this.date = date;
		this.rank = rank;
		this.comment = comment;
	}
}
