package org.client.bl.promotionbl;

public class SpecialAreaStrategy implements PromotionStrategy {

	double discount;
	
	SpecialAreaStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
