package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class PromotionVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1774019741909946616L;
	
	public String promotionID;
	
	public String provider;

	public String type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public String hotelID;
	
	public int level;
	
	public String city;
	
	public String area;
	
	public double discount;
	
	public String name;
	
	public PromotionVO(String promotionID, String provider, String type, Date startTime, Date endTime, String hotelName, String hotelID,
			int level, String city, String area, double discount, String name) {
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
	
	public PromotionVO() {
		
	}

}
