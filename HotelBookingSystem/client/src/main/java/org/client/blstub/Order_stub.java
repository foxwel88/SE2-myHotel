package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class Order_stub implements Orderblservice {

	OrderVO vo1 = new OrderVO(OrderType.ABNORMAL.getString()
			,new Date(),new Date(),new Date(),new Date()
			,new Date(),new Date(),new Date(),
			"aaaaa","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13919191919");

	OrderVO vo2 = new OrderVO(OrderType.ABNORMAL.getString(),
			new Date(),new Date(),new Date(),new Date()
			,new Date(),new Date(),new Date(),
			"aaaaa","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");

	ArrayList<OrderVO> vo = new ArrayList<OrderVO>();
	
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return vo1;
	}

	public ArrayList<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

	public ArrayList<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		return vo;
	}

	public ArrayList<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		return vo;
	}

	public ResultMessage executeOrder(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public List<String> getHistoryHotels(String userId) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("1号酒店");
		list.add("2号酒店");
		return list;
	}

	

}
