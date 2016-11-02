package org.client.bl.hotelbl;

import java.util.ArrayList;
import java.util.List;

import org.client.vo.HotelVO;
import org.common.utility.HotelFilter;

public class HotelList {
	public List<Hotel> list;
	
	public HotelList initList(HotelFilter filter) {
		return this;
	}
	
	public List<HotelVO> getVOs() {
		if(list != null) {
			List<HotelVO> voList = new ArrayList<HotelVO>();
			for(Hotel h: list) {
				voList.add(h.generateVO());
			}
			return voList;
		} else {
			return null;
		}
	}
}
