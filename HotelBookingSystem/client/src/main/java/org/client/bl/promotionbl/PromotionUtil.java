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

	/**获得可以使用的最便宜的一个酒店促销策略和一个网站促销策略
	 * @return bestPromotion, 顺序是酒店、网站，list size <= 2 */
	//通过排序两个种类的促销策略列表实现
	static List<PromotionVO> getPromotion (String hotelID, String userID, int roomNum) {
		List<Promotion> hotelPromotion = getCanBeUsedHotelPromotion(hotelID, userID, roomNum);
		List<Promotion> webPromotion = getCanBeUsedWebsitePromotion(hotelID, userID, roomNum);
		Collections.sort(hotelPromotion);
		Collections.sort(webPromotion);
		ArrayList<PromotionVO> bestPromotion = new ArrayList<>();
		try {
			bestPromotion.add(hotelPromotion.get(0).toVO());
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// nothing to do
			// 出现此异常说明没有可享用的酒店促销策略
		}
		try {
			bestPromotion.add(webPromotion.get(0).toVO());
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// nothing to do
			// 出现此异常说明没有可享用的网站促销策略
		}
		return bestPromotion;
	}

	/**获得酒店的所有促销策略 */
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

		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		return promotionList;
	}

	/**获得网站的所有促销策略 */
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

		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		return promotionList;
	}
	
	/**
	 * 这个方法会分别找到适用于某人的所有酒店促销策略和网站促销策略，然后交给PromotionPriceCalculator计算价格
	 */
	static double getPrice (String userID, String hotelID, int roomNum, double rawPrice) {
		ArrayList<Promotion> hotelPromotionList = getCanBeUsedHotelPromotion(hotelID, userID, roomNum);
		ArrayList<Promotion> websitePromotionList = getCanBeUsedWebsitePromotion(hotelID, userID, roomNum);
		
		PromotionPriceCalculator priceCalculator = new PromotionPriceCalculator(hotelPromotionList, websitePromotionList);
		return priceCalculator.getPrice(rawPrice);
	}
	
	private static ArrayList<Promotion> getCanBeUsedHotelPromotion(String hotelID, String userID, int roomNum) {
		List<Promotion> hotelPromotionList = showHotelPromotion(hotelID);
		ArrayList<Promotion> canBeUsedHotelPromotion = new ArrayList<>();
		
		for (Promotion hotelPromotion: hotelPromotionList) {
			if (hotelPromotion.canBeUsed(hotelID, userID, roomNum)) {
				canBeUsedHotelPromotion.add(hotelPromotion);
			}
		}
		
		return canBeUsedHotelPromotion;
	}
	
	private static ArrayList<Promotion> getCanBeUsedWebsitePromotion(String hotelID, String userID, int roomNum) {
		List<Promotion> websitePromotionList = showWebsitePromotion();
		ArrayList<Promotion> canBeUsedWebsitePromotion = new ArrayList<>();
		
		for (Promotion webPromotion: websitePromotionList) {
			if (webPromotion.canBeUsed(hotelID, userID, roomNum)) {
				canBeUsedWebsitePromotion.add(webPromotion);
			}
		}
		
		return canBeUsedWebsitePromotion;
	}

	static List<String> getAdvertisedHotels() {
		if (promotionDataService == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			setDAO(rmihelper.getPromotionDataServiceImpl());
		}
		try {
			return promotionDataService.getAdvertisedHotels();
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}


}
