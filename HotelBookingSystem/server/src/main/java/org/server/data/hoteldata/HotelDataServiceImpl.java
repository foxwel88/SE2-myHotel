package org.server.data.hoteldata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.*;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.server.data.datafactory.DataFactory;
import org.server.util.mysql.DatabaseCommunicator;

public class HotelDataServiceImpl extends UnicastRemoteObject implements HotelDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4005413439043494852L;

	public HotelDataServiceImpl() throws RemoteException {
		System.out.println("hotel start");
	}

	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException {

		//获取新ID
		po.id = DataFactory.getInstance().getIDUtil().generateNewHotelID();

		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT * FROM Hotel WHERE address='" + po.address + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (!resultSet.next()) {

				//在Hotel Table中添加酒店
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("INSERT INTO Hotel(hotelID,hotelName,address,area,"
						+ "city,introduction,rank,star,facility,cooperators,checkInInfos,imgURL)"
						+ " VALUES ('" + po.id + "','" + po.hotelName + "','" + po.address + "','" + po.area
						+ "','" + po.city + "','" + po.introduction + "','" + po.rank + "','" + po.star
						+ "','" + po.facility + "','" + po.cooperators + "','" + po.checkInInfos + "','" + po.imgURL + "')");
				DatabaseCommunicator.execute(preparedStatement);

				//Create新Table存储该酒店的房间信息
				String create = "CREATE TABLE `" + po.id + "`(RoomType TEXT, RoomNum INT, RoomPrice DOUBLE) DEFAULT CHARSET=utf8";
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(create);
				DatabaseCommunicator.execute(preparedStatement);

				for (RoomType t: RoomType.values()) {
					preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("INSERT INTO `" + po.id + "`(RoomType,RoomNum,RoomPrice)"
							+ " VALUES ('" + t.getString() + "','0','0')");
					DatabaseCommunicator.execute(preparedStatement);
				}

				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}

	}

	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"DELETE FROM Hotel WHERE HotelID='" + po.id + "'");
			System.out.println("delete " + po.id);
			DatabaseCommunicator.execute(preparedStatement);

			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("INSERT INTO Hotel(hotelID,hotelName,address,area,"
					+ "city,introduction,rank,star,facility,cooperators,checkInInfos,imgURL)"
					+ " VALUES ('" + po.id + "','" + po.hotelName + "','" + po.address + "','" + po.area
					+ "','" + po.city + "','" + po.introduction + "','" + po.rank + "','" + po.star
					+ "','" + po.facility + "','" + po.cooperators + "','" + po.checkInInfos + "','" + po.imgURL + "')");
			DatabaseCommunicator.execute(preparedStatement);

			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.SUCCESS;
	}

	HotelPO getHotelFromSet(ResultSet set) {
		HotelPO po = null;
		try {
			String id = set.getString("hotelId");
			String hotelName = set.getString("hotelName");
			String address = set.getString("address");
			String area = set.getString("area");
			String city = set.getString("city");
			String introduction = set.getString("introduction");
			Double rank = set.getDouble("rank");
			Integer star = set.getInt("star");
			String facility = set.getString("facility");
			String cooperators = set.getString("cooperators");
			String checkInInfos = set.getString("checkInInfos");
			String imgURL = set.getString("imgURL");
			po = new HotelPO(id, hotelName, address, city, area, introduction, rank, star, facility, checkInInfos, cooperators, imgURL);
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
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT * FROM Hotel WHERE HotelID='" + hotelID + "'");

			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (resultSet.next()) {
				po = getHotelFromSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public List<HotelPO> findHotels(HotelFilter filter) throws RemoteException {
		List<HotelPO> list = new ArrayList<>();
		try {
			//首先根据星级、评分、地区选择一个范围
			String query = "SELECT * FROM Hotel WHERE star >= " + filter.minStar + " AND star <= " + filter.maxStar
					+ " AND rank >= " + filter.minRank + " AND rank <= " + filter.maxRank
					+ " AND city = '" + filter.city + "' AND area = '" + filter.area + "'";
			if (!(filter.hotelName == null)) {
				query += " AND hotelname LIKE '%" + filter.hotelName + "%'";
			}
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(query);
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);

			//再根据酒店地址进一步筛选
			while (resultSet.next()) {
				HotelPO po = getHotelFromSet(resultSet);
				if (filter.livedHotelIDs != null) {
					if (!filter.livedHotelIDs.contains(po.id)) {
						continue;
					}
				}
				list.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<CityPO> getCitys() throws RemoteException {
		List<CityPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT CityName"
					+ " FROM CityAndArea");

			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				String name = resultSet.getString("CityName");
				if (list.isEmpty()) {
					list.add(new CityPO(name));
				} else {                                                        //剔除重复的城市名称
					if (!name.equals(list.get(list.size() - 1).cityName)) {
						list.add(new CityPO(name));
					}
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
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT TradeArea"
					+ " FROM CityAndArea" + " WHERE CityName='" + po.cityName + "'");

			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				list.add(new AreaPO(resultSet.getString("TradeArea")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RoomPO> getRooms(String hotelID) throws RemoteException {
		List<RoomPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT *"
					+ " FROM `" + hotelID + "`");

			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
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
					"DELETE FROM `" + hotelID + "`");
			System.out.println("delete " + hotelID);
			DatabaseCommunicator.execute(preparedStatement);

			for (RoomPO p: po) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("INSERT INTO `" + hotelID + "`(roomType,roomNum,roomPrice)"
						+ " VALUES ('" + p.roomType.getString() + "','" + p.roomNum + "','" + p.roomPrice + "')");
				DatabaseCommunicator.execute(preparedStatement);
			}

			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.SUCCESS;
	}


}
