package org.client.blservice.promotionblservice;

import java.util.ArrayList;

import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

public interface Promotionblservice {
	public ResultMessage add(PromotionVO vo);
	
	public ArrayList<PromotionVO> getPromotion(String hotelAddress, String userID);
	
	public ArrayList<PromotionVO> showHotelPromotion(String hotelAddress);
	
	public ArrayList<PromotionVO> showWebsitePromotion();
	
	public ResultMessage modify(PromotionVO vo);
	
	public ResultMessage delete(PromotionVO vo);
	
	public LevelVO showLevel();
	
	public ResultMessage modifyLevel(LevelVO vo);
	
	
}
