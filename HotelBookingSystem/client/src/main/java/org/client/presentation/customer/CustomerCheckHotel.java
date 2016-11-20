package org.client.presentation.customer;

import javafx.fxml.FXML;

/**
 * 
 * 客户-酒店详细信息
 *
 */

public class CustomerCheckHotel {
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
	
	@FXML
	void turnToCustomerGenerateOrder() {
		SwitchSceneUtil.turnToCustomerGenerateOrder();
	}
}
