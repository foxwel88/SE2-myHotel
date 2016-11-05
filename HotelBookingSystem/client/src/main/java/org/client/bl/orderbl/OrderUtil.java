package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.hotelbl.Hotel;
import org.client.rmi.RMIHelper;
import org.client.vo.OrderVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.HotelPO;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderUtil {
	
	private static OrderUtil util;
	
	private static OrderDataService dao;
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
	}
	
	public static OrderUtil getInstance() {
		if (util == null) {
			util = new OrderUtil();
		}
		return util;
	}
	
	
	public ResultMessage createOrder(OrderVO vo) {
		Order myorder = new Order();
		myorder.setOrder(vo);
		OrderPO po = myorder.getOrderPO();
		try {
			return dao.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
	}
	
	public OrderVO getOrder (String orderID) {
		Order myorder = new Order();
		try {
			myorder.setOrder(dao.getOrderPO(orderID));
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
		return null;
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
	
	public ResultMessage cancelOrder () {
		return null;
	}
	
	public ResultMessage executeOrder () {
		return null;
	}
	
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		return null;
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

}
