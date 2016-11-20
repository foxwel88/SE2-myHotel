package org.client.presentation.customer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SwitchSceneUtil {
	private static Stage stage = null;
	
	static void setStage(Stage stage) {
		SwitchSceneUtil.stage = stage;
	}
	
	static void turnToCustomerMain() {
		stage.setTitle("酒店预订管理系统");
		turnToAnotherScene("/客户/客户主界面.fxml");
		stage.show();
	}
	
	static void turnToCustomerInfo() {
		turnToAnotherScene("/客户/查看客户信息界面.fxml");
	}
	
	static void turnToCustomerHotelList() {
		turnToAnotherScene("/客户/浏览酒店界面.fxml");
	}
	
	static void turnToCustomerHistoryOrderList() {
		turnToAnotherScene("/客户/浏览客户历史订单界面.fxml");
	}
	
	static void turnToCustomerUnexcutedOrderList() {
		turnToAnotherScene("/客户/浏览客户未执行订单界面.fxml");
	}
	
	static void turnToCustomerCheckCredit() {
		turnToAnotherScene("/客户/查看信用记录界面.fxml");
	}
	
	static void turnToCustomerModifyInfo() {
		turnToAnotherScene("/客户/修改客户信息界面.fxml");
	}
	
	static void turnToCustomerGenerateOrder() {
		turnToAnotherScene("/客户/生成订单界面.fxml");
	}
		
	private static void turnToAnotherScene(String resource) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SwitchSceneUtil.class.getResource(resource));
			Pane customerRoot = loader.load();
			Scene scene = new Scene(customerRoot, 1100, 680);
			stage.setScene(scene);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
