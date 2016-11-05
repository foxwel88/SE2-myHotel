package org.common.utility;

import java.util.ArrayList;
import java.util.List;

public class HotelFilter {
	
	public boolean livedOnly = false;
	
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
	
	public void setRank(double min, double max) {
		minRank = min;
		maxRank = max;
	}
	
	public void setPrice(double min, double max) {
		minPrice = min;
		maxPrice = max;
	}
	
	public void setStar(int min, int max) {
		minStar = min;
		maxStar = max;
	}
	
	public void setRoomType(RoomType type) {
		roomType = type;
	}
	
	public void setRoomNum(int num) {
		roomNum = num;
	}
	
	public void setHistory(List<String> addresses) {
		livedOnly = true;
		this.livedAddresses = new ArrayList<String>(addresses);
	}
	
	public void setLocation(String city, String area) {
		this.city = city;
		this.area = area;
	}
}
