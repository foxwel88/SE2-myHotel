package org.common.po;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.PromotionType;

public class PromotionPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6351683109312938710L;
	
	public String promotionID;

	public PromotionType type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public String hotelAddress;
	
	public int level;
	
	public String area;
	
	public double discount;
	
	public String name;
	
	public PromotionPO(String promotionID, PromotionType type, Date startTime, Date endTime, String hotelName, String hotelAddress, int level, String area, double discount, String name) {
		this.promotionID = promotionID;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.level = level;
		this.area = area;
		this.discount = discount;
		this.name = name;
	}

}
