package org.client.blservice.orderblservice;

import java.util.List;

import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public interface Orderblservice {
	public ResultMessage createOrder(OrderVO vo);
	
	public ResultMessage cancelOrder(String orderID);
	
	public OrderVO getOrder(String ID);
	
	public List<OrderVO> getAbnormalOrder();
	
	public List<OrderVO> getUserOrderList(String userID, OrderType type);
	
	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type);
	
	public ResultMessage executeOrder (String orderID);
	
	public ResultMessage cancelAbnormalOrder (String orderID, Boolean isHalf);
	
	public List<String> getHistoryHotels(String userId);
	
	public ResultMessage checkOut(String ID);
}
