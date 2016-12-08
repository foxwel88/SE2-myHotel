package org.client.bl.promotionbl;

import org.common.utility.PromotionType;

/**
 * 为不同的Promotion创建不同PromotionStrategy的工厂类
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
public class PromotionStrategyFactory {
	
	/**
	 * 
	 * @param type 促销策略的类型
	 * @param value 具体促销的促销值
	 * @return
	 */
	static PromotionStrategy getSuitableStrategy(String type, double value) {
		switch (PromotionType.getType(type)) {
			case BIRTHDAYBONUS:
				return new BirthdayBonusStrategy(value);
			case COMPANYBONUS:
				return new CompanyBonusStrategy(value);
			case TRIPLEROOMBONUS:
				return new TripleRoomBonusStrategy(value);
			case SPECIALDATE:
				return new SpecialDateStrategy(value);
			case VIPLEVEL:
				return new VIPLevelStrategy(value);
			case SPECIALAREA:
				return new SpecialAreaStrategy(value);
			default:
				return new EmptyPromotionStrategy();
		}
	}
	
}
