package org.client.presentation.util;

import java.util.Comparator;

import org.client.vo.OrderVO;

/**
 * 按照撤销订单时间（cancelTime）比较两个OrderVO，后执行者较小
 * 可用于已撤销订单列表的排序
 */
public class CancelTimeComparator implements Comparator<OrderVO> {
	
	@Override
	public int compare(OrderVO o1, OrderVO o2) {
		return -o1.cancelTime.compareTo(o2.cancelTime);
	}
	
}
