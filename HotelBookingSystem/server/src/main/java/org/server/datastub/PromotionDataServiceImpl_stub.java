package org.server.datastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public class PromotionDataServiceImpl_stub implements PromotionDataService{

	public ResultMessage add(PromotionPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(PromotionPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<PromotionPO> showHotelPromotion(String hotelAddress) throws RemoteException {
		ArrayList<PromotionPO> promotions = new ArrayList<PromotionPO>();
		promotions.add(new PromotionPO(null, null, null, hotelAddress, 0, hotelAddress, 0));
		return promotions;
	}

	public ArrayList<PromotionPO> showWebsitePromotion() throws RemoteException {
		ArrayList<PromotionPO> promotions = new ArrayList<PromotionPO>();
		promotions.add(new PromotionPO(null, null, null, "", 0, "", 0));
		return promotions;
	}

	public ResultMessage delete(PromotionPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public LevelPO showLevel() throws RemoteException {
		return new LevelPO(0, null);
	}

	public ResultMessage modifyLevel(LevelPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}


}
