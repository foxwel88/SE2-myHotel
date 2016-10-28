package org.client.blservice.hotelblservice;

import java.util.List;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public interface Hotelblservice 
{
	public List<HotelVO> findHotels(HotelFilter filter);
	
	public HotelVO getHotel(String hotelAddress);
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage changeRoom(RoomType type, int num);
	
	public HotelVO getHotelVO(String hotelAddress);
	
	public List<CityVO> getCitys();
	
	public List<AreaVO> getAreas(CityVO vo);

}
