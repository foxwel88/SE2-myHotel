package org.client.bl.promotionbl;

/**
 * 空促销策略，相当于Promotion的“0”值
 * @author fraliphsoft
 * @version fraliphsoft 12/6
 */
public class EmptyPromotionStrategy implements PromotionStrategy {
	
	@Override
	public double getPrice(double rawPrice) {
		return rawPrice;
	}
}
