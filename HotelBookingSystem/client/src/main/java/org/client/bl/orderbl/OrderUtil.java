package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.HotelVO;
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
 * @version 2016/11/27 Foxwel
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
	
	private boolean check(OrderVO vo) {
		if (vo.phoneNumber.length() != 11) {
			return false;
		}
		
		for (int i = 0; i < 11; ++i) {
			if (!((vo.phoneNumber.charAt(i) <= '9') && (vo.phoneNumber.charAt(i) >= '0'))) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkOrderID(String ID) {
		if (ID.length() != 24) {
			return false;
		}
	
		for (int i = 0; i < 11; ++i) {
			if (!((ID.charAt(i) <= '9') && (ID.charAt(i) >= '0'))) {
				return false;
			}
		}
		
		return true;
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		Order myorder = new Order();
		
		UserVO uservo = userController.findbyUserName(vo.customerName);
		
		if (uservo.credit <= 0) {
			return ResultMessage.CREDIT_NOT_ENOUGH;
		}
		
		if (!check(vo)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		HotelVO hotelvo = hotelHelper.getHotelVO(vo.hotelAddress);
		
		if (hotelvo.roomType != null) {
			ResultMessage message = hotelHelper.decreaseAvailableRoom(RoomType.getType(vo.roomType), vo.hotelAddress);
			if (message != ResultMessage.SUCCESS) {
				return message;
			}
		} else {
			return ResultMessage.WRONG_FORMAT;
		}
		
		myorder.setOrder(vo);
		return myorder.create();
	}
	
	public OrderVO getOrder (String orderID) {
		
		if (!checkOrderID(orderID)) {
			OrderVO vo = new OrderVO(ResultMessage.WRONG_FORMAT);
			return vo;
		}
		
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
			mylist.setOrderList(dao.getUserOrderPO(userID, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OrderVO> getHotelOrderList (String hoteladdress, OrderType type) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getHotelOrderPO(hoteladdress, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultMessage cancelOrder (String orderID) {
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		myorder.setOrder(orderpo);
		return myorder.cancel();
	}
	
	public ResultMessage executeOrder (String orderID) {
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		myorder.setOrder(orderpo);
		ResultMessage excuteMessage = myorder.execute();
		if (excuteMessage != ResultMessage.SUCCESS) {
			return excuteMessage;
		}

		UserVO uservo = userController.findbyID(myorder.userID);
		CreditRecordVO creditrecordvo = null;
		try {
			creditrecordvo = new CreditRecordVO(timedao.getDate(), myorder.orderID, myorder.userID, myorder.totalPrice, uservo.credit + (myorder.totalPrice), CreditOperation.FINISHORDER.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return userController.addCreditRecord(creditrecordvo);
	}
	
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
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
		
		UserVO uservo = userController.findbyID(myorder.userID);
		
		double temp = myorder.totalPrice / 2.0;
		if (isHalf) {
			temp = temp / 2.0;
		}
		
		CreditRecordVO creditrecordvo;
		try {
			creditrecordvo = new CreditRecordVO(timedao.getDate(), myorder.orderID, uservo.ID, temp, uservo.credit + temp, CreditOperation.EXCEPTIONORDER.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}

		return userController.addCreditRecord(creditrecordvo);
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
		if (myorder.type != OrderType.EXECUTED) {
			return ResultMessage.WRONG_ORDER_TYPE;
		}
		try {
			myorder.actTo = timedao.getDate();
			dao.modify(myorder.getOrderPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return ResultMessage.CONNECTION_FAIL;
		}
		return hotelHelper.increaseAvailableRoom(myorder.roomType, myorder.hotelAddress);
	}
}
