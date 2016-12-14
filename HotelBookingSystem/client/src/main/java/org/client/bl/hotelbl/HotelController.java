package org.client.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.orderbl.HotelHelper;
import org.client.bl.orderbl.OrderController;
import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.utility.HotelFilter;
import org.common.utility.IDService;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Hotel模块逻辑层接口的实现类
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class HotelController implements Hotelblservice, HotelHelper {
	private static HotelController controller;
	
	private Userblservice userBl;
	
	private Orderblservice orderBl;
	
	public HotelUtil util;
	
	private HotelController() {
		util = new HotelUtil();
	}
	
	public void setUserblservice(Userblservice u) {
		userBl = u;
	}
	
	public void setOrderblservice(Orderblservice o) {
		orderBl = o;
	}
	
	public static HotelController getInstance() {
		if (controller == null) {
			controller = new HotelController();
		} 
		return controller;
	}
	
	public List<HotelVO> findHotels(HotelFilter filter, String userId, boolean historyOnly) {
		if (userId != null && historyOnly) {
			if (orderBl == null) { // when orderBl is not set by external driver
				orderBl = OrderController.getInstance(); // use true logic code
			}
			List<String> hotelIDs = orderBl.getHistoryHotels(userId);
			filter.setHistory(hotelIDs);
		}
		List<HotelVO> list = util.getHotelList(filter);
		return list;
	}

	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		if (userBl == null) { // when userBl is not set by external driver
			userBl = UserController.getInstance(); // use true logic code
		}

		//预填补酒店工作人员的HotelID
		String newHotelID = null;
		try {
			newHotelID = RMIHelper.getInstance().getIDUtil().generateNewHotelID();
		} catch (RemoteException e) {
			return ResultMessage.CONNECTION_FAIL;
		}
		userVO.hotelID = newHotelID;

		ResultMessage userRe = userBl.add(userVO);
		if (userRe != ResultMessage.SUCCESS) {
			return userRe;
		}

		ResultMessage hotelRe = util.addHotel(hotelVO);
		if (hotelRe != ResultMessage.SUCCESS) {
			userBl.deleteUser(userVO.userName);
			return hotelRe;
		}

		return userRe;
	}

	/**
	 * 修改酒店信息，包括酒店持久化对象和房间持久化对象的信息
	 */
	public ResultMessage modifyHotel(HotelVO vo) {
		return util.modify(vo);
	}

	public HotelVO getHotelVO(String hotelID) {
		return util.getHotel(hotelID);
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

	public void increaseAvailableRoom(RoomType type, String hotelID, int num) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		try {
			dao.increaseAvailableRoom(type, hotelID, num);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ResultMessage decreaseAvailableRoom(RoomType type, String hotelID, int num) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		try {
			ResultMessage result = dao.decreaseAvailableRoom(type, hotelID, num);
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}

	}


}
