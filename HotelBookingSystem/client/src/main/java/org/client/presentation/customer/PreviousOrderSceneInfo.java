package org.client.presentation.customer;

/**
 * 此界面用于保存跳转到子界面之前，各种订单列表界面的信息，以便后退按钮使用
 * 此类的实例化对象的成员属性均为Read-Only
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class PreviousOrderSceneInfo {
	
	// 保存历史订单列表界面和未执行订单列表界面所处的页码
	// Attention！！！如果从未执行订单列表的最后一页跳转到未执行订单详细信息界面，可能会因为撤销订单导致列表的最大页数发生变化，因此获得此信息后需要再次检查
	final int currentPage;
	
	/**
	 * @param currentPage 历史订单列表界面和未执行订单列表界面所处的页码
	 */
	public PreviousOrderSceneInfo(int currentPage) {
		this.currentPage = currentPage;
	}

}
