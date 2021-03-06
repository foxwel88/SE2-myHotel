package org.client.vo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class HotelVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3889821127700593872L;

	public String id;

	public String hotelName;

	public String address;
	
	public CityVO city;
	
	public AreaVO area;
	
	public String introduction;
	
	public double rank;
	
	public int star;
	
	public String facility;
	
	public String checkInInfos;
	
	public List<String> roomType;
	
	public List<Integer> roomNum;
	
	public List<Double> roomPrice;
	
	public List<String> cooperators;

	public String imgURL;
	
	public HotelVO(String id, String hotelName, String address, CityVO city, AreaVO area, String introduction,
			double rank, int star, String facility, String checkInInfos, List<String> roomType,
			List<Integer> roomNum, List<Double> roomPrice, List<String> cooperators, String imgURL) {

		this.id = id;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.area = area;
		this.introduction = introduction;
		DecimalFormat df = new DecimalFormat("#.00");
		df.format(rank);
		this.rank = rank;
		this.star = star;
		this.facility = facility;
		this.checkInInfos = checkInInfos;
		if (roomType == null) {
			this.roomType = null;
		} else {
			this.roomType = new ArrayList<>(roomType);
		}
		if (roomNum == null) {
			this.roomNum = null;
		} else {
			this.roomNum = new ArrayList<>(roomNum);
		}
		if (roomPrice == null) {
			this.roomPrice = null;
		} else {
			this.roomPrice = new ArrayList<>(roomPrice);
		}
		if (cooperators == null) {
			this.cooperators = null;
		} else {
			this.cooperators = new ArrayList<>(cooperators);
		}
		if (imgURL == null) {
			this.imgURL = null;
		} else {
			this.imgURL = imgURL;
		}
	}

	
}
