package org.common.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotelFilter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -421561104499778313L;
	
	public List<String> livedAddresses;
	
	public int minStar = -1;
	
	public int maxStar = -1;
	
	public double minRank = -1;
	
	public double maxRank = -1;
	
	public double minPrice = -1;
	
	public double maxPrice = -1;
	
	public String city;
	
	public String area; 
	
	public RoomType roomType;
	
	public int roomNum = -1;
	
	@Deprecated
	public void setRank(double min, double max) {
		minRank = min;
		maxRank = max;
	}
	
	@Deprecated
	public void setPrice(double min, double max) {
		minPrice = min;
		maxPrice = max;
	}
	
	@Deprecated
	public void setStar(int min, int max) {
		minStar = min;
		maxStar = max;
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
	
	public void setHistory(List<String> addresses) {
		this.livedAddresses = new ArrayList<>(addresses);
	}
	
	public void setLocation(String city, String area) {
		this.city = city;
		this.area = area;
	}
}
