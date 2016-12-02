package org.client.bl.orderbl;

import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * 
 * bl层order模块的order类
 * 用于存放一个order 并在vo po之间转化
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class Order {
	
	public Userblservice userController;
	
	public OrderType type;
	
	public String userID;
	
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
	
	public Order() {
		this.userController = OrderUtil.getInstance().userController;
	}
	
	public ResultMessage setOrder (OrderVO vo) {
		this.userID = vo.userID;
		this.customerName = vo.customerName;
		UserVO uservo = userController.findbyUserName(customerName);
		this.userID = uservo.ID;
		
		this.type = OrderType.getType(vo.type);
		this.generatedDate = vo.generatedDate;
		this.schFrom = vo.schFrom;
		this.schTo = vo.schTo;
		this.actFrom = vo.actFrom;
		this.actTo = vo.actTo;
		this.latestTime = vo.latestTime;
		this.cancelTime = vo.cancelTime;
		this.hotelID = vo.hotelID;
		this.orderID = vo.orderID;
		this.hotelAddress = vo.hotelAddress;
		this.roomType = RoomType.getType(vo.roomType);
		this.totalPrice = vo.totalPrice;
		this.roomNum = vo.roomNum;
		this.numOfPeople = vo.numOfPeople;
		this.existsChild = vo.existsChild;
		
		this.phoneNumber = vo.phoneNumber;
		
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
		this.hotelID = po.hotelID;
		this.orderID = po.orderID;
		this.hotelAddress = po.hotelAddress;
		this.roomType = po.roomType;
		this.totalPrice = po.totalPrice;
		this.roomNum = po.roomNum;
		this.numOfPeople = po.numOfPeople;
		this.existsChild = po.existsChild;
		
		this.phoneNumber = po.phoneNumber;
		
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO getOrderVO () {
		OrderVO vo = new OrderVO("i'm a userid",type.getString(),generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,orderID,hotelAddress,roomType.getString(),totalPrice,roomNum,numOfPeople,existsChild,customerName,phoneNumber);
		return vo;
	}
	
	public OrderPO getOrderPO () {
		OrderPO po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,orderID,hotelAddress,roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userID,phoneNumber);
		return po;
	}

}
