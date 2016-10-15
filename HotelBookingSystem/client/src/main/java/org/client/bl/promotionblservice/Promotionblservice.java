package org.client.bl.promotionblservice;

import java.util.ArrayList;

public interface Promotionblservice {
	public ResultMessage add(PromotionVO vo);
	
	public ArrayList<PromotionVO> getPromotionByHotel(String hotelAddress);
	
	public ArrayList<PromotionVO> showHotelPromotion(String hotelAddress);
	
	public ArrayList<PromotionVO> showWebsitePromotion();
	
	public ResultMessage modify(PromotionVO vo);
	
	public ResultMessage delete(PromotionVO vo);
	
	public LevelVO showLevel();
	
	public ResultMessage modifyLevel(LevelVO vo);
	
	
}
