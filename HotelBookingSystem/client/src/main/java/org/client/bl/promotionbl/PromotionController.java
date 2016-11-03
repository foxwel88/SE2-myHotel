package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.List;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

public class PromotionController implements Promotionblservice{

	public ResultMessage add(PromotionVO vo) {
		return null;
	}

	public List<PromotionVO> getPromotion(String hotelAddress, String userID) {
		ArrayList<PromotionVO> promotionVOList = new ArrayList();
		return promotionVOList;
	}

	public List<PromotionVO> showHotelPromotion(String hotelAddress) {
		ArrayList<PromotionVO> promotionVOList = new ArrayList();
		return promotionVOList;
	}

	public List<PromotionVO> showWebsitePromotion() {
		ArrayList<PromotionVO> promotionVOList = new ArrayList();
		return promotionVOList;
	}

	public ResultMessage modify(PromotionVO vo) {
		return null;
	}

	public LevelVO showLevel() {
		return new LevelVO(0, new ArrayList<Integer>());
	}

	public ResultMessage modifyLevel(LevelVO vo) {
		return null;
	}

}
