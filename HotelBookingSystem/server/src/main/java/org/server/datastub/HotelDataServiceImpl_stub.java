package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class HotelDataServiceImpl_stub extends UnicastRemoteObject implements HotelDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560310380410014760L;
	

	protected HotelDataServiceImpl_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException {
		if (po.hotelName == null || po.address == null || 
				po.hotelName.isEmpty() || po.address.isEmpty()
				|| po.city == null || po.area == null
				|| po.city.isEmpty() || po.area.isEmpty()) {
			return ResultMessage.WRONG_FORMAT;
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException {
		if (po.hotelName == null || po.address == null || 
				po.hotelName.isEmpty() || po.address.isEmpty()
				|| po.city == null || po.area == null
				|| po.city.isEmpty() || po.area.isEmpty()) {
			return ResultMessage.WRONG_FORMAT;
		}
		return ResultMessage.SUCCESS;
	}

	public HotelPO getHotelInfo(String hotelAddress) throws RemoteException {
		return new HotelPO(hotelAddress, hotelAddress, hotelAddress, hotelAddress, hotelAddress, 0, 0, hotelAddress, hotelAddress, hotelAddress);
	}

	public List<RoomPO> getRooms(String hotelAddress) throws RemoteException {
		List<RoomPO> list = new ArrayList<RoomPO>();
		list.add(new RoomPO("small",0,0));
		return list;
	}

	public ResultMessage modifyRooms(String hotelAddress, List<RoomPO> po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<HotelPO> findHotels(HotelFilter filter) throws RemoteException {
		ArrayList<HotelPO> hotels = new ArrayList<HotelPO>();
		hotels.add(new HotelPO("n", "a", "c", "a", "i", 1, 1, "f", "c", "com"));
		return hotels;
	}

	public ArrayList<CityPO> getCitys() throws RemoteException {
		ArrayList<CityPO> citys = new ArrayList<CityPO>();
		citys.add(new CityPO("南京"));
		return citys;
	}

	public ArrayList<AreaPO> getAreas(CityPO po) throws RemoteException {
		ArrayList<AreaPO> areas = new ArrayList<AreaPO>();
		areas.add(new AreaPO("仙林中心"));
		return areas;
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}

	public ResultMessage changeRoom(RoomType type, int num, String hotelAddress) throws RemoteException {
		if (num < 0) {
			return ResultMessage.WRONG_FORMAT;
		}
		return ResultMessage.SUCCESS;
	}

}
