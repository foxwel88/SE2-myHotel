package org.client.presentation.customer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * 
 * 客户-主界面
 *
 */

public class CustomerMain extends Application {
	private static CustomerMain customerMain;
	
	private Stage stage = null;
	
	public static CustomerMain getInstance(Stage stage) {
		if (customerMain == null) {
			customerMain = new CustomerMain();
		}
		customerMain.setStage(stage);
		return customerMain;
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
	
	/*
	 * 界面测试入口
	 */
	@Override
	public void start(Stage primaryStage) {
		CustomerMain main = CustomerMain.getInstance(primaryStage);
		SwitchSceneUtil.turnToCustomerMain();
	}
	
	public static void main(String[] args) {
		launch(args);		
	}
	
	private void setStage (Stage stage) {
		this.stage = stage;
		SwitchSceneUtil.setStage(stage);
	}
}
