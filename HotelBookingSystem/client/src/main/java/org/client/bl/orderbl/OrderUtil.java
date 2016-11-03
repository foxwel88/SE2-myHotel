package org.client.bl.orderbl;

import java.util.List;

import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderUtil {
	
	private static OrderUtil util;

	private OrderUtil() {
		
	}
	
	public static OrderUtil getInstance() {
		if (util == null) {
			util = new OrderUtil();
		}
		return util;
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		return null;
	}
	
	public OrderVO getOrder (String orderID) {
		return null;
	}
	
	public List<OrderVO> getAbnormalOrder () {
		return null;
	}
	
	public List<OrderVO> getUserOrderList (String UserID, OrderType type) {
		return null;
	}
	
	public List<OrderVO> getHotelOrderList (String hoteladdress, OrderType type) {
		return null;
	}
	
	public List<String> getHistoryHotels(String userId) {
		return null;
	}

}
