package org.client.bl.orderbl;

import java.util.ArrayList;
import java.util.List;

import org.client.vo.OrderVO;
import org.common.po.OrderPO;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * 
 * bl层order模块的order列表类，用于存放一个List的order
 * @author Foxwel
 * @version 2017/1/1 Foxwel
 * 
 */

public class OrderList {
	
	private ArrayList<Order> list;

	/*
	通过orderPO 的 List 来初始化OrderList对象
	 */
	public ResultMessage setOrderList (List<OrderPO> polist) {
		list = new ArrayList<>();
		for (int i = 0;i < polist.size(); ++i) {
			Order myorder = new Order();
			myorder.setOrder(polist.get(i));
			list.add(myorder);
		}
		return ResultMessage.SUCCESS;
	}

	/*
	将orderList对象中的订单列表导出成OrderVO 的 List
	 */

	public List<OrderVO> getOrderListVO () {
		List<OrderVO> reslist = new ArrayList<>();
		for (int i = 0;i < list.size(); ++i) {
			reslist.add(list.get(i).getOrderVO());
		}
		return reslist;
	}

	/*
	获得该订单列表中的酒店ID列表
	 */

	public List<String> getHotelList() {
		List<String> reslist = new ArrayList<>();
		for (int i = 0;i < list.size(); ++i) {
			reslist.add(list.get(i).hotelID);
		}
		return reslist;
	}

	/*
	获取房间类型roomType的房间在该订单列表中的预订间数
	 */

	public int getTypeRoomNum(RoomType roomType) {
		int res = 0;
		for (int i = 0; i < list.size(); ++i) {
			Order myorder = list.get(i);
			if (myorder.roomType == roomType) {
				res += myorder.roomNum;
			}
		}
		return res;
	}
	
}
