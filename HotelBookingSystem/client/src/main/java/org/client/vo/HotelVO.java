package org.client.vo;

import java.io.Serializable;
import java.util.ArrayList;

import org.common.utility.RoomType;

public class HotelVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3889821127700593872L;

	public String hotelName;

	public String address;
	
	public String city;
	
	public String area;
	
	public String introduce;
	
	public double rank;
	
	public int star;
	
	public String facility;
	
	public String checkInInfos;
	
	public ArrayList<RoomType> roomType;
	
	public ArrayList<Integer> roomNum;
	
	public ArrayList<Double> roomPrice;
	public HotelVO(String hotelName, String address, String city, String area, String introduce,
			double rank, int star, String facility, String checkInInfos, ArrayList<RoomType> roomType,
			ArrayList<Integer> roomNum, ArrayList<Double> roomPrice) {
		
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.area = area;
		this.introduce = introduce;
		this.rank = rank;
		this.star = star;
		this.facility = facility;
		this.checkInInfos = checkInInfos;
		if (roomType==null) this.roomType=null;else this.roomType = new ArrayList<RoomType>(roomType);
		if (roomNum==null) this.roomNum=null;else this.roomNum = new ArrayList<Integer>(roomNum);
		if (roomPrice==null) this.roomPrice=null;else this.roomPrice = new ArrayList<Double>(roomPrice);
	}
	
}
