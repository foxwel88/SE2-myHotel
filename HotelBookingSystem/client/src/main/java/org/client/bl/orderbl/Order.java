package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.OrderVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.common.utility.TimeService;

/**
 * 
 * bl层order模块的order类
 * 用于存放一个order 并在VO PO之间转化
 * @author Foxwel
 * @version 2017/1/1 Foxwel
 * 
 */

public class Order {
	
	private OrderDataService dao;
	
	private TimeService timeDao;
	
	private Userblservice userbl;
	
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
	
	public boolean isCommented;
	
	public boolean isCheckedOut;
	
	public Order() {
		this.dao = OrderUtil.getInstance().dao;
		this.timeDao = OrderUtil.getInstance().timeDao;
		this.userbl = OrderUtil.getInstance().userController;
	}

	/*
	通过OrderVO来初始化该Order对象的内容
	 */
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
		
		this.isCommented = vo.isCommented;
		this.isCheckedOut = vo.isCheckedOut;
		
		return ResultMessage.SUCCESS;
	}

	/*
	通过OrderPO来初始化该Order对象的内容
	 */
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
		
		this.isCommented = po.isCommented;
		this.isCheckedOut = po.isCheckedOut;
		
		return ResultMessage.SUCCESS;
	}

	/*
	对该订单做更新操作，将新的数据持久化到数据库中
	 */
	public ResultMessage modify() {
		try {
			return dao.modify(getOrderPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	public ResultMessage create() {
		try {
			generatedDate = timeDao.getDate();
			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			if (type == OrderType.OFFLINE) {
				orderID = "00000" + hotelID + timeFormat.format(generatedDate);
			} else {
				orderID = userID + timeFormat.format(generatedDate);
			}
			return dao.add(getOrderPO());
		} catch (RemoteException e) {
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
			actFrom = timeDao.getDate();
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return modify();
	}
	
	public ResultMessage checkOut() {
		if (type != OrderType.EXECUTED) {
			return ResultMessage.WRONG_ORDER_TYPE;
		}
		this.isCheckedOut = true;
		try {
			actTo = timeDao.getDate();
		} catch (RemoteException e) {
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
			cancelTime = timeDao.getDate();
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return modify();
	}
	
	public ResultMessage cancelAbnormal() {
		if (type != OrderType.ABNORMAL) {
			return ResultMessage.NOT_EXIST;
		}
		type = OrderType.CANCELED;
		return modify();
	}

	public ResultMessage comment() {
		isCommented = true;
		return modify();
	}

	/*
	通用的修改信用方法，通过修改值和修改类型，来对该用户做信用变更操作
	 */
	public ResultMessage addCreditRecord(Double value, String type) {
		CreditRecordVO creditrecordvo;
		try {
			creditrecordvo = new CreditRecordVO(timeDao.getDate(), orderID, userID, value, userbl.findbyID(userID).credit + value, type);
			userbl.addCreditRecord(creditrecordvo);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}

	/*
	将order对象中的信息导出成OrderVO
	 */
	public OrderVO getOrderVO () {
		OrderVO vo = new OrderVO(userID,type.getString(),generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,roomType.getString(),totalPrice,roomNum,numOfPeople,existsChild,customerName,phoneNumber,isCommented,isCheckedOut);
		return vo;
	}

	/*
	将order对象中的信息导出成OrderPO
	 */
	public OrderPO getOrderPO () {
		OrderPO po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userID,phoneNumber,isCommented,isCheckedOut);
		return po;
	}


}
