package org.client.bl.hotelblservice;

import java.util.ArrayList;

import org.client.bl.hotelbl.HotelFilter;
import org.client.bl.hotelbl.RoomType;

public interface Hotelblservice {
	public ArrayList<HotelVO> findHotels(HotelFilter filter);
	
	public HotelVO getHotel(String hotelAddress);
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage changeRoom(RoomType type, int num);
	
	public HotelVO getHotelVO(String hotelAddress);
	
	public ArrayList<String> getCitys();
	
	public ArrayList<String> getAreas(String city);

}
