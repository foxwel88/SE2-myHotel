package org.client.bl.promotionbl;

public class TripleRoomBonusStrategy implements PromotionStrategy {

	double discount;
	
	TripleRoomBonusStrategy(double discount) {
		this.discount = discount;
	}
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice * discount / 10;
	}
}
