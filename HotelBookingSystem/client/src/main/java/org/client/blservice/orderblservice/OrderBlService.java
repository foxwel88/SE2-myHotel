package org.client.blservice.orderblservice;

import java.util.Date;
import java.util.List;

import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public interface OrderBlService {
	public ResultMessage createOrder(OrderVO vo);
	
	public ResultMessage cancelOrder(String orderID);
	
	public OrderVO getOrder(String orderID);
	
	public List<OrderVO> getAbnormalOrder();
	
	public List<OrderVO> getUserOrderList(String userID, OrderType type);
	
	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type);
	
	public ResultMessage executeOrder (String orderID);
	
	public ResultMessage cancelAbnormalOrder (String orderID, Boolean isHalf);
	
	public List<String> getHistoryHotels(String userId);
	
	public ResultMessage checkOut(String orderID);
	
	public ResultMessage comment(String orderID);
	
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromdate, Date todate);
	
	public ResultMessage createOffLineOrder(OrderVO vo);
}
