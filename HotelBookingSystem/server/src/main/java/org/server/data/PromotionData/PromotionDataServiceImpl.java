package org.server.data.PromotionData;

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
					"insert into promotion(type, promotionid, starttime, endtime, hotelname, hotelid, level, area, discount, name)"
					+ " values ('" + po.type.getString() + "','" + po.promotionID + "','" + getSQLDate(po.startTime) + "','" + getSQLDate(po.endTime) + "','" + po.hotelName
					+ "','" + po.hotelID + "','" + po.level + "','" + po.area + "','" + po.discount + "','" + po.name + "')");
			preparedStatement.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.CONNECTION_FAIL;
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
						resultSet.getDate("endTime"), resultSet.getString("hotelName"), 
						resultSet.getString("hotelID"), resultSet.getInt("level"), resultSet.getString("area"), 
						resultSet.getDouble("discount"), resultSet.getString("name")));
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
	 * 酒店促销策略检查项：是否重名、酒店是否存在
	 * 网站促销策略检查项：是否重名
	 * @param po
	 * @return
	 */
	private ResultMessage checkNewPromotionStyle(PromotionPO po) {
		ArrayList<PromotionPO> promotionPO;
		ArrayList<String> hotelIDList;
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
			// TODO 这里需要访问hotel表，获得所有的hotelID，总觉得让promotionDAO做这种事不太好。。。。。。
			if (po.hotelID != null) {
				hotelIDList = new ArrayList<>();
				PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select hotelid from hotel");
				ResultSet resultSet = preparedStatement.executeQuery();
				boolean isExsit = false;
				while (resultSet.next()) {
					String hotelID = resultSet.getString("hotelid");
					if (hotelID.equals(po.hotelID)) {
						isExsit = true;
						break;
					}
				}
				if (!isExsit) {
					return ResultMessage.NOT_EXIST;
				}
			}
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	
}
