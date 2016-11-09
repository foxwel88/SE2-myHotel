package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

public class PromotionUtil {
	
	private static PromotionDataService promotionDataService = null;
	
	static void setDAO (PromotionDataService promotionDAO) {
		promotionDataService = promotionDAO;
	}
	
	static ResultMessage add(PromotionVO vo) {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		
		try {
			if (checkPromotionFormat(vo, true)) {
				return promotionDataService.add(new Promotion(vo).toPO());
			} else {
				return ResultMessage.WRONG_FORMAT;
			}
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	static List<PromotionVO> getPromotion (String hotelAddress, String userID) {
		List<Promotion> okPromotion = getCanBeUsedHotelPromotion(hotelAddress, userID);
		
		okPromotion.addAll(getCanBeUsedWebsitePromotion(hotelAddress, userID));
		
		System.out.println(okPromotion.size());
		
		List<PromotionVO> okPromotionVO = new ArrayList<PromotionVO>();
		
		for (int i = 0; i < okPromotion.size(); i++) {
			okPromotionVO.add(okPromotion.get(i).toVO());
		}
		
		return okPromotionVO;
	}
	
	static List<Promotion> showHotelPromotion (String hotelAddress) {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		
		try {
			List<PromotionPO> promotionPOList = promotionDataService.showHotelPromotion(hotelAddress);
			
			if (promotionPOList == null) {
				promotionList.add(new Promotion(new PromotionVO(ResultMessage.NOT_EXIST)));
				
				return promotionList;
			}
			
			for (int i = 0; i < promotionPOList.size(); i++) {
				promotionList.add(new Promotion(promotionPOList.get(i)));
			}
			
			return promotionList;
		} catch (RemoteException rex) {
			return null;
		}
	}
	
	static List<Promotion> showWebsitePromotion() {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		
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
	
	static double getPrice (String userID, String hotelAddress, double rawPrice) {
		List<Promotion> hotelPromotionList = getCanBeUsedHotelPromotion(hotelAddress, userID);
		
		List<Promotion> websitePromotionList = getCanBeUsedWebsitePromotion(hotelAddress, userID);
		
		int h = 0, w = 0;
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (hotelPromotionList.get(i).discount < hotelPromotionList.get(h).discount) {
				h = i;
			}
		}
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (websitePromotionList.get(i).discount < websitePromotionList.get(w).discount) {
				w = i;
			}
		}
		double discount = hotelPromotionList.get(h).discount * websitePromotionList.get(w).discount;
		return (rawPrice * discount) / 100;
	}
	
	/**
	 * 添加新的促销策略或者修改已有促销策略时，以下情况返回格式错误的ResultMessage：
	 * 		Promotion类型不存在
	 * 		Promotion的开始时间早于服务器系统时间	//TODO
	 * 		Promotion结束时间早于开始时间
	 * 		添加时已有同名Promotion存在或者修改时无此Promotion存在		//TODO
	 * 		折扣范围小于等于0或者大于等于10
	 * 		商圈不存在	//TODO
	 * 		最低适用等级不在Level规定的范围内	//TODO
	 */
	static boolean checkPromotionFormat(PromotionVO vo, boolean isNew) {
		boolean isOK = true;
		if (PromotionType.getType(vo.type) == null) {
			isOK = false;
		}
//		if (promotion的结束时间早于服务器系统时间) {
//			isOK = false;
//		}
		if (!vo.startTime.before(vo.endTime)) {
			isOK = false;
		}
//		if (isNew) {
//			if (同名) {
//				isOK = false;
//			}
//		} else {
//			if(不同名) {
//				isOK = false;
//			}
//		}
		if (vo.discount <= 0 || vo.discount >= 10) {
			isOK = false;
		}
//		if (商圈不存在) {
//			isOK = false;
//		}
//		if (等级范围) {
//			isOK = false;
//		}
		return isOK;
	}
	
	private static List<Promotion> getCanBeUsedHotelPromotion(String hotelAddress, String userID) {
		List<Promotion> hotelPromotionList = showHotelPromotion(hotelAddress);
		
		ArrayList<Promotion> canBeUsedHotelPromotion = new ArrayList<Promotion>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (checkCanBeUse(hotelPromotionList.get(i), hotelAddress, userID)) {
				canBeUsedHotelPromotion.add(hotelPromotionList.get(i));
			}
		}
		
		return canBeUsedHotelPromotion;
	}
	
	private static List<Promotion> getCanBeUsedWebsitePromotion(String hotelAddress, String userID) {
		List<Promotion> websitePromotionList = showWebsitePromotion();
		
		ArrayList<Promotion> canBeUsedWebsitePromotion = new ArrayList<Promotion>();
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			if (checkCanBeUse(websitePromotionList.get(i), hotelAddress, userID)) {
				canBeUsedWebsitePromotion.add(websitePromotionList.get(i));
			}
		}
		
		return canBeUsedWebsitePromotion;
	}
	
	private static boolean checkCanBeUse(Promotion promotion, String hotelAddress, String userID) {
		boolean isOK = true;
		// TODO
		return isOK;
	}
	
}
