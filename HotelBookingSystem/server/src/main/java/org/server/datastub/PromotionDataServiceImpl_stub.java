package org.server.datastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public class PromotionDataServiceImpl_stub implements PromotionDataService{

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

	public void getPromotion(String hotelAddress, String userID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
