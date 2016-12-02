package org.common.po;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.OrderType;
import org.common.utility.RoomType;

public class OrderPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8891258690284845208L;

	public OrderType type;
	
	public String userId;
	
	public Date generatedDate;
	
	public Date schFrom;
	
	public Date schTo;
	
	public Date actFrom;
	
	public Date actTo;
	
	public Date latestTime;
	
	public Date cancelTime;
	
	public String hotelID;
	
	public String orderID;

	public String hotelAddress;

	public RoomType roomType;
	
	public double totalPrice;
	
	public int roomNum;
	
	public int numOfPeople;
	
	public boolean existsChild;
	
	public String customerName;
	
	public String phoneNumber;
	
	public OrderPO(OrderType type, Date generatedDate, Date schFrom, Date schTo, Date actFrom, Date actTo,
			Date latestTime, Date cancelTime, String hotelID, String orderID,
			String hotelAddress, RoomType roomType, double totalPrice, int roomNum, int numOfPeople, boolean existsChild, String customerName,
			String userId, String phoneNumber) {
		this.type = type;
		this.generatedDate = generatedDate;
		this.schFrom = schFrom;
		this.schTo = schTo;
		this.actFrom = actFrom;
		this.actTo = actTo;
		this.latestTime = latestTime;
		this.cancelTime = cancelTime;
		this.hotelID = hotelID;
		this.orderID = orderID;
		this.hotelAddress = hotelAddress;
		this.roomType = roomType;
		this.totalPrice = totalPrice;
		this.roomNum = roomNum;
		this.numOfPeople = numOfPeople;
		this.existsChild = existsChild;
		this.customerName = customerName;
		this.userId = userId;
		this.phoneNumber = phoneNumber;
	}
	
	
	

}
