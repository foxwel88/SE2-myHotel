package org.client.bl.promotionbl;

/**
 * 各类promotion的策略类，专门用于提供不同促销策略的价格算法
 * @author fraliphsoft
 * @version fraliphsoft 12/7
 */
public interface PromotionStrategy {
	
	double getPrice (double rawPrice);
	
}
