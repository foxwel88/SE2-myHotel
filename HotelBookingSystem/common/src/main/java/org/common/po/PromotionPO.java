package org.common.po;

import java.io.Serializable;
import java.sql.Date;

import org.common.utility.PromotionType;

public class PromotionPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PromotionType type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public int level;
	
	public String area;
	
	public double discount;

}
