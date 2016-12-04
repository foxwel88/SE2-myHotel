package org.client.vo;

import java.io.Serializable;
import java.util.Date;

import org.common.utility.ResultMessage;

public class OrderVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8958928454707420061L;

	public String userID;
	
	public String type;
	
	public Date generatedDate;
	
	public Date schFrom;
	
	public Date schTo;
	
	public Date actFrom;
	
	public Date actTo;
	
	public Date latestTime;
	
	public Date cancelTime;
	
	public String hotelID;
	
	public String hotelName;

	public String orderID;
	
	public String hotelAddress;
	
	public String roomType;
	
	public double totalPrice;
	
	public int roomNum;
	
	public int numOfPeople;
	
	public boolean existsChild;
	
	public String customerName;
	
	public String phoneNumber;
	
	public ResultMessage resultMessage;
	
	public OrderVO(String userID, String type, Date generatedDate, Date schFrom, Date schTo, Date actFrom, Date actTo,
			Date latestTime, Date cancelTime, String hotelID, String hotelName, String orderID,
			String hotelAddress, String roomType, double totalPrice, int roomNum, int numOfPeople, boolean existsChild,
			String customerName, String phoneNumber) {
		this.userID = userID;
		this.type = type;
		this.generatedDate = generatedDate;
		this.schFrom = schFrom;
		this.schTo = schTo;
		this.actFrom = actFrom;
		this.actTo = actTo;
		this.latestTime = latestTime;
		this.cancelTime = cancelTime;
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.orderID = orderID;
		this.hotelAddress = hotelAddress;
		this.roomType = roomType;
		this.totalPrice = totalPrice;
		this.roomNum = roomNum;
		this.numOfPeople = numOfPeople;
		this.existsChild = existsChild;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public OrderVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
