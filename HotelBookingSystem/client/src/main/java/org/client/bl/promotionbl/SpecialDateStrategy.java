package org.client.bl.promotionbl;

public class SpecialDateStrategy implements PromotionStrategy {

	double discount;
	
	SpecialDateStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
