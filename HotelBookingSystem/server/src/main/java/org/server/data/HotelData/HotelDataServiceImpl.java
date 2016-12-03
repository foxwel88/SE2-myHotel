package org.server.data.HotelData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from Hotel where HotelID=" + po.id);
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			if (!resultSet.next()) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("insert into Hotel(hotelID,hotelName,address,area,"
						+ "city,introduce,rank,star,facility,cooperators,checkInInfos)"
						+ " values(" + po.id + "," + po.hotelName + "," + po.address + "," + po.area
						+ "," + po.city + "," + po.introduce + "," + po.rank + "," + po.star
						+ "," + po.facility + "," + po.cooperators + "," + po.checkInInfos + ")");
				DatabaseCommunicator.execute(preparedStatement);
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from Hotel where HotelID=" + po.id);
			DatabaseCommunicator.execute(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		addHotelInfo(po);
		return ResultMessage.SUCCESS;
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
		RoomPO po = null;
		try {
			String type = set.getString("roomType");
			Integer num = set.getInt("roomNum");
			Double price = set.getDouble("roomPrice");
			po = new RoomPO(RoomType.getType(type), num, price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public HotelPO getHotelInfo(String hotelID) throws RemoteException {
		HotelPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select id, hotelName,address,area,"
					+ "city,introduce,rank,star,facility,cooperators,checkInInfos from Hotel where Address=" + hotelID);

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
		List<CityPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select CityName"
					+ " from CityAndArea");

			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				String name = resultSet.getString("CityName");
				if (!name.equals(list.get(list.size() - 1))) {
					list.add(new CityPO(name));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AreaPO> getAreas(CityPO po) throws RemoteException {
		List<AreaPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select TradeArea"
					+ " from CityAndArea" + " WHERE CityName=" + po.cityName);

			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				list.add(new AreaPO(resultSet.getString("TradeArea")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void finish() throws RemoteException {
		
	}

	public List<RoomPO> getRooms(String hotelID) throws RemoteException {
		List<RoomPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select roomType, roomNum, roomPrice"
					+ " from " + hotelID);

			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				list.add(getRoomFromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ResultMessage modifyRooms(String hotelID, List<RoomPO> po) throws RemoteException {

		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"DELETE FROM " + hotelID);
			DatabaseCommunicator.execute(preparedStatement);

			for (RoomPO p: po) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("insert into " + hotelID + "(roomType,roomNum,roomPrice)"
						+ " values(" + p.roomType.getString() + "," + p.roomNum + "," + p.roomPrice + ")");
				DatabaseCommunicator.execute(preparedStatement);
			}

			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage increaseAvailableRoom(RoomType type, String hotelID) throws RemoteException {

		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"SELECT roomNum FROM " + hotelID + " WHERE roomType=" + type.getString());
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			if (resultSet.next()) {
				int roomNum = resultSet.getInt("roomNum");
				roomNum += 1;
				String update = "UPDATE " + hotelID +
						" SET roomNum = " + String.valueOf(roomNum) +
						" WHERE roomType = " + type.getString();
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(update);
				DatabaseCommunicator.execute(preparedStatement);
			} else {
				return ResultMessage.NOT_EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage decreaseAvailableRoom(RoomType type, String hotelID) throws RemoteException {

		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"SELECT roomNum FROM " + hotelID + " WHERE roomType=" + type.getString());
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			if (resultSet.next()) {
				int roomNum = resultSet.getInt("roomNum");
				roomNum -= 1;

				//房间不够时，返回ROOM_NOT_ENOUGH
				if (roomNum < 0) {
					return ResultMessage.ROOM_NOT_ENOUGH;
				}

				String update = "UPDATE " + hotelID +
						" SET roomNum = " + String.valueOf(roomNum) +
						" WHERE roomType = " + type.getString();
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(update);
				DatabaseCommunicator.execute(preparedStatement);
			} else {
				return ResultMessage.NOT_EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.SUCCESS;
	}
	
	

}
