package org.client.bl.orderbl;

import java.util.Date;

import org.client.bl.userbl.UserController;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class Order {
	
	
	public OrderType type;
	
	public String userID;
	
	public Date generatedDate;
	
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
	
	public ResultMessage setOrder (OrderVO vo) {
		this.customerName = vo.customerName;
		UserVO uservo = UserController.getInstance().findbyUserName(customerName);
		this.userID = uservo.ID;
		
		this.type = OrderType.getType(vo.type);
		this.generatedDate = vo.generatedDate;
		this.schFrom = vo.schFrom;
		this.schTo = vo.schTo;
		this.actFrom = vo.actFrom;
		this.actTo = vo.actTo;
		this.latestTime = vo.latestTime;
		this.cancelTime = vo.cancelTime;
		this.hotelAddress = vo.hotelAddress;
		this.orderID = vo.orderID;
		this.hotelName = vo.hotelName;
		this.roomType = RoomType.getType(vo.roomType);
		this.totalPrice = vo.totalPrice;
		this.roomNum = vo.roomNum;
		this.numOfPeople = vo.numOfPeople;
		this.existsChild = vo.existsChild;
		
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage setOrder (OrderPO po) {
		this.userID = po.userId;
		this.customerName = po.customerName;
		
		this.type = po.type;
		this.generatedDate = po.generatedDate;
		this.schFrom = po.schFrom;
		this.schTo = po.schTo;
		this.actFrom = po.actFrom;
		this.actTo = po.actTo;
		this.latestTime = po.latestTime;
		this.cancelTime = po.cancelTime;
		this.hotelAddress = po.hotelAddress;
		this.orderID = po.orderID;
		this.hotelName = po.hotelName;
		this.roomType = po.roomType;
		this.totalPrice = po.totalPrice;
		this.roomNum = po.roomNum;
		this.numOfPeople = po.numOfPeople;
		this.existsChild = po.existsChild;
		
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO getOrderVO () {
		OrderVO vo = new OrderVO(type.getString(),generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelAddress,orderID,hotelName,roomType.getString(),totalPrice,roomNum,numOfPeople,existsChild,customerName);
		return vo;
	}
	
	public OrderPO getOrderPO () {
		OrderPO po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelAddress,orderID,hotelName,roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userID);
		return po;
	}

}
