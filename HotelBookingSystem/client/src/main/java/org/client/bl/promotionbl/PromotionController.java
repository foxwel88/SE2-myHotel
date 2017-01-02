package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.List;

import org.client.blservice.promotionblservice.PromotionBlService;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

/**
 * bl层promotion模块的控制器类
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
public class PromotionController implements PromotionBlService {
	
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

	@Override
	public ResultMessage add(PromotionVO vo) {
		return PromotionUtil.add(vo);
	}
	
	/**
	 * 获得两个Promotion，分别是最优的网站促销策略和最优的酒店促销策略
	 */
	@Override
	public List<PromotionVO> getPromotion(String hotelID, String userID, int roomNum) {
		return PromotionUtil.getPromotion(hotelID, userID, roomNum);
	}

	@Override
	public List<PromotionVO> showHotelPromotion(String hotelID) {
		hotelPromotionList = PromotionUtil.showHotelPromotion(hotelID);
		
		List<PromotionVO> tempVOList = new ArrayList<>();
		
		for (int i = 0; i < hotelPromotionList.size(); i++) {
			tempVOList.add(hotelPromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	@Override
	public List<PromotionVO> showWebsitePromotion() {
		websitePromotionList = PromotionUtil.showWebsitePromotion();
		
		List<PromotionVO> tempVOList = new ArrayList<>();
		
		for (int i = 0; i < websitePromotionList.size(); i++) {
			tempVOList.add(websitePromotionList.get(i).toVO());
		}
		
		return tempVOList;
	}

	@Override
	public ResultMessage modify(PromotionVO vo) {
		return new Promotion().modify(vo);
	}

	@Override
	public ResultMessage delete(String promotionID) {
		return PromotionUtil.delete(promotionID);
	}

	@Override
	public LevelVO showLevel() {
		return new Level().showLevel();
	}

	@Override
	public ResultMessage modifyLevel(LevelVO vo) {
		return new Level().modifyLevel(vo);
	}

	@Override
	public double getPrice(String userID, String hotelID, int roomNum, double rawPrice) {
		return PromotionUtil.getPrice(userID, hotelID, roomNum, rawPrice);
	}

	@Override
	public int calculateLevel(double credit) {
		return new Level().calculateLevel(credit);
	}

	@Override
	public List<String> getAdvertisedHotels() {
		return PromotionUtil.getAdvertisedHotels();
	}

}
