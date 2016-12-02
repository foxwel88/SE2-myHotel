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

	public String type; 
	
	public Date startTime;
	
	public Date endTime;
	
	public String hotelName;
	
	public String hotelID;
	
	public int level;
	
	public String area;
	
	public double discount;
	
	public String name;
	
	public ResultMessage resultMessage;
	
	public PromotionVO(String promotionID, String type, Date startTime, Date endTime, String hotelName, String hotelID,
			int level, String area, double discount, String name) {
		this.promotionID = promotionID;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hotelName = hotelName;
		this.hotelID = hotelID;
		this.level = level;
		this.area = area;
		this.discount = discount;
		this.name = name;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public PromotionVO() {
		
	}
	
	public PromotionVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
