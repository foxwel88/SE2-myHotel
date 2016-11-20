package org.client.presentation.customer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * 
 * 客户-主界面
 *
 */

public class CustomerMain {
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
	
	public static void setStage(Stage stage) {
		
	}
}
