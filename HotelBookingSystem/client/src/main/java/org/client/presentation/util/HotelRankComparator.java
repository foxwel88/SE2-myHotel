package org.client.presentation.util;

import java.util.Comparator;

import org.client.vo.HotelVO;

/**
 * 按照酒店评分从高到低排列
 * @author Lenovo
 *
 */
public class HotelRankComparator implements Comparator<HotelVO> {
	public int compare(HotelVO o1, HotelVO o2) {
		if (o1.rank > o2.rank) {
			return -1;
		} else {
			return 1;
		}
	}
}
