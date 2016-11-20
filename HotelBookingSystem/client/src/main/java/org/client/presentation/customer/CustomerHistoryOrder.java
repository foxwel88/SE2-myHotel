package org.client.presentation.customer;

import javafx.fxml.FXML;

/**
 * 
 * 客户-浏览客户历史订单
 *
 */
public class CustomerHistoryOrder {
	@FXML
	void turnToCustomerMain() {
		SwitchSceneUtil.turnToCustomerMain();
	}
	
	@FXML
	void turnToCustomerInfo() {
		SwitchSceneUtil.turnToCustomerInfo();
	}
	
	@FXML
	void turnToCustomerHotelList() {
		SwitchSceneUtil.turnToCustomerHotelList();
	}
	
	@FXML
	void turnToCustomerUnexcutedOrderList() {
		SwitchSceneUtil.turnToCustomerUnexcutedOrderList();
	}
}
