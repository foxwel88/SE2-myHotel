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
	
	public String provider;

	public PromotionType type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public String hotelID;
	
	public int level;
	
	public String city;
	
	public String area;
	
	public double discount;
	
	public String name;
	
	public PromotionPO(String promotionID, String provider, PromotionType type, Date startTime, Date endTime, String hotelName, String hotelID, int level, String city, String area, double discount, String name) {
		this.promotionID = promotionID;
		this.provider = provider;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelName = hotelName;
		this.hotelID = hotelID;
		this.level = level;
		this.city = city;
		this.area = area;
		this.discount = discount;
		this.name = name;
	}

}
