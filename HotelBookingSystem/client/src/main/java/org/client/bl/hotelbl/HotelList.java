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

/**
 * 持有根据HotelFilter选出的Hotel列表
 * 通过调用dao的findHotel()方法
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class HotelList {
	public List<Hotel> list;
	
	public HotelDataService dao;
	
	public void setDAO(HotelDataService d) {
		dao = d;
	}
	
	public HotelList initList(HotelFilter filter) {
		list = new ArrayList<>();
		if (dao == null) {
			dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		}
		List<HotelPO> pos = null;
		try {
			pos = dao.findHotels(filter);
			for (HotelPO p : pos) {
				Hotel h = new Hotel();
				List<RoomPO> rooms = dao.getRooms(p.id);
				h.initByPO(p, rooms);
				list.add(h);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this;
	}

	/**获得当前hotel列表的VO列表 */
	public List<HotelVO> getVOs() {
		if (list != null) {
			List<HotelVO> voList = new ArrayList<>();
			for (Hotel h: list) {
				voList.add(h.generateVO());
			}
			return voList;
		} else {
			return null; // initList() 还没有被正确调用
		}
	}
}
