package org.client.bl.orderbl;

import java.util.ArrayList;
import java.util.List;

import org.client.vo.OrderVO;
import org.common.po.OrderPO;
import org.common.utility.ResultMessage;

/**
 * 
 * bl层order模块的order列表类，用于存放一个list的order
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class OrderList {
	
	private ArrayList<Order> list;
	
	
	public ResultMessage setOrderList (List<OrderPO> polist) {
		list = new ArrayList<Order>();
		for (int i = 0;i < polist.size(); ++i) {
			Order myorder = new Order();
			myorder.setOrder(polist.get(i));
			list.add(myorder);
		}
		return ResultMessage.SUCCESS;
	}
	
	public List<OrderVO> getOrderListVO () {
		List<OrderVO> reslist = new ArrayList<OrderVO>();
		for (int i = 0;i < list.size(); ++i) {
			reslist.add(list.get(i).getOrderVO());
		}
		return reslist;
	}
	
	public List<String> getHotelList() {
		List<String> reslist = new ArrayList<String>();
		for (int i = 0;i < list.size(); ++i) {
			reslist.add(list.get(i).hotelAddress);
		}
		return reslist;
	}
}
