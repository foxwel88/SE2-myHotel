package org.client.bl.orderbl;

import java.util.List;



import org.client.blservice.orderblservice.Orderblservice;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderController implements Orderblservice{

	private static OrderController controller;
	
	private OrderController() {
		
	}
	
	public static OrderController getInstance() {
		if (controller == null) {
			controller = new OrderController();
		}
		return controller;
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return OrderUtil.getInstance().createOrder(vo);
	}

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return OrderUtil.getInstance().getOrder(ID);
	}

	public List<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		return OrderUtil.getInstance().getAbnormalOrder();
	}

	public List<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		return OrderUtil.getInstance().getUserOrderList(userID, type);
	}

	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		return OrderUtil.getInstance().getHotelOrderList(hotelID, type);
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
