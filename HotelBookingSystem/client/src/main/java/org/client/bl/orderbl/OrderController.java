package org.client.bl.orderbl;

import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.OrderBlService;
import org.client.blservice.userblservice.UserBlService;
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

public class OrderController implements OrderBlService {

	private static OrderController controller;
	
	private OrderUtil orderUtil;
	
	private OrderController() {
		orderUtil = OrderUtil.getInstance();
	}
	
	public static OrderController getInstance() {
		if (controller == null) {
			controller = new OrderController();
		}
		return controller;
	}

	public void setUserblservice(UserBlService userController) {
		this.orderUtil.setUserblservice(userController);
	}

	/*
	通过orderVO 来新建一个订单
	 */
	@Override
	public ResultMessage createOrder(OrderVO vo) {
		return orderUtil.createOrder(vo);
	}

	/*
	通过orderID 来对该订单做撤销操作
	 */
	@Override
	public ResultMessage cancelOrder(String orderID) {
		return orderUtil.cancelOrder(orderID);
	}

	/*
	通过orderID 获取orderVO
	 */
	@Override
	public OrderVO getOrder(String orderID) {
		return orderUtil.getOrder(orderID);
	}

	/*
	获得所有异常订单列表
	 */
	@Override
	public List<OrderVO> getAbnormalOrder() {
		return orderUtil.getAbnormalOrder();
	}

	/*
	通过用户userID 和 orderType 来获得该用户该类型订单的的列表
	 */
	@Override
	public List<OrderVO> getUserOrderList(String userID, OrderType type) {
		return orderUtil.getUserOrderList(userID, type);
	}

	/*
	通过酒店hotelID 和 orderType 来获得该酒店该类型订单的的列表
	 */
	@Override
	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		return orderUtil.getHotelOrderList(hotelID, type);
	}


	/*
	通过orderID 来对该订单做执行操作
	 */
	@Override
	public ResultMessage executeOrder(String orderID) {
		return orderUtil.executeOrder(orderID);
	}

	/*
	通过orderID 来对该订单做撤销异常订单操作
	 */
	@Override
	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		return orderUtil.cancelAbnormalOrder(orderID,isHalf);
	}

	/*
	通过用户userID 来获得该用户历史预订过的酒店id列表
	 */
	@Override
	public List<String> getHistoryHotels(String userId) {
		return orderUtil.getHistoryHotels(userId);
	}

	/*
	通过orderID 来对该订单做退房操作
 	*/
	@Override
	public ResultMessage checkOut(String orderID) {
		return orderUtil.checkOut(orderID);
	}

	/*
	通过orderID 来对该订单做标记已评论的操作
	 */
	@Override
	public ResultMessage comment(String orderID) {
		return orderUtil.comment(orderID);
	}

	/*
	通过酒店 hotelID 房间类型 roomType 起始和结束日期 fromDate toDate 来获得给定日期内该酒店该房间类型已被预订的房间数量
	 */
	@Override
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromDate, Date toDate) {
		return orderUtil.getBookedRoomNum(hotelID, roomType, fromDate, toDate);
	}


	/*
	通过orderVO 来新建一个线下订单
	 */
	@Override
	public ResultMessage createOffLineOrder(OrderVO orderVO) {
		return orderUtil.createOffLineOrder(orderVO);
	}

	
}
