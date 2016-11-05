package org.client.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.HotelVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public class HotelUtil {
	private static HotelUtil util;
	
	private static HotelList hotelList;
	
	private HotelUtil() {
		
	}
	
	public static HotelUtil getInstance() {
		if (util == null) {
			util = new HotelUtil();
		}
		return util;
	}
	
	public ResultMessage addHotel(HotelVO vo) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		Hotel h = new Hotel();
		HotelPO po = h.modify(vo);
		try {
			return dao.addHotelInfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
	}
	
	public static HotelVO getHotel(String hotelAddress) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		HotelPO po;
		try {
			po = dao.getHotelInfo(hotelAddress);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		Hotel h = new Hotel();
		h.initByPO(po);
		return h.generateVO();
	}
	
	public static List<HotelVO> getHotelList(HotelFilter filter) {
		hotelList = new HotelList();
		hotelList.initList(filter);
		List<HotelVO> list = hotelList.getVOs();
		return list;
	}

	/**
	 * 用于工作人员维护酒店信息，更新酒店和房间的持久化对象
	 * @param HotelVO
	 * @return ResultMessage
	 */
	public ResultMessage modify(HotelVO vo) {
		Hotel h = new Hotel();
		HotelPO hotelPO = h.modify(vo);
		List<RoomPO> rooms = new ArrayList<RoomPO>();
		for (int i = 0; i < vo.roomNum.size(); i++) {
			rooms.add(new RoomPO(vo.roomType.get(i), vo.roomNum.get(i), vo.roomPrice.get(i)));
		}
		
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		ResultMessage hotelRe;
		ResultMessage roomRe;
		try {
			hotelRe = dao.modifyHotelInfo(hotelPO);
			roomRe = dao.modifyRooms(vo.address, rooms);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		if (hotelRe != ResultMessage.SUCCESS) {
			return hotelRe;
		}
		if (roomRe != ResultMessage.SUCCESS) {
			return roomRe;
		}
		return ResultMessage.SUCCESS;
	}
}
