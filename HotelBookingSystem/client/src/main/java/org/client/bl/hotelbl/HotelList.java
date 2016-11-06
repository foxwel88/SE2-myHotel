package org.client.bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.HotelVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.HotelPO;
import org.common.utility.HotelFilter;

public class HotelList {
	public List<Hotel> list;
	
	public HotelDataService dao;
	
	public void setDAO(HotelDataService d) {
		dao = d;
	}
	
	public HotelList initList(HotelFilter filter) {
		list = new ArrayList<Hotel>();
		if (dao == null) {
			dao = RMIHelper.getInstance().getHotelDataServiceImpl();
		}
		List<HotelPO> pos = null;
		try {
			pos = dao.findHotels(filter);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (HotelPO p: pos) {
			Hotel h = new Hotel();
			h.initByPO(p);
			list.add(h);
		}
		return this;
	}
	
	public List<HotelVO> getVOs() {
		if (list != null) {
			List<HotelVO> voList = new ArrayList<HotelVO>();
			for (Hotel h: list) {
				voList.add(h.generateVO());
			}
			return voList;
		} else {
			return null; // initList() not called yet
		}
	}
}
