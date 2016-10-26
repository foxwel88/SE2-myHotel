package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.OrderType;
import org.common.utility.RoomType;

public class OrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8958928454707420061L;

	public OrderType type;
	
	public Data generatedData;
	
	public Date schFrom;
	
	public Date schTo;
	
	public Date actFrom;
	
	public Date actTo;
	
	public Date latestTime;
	
	public Date cancelTime;
	
	public String hotelAddress;
	
	public String orderID;
	
	public String hotelName;
	
	public RoomType roomType;
	
	public double totalPrice;
	
	public int roomNum;
	
	public int numOfPeople;
	
	public boolean existsChild;
	
	public String customerName;
	
	public OrderVO(OrderType type, Data generatedData, Date schFrom, Date schTo, Date actFrom, Date actTo,
			Date latestTime, Date cancelTime, String hotelAddress, String orderID,
			String hotelName, RoomType roomType, double totalPrice, int roomNum, int numOfPeople, boolean existsChild, String customerName) {
		this.type = type;
		this.generatedData = generatedData;
		this.schFrom = schFrom;
		this.schTo = schTo;
		this.actFrom = actFrom;
		this.actTo = actTo;
		this.latestTime = latestTime;
		this.cancelTime = cancelTime;
		this.hotelAddress = hotelAddress;
		this.orderID = orderID;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.totalPrice = totalPrice;
		this.roomNum = roomNum;
		this.numOfPeople = numOfPeople;
		this.existsChild = existsChild;
		this.customerName = customerName;
	}
}
