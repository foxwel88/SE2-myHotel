package org.client.blservice.orderblservice;

import java.util.ArrayList;

import org.client.bl.orderbl.OrderType;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

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
