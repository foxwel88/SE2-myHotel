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
 * @version 2016/12/31 Foxwel
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

	/*
	通过orderVO 来新建一个订单
	 */

	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderutil.createOrder(vo);
	}

	/*
	通过orderID 来对该订单做撤销操作
	 */

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.cancelOrder(orderID);
	}

	/*
	通过orderID 获取orderVO
	 */

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return orderutil.getOrder(ID);
	}

	/*
	获得异常订单列表
	 */

	public List<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return orderutil.getAbnormalOrder();
	}

	/*
	通过用户userID 和 orderType 来获得该用户该类型订单的的列表
	 */

	public List<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		return orderutil.getUserOrderList(userID, type);
	}

	/*
	通过酒店orderID 和 orderType 来获得该酒店该类型订单的的列表
	 */

	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		return orderutil.getHotelOrderList(hotelID, type);
	}


	/*
	通过orderID 来对该订单做执行操作
	 */

	public ResultMessage executeOrder(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.executeOrder(orderID);
	}

	/*
	通过orderID 来对该订单做撤销异常订单操作
	 */

	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		// TODO Auto-generated method stub
		return orderutil.cancelAbnormalOrder(orderID,isHalf);
	}

	/*
	通过用户userID 来获得该用户历史预订过的酒店id列表
	 */

	public List<String> getHistoryHotels(String userId) {
		// TODO Auto-generated method stub
		return orderutil.getHistoryHotels(userId);
	}

	/*
	通过orderID 来对该订单做退房操作
 	*/

	@Override
	public ResultMessage checkOut(String ID) {
		// TODO Auto-generated method stub
		return orderutil.checkOut(ID);
	}

	/*
	通过orderID 来对该订单做标记已评论的操作
	 */

	@Override
	public ResultMessage comment(String orderID) {
		// TODO Auto-generated method stub
		return orderutil.comment(orderID);
	}

	/*
	通过酒店 hotelID 房间类型 roomType 起始和结束日期 fromDate toDate 来获得给定日期内该酒店该房间类型已被预订的房间数量
	 */

	@Override
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromdate, Date todate) {
		// TODO Auto-generated method stub
		return orderutil.getBookedRoomNum(hotelID, roomType, fromdate, todate);
	}


	/*
	通过orderVO 来新建一个线下订单
	 */

	@Override
	public ResultMessage createOffLineOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderutil.createOffLineOrder(vo);
	}

	
}
