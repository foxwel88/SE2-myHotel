package org.server.data.promotiondata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.server.util.mysql.DatabaseCommunicator;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8003664894492865142L;

	private static final String ADVERTISED_HOTEL_FILE_LOCATION = "/adHotels.txt";

	public PromotionDataServiceImpl() throws RemoteException {
		System.out.println("promotion start");
	}

	@Override
	public ResultMessage add(PromotionPO po) throws RemoteException {
		ResultMessage styleMessage = checkNewPromotionStyle(po);
		if (!styleMessage.equals(ResultMessage.SUCCESS)) {
			return styleMessage;
		}
		if (po.promotionID == null) {
			po.promotionID = getNewID();
		}
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"insert into promotion(provider, type, promotionid, starttime, endtime, hotelname, hotelid, level, city, area, discount, name)"
					+ " values ('" + po.provider + "','" + po.type.getString() + "','" + po.promotionID + "','" + getSQLDate(po.startTime) + "','" + getSQLDate(po.endTime)
					+ "','" + DatabaseCommunicator.getStorableQuote(po.hotelName) + "','" + po.hotelID + "','" + po.level + "','" + po.city + "','" + po.area + "','" + po.discount + "','"
					+ DatabaseCommunicator.getStorableQuote(po.name) + "')");
			preparedStatement.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.CONNECTION_FAIL;
	}

	@Override
	public ResultMessage modify(PromotionPO po) throws RemoteException {
		delete(po.promotionID);
		add(po);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String promotionID) throws RemoteException {
		try {
			PreparedStatement deleteStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from promotion where promotionid='" + promotionID + "'");
			deleteStatement.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.WRONG_VALUE;
	}

	@Override
	public List<PromotionPO> showHotelPromotion(String hotelID) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"select * from promotion where hotelID='" + hotelID + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			return getPromotionPOList(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PromotionPO> showWebsitePromotion() throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"select * from promotion where provider='web'");
			ResultSet resultSet = preparedStatement.executeQuery();
			return getPromotionPOList(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得等级制度信息
	 * 注意，此方法如果没有成功，可能返回null
	 */
	@Override
	public LevelPO showLevel() throws RemoteException {
		ArrayList<Double> creditsList = new ArrayList<>();
		LevelPO levelPO = null;
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select Credits from Level");
			ResultSet creditsSet = preparedStatement.executeQuery();
			while (creditsSet.next()) {
				creditsList.add(creditsSet.getDouble("Credits"));
			}
			levelPO = new LevelPO(creditsList.size(), creditsList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return levelPO;
	}

	@Override
	public ResultMessage modifyLevel(LevelPO po) throws RemoteException {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("truncate table level");
			preparedStatement.execute();
			for (int i = 1; i <= po.levelNum; i++) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
						"insert into level(levelnum, credits) values ('" + i + "',' " + po.credits.get(i - 1) + "')");
				preparedStatement.executeUpdate();
			}
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.WRONG_VALUE;
	}

	/**从文件中获取当前广告位的酒店id */
	@Override
	public List<String> getAdvertisedHotels() throws RemoteException {
		List<String> result = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(ADVERTISED_HOTEL_FILE_LOCATION)));
		String input;
		try {
			while ((input = bufferedReader.readLine().trim()) != null) {
				result.add(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getNewID() throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select promotionid from promotion", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.last();
			// 获得当前表中最大的PromotionID
			String largestID = resultSet.getString("promotionid");
			// 因为目前的PromotionID是十位数字，因此此处直接转为int，如果PromotionID加长，则需要实现String加法器
			return String.format("%010d", (Integer.parseInt(largestID) + 1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用于获得PromotionPO的列表的私有方法
	 * @param resultSet
	 * @return
	 */
	private ArrayList<PromotionPO> getPromotionPOList (ResultSet resultSet) {
		ArrayList<PromotionPO> poList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				poList.add(new PromotionPO(resultSet.getString("promotionID"), resultSet.getString("provider"), 
						PromotionType.getType(resultSet.getString("type")), resultSet.getDate("startTime"), 
						resultSet.getDate("endTime"), DatabaseCommunicator.getReadableQuote(resultSet.getString("hotelName")),
						resultSet.getString("hotelID"), resultSet.getInt("level"), resultSet.getString("city"), resultSet.getString("area"), 
						resultSet.getDouble("discount"), DatabaseCommunicator.getReadableQuote(resultSet.getString("name"))));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return poList;
	}
	
	private Date getSQLDate(java.util.Date rawDate) {
		return new Date(rawDate.getTime());
	}
	
	/**
	 * 酒店促销策略检查项：是否重名
	 * 网站促销策略检查项：是否重名
	 * @param po
	 * @return
	 */
	private ResultMessage checkNewPromotionStyle(PromotionPO po) {
		ArrayList<PromotionPO> promotionPO;
		try {
			if (po.provider.equals("web")) {
				promotionPO = (ArrayList<PromotionPO>)showWebsitePromotion();
			} else {
				promotionPO = (ArrayList<PromotionPO>)showHotelPromotion(po.hotelID);
			}
			for (int i = 0; i < promotionPO.size(); i++) {
				if (promotionPO.get(i).name.equals(po.name)) {
					return ResultMessage.WRONG_VALUE;
				}
			}

		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}

		return ResultMessage.SUCCESS;
	}
	
}
