package org.client.presentation.customer;

import javafx.stage.*;

import javafx.application.Application;

/**
 * 
 * 客户-主界面
 *
 */

public class CustomerMain extends Application {
	private static CustomerMain customerMain;
	
	private Stage stage = null;
	
	public static CustomerMain getInstance() {
		if (customerMain == null) {
			customerMain = new CustomerMain();
		}
		return customerMain;
	}
	
	/*
	 * 过一阵子再写setStage的检查
	 * 因为客户进入的第一个页面必然是主界面，因此客户第一次进入主界面的时候setStage方法必须被调用，确保工具类的stage被初始化
	 */
	public void setStage (Stage stage) {
		this.stage = stage;
		SwitchSceneUtil.setStage(stage);
	}
	
	public void turnToCustomerInfo() {
		SwitchSceneUtil.turnToCustomerInfo();
	}
	
	public void turnToCustomerHotelList() {
		SwitchSceneUtil.turnToCustomerHotelList();
	}
	
	public void turnToCustomerHistoryOrderList() {
		SwitchSceneUtil.turnToCustomerHistoryOrderList();
	}
	
	public void turnToCustomerUnexcutedOrderList() {
		SwitchSceneUtil.turnToCustomerUnexcutedOrderList();
	}
	
	/*
	 * 界面测试入口
	 */
	@Override
	public void start(Stage primaryStage) {
		CustomerMain main = CustomerMain.getInstance();
		main.setStage(primaryStage);
		SwitchSceneUtil.turnToCustomerMain();
	}
	
	public static void main(String[] args) {
		launch(args);		
	}
}
