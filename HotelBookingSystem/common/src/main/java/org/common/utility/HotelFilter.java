package org.common.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 酒店搜索的过滤器
 * @author Hirico
 * @version 2016/12/05 Hirico
 */
public class HotelFilter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -421561104499778313L;
	
	public List<String> livedHotelIDs;
	
	public String hotelName;
	
	public int minStar = 0;
	
	public int maxStar = 5;
	
	public double minRank = 0.0;
	
	public double maxRank = 5.0;
	
	public double minPrice = 0.0;
	
	public double maxPrice = Double.MAX_VALUE;
	
	public String city;
	
	public String area; 
	
	public Date schFrom;

	public Date schTo;
	
	public RoomType roomType;
	
	public int roomNum = 1;

	public void setHotelName(String name) {
		if (name != null) {
			if (!name.isEmpty()) {
				this.hotelName = name;
			}
		}
	}
	
	public void setLowerRank(double min) {
		minRank = min;
	}
	
	public void setUpperRank(double max) {
		maxRank = max;
	}
	
	public void setLowerPrice(double min) {
		minPrice = min;
	}
	
	public void setUpperPrice(double max) {
		maxPrice = max;
	}
	
	public void setLowerStar(int min) {
		minStar = min;
	}
	
	public void setUpperStar(int max) {
		maxStar = max;
	}
	
	public void setRoomType(RoomType type) {
		roomType = type;
	}
	
	public void setRoomNum(int num) {
		roomNum = num;
	}
	
	public void setHistory(List<String> livedHotelIDs) {
		this.livedHotelIDs = new ArrayList<>(livedHotelIDs);
	}
	
	public void setLocation(String city, String area) {
		this.city = city;
		this.area = area;
	}
	
	public void setSchFromDate (Date date) {
		this.schFrom = date;
	}
	
	public void setSchToDate (Date date) {
		this.schTo = date;
	}
}
