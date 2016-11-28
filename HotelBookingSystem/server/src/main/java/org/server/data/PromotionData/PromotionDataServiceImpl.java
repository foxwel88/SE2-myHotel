package org.server.data.PromotionData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
	
	private DatabaseCommunicator communicator;

	public PromotionDataServiceImpl() throws RemoteException {
		System.out.println("promotion start");
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
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

	public LevelPO showLevel() throws RemoteException {
		communicator = DatabaseCommunicator.getInstance();
		ArrayList<Integer> levelNumList = new ArrayList<>(communicator.getLevel_LevelNum());
		ArrayList<Double> creditsList = new ArrayList<>(communicator.getLevel_Credits());
		ArrayList<Double> badList = new ArrayList<>();
		for (double sadNum:creditsList) {
			badList.add(sadNum);
		}
		LevelPO levelPO = new LevelPO(levelNumList.size(), badList);
//		LevelPO levelPO = new LevelPO(levelNumList.size(), creditsList);
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
