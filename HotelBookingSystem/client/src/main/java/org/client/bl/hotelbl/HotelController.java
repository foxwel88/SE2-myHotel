package org.client.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class HotelController implements Hotelblservice {

	public List<HotelVO> findHotels(HotelFilter filter) {
		return HotelUtil.getInstance().getHotelList(filter);
	}

	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		UserController userController = new UserController();       // here needs mock
		ResultMessage userRe = userController.add(userVO);
		
		ResultMessage hotelRe = HotelUtil.getInstance().addHotel(hotelVO);
		if (userRe != ResultMessage.SUCCESS) {
			return userRe;
		}
		if (hotelRe != ResultMessage.SUCCESS) {
			return hotelRe;
		}
		return userRe;
	}

	/**
	 * 修改酒店信息，包括酒店持久化对象和房间持久化对象的信息
	 */
	public ResultMessage modifyHotel(HotelVO vo) {
		return HotelUtil.getInstance().modify(vo);
	}

	/**
	 * 修改可用房间信息，供非酒店工作人员使用
	 */
	public ResultMessage changeRoom(RoomType type, int num, String hotelAddress) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		try {
			dao.changeRoom(type, num, hotelAddress);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		return ResultMessage.SUCCESS;
	}

	public HotelVO getHotelVO(String hotelAddress) {
		return HotelUtil.getInstance().getHotel(hotelAddress);
	}

	public List<AreaVO> getAreas(CityVO vo) {
		try {
			return AreaVO.generateVOList(RMIHelper.getInstance().getHotelDataServiceImpl().getAreas(CityVO.generatePO(vo)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CityVO> getCitys() {
		try {
			return CityVO.generateVOList(RMIHelper.getInstance().getHotelDataServiceImpl().getCitys());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


}
