package org.client.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.IDService;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Hotel模块逻辑层接口的实现类
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class HotelController implements Hotelblservice {
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

	@Override
	public List<HotelVO> findHotels(HotelFilter filter, String userId, boolean historyOnly) {
		if (userId != null && historyOnly) {
			if (orderBl == null) { // when orderBl is not set by external driver
				orderBl = OrderController.getInstance(); // use true logic code
			}
			List<String> hotelIDs = orderBl.getHistoryHotels(userId);
			filter.setHistory(hotelIDs);
		}

		//先获得匹配房间价格数量之外信息的酒店列表
		List<HotelVO> list = util.getHotelList(filter);
		List<HotelVO> result = new ArrayList<>();

		//再根据房间价格和数量做进一步的筛选
		for (HotelVO vo: list) {
			if (isRoomInfoMatched(vo.id, filter)) {
				result.add(vo);
			}
		}
		return result;
	}

	/**
	 * 满足条件要求：若filter中指定房间类型，该类型的价格和数量满足要求
	 *               若filter没有指定房间类型，则只要同时有房间满足价格要求且房间总数满足数量要求即可
	 * */
	private boolean isRoomInfoMatched(String hotelId, HotelFilter filter) {
		HotelVO vo = getHotelVO(hotelId);
		List<Double> prices = vo.roomPrice;
		List<String> types = vo.roomType;

		if (filter.roomType != null) {
			for (int i = 0; i < types.size(); i++) {
				if (types.get(i).equals(filter.roomType.getString())) {
					if (prices.get(i) >= filter.minPrice && prices.get(i) <= filter.maxPrice
							&& getAvailableRoomNum(filter.schFrom, filter.schTo, hotelId, RoomType.getType(types.get(i))) >= filter.roomNum) {
						return true;
					}
				}
			}
		} else {
			int requiredNum = filter.roomNum;
			for (int i = 0; i < types.size(); i++) {
				if (prices.get(i) >= filter.minPrice && prices.get(i) <= filter.maxPrice) {
					requiredNum -= getAvailableRoomNum(filter.schFrom, filter.schTo, hotelId, RoomType.getType(types.get(i)));
				}
				if (requiredNum <= 0) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		if (userBl == null) { // when userBl is not set by external driver
			userBl = UserController.getInstance(); // use true logic code

			//预填补酒店工作人员的HotelID
			String newHotelID = null;
			try {
				newHotelID = RMIHelper.getInstance().getIDUtil().generateNewHotelID();
			} catch (RemoteException e) {
				return ResultMessage.CONNECTION_FAIL;
			}
			userVO.hotelID = newHotelID;
		}

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
	@Override
	public ResultMessage modifyHotel(HotelVO vo) {
		return util.modify(vo);
	}

	@Override
	public int getAvailableRoomNum(Date schFrom, Date schTo, String hotelId, RoomType type) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		int availableNum = 0;

		//需要向order模块获得该类型房间已被预定数量
		if (orderBl == null) { // when orderBl is not set by external driver
			orderBl = OrderController.getInstance(); // use true logic code
		}

		try {
			List<RoomPO> roomPOS = dao.getRooms(hotelId);
			int total = 0;
			for (RoomPO po: roomPOS) {
				if (po.roomType == type) {
					total = po.roomNum;
					break;
				}
			}

			availableNum = total;
			availableNum -= orderBl.getBookedRoomNum(hotelId, type, schFrom, schTo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return availableNum;
	}

	@Override
	public HotelVO getHotelVO(String hotelID) {
		return util.getHotel(hotelID);
	}

	@Override
	public List<AreaVO> getAreas(CityVO vo) {
		try {
			return AreaVO.generateVOList(RMIHelper.getInstance().getHotelDataServiceImpl().getAreas(CityVO.generatePO(vo)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CityVO> getCitys() {
		try {
			return CityVO.generateVOList(RMIHelper.getInstance().getHotelDataServiceImpl().getCitys());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


}
