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

<<<<<<< HEAD
	ResultMessage increaseAvailableRoom(RoomType type, String hotelID);
=======
	void increaseAvailableRoom(RoomType type, String hotelAddress);
>>>>>>> origin/master

	ResultMessage decreaseAvailableRoom(RoomType type, String hotelID);
}
