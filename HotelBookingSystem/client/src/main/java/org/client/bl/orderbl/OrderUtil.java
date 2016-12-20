package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
 * @version 2016/12/20 Foxwel
 * 
 */

public class OrderUtil {
	
	private static OrderUtil util;
	
	protected OrderDataService dao;
	
	protected TimeService timedao;
	
	protected Userblservice userController;
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
		userController = UserController.getInstance();
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
			//if (dao.getUserOrderPO(userID, type).size() != 0) {
			mylist.setOrderList(dao.getUserOrderPO(userID, type));
			//}
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
			//if (dao.getHotelOrderPO(hotelID, type).size() != 0) {
			mylist.setOrderList(dao.getHotelOrderPO(hotelID, type));
			//}
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
		Order myorder = new Order();
		myorder.setOrder(vo);
		return myorder.create();
	}
	
	public ResultMessage createOffLineOrder(OrderVO vo) {
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

	public int getRestRoom(String hotelID, RoomType roomType, Date fromDate, Date toDate) {
		Calendar startDay = new GregorianCalendar();
		startDay.setTime(fromDate);
		Calendar stopDay = new GregorianCalendar();
		stopDay.setTime(toDate);
		int[] res = new int[10000];
		int n = 0;
		while (startDay.compareTo(stopDay) != 0) {
			OrderList mylist = new OrderList();
			try {
				Date nowDate = startDay.getTime();
				mylist.setOrderList(dao.getDateOrderPO(hotelID, nowDate));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res[n] = mylist.getTypeRoomNum(roomType);
			++n;
			startDay.add(Calendar.DATE, 1);
		}
		int maxn = 0;
		for (int i = 0; i < n; ++i) {
			if (res[i] > maxn) {
				maxn = res[i];
			}
		}
		
		return maxn;
	}



	/*
	public static void main(String[] args) throws ParseException {
		System.out.println("start");
		RMIHelper.getInstance().init();
		System.out.println("end");
		OrderUtil test = new OrderUtil();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fromDate = null;
		Date toDate = null;
		fromDate = dateFormat.parse("2016-12-18 00:00:00");
		toDate = dateFormat.parse("2016-12-20 00:00:00");
		System.out.println(test.getRestRoom("00001", RoomType.DOUBLE, fromDate, toDate));
	}
	*/
}
