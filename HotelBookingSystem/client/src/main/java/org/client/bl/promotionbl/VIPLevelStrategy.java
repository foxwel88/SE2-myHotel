package org.client.bl.promotionbl;

public class VIPLevelStrategy implements PromotionStrategy {
	
	double discount;
	
	VIPLevelStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
