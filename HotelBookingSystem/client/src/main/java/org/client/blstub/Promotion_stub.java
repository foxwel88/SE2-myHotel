package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

public class Promotion_stub implements Promotionblservice{
	
	PromotionVO vo1=new PromotionVO(PromotionType.SPECIALDATE, new Date(), new Date(), "goodhotel",2 , "lalal", 0.8, null);
	PromotionVO vo2=new PromotionVO(PromotionType.SPECIALDATE, new Date(), new Date(), "goodhotel",2 , "lalal", 0.8, null);
	ArrayList<PromotionVO> vo=new ArrayList<PromotionVO>();

	public ResultMessage add(PromotionVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ArrayList<PromotionVO> getPromotion(String hotelAddress, String userID) {
		// TODO Auto-generated method stub
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

	public ArrayList<PromotionVO> showHotelPromotion(String hotelAddress) {
		// TODO Auto-generated method stub
		return vo;
	}

	public ArrayList<PromotionVO> showWebsitePromotion() {
		// TODO Auto-generated method stub
		return vo;
	}

	public ResultMessage modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(PromotionVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public LevelVO showLevel() {
		// TODO Auto-generated method stub
		ArrayList<Integer> level=new ArrayList<Integer>();
		level.add(100);
		level.add(200);
		level.add(300);
		level.add(400);
		level.add(500);
		return new LevelVO(5,level);
	}

	public ResultMessage modifyLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	

}
