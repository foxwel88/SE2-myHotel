package org.client.blservice.hotelblservice;

import java.util.Date;
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
 * @version 2016/12/20 Hirico
 */
public interface HotelBlService {
	public List<HotelVO> findHotels(HotelFilter filter, String userId, boolean historyOnly);
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);
	
	public ResultMessage modifyHotel(HotelVO vo);
	
	public int getAvailableRoomNum(Date schFrom, Date schTo, String hotelId, RoomType type);
	
	public HotelVO getHotelVO(String hotelID);
	
	public List<CityVO> getCitys();
	
	public List<AreaVO> getAreas(CityVO vo);

}
