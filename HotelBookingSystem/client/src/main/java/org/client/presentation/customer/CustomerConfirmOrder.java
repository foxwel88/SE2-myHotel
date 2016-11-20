package org.client.presentation.customer;

import javafx.fxml.FXML;

/**
 * 
 * 客户-生成订单确认界面
 *
 */
public class CustomerConfirmOrder {
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
	void turnToCustomerHistoryOrderList() {
		SwitchSceneUtil.turnToCustomerHistoryOrderList();
	}
	
	@FXML
	void turnToCustomerUnexcutedOrderList() {
		SwitchSceneUtil.turnToCustomerUnexcutedOrderList();
	}
}
