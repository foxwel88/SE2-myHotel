package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

/**
 * Promotion模块的工具类，实现了大部分逻辑
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
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
			return promotionDataService.add(new Promotion(vo).toPO());
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	static ResultMessage delete(String promotionID) {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		
		try {
			return promotionDataService.delete(promotionID);
		} catch (RemoteException remoteException) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	static List<PromotionVO> getPromotion (String hotelID, String userID, int roomNum) {
		List<Promotion> hotelPromotion = getCanBeUsedHotelPromotion(hotelID, userID, roomNum);
		List<Promotion> webPromotion = getCanBeUsedWebsitePromotion(hotelID, userID, roomNum);
		Collections.sort(hotelPromotion);
		Collections.sort(webPromotion);
		ArrayList<PromotionVO> bestPromotion = new ArrayList<>();
		try {
			bestPromotion.add(hotelPromotion.get(0).toVO());
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// nothing to  do
			// 出现此异常说明没有可享用的酒店促销策略
		}
		try {
			bestPromotion.add(webPromotion.get(0).toVO());
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// nothing to  do
			// 出现此异常说明没有可享用的网站促销策略
		}
		return bestPromotion;
	}
	
	static List<Promotion> showHotelPromotion (String hotelID) {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		
		ArrayList<Promotion> promotionList = new ArrayList<>();
		
		try {
			List<PromotionPO> promotionPOList = promotionDataService.showHotelPromotion(hotelID);
			
			if (promotionPOList == null) {
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
		
		ArrayList<Promotion> promotionList = new ArrayList<>();
		
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
	
	/**
	 * 这个方法会分别找到适用于某人的酒店促销策略和网站促销策略，然后交给PromotionPriceCalculater计算价格
	 * @param userID
	 * @param hotelID
	 * @param rawPrice
	 * @return
	 */
	static double getPrice (String userID, String hotelID, int roomNum, double rawPrice) {
		ArrayList<Promotion> hotelPromotionList = getCanBeUsedHotelPromotion(hotelID, userID, roomNum);
		ArrayList<Promotion> websitePromotionList = getCanBeUsedWebsitePromotion(hotelID, userID, roomNum);
		
		PromotionPriceCalculator priceCalculator = new PromotionPriceCalculator(hotelPromotionList, websitePromotionList);
		return priceCalculator.getPrice(rawPrice);
	}
	
	// TODO 放到界面层检查
//	/**
//	 * 添加新的促销策略或者修改已有促销策略时，以下情况返回格式错误的ResultMessage：
//	 * 		Promotion类型不存在
//	 * 		Promotion的开始时间早于服务器系统时间
//	 * 		Promotion结束时间早于开始时间
//	 * 		添加时已有同名Promotion存在或者修改时无此Promotion存在
//	 * 		折扣范围小于等于0或者大于等于10
//	 * 		商圈不存在
//	 * 		最低适用等级不在Level规定的范围内
//	 */
//	static boolean checkPromotionFormat(PromotionVO vo, boolean isNew) {
//		boolean isOK = true;
//		if (PromotionType.getType(vo.type) == null) {
//			isOK = false;
//		}
////		if (promotion的结束时间早于服务器系统时间) {
////			isOK = false;
////		}
//		if (!vo.startTime.before(vo.endTime)) {
//			isOK = false;
//		}
////		if (isNew) {
////			if (同名) {
////				isOK = false;
////			}
////		} else {
////			if(不同名) {
////				isOK = false;
////			}
////		}
//		if (vo.discount <= 0 || vo.discount >= 10) {
//			isOK = false;
//		}
////		if (商圈不存在) {
////			isOK = false;
////		}
////		if (等级范围) {
////			isOK = false;
////		}
//		return isOK;
//	}
	
	private static ArrayList<Promotion> getCanBeUsedHotelPromotion(String hotelID, String userID, int roomNum) {
		List<Promotion> hotelPromotionList = showHotelPromotion(hotelID);
		ArrayList<Promotion> canBeUsedHotelPromotion = new ArrayList<>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (checkCanBeUse(hotelPromotionList.get(i), hotelID, userID, roomNum)) {
				canBeUsedHotelPromotion.add(hotelPromotionList.get(i));
			}
		}
		
		return canBeUsedHotelPromotion;
	}
	
	private static ArrayList<Promotion> getCanBeUsedWebsitePromotion(String hotelID, String userID, int roomNum) {
		List<Promotion> websitePromotionList = showWebsitePromotion();
		ArrayList<Promotion> canBeUsedWebsitePromotion = new ArrayList<>();
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			if (checkCanBeUse(websitePromotionList.get(i), hotelID, userID, roomNum)) {
				canBeUsedWebsitePromotion.add(websitePromotionList.get(i));
			}
		}
		
		return canBeUsedWebsitePromotion;
	}
	
	/**
	 * 检查某个酒店的促销策略或者网站促销策略是否适用于某人
	 * @param promotion
	 * @param hotelID
	 * @param userID
	 * @return
	 */
	private static boolean checkCanBeUse(Promotion promotion, String hotelID, String userID, int roomNum) {
		return promotion.canBeUsed(hotelID, userID, roomNum);
	}
}
