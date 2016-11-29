package org.client.blservice.hotelblservice;

import java.util.List;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Hotel模块的logic层接口
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public interface Hotelblservice {
	public List<HotelVO> findHotels(HotelFilter filter, String userId, boolean historyOnly);
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public ResultMessage changeRoom(RoomType type, int num, String hotelAddress);
	
	public ResultMessage increaseAvailableRoom(RoomType type, String hotelAddress);
	
	public ResultMessage decreaseAvailableRoom(RoomType type, String hotelAddress);
	
	public HotelVO getHotelVO(String hotelAddress);
	
	public List<CityVO> getCitys();
	
	public List<AreaVO> getAreas(CityVO vo);

}
