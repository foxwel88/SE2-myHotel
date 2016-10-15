package org.client.bl.orderblservice;

import java.util.ArrayList;

import org.client.bl.orderbl.OrderType;

public interface Orderblservice {
	public ResultMessage createOrder(OrderVO vo);
	
	public ResultMessage cancelOrder(String orderID);
	
	public OrderVO getOrder(String ID);
	
	public ArrayList<OrderVO> getAbnormalOrder();
	
	public ArrayList<OrderVO> getUserOrderList(String userID, OrderType type);
	
	public ArrayList<OrderVO> getHotelOrderList(String hotelID, OrderType type);
	
	public ResultMessage executeOrder (String orderID);
	
	public ResultMessage cancelAbnormalOrder (String orderID, Boolean isHalf);
}
