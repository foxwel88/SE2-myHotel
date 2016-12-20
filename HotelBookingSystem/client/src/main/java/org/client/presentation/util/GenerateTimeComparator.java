package org.client.presentation.util;

import java.util.Comparator;

import org.client.vo.OrderVO;

/**
 * 按照订单生成时间（latestTime）比较两个OrderVO，后执行者较小
 * 可用于未执行订单列表的排序
 */
public class GenerateTimeComparator implements Comparator<OrderVO> {

	@Override
	public int compare(OrderVO o1, OrderVO o2) {
		return -o1.generatedDate.compareTo(o2.latestTime);
	}
	
}
