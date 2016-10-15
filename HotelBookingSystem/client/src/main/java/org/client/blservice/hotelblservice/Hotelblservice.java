package org.client.blservice.hotelblservice;

import java.util.ArrayList;

import org.client.bl.hotelbl.RoomType;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public interface Hotelblservice 
{
	public ArrayList<HotelVO> findHotels(HotelFilter filter);
	
	public HotelVO getHotel(String hotelAddress);
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage changeRoom(RoomType type, int num);
	
	public HotelVO getHotelVO(String hotelAddress);
	
	public ArrayList<CityVO> getCitys();
	
	public ArrayList<AreaVO> getAreas(CityVO vo);

}
