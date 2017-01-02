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

	private static final int LATEST_CANCEL_TIME_IN_SECONDS = 6 * 60 * 60; //在最晚执行时间之前的这个时间之后再撤销，会扣除信用值
	
	protected OrderDataService dao;
	
	protected TimeService timeDao;
	
	protected Userblservice userController;
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
		userController = UserController.getInstance();
		timeDao = RMIHelper.getInstance().getTimeServiceImpl();
		
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

	/*
	通过orderID 获取orderVO
	 */
	public OrderVO getOrder (String orderID) {
		Order myOrder = new Order();
		try {
			OrderPO resPO = dao.getOrderPO(orderID);
			if (resPO == null) {
				OrderVO vo = new OrderVO(ResultMessage.NOT_EXIST);
				return vo;
			}
			myOrder.setOrder(resPO);
			return myOrder.getOrderVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			OrderVO vo = new OrderVO(ResultMessage.CONNECTION_FAIL);
			return vo;
		}
	}

	/*
	获得异常订单列表
	 */
	public List<OrderVO> getAbnormalOrder () {
		OrderList myList = new OrderList();
		try {
			myList.setOrderList(dao.getAbnormalOrderPO());
			return myList.getOrderListVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	通过用户userID 和 orderType 来获得该用户该类型订单的的列表
	 */
	public List<OrderVO> getUserOrderList (String userID, OrderType type) {		
		OrderList myList = new OrderList();
		try {
			myList.setOrderList(dao.getUserOrderPO(userID, type));
			return myList.getOrderListVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	通过酒店orderID 和 orderType 来获得该酒店该类型订单的的列表
	 */
	public List<OrderVO> getHotelOrderList (String hotelID, OrderType type) {
		OrderList myList = new OrderList();
		try {
			myList.setOrderList(dao.getHotelOrderPO(hotelID, type));
			return myList.getOrderListVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	通过用户userID 来获得该用户历史预订过的酒店id列表
	 */
	public List<String> getHistoryHotels(String userId) {
		OrderList myList = new OrderList();
		try {
			myList.setOrderList(dao.getUserOrderPO(userId, OrderType.EXECUTED));
			return myList.getHotelList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	通过orderVO 来新建一个订单
	 */
	public ResultMessage createOrder(OrderVO vo) {
		UserVO userVO = userController.findbyID(vo.userID);
		if (userVO.credit <= 0) {
			return ResultMessage.CREDIT_NOT_ENOUGH;
		}
		Order myOrder = new Order();
		myOrder.setOrder(vo);
		return myOrder.create();
	}

	/*
	通过orderVO 来新建一个线下订单
	 */
	public ResultMessage createOffLineOrder(OrderVO vo) {
		Order myOrder = new Order();
		myOrder.setOrder(vo);
		return myOrder.create();
	}

	/*
	通过orderID 来对该订单做撤销操作
	 */
	public ResultMessage cancelOrder (String orderID) {
		OrderPO orderPO = null;
		try {
			orderPO = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		Order myOrder = new Order();
		myOrder.setOrder(orderPO);
		ResultMessage executeMessage = myOrder.cancel();
		if (executeMessage != ResultMessage.SUCCESS) {
			return executeMessage;
		}

		//检查是否过晚撤销
		try {
			long between = (myOrder.latestTime.getTime() - timeDao.getDate().getTime()) / 1000;
			if (between <= LATEST_CANCEL_TIME_IN_SECONDS) {
				myOrder.addCreditRecord(-myOrder.totalPrice, CreditOperation.CANCELORDER.getString());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	/*
	通过orderID 来对该订单做执行操作
	 */
	public ResultMessage executeOrder (String orderID) {
		OrderPO orderPO = null;
		try {
			orderPO = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		Order myOrder = new Order();
		myOrder.setOrder(orderPO);
		ResultMessage executeMessage = myOrder.execute();
		if (executeMessage != ResultMessage.SUCCESS) {
			return executeMessage;
		}
		
		myOrder.addCreditRecord(myOrder.totalPrice, CreditOperation.FINISHORDER.getString());
		return ResultMessage.SUCCESS;
	}

	/*
	通过orderID 来对该订单做撤销异常订单操作，并恢复一半或全部的信用值
	 */
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		Order myOrder = new Order();
		OrderPO orderPO = null;
		try {
			orderPO = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		myOrder.setOrder(orderPO);
		ResultMessage cancelMessage = myOrder.cancelAbnormal();
		if (cancelMessage != ResultMessage.SUCCESS) {
			return cancelMessage;
		}
		
		double temp = myOrder.totalPrice;
		if (isHalf) {
			temp = temp / 2.0;
		}
		myOrder.addCreditRecord(temp, CreditOperation.EXCEPTIONORDER.getString());
		return ResultMessage.SUCCESS;
	}

	/*
	通过orderID 来对该订单做退房操作
	 */
	public ResultMessage checkOut(String ID) {
		OrderPO po = null;
		try {
			po = dao.getOrderPO(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		Order myOrder = new Order();
		myOrder.setOrder(po);
		ResultMessage checkOutMessage = myOrder.checkOut();
		if (checkOutMessage != ResultMessage.SUCCESS) {
			return checkOutMessage;
		}
		return ResultMessage.SUCCESS;
	}

	/*
	通过orderID 来对该订单做标记已评论的操作
	 */
	public ResultMessage comment(String orderID) {
		OrderPO po = null;
		try {
			po = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		Order myOrder = new Order();
		myOrder.setOrder(po);
		return myOrder.comment();
	}

	/*
	通过酒店 hotelID 房间类型 roomType 起始和结束日期 fromDate toDate 来获得给定日期内该酒店该房间类型已被预订的房间数量
	算法是对中间每天作为起始日期的订单进行比对、统计
	 */
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromDate, Date toDate) {
		Calendar startDay = new GregorianCalendar();
		startDay.setTime(fromDate);
		Calendar stopDay = new GregorianCalendar();
		stopDay.setTime(toDate);
		int[] res = new int[10000];  //安全起见开了一个大数组，不过日期选择其实已经由界面层做过一次范围限制
		int n = 0;
		while (startDay.compareTo(stopDay) != 0) {
			OrderList myList = new OrderList();
			try {
				Date nowDate = startDay.getTime();
				myList.setOrderList(dao.getDateOrderPO(hotelID, nowDate));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			res[n] = myList.getTypeRoomNum(roomType);
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
}
