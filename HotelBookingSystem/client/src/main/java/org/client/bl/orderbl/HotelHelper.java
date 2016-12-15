package org.client.bl.orderbl;

import org.client.vo.HotelVO;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Order模块内的Hotel接口，解决相互依赖
 * @author Hirico
 * @version 2016/12/06 Foxwel
 */
public interface HotelHelper {
	HotelVO getHotelVO(String hotelAddress);
	
	void increaseAvailableRoom(RoomType type, String hotelID, int num);

	ResultMessage decreaseAvailableRoom(RoomType type, String hotelID, int num);
}
