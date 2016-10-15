package org.client.bl.hotelbl;

import java.util.ArrayList;

import org.client.bl.hotelblservice.Hotelblservice;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class Hotel implements Hotelblservice{

	public ArrayList<HotelVO> findHotels(HotelFilter filter) {
		// TODO Auto-generated method stub
		return null;
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

	public ArrayList<String> getCitys() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getAreas(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
