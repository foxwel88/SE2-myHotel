package org.client.bl.orderbl;

import java.util.ArrayList;
import java.util.List;

import org.client.vo.OrderVO;
import org.common.po.OrderPO;
import org.common.utility.ResultMessage;

public class OrderList {
	
	@SuppressWarnings("unused")
	private ArrayList<OrderVO> list;
	
	
	public ResultMessage setOrderList (List<OrderPO> polist) {
		list=new ArrayList<OrderVO>();
		return null;
	}
	
	public List<OrderVO> getOrderListVO () {
		return null;
	}
}
