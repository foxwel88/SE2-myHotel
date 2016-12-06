package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.common.utility.TimeService;

/**
 * 
 * bl层order模块的order类
 * 用于存放一个order 并在vo po之间转化
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class Order {
	
	private OrderDataService dao;
	
	private TimeService timedao;
	
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
	
	public String hotelName;
	
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
		this.dao = OrderUtil.getInstance().dao;
		this.timedao = OrderUtil.getInstance().timedao;
	}
	
	public ResultMessage setOrder (OrderVO vo) {
		this.orderID = vo.orderID;
		this.type = OrderType.getType(vo.type);
		
		this.generatedDate = vo.generatedDate;
		this.schFrom = vo.schFrom;
		this.schTo = vo.schTo;
		this.actFrom = vo.actFrom;
		this.actTo = vo.actTo;
		this.latestTime = vo.latestTime;
		this.cancelTime = vo.cancelTime;
		
		this.userID = vo.userID;
		this.customerName = vo.customerName;
		
		this.hotelID = vo.hotelID;
		this.hotelName = vo.hotelName;
		this.hotelAddress = vo.hotelAddress;
		this.roomType = RoomType.getType(vo.roomType);
		this.roomNum = vo.roomNum;
		this.totalPrice = vo.totalPrice;
		
		this.numOfPeople = vo.numOfPeople;
		this.existsChild = vo.existsChild;
		this.phoneNumber = vo.phoneNumber;
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage setOrder (OrderPO po) {
		this.orderID = po.orderID;
		this.type = po.type;
		
		this.generatedDate = po.generatedDate;
		this.schFrom = po.schFrom;
		this.schTo = po.schTo;
		this.actFrom = po.actFrom;
		this.actTo = po.actTo;
		this.latestTime = po.latestTime;
		this.cancelTime = po.cancelTime;
		
		this.userID = po.userId;
		this.customerName = po.customerName;
		
		this.hotelID = po.hotelID;
		this.hotelName = po.hotelName;
		this.hotelAddress = po.hotelAddress;
		this.roomType = po.roomType;
		this.roomNum = po.roomNum;
		this.totalPrice = po.totalPrice;
		
		this.numOfPeople = po.numOfPeople;
		this.existsChild = po.existsChild;
		this.phoneNumber = po.phoneNumber;
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage modify() {
		try {
			return dao.modify(getOrderPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	public ResultMessage create() {
		try {
			generatedDate = timedao.getDate();
			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			orderID = userID + timeFormat.format(generatedDate);
			return dao.add(getOrderPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	public ResultMessage execute() {
		if ((type != OrderType.UNEXECUTED) && (type != OrderType.ABNORMAL)) {
			return ResultMessage.NOT_EXIST;
		}
		type = OrderType.EXECUTED;
		try {
			actFrom = timedao.getDate();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return modify();
	}
	
	public ResultMessage cancel() {
		if (type != OrderType.UNEXECUTED) {
			return ResultMessage.NOT_EXIST;
		}
		type = OrderType.CANCELED;
		try {
			cancelTime = timedao.getDate();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return modify();
	}
	
	public ResultMessage cancelAbnormal() {
		if (type != OrderType.ABNORMAL) {
			return ResultMessage.NOT_EXIST;
		}
		type = OrderType.UNEXECUTED;
		return modify();
	}
	
	public OrderVO getOrderVO () {
		OrderVO vo = new OrderVO(userID,type.getString(),generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,roomType.getString(),totalPrice,roomNum,numOfPeople,existsChild,customerName,phoneNumber);
		return vo;
	}
	
	public OrderPO getOrderPO () {
		OrderPO po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userID,phoneNumber);
		return po;
	}

}
