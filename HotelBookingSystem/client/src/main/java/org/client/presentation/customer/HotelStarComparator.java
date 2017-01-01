package org.client.presentation.customer;

import java.util.Comparator;

import org.client.vo.HotelVO;

/**
 * 按照酒店星级从高到低排序
 * @author Lenovo
 *
 */
public class HotelStarComparator implements Comparator<HotelVO> {
	public int compare(HotelVO o1, HotelVO o2) {
		return o2.star - o1.star;
	}
}
