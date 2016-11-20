package org.client.presentation.customer;

import javafx.fxml.FXML;

/**
 * 
 * 客户-异常订单详细信息
 *
 */
public class CustomerAbnomoralOrder {
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
