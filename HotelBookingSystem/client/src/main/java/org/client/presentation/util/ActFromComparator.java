package org.client.presentation.util;

import org.client.vo.OrderVO;

import java.util.Comparator;

/**
 * 按照执行时间（actFrom）比较两个OrderVO，后执行者较小
 * 可用于已执行订单列表的排序
 * @author Hirico
 * @version 2016/12/19 Hirico
 */
public class ActFromComparator implements Comparator<OrderVO>{

	@Override
	public int compare(OrderVO o1, OrderVO o2) {
		return -o1.actFrom.compareTo(o2.actFrom);
	}
}
