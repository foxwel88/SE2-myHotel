package org.server.data.PromotionData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import mySQL.DatabaseCommunicator;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8003664894492865142L;

	public PromotionDataServiceImpl() throws RemoteException {
		System.out.println("promotion start");
		// TODO Auto-generated constructor stub
	}
	
	public String getNewID() throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select promotionid from promotion", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.last();
			// 获得当前表中最大的PromotionID
			String largestID = resultSet.getString("promotionid");
			// 因为目前的PromotionID是十位数字，因此此处直接转为int，如果PromotionID加长，则需要实现String加法器
			return String.valueOf(Integer.parseInt(largestID) + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(PromotionPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"insert into promotion(type, promotionid, starttime, endtime, hotelname, hotelid, level, area, discount, name)"
					+ " values ('" + po.type.getString() + "','" + po.promotionID + "','" + po.startTime + "','" + po.endTime + "','" + po.hotelName
					+ "','" + po.hotelID + "','" + po.level + "','" + po.area + "','" + po.discount + "','" + po.name + "')");
			preparedStatement.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.WRONG_VALUE;
	}

	public ResultMessage modify(PromotionPO po) throws RemoteException {
		delete(po.promotionID);
		add(po);
		return ResultMessage.SUCCESS;
	}
	
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

	public List<PromotionPO> showWebsitePromotion() throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"select * from promotion where type='网站促销策略'");
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

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
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
				poList.add(new PromotionPO(resultSet.getString("promotionID"), 
						PromotionType.getType(resultSet.getString("type")), resultSet.getDate("startTime"), 
						resultSet.getDate("endTime"), resultSet.getString("hotelName"), 
						resultSet.getString("hotelID"), resultSet.getInt("level"), resultSet.getString("area"), 
						resultSet.getDouble("discount"), resultSet.getString("name")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return poList;
	}
	
}
