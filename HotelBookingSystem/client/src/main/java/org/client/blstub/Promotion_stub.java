package org.client.blstub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

public class Promotion_stub implements Promotionblservice {
	
	PromotionVO vo1 = new PromotionVO("i'm an id", "hotel", PromotionType.SPECIALDATE.getString()
			, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "goodhotel","address",2 , "", "", 7.5, "期末特惠");
	
	PromotionVO vo2 = new PromotionVO("i'm an id", "web", PromotionType.SPECIALAREA.getString()
			, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "","",2 , "南京", "仙林中心", 7.8, "仙林中心地区促销活动");
	
	PromotionVO vo3 = new PromotionVO("i'm an id", "hotel", PromotionType.BIRTHDAYBONUS.getString()
			, new Date(), new Date(), "goodhotel","address",1 , "", "", 8, "生日特惠");
	
	ArrayList<PromotionVO> generalVOs = new ArrayList<>(Arrays.asList(new PromotionVO[]{vo1, vo2, vo3}));
	
	ArrayList<PromotionVO> hotelVOs = new ArrayList<>(Arrays.asList(new PromotionVO[]{vo1, vo3}));
	
	public ResultMessage add(PromotionVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ArrayList<PromotionVO> getPromotion(String hotelAddress, String userID) {
		// TODO Auto-generated method stub
		return generalVOs;
	}

	public ArrayList<PromotionVO> showHotelPromotion(String hotelAddress) {
		// TODO Auto-generated method stub
		return hotelVOs;
	}

	public ArrayList<PromotionVO> showWebsitePromotion() {
		// TODO Auto-generated method stub
		return generalVOs;
	}
	
	public double getPrice (String userID, String hotelID, double rawPrice) {
		return 25;
	}

	public ResultMessage modify(PromotionVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage delete(String PromotionID) {
		// TODO
		return ResultMessage.SUCCESS;
	}

	public LevelVO showLevel() {
		// TODO Auto-generated method stub
		ArrayList<Double> level = new ArrayList<>();
		level.add(100.0);
		level.add(200.0);
		level.add(300.0);
		level.add(400.0);
		level.add(500.0);
		return new LevelVO(5,level);
	}

	public ResultMessage modifyLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public int calLevel(double credit) {
		// TODO Auto-generated method stub
		return 3;
	}
}
