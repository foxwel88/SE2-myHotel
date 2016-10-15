package org.server.datastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public class HotelDataServiceImpl_stub implements HotelDataService{

	public void init() throws RemoteException {
		
	}

	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public HotelPO getHotelInfo(String hotelAddress) throws RemoteException {
		return new HotelPO(hotelAddress, hotelAddress, hotelAddress, hotelAddress, hotelAddress, 0, 0, hotelAddress, hotelAddress);
	}

	public RoomPO getRooms(String hotelAddress) throws RemoteException {
		return new RoomPO(null, null, null);
	}

	public ResultMessage modifyRooms(String hotelAddress, RoomPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<HotelPO> findHotels(HotelFilter filter) throws RemoteException {
		ArrayList<HotelPO> hotels = new ArrayList<HotelPO>();
		hotels.add(new HotelPO(null, null, null, null, null, 0, 0, null, null));
		return hotels;
	}

	public ArrayList<CityPO> getCitys() throws RemoteException {
		ArrayList<CityPO> citys = new ArrayList<CityPO>();
		citys.add(new CityPO(null));
		return citys;
	}

	public ArrayList<AreaPO> getAreas(CityPO po) throws RemoteException {
		ArrayList<AreaPO> areas = new ArrayList<AreaPO>();
		areas.add(new AreaPO(null));
		return areas;
	}

	public void finish() throws RemoteException {
		
	}

}
