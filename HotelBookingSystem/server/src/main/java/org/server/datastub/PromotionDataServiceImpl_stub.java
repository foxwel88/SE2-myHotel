package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

public class PromotionDataServiceImpl_stub extends UnicastRemoteObject implements PromotionDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293362855285814646L;

	protected PromotionDataServiceImpl_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNewID() throws RemoteException {
		return "000000000000";
	}

	public ResultMessage add(PromotionPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(PromotionPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ArrayList<PromotionPO> showHotelPromotion(String hotelAddress) throws RemoteException {
		ArrayList<PromotionPO> promotions = new ArrayList<>();
		promotions.add(new PromotionPO("i'm an id", PromotionType.SPECIALDATE, new Date(100000), new Date(1000000), hotelAddress, hotelAddress, 3, hotelAddress, 5, hotelAddress));
		return promotions;
	}

	public ArrayList<PromotionPO> showWebsitePromotion() throws RemoteException {
		ArrayList<PromotionPO> promotions = new ArrayList<>();
		promotions.add(new PromotionPO("i'm an id", PromotionType.BIRTHDAYBONUS, new Date(100000), new Date(1000000), "add", "add", 3, "add", 5, "add"));
		return promotions;
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
