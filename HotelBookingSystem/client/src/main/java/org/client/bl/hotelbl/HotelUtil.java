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

/**
 * Hotel模块的工具类，用于协作HotelController转发
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class HotelUtil {
	
	private HotelList hotelList;
	
	public HotelUtil() {
		
	}
	
	public ResultMessage addHotel(HotelVO vo) {
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		Hotel h = new Hotel();
		HotelPO po = h.modifyAndReturnPO((vo));
		try {
			return dao.addHotelInfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	public HotelVO getHotel(String hotelAddress) {
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
	
	public List<HotelVO> getHotelList(HotelFilter filter) {
		hotelList = new HotelList();
		hotelList.initList(filter);
		List<HotelVO> list = hotelList.getVOs();
		return list;
	}

	/**
	 * 用于工作人员维护酒店信息，更新酒店和房间的持久化对象
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage modify(HotelVO vo) {
		
		//准备好HotelPO和RoomPO
		Hotel h = new Hotel();
		HotelPO hotelPO = h.modifyAndReturnPO(vo);
		
		List<RoomPO> rooms = new ArrayList<RoomPO>();
		for (int i = 0; i < vo.roomNum.size(); i++) {
			rooms.add(new RoomPO(vo.roomType.get(i), vo.roomNum.get(i), vo.roomPrice.get(i)));
		}
		
		//调用数据层的modify方法
		HotelDataService dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		ResultMessage hotelResult;
		ResultMessage roomResult;
		try {
			hotelResult = dao.modifyHotelInfo(hotelPO);
			roomResult = dao.modifyRooms(vo.address, rooms);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		if (hotelResult != ResultMessage.SUCCESS) {
			return hotelResult;
		}
		if (roomResult != ResultMessage.SUCCESS) {
			return roomResult;
		}
		return ResultMessage.SUCCESS;
	}
}
