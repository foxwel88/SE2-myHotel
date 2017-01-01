package org.client.presentation.customer;

import java.util.Comparator;

import org.client.vo.HotelVO;

public class HotelComparatorFactory {
	
	public static Comparator<HotelVO> getPriceComparator() {
		return new HotelPriceComparator();
	}
	
	public static Comparator<HotelVO> getStarComparator() {
		return new HotelStarComparator();
	}

	public static Comparator<HotelVO> getRankComparator() {
		return new HotelRankComparator();
	}
	
}
