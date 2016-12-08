package org.client.bl.promotionbl;

public class CompanyBonusStrategy implements PromotionStrategy {

	double discount;
	
	CompanyBonusStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
