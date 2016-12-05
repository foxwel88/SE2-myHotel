package org.common.po;

import java.io.Serializable;

public class HotelPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3937802063959755822L;

	public String id;

	public String hotelName;

	public String address;
	
	public String city;
	
	public String area;
	
	public String introduction;
	
	public double rank;
	
	public int star;
	
	public String facility;
	
	public String checkInInfos;
	
	public String cooperators;
	
	public HotelPO(String id, String hotelName, String address, String city, String area, String introduction,
			double rank, int star, String facility, String checkInInfos, String cooperators) {
		this.id = id;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.area = area;
		this.introduction = introduction;
		this.rank = rank;
		this.star = star;
		this.facility = facility;
		this.checkInInfos = checkInInfos;
		this.cooperators = cooperators;
	}
	
	
}
