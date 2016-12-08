package org.client.bl.promotionbl;

public class BirthdayBonusStrategy implements PromotionStrategy {
	
	double discount;
	
	BirthdayBonusStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
