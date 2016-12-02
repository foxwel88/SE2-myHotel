package org.server.data.PromotionData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
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
		// TODO
		return null;
	}

	public ResultMessage add(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage delete(String promotionID) throws RemoteException {
		// TODO
		return null;
	}

	public List<PromotionPO> showHotelPromotion(String hotelAddress) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PromotionPO> showWebsitePromotion() throws RemoteException {
		// TODO Auto-generated method stub
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
			ResultSet creditsSet = DatabaseCommunicator.execute(preparedStatement);
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
		// TODO Auto-generated method stub
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
