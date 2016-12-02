package org.server.data.HotelData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mySQL.DatabaseCommunicator;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.*;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4005413439043494852L;

	public HotelDataServiceImpl() throws RemoteException {
		System.out.println("hotel start");
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

	HotelPO getHotelFromSet(ResultSet set) {
		HotelPO po = null;
		try {
			String id = set.getString("id");
			String hotelName = set.getString("hotelName");
			String address = set.getString("address");
			String area = set.getString("area");
			String city = set.getString("city");
			String introduce = set.getString("introduce");
			Double rank = set.getDouble("rank");
			Integer star = set.getInt("star");
			String facility = set.getString("facility");
			String cooperators = set.getString("cooperators");
			String checkInInfos = set.getString("checkInInfos");
			po = new HotelPO(id, hotelName, address, city, area, introduce, rank, star, facility, checkInInfos, cooperators);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	RoomPO getRoomFromSet(ResultSet set) {
		return null;
	}

	public HotelPO getHotelInfo(String hotelID) throws RemoteException {
		HotelPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select id, hotelName,address,area,"
					+ "city,introduce,rank,star,facility,cooperators,checkInInfos from `Hotel` where Address=" + hotelID);

			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				po = getHotelFromSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public List<HotelPO> findHotels(HotelFilter filter) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CityPO> getCitys() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AreaPO> getAreas(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public List<RoomPO> getRooms(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyRooms(String hotelID, List<RoomPO> po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeRoom(RoomType type, int num, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage increaseAvailableRoom(RoomType type, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage decreaseAvailableRoom(RoomType type, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
