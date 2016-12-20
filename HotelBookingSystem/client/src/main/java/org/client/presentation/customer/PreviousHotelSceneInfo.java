package org.client.presentation.customer;

import org.common.utility.HotelFilter;

/**
 * 此界面用于保存跳转到子界面之前，酒店列表界面的信息，以便后退按钮使用
 * 此类的实例化对象的成员属性均为Read-Only
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class PreviousHotelSceneInfo {
	// 记录酒店列表界面的酒店筛选条件
	final HotelFilter hotelFilter;
	
	// 记录是否曾经入住
	final boolean everOrdered;
	
	// 保存酒店列表界面所处的页码
	final int currentPage;
	
	public PreviousHotelSceneInfo(HotelFilter hotelFilter, boolean everOrdered, int currentPage) {
		this.hotelFilter = hotelFilter;
		this.everOrdered = everOrdered;
		this.currentPage = currentPage;
	}
}
