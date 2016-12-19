package org.client.blservice.promotionblservice;

import java.util.List;

import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

public interface Promotionblservice {
	
	public ResultMessage add(PromotionVO vo);
	
	public List<PromotionVO> getPromotion(String hotelAddress, String userID);
	
	public List<PromotionVO> showHotelPromotion(String hotelAddress);
	
	public List<PromotionVO> showWebsitePromotion();
	
	public ResultMessage modify(PromotionVO vo);
	
	public ResultMessage delete(String promotionID);
	
	public LevelVO showLevel();
	
	public ResultMessage modifyLevel(LevelVO vo);
	
	public double getPrice (String userID, String hotelID, double rawPrice);
	
	public int calLevel(double credit);
}
