package org.common.po;

import java.io.Serializable;
import java.sql.Date;

import org.common.utility.PromotionType;

public class PromotionPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6351683109312938710L;

	public PromotionType type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public int level;
	
	public String area;
	
	public double discount;
	
	public PromotionPO(PromotionType type, Date startTime, Date endTime, String hotelName,
			int level, String area, double discount) {
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelName = hotelName;
		this.level = level;
		this.area = area;
		this.discount = discount;
	}

}
