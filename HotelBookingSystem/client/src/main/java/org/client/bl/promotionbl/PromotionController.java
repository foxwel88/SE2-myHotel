package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

/**
 * bl层promotion模块的控制器类
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class PromotionController implements Promotionblservice {
	
	private static PromotionController promotionController;
	
	private List<Promotion> hotelPromotionList;
	
	private List<Promotion> websitePromotionList;
	
	private Level level;
	
	private PromotionController() {
		hotelPromotionList = new ArrayList<>();
		
		websitePromotionList = new ArrayList<>();
		
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
		Promotion promotion = null;
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			if (Objects.equals(vo.name, hotelPromotionList.get(i).name)) {
				promotion = hotelPromotionList.get(i);
			}
		}
		for (int i = 0; i < websitePromotionList.size(); i++) {
			if (Objects.equals(vo.name, websitePromotionList.get(i).name)) {
				promotion = websitePromotionList.get(i);
			}
		}
		if (promotion == null) {
			return ResultMessage.NOT_EXIST;
		} else {
			return promotion.modify(vo);
		}
	}
	
	public ResultMessage delete(String promotionID) {
		return PromotionUtil.delete(promotionID);
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
	
	public int calLevel(double credit) {
		return level.calLevel(credit);
	}

}
