package org.client.presentation.customer;

/**
 * 这个枚举类只记录能够执行返回上一界面命令的界面名称
 * @author Lenovo
 *
 */
public enum CustomerBackableScene {
	CREDITS_RECORD_SCENE,		// 详细信用记录界面
	MODIFY_INFO_SCENE,			// 修改个人信息界面
	HOTEL_INFO_SCENE,			// 酒店详细信息界面
	EXECUTED_ORDER_SCENE,		// 已执行订单详细信息界面
	CANCELED_ORDER_SCENE,		// 已撤销订单详细信息界面
	ABNORMAL_ORDER_SCENE,		// 异常订单详细信息界面
	UNEXECUTED_ORDER_SCENE,		// 未执行订单详细信息界面
	MAKE_COMMENT_SCENE,			// 评价酒店界面
	GENERATE_ORDER_SCENE		// 生成订单界面
}
