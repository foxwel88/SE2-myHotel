package org.common.po;

import java.io.Serializable;

public class HotelPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3937802063959755822L;

	public String hotelName;

	public String address;
	
	public String city;
	
	public String area;
	
	public String introduce;
	
	public double rank;
	
	public int star;
	
	public String facility;
	
	public String checkInInfos;
	
	public HotelPO(String hotelName, String address, String city, String area, String introduce,
			double rank, int star, String facility, String checkInInfos) {
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.area = area;
		this.introduce = introduce;
		this.rank = rank;
		this.star = star;
		this.facility = facility;
		this.checkInInfos = checkInInfos;
	}
	
	
}
