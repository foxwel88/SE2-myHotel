package org.client.presentation.customer;

import javafx.fxml.FXML;

/**
 * 
 * 客户-查看客户信息
 *
 */

public class CustomerCheckInfo {
	@FXML
	void turnToCustomerMain() {
		SwitchSceneUtil.turnToCustomerMain();
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
	void turnToCustomerCheckCredit() {
		SwitchSceneUtil.turnToCustomerCheckCredit();
	}
	
	@FXML
	void turnToCustomerModifyInfo() {
		SwitchSceneUtil.turnToCustomerModifyInfo();
	}
}
