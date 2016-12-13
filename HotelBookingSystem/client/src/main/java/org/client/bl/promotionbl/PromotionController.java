package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.List;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

/**
 * bl层promotion模块的控制器类
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
public class PromotionController implements Promotionblservice {
	
	private static PromotionController promotionController;
	
	private List<Promotion> hotelPromotionList;
	
	private List<Promotion> websitePromotionList;
	
	private PromotionController() {
		hotelPromotionList = new ArrayList<>();
		
		websitePromotionList = new ArrayList<>();
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

	public List<PromotionVO> getPromotion(String hotelID, String userID) {
		return PromotionUtil.getPromotion(hotelID, userID);
	}

	public List<PromotionVO> showHotelPromotion(String hotelID) {
		hotelPromotionList = PromotionUtil.showHotelPromotion(hotelID);
		
		List<PromotionVO> tempVOList = new ArrayList<>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			tempVOList.add(hotelPromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	public List<PromotionVO> showWebsitePromotion() {
		websitePromotionList = PromotionUtil.showWebsitePromotion();
		
		List<PromotionVO> tempVOList = new ArrayList<>();
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			tempVOList.add(websitePromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	public ResultMessage modify(PromotionVO vo) {
		return new Promotion().modify(vo);
	}
	
	public ResultMessage delete(String promotionID) {
		return PromotionUtil.delete(promotionID);
	}

	public LevelVO showLevel() {
		return new Level().showLevel();
	}

	public ResultMessage modifyLevel(LevelVO vo) {
		return new Level().modifyLevel(vo);
	}
	
	public double getPrice (String userID, String hotelID, double rawPrice) {
		return PromotionUtil.getPrice(userID, hotelID, rawPrice);
	}
	
	public int calLevel(double credit) {
		return new Level().calLevel(credit);
	}

}
