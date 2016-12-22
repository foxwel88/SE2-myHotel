package org.client.bl.orderbl;

import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * 
 * bl层Order模块的接口分发
 * @author Foxwel
 * @version 2016/12/20 Foxwel
 * 
 */

public class OrderController implements Orderblservice {

	private static OrderController controller;
	
	private OrderUtil orderutil;
	
	private OrderController() {
		orderutil = OrderUtil.getInstance();
	}
	
	public static OrderController getInstance() {
		if (controller == null) {
			controller = new OrderController();
		}
		return controller;
	}
	
	public void setUserblservice(Userblservice userController) {
		this.orderutil.setUserblservice(userController);
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderutil.createOrder(vo);
	}

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.cancelOrder(orderID);
	}

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return orderutil.getOrder(ID);
	}

	public List<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return orderutil.getAbnormalOrder();
	}

	public List<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		return orderutil.getUserOrderList(userID, type);
	}

	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		return orderutil.getHotelOrderList(hotelID, type);
	}

	public ResultMessage executeOrder(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.executeOrder(orderID);
	}

	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		// TODO Auto-generated method stub
		return orderutil.cancelAbnormalOrder(orderID,isHalf);
	}

	public List<String> getHistoryHotels(String userId) {
		// TODO Auto-generated method stub
		return orderutil.getHistoryHotels(userId);
	}

	@Override
	public ResultMessage checkOut(String ID) {
		// TODO Auto-generated method stub
		return orderutil.checkOut(ID);
	}

	@Override
	public ResultMessage comment(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.comment(orderID);
	}

	@Override
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromdate, Date todate) {
		// TODO Auto-generated method stub
		return orderutil.getRestRoom(hotelID, roomType, fromdate, todate);
	}

	@Override
	public ResultMessage createOffLineOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderutil.createOffLineOrder(vo);
	}

	
}
