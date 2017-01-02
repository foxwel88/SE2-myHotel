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

	/**根据条件搜索酒店 */
	public List<HotelVO> findHotels(HotelFilter filter, String userId, boolean historyOnly);

	/**添加一个酒店，包括酒店信息和工作人员信息 */
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO);

	/**修改酒店信息 */
	public ResultMessage modifyHotel(HotelVO vo);

	/**获得酒店的某种房间类型在指定日期范围内的剩余数量 */
	public int getAvailableRoomNum(Date schFrom, Date schTo, String hotelId, RoomType type);

	/**获得酒店信息VO，包括酒店和房间信息 */
	public HotelVO getHotelVO(String hotelID);

	/**获得所有城市 */
	public List<CityVO> getCitys();

	/**获得指定城市中的所有商圈 */
	public List<AreaVO> getAreas(CityVO vo);

}
