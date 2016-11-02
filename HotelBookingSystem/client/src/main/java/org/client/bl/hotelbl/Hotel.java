package org.client.bl.hotelbl;

import org.client.vo.HotelVO;
import org.common.po.HotelPO;

public class Hotel {

	public HotelVO generateVO() {
		return new HotelVO(null, null, null, null, null, 0, 0, null, null, null, null, null, null);
	}
	
	public Hotel initByPO(HotelPO po) {
		return this;
	}
	
	public HotelPO modify(HotelVO vo) {
		return new HotelPO(null, null, null, null, null, 0, 0, null, null, null);
	}
}
