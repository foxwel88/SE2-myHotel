package org.client.bldriver;

import java.util.Date;

import org.client.bl.orderbl.OrderType;
import org.client.vo.OrderVO;

public class Orderblservice_driver {
	
	public static void main(String[] args){
		Order_stub stub = new Order_stub();
		
		System.out.println(stub.createOrder(new OrderVO(new OrderType(), new Date(), new Date(), new Date(), new Date(), new Date(), new Date(), "wefw", "657", "as", new RoomType(), 1, 2, true)));
		System.out.println(stub.cancelOrder("dsa"));
		System.out.println(stub.getOrder("879"));
		System.out.println(stub.getAbnormalOrder());
		System.out.println(stub.getUserOrderList("csz", new OrderType()));
		System.out.println(stub.getHotelOrderList("ds", new OrderType()));
		System.out.println(stub.executeOrder ("5y4"));
		System.out.println(stub.cancelAbnormalOrder ("czs", true));
	}
}
