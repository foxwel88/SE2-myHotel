package org.client.presentation.util;

import java.util.ArrayList;
import java.util.Comparator;

import org.client.vo.HotelVO;

/**
 * 按照最低价格从低到高排列酒店
 * @author Lenovo
 *
 */
public class HotelPriceComparator implements Comparator<HotelVO> {
	public int compare(HotelVO o1, HotelVO o2) {
		ArrayList<Double> priceList1 = new ArrayList<>(o1.roomPrice);
		ArrayList<Double> priceList2 = new ArrayList<>(o2.roomPrice);
		double min1 = priceList1.get(0);
		double min2 = priceList2.get(0);
		for (int i = 1; i < priceList1.size(); i++) {
			if (priceList1.get(i) < min1) {
				min1 = priceList1.get(i);
			}
		}
		for (int i = 1; i < priceList2.size(); i++) {
			if (priceList2.get(i) < min2) {
				min2 = priceList1.get(i);
			}
		}
		if (min1 < min2) {
			return -1;
		} else {
			return 1;
		}
	}
}
