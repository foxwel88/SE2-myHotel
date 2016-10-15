package org.server.data.PromotionData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8003664894492865142L;

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

	public ArrayList<PromotionPO> showHotelPromotion(String hotelAddress) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionPO> showWebsitePromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LevelPO showLevel() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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

	public void getPromotion(String hotelAddress, String userID) throws RemoteException  {
		// TODO Auto-generated method stub
		
	}
	
}
