package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.List;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

public class PromotionController implements Promotionblservice {
	
	private static PromotionController promotionController;
	
	private List<Promotion> hotelPromotionList;
	
	private List<Promotion> websitePromotionList;
	
	private Level level;
	
	private PromotionController() {
		hotelPromotionList = new ArrayList<Promotion>();
		
		websitePromotionList = new ArrayList<Promotion>();
		
		level = Level.getInstance();
	}
	
	public static PromotionController getInstance() {
		if (promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}

	public ResultMessage add(PromotionVO vo) {
		return PromotionUtil.add(vo);
	}

	public List<PromotionVO> getPromotion(String hotelAddress, String userID) {
		return PromotionUtil.getPromotion(hotelAddress, userID);
	}

	public List<PromotionVO> showHotelPromotion(String hotelAddress) {
		hotelPromotionList = PromotionUtil.showHotelPromotion(hotelAddress);
		
		List<PromotionVO> tempVOList = new ArrayList<PromotionVO>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			tempVOList.add(hotelPromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	public List<PromotionVO> showWebsitePromotion() {
		websitePromotionList = PromotionUtil.showWebsitePromotion();
		
		List<PromotionVO> tempVOList = new ArrayList<PromotionVO>();
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			tempVOList.add(websitePromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	public ResultMessage modify(PromotionVO vo) {
		Promotion promotion = null;
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (vo.name == hotelPromotionList.get(i).name) {
				promotion = hotelPromotionList.get(i);
			}
		}
		for (int i = 0; i < websitePromotionList.size(); i++) {
			if (vo.name == websitePromotionList.get(i).name) {
				promotion = websitePromotionList.get(i);
			}
		}
		if (promotion == null) {
			return ResultMessage.NOT_EXIST;
		} else {
			return promotion.modify(vo);
		}
	}

	public LevelVO showLevel() {
		return level.showLevel();
	}

	public ResultMessage modifyLevel(LevelVO vo) {
		return level.modifyLevel(vo);
	}
	
	public double getPrice (String userID, String hotelAddress, double rawPrice) {
		return PromotionUtil.getPrice(userID, hotelAddress, rawPrice);
	}

}
