package org.client.bl.hotelbl;

import java.util.List;

import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class HotelController implements Hotelblservice {

	public List<HotelVO> findHotels(HotelFilter filter) {
		return HotelUtil.getInstance().getHotelList(filter);
	}

	public HotelVO getHotel(String hotelAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeRoom(RoomType type, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelVO getHotelVO(String hotelAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAreas(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AreaVO> getAreas(CityVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CityVO> getCitys() {
		// TODO Auto-generated method stub
		return null;
	}


}
