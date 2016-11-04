package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.PromotionType;

public class PromotionVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1774019741909946616L;

	public String type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public int level;
	
	public String area;
	
	public double discount;
	
	public String name;
	
	public PromotionVO(String type, Date startTime, Date endTime, String hotelName,
			int level, String area, double discount, String name) {
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelName = hotelName;
		this.level = level;
		this.area = area;
		this.discount = discount;
		this.name = name;
	}
}
