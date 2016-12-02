package org.client.bl.orderbl;

import org.client.vo.HotelVO;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Order模块内的Hotel接口，解决相互依赖
 * @author Hirico
 * @version 2016/12/02 Hirico
 */
public interface HotelHelper {
	HotelVO getHotelVO(String hotelAddress);

	ResultMessage increaseAvailableRoom(RoomType type, String hotelAddress);

	ResultMessage decreaseAvailableRoom(RoomType type, String hotelAddress);
}
