package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.CreditOperation;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.common.utility.TimeService;


/**
 * 
 * bl层order模块的工具类
 * @author Foxwel
 * @version 2016/12/5 Foxwel
 * 
 */

public class OrderUtil {
	
	private static OrderUtil util;
	
	protected OrderDataService dao;
	
	protected TimeService timedao;
	
	protected Userblservice userController;
	
	protected HotelHelper hotelHelper;
	
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
		userController = UserController.getInstance();
		hotelHelper = HotelController.getInstance();
		timedao = RMIHelper.getInstance().getTimeServiceImpl();
	}
	
	public static OrderUtil getInstance() {
		if (util == null) {
			util = new OrderUtil();
		}
		return util;
	}
	
	public void setUserblservice(Userblservice userController) {
		this.userController = userController;
	}
	
	public void setHotelHelper(HotelHelper hotelHelper) {
		this.hotelHelper = hotelHelper;
	}
	
	public OrderVO getOrder (String orderID) {
		Order myorder = new Order();
		try {
			OrderPO respo = dao.getOrderPO(orderID);
			if (respo == null) {
				OrderVO vo = new OrderVO(ResultMessage.NOT_EXIST);
				return vo;
			}
			myorder.setOrder(respo);
			return myorder.getOrderVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			OrderVO vo = new OrderVO(ResultMessage.CONNECTION_FAIL);
			return vo;
		}
	}
	
	public List<OrderVO> getAbnormalOrder () {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getAbnormalOrderPO());
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OrderVO> getUserOrderList (String userID, OrderType type) {		
		OrderList mylist = new OrderList();
		try {
			if (dao.getUserOrderPO(userID, type).get(0) == null) {
			}
			mylist.setOrderList(dao.getUserOrderPO(userID, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OrderVO> getHotelOrderList (String hotelID, OrderType type) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getHotelOrderPO(hotelID, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> getHistoryHotels(String userId) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getUserOrderPO(userId, OrderType.EXECUTED));
			return mylist.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		UserVO uservo = userController.findbyID(vo.userID);
		if (uservo.credit <= 0) {
			return ResultMessage.CREDIT_NOT_ENOUGH;
		}
		
		ResultMessage message = hotelHelper.decreaseAvailableRoom(RoomType.getType(vo.roomType), vo.hotelID, vo.roomNum);
		if (message != ResultMessage.SUCCESS) {
			return message;
		}
		
		Order myorder = new Order();
		myorder.setOrder(vo);
		return myorder.create();
	}
	
	public ResultMessage cancelOrder (String orderID) {
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		Order myorder = new Order();
		myorder.setOrder(orderpo);
		ResultMessage excuteMessage = myorder.cancel();
		if (excuteMessage != ResultMessage.SUCCESS) {
			return excuteMessage;
		}
		
		myorder.addCreditRecord(-myorder.totalPrice, CreditOperation.CANCELORER.getString());
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage executeOrder (String orderID) {
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		Order myorder = new Order();
		myorder.setOrder(orderpo);
		ResultMessage excuteMessage = myorder.execute();
		if (excuteMessage != ResultMessage.SUCCESS) {
			return excuteMessage;
		}
		
		myorder.addCreditRecord(myorder.totalPrice, CreditOperation.FINISHORDER.getString());
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		myorder.setOrder(orderpo);
		ResultMessage cancelMessage = myorder.cancelAbnormal();
		if (cancelMessage != ResultMessage.SUCCESS) {
			return cancelMessage;
		}
		
		double temp = myorder.totalPrice;
		if (isHalf) {
			temp = temp / 2.0;
		}
		myorder.addCreditRecord(temp, CreditOperation.EXCEPTIONORDER.getString());
		return ResultMessage.SUCCESS;
	}

	
	public ResultMessage checkOut(String ID) {
		OrderPO po = null;
		try {
			po = dao.getOrderPO(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order myorder = new Order();
		myorder.setOrder(po);
		ResultMessage checkOutMessage = myorder.checkOut();
		if (checkOutMessage != ResultMessage.SUCCESS) {
			return checkOutMessage;
		}
		hotelHelper.increaseAvailableRoom(myorder.roomType, myorder.hotelID, myorder.roomNum);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage comment(String orderID) {
		OrderPO po = null;
		try {
			po = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order myorder = new Order();
		myorder.setOrder(po);
		return myorder.comment();
	}
}
