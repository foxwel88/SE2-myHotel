package org.server.data.HotelData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4005413439043494852L;

	public HotelDataServiceImpl() throws RemoteException {
		System.out.println("hotel start");
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelPO getHotelInfo(String hotelAddress) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelPO> findHotels(HotelFilter filter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CityPO> getCitys() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AreaPO> getAreas(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public RoomPO getRooms(String hotelAddress) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyRooms(String hotelAddress, RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
