package org.client.bldriver;

import java.util.Date;

import org.client.bl.orderbl.Order;
import org.client.blstub.Order_stub;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.RoomType;

public class Orderblservice_driver {
	
	public static void main(String[] args){
		Order_stub stub = new Order_stub();
		
		System.out.println(stub.createOrder(new OrderVO(OrderType.ABNORMAL, new Date(), new Date(), new Date(), new Date(), new Date(), new Date(), "wefw", "657", "as",RoomType.BIG, 1, 2, true)));
		System.out.println(stub.cancelOrder("dsa"));
		System.out.println(stub.getOrder("879"));
		System.out.println(stub.getAbnormalOrder());
		System.out.println(stub.getUserOrderList("csz", OrderType.ABNORMAL));
		System.out.println(stub.getHotelOrderList("ds",  OrderType.ABNORMAL));
		System.out.println(stub.executeOrder ("5y4"));
		System.out.println(stub.cancelAbnormalOrder ("czs", true));
	}
}
