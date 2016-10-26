package org.client.bl.orderbl;

import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class Order implements Orderblservice{

	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage executeOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		// TODO Auto-generated method stub
		return null;
	}


}
