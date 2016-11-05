package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public class PromotionUtil {
	
	static ResultMessage add(PromotionVO vo) {
		RMIHelper rmihelper = RMIHelper.getInstance();
		
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		try {
			return promotionDataService.add(new Promotion(vo).toPO());
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTIONFAIL;
		}
	}
	
	static List<PromotionVO> getPromotion (String hotelAddress, String userID) {
		List<Promotion> hotelPromotionList = showHotelPromotion(hotelAddress);
		
		List<Promotion> websitePromotionList = showWebsitePromotion();
		
		ArrayList<PromotionVO> okPromotion = new ArrayList<PromotionVO>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (checkCanBeUse(hotelPromotionList.get(i), hotelAddress, userID)) {
				okPromotion.add(hotelPromotionList.get(i).toVO());
			}
		}
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			if (checkCanBeUse(websitePromotionList.get(i), hotelAddress, userID)) {
				okPromotion.add(websitePromotionList.get(i).toVO());
			}
		}
		
		return okPromotion;
	}
	
	static List<Promotion> showHotelPromotion (String hotelAddress) {
		RMIHelper rmihelper = RMIHelper.getInstance();
		
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		
		try {
			List<PromotionPO> promotionPOList = promotionDataService.showHotelPromotion(hotelAddress);
			
			for (int i = 0; i < promotionPOList.size(); i++) {
				promotionList.add(new Promotion(promotionPOList.get(i)));
			}
			
			return promotionList;
		} catch (RemoteException rex) {
			return null;
		}
	}
	
	static List<Promotion> showWebsitePromotion() {
		RMIHelper rmihelper = RMIHelper.getInstance();
		
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		
		try {
			List<PromotionPO> promotionPOList = promotionDataService.showWebsitePromotion();
			
			for (int i = 0; i < promotionPOList.size(); i++) {
				promotionList.add(new Promotion(promotionPOList.get(i)));
			}
			
			return promotionList;
		} catch (RemoteException rex) {
			return null;
		}
	}
	
	private static boolean checkCanBeUse(Promotion promotion, String hotelAddress, String userID) {
		boolean isOK = true;
		// TODO
		return isOK;
	}
	
}
