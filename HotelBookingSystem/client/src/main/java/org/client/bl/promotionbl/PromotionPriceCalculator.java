package org.client.bl.promotionbl;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 计算综合的促销后的价格的计算类
 * 规定（这个可以补充到需求文档）：如果新的促销方式冲突，优先级为：满减 > 直减 > 折扣
 * 由于现在只有折扣类型，所以现在的promotion只能比较折扣，但考虑其作为可能扩展的功能，特设此类用于计算不同类型促销策略的共同促销价格
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
public class PromotionPriceCalculator {
	ArrayList<Promotion> hotelPromotionList;
	
	ArrayList<Promotion> websitePromotionList;
	
	Promotion bestHotelPromotion;
	
	Promotion bestWebsitePromotion;
	
	PromotionPriceCalculator(ArrayList<Promotion> hotelPromotionList, ArrayList<Promotion> websitePromotionList) {
		this.hotelPromotionList = hotelPromotionList;
		this.websitePromotionList = websitePromotionList;
		if (hotelPromotionList.size() == 0) {
			this.hotelPromotionList.add(new Promotion());
		}
		if (websitePromotionList.size() == 0) {
			this.websitePromotionList.add(new Promotion());
		}
	}

	/**根据一个最佳酒店促销策略和一个最佳网站促销策略，对原始价格进行二次计算 */
	double getPrice(double rawPrice) {
		setBestPromotions();

		// 由于仅有折扣类型的promotion，没有考虑优先级导致的先后折扣问题
		return bestWebsitePromotion.getPrice(bestHotelPromotion.getPrice(rawPrice));
	}
	
	// 由于每人最多同时享用1种酒店促销策略和1种网站促销策略，因此需要筛选出最优的促销策略
	private void setBestPromotions() {
		Collections.sort(hotelPromotionList);
		Collections.sort(websitePromotionList);
		bestHotelPromotion = hotelPromotionList.get(0);
		bestWebsitePromotion = websitePromotionList.get(0);
	}
}
