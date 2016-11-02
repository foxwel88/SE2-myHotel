package org.client.bl.hotelbl;

import java.util.List;

import org.client.vo.HotelVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public class HotelUtil {
	private static HotelUtil util;
	private HotelList hotelList;
	
	private HotelUtil() {
		
	}
	
	public static HotelUtil getInstance() {
		if(util == null) {
			util = new HotelUtil();
		}
		return util;
	}
	
	public ResultMessage addHotel() {
		return null;
	}
	
	public HotelVO getHotel(String hotelAddress) {
		return null;
	}
	
	public List<HotelVO> getHotelList(HotelFilter filter) {
		hotelList = new HotelList();
		hotelList.initList(filter);
		return hotelList.getVOs();
	}
}
