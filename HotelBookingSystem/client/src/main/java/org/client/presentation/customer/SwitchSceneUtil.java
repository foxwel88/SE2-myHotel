package org.client.presentation.customer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwitchSceneUtil {
	private static Stage stage = null;
	
	private static GridPane gridpane;
	
	public static void setStage(Stage stage) {
		SwitchSceneUtil.stage = stage;
	}
	
	static void turnToCusController_Main() {
		switchindex("/客户/导航_主界面.fxml");
		stage.setTitle("酒店预订管理系统");
		stage.show();
	}
	
	static void turnToCusController_CusInfo() {
		switchindex("/客户/导航_客户信息.fxml");
		turnToCustomerInfo(new AnchorPane());
	}
	
	static void turnToCusController_HotelList() {
		switchindex("/客户/导航_酒店列表.fxml");
		turnToCustomerHotelList(new AnchorPane());
	}
	
	static void turnToCusController_HistoryOrderList() {
		switchindex("/客户/导航_历史订单.fxml");
		turnToCustomerHistoryOrderList(new AnchorPane());
	}
	
	static void turnToCusController_UnexcutedOrderList() {
		switchindex("/客户/导航_未执行订单.fxml");
		turnToCustomerUnexcutedOrderList(new AnchorPane());
	}
	
	static void turnToCustomerInfo(AnchorPane root) {
		turnToAnotherScene(root, "/客户/查看客户信息界面.fxml");
	}
	
	static void turnToCustomerHotelList(AnchorPane root) {
		turnToAnotherScene(root, "/客户/浏览酒店界面.fxml");
	}
	
	static void turnToCustomerHistoryOrderList(AnchorPane root) {
		turnToAnotherScene(root, "/客户/浏览客户历史订单界面.fxml");
	}
	
	static void turnToCustomerUnexcutedOrderList(AnchorPane root) {
		turnToAnotherScene(root, "/客户/浏览客户未执行订单界面.fxml");
	}
	
	static void turnToCustomerCheckCredit(AnchorPane root) {
		turnToAnotherScene(root, "/客户/查看信用记录界面.fxml");
	}
	
	static void turnToCustomerModifyInfo(AnchorPane root) {
		turnToAnotherScene(root, "/客户/修改客户信息界面.fxml");
	}
	
	static void turnToCustomerGenerateOrder(AnchorPane root) {
		turnToAnotherScene(root, "/客户/生成订单界面.fxml");
	}
	
	
	
	/*
	 * 此方法用于加载导航栏
	 */
	private static void switchindex(String resource) {
		try {
			Parent parent = FXMLLoader.load(SwitchSceneUtil.class.getResource(resource));
			stage.setScene(new Scene(parent));
			gridpane = getGridpane(parent);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * 此方法用于加载除了导航栏以外的界面
	 */
	private static void turnToAnotherScene(AnchorPane root, String resource) {
		try {
			root = FXMLLoader.load(SwitchSceneUtil.class.getResource(resource));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		GridPane.setConstraints(root, 1, 0);
		if (gridpane.getChildren().size() > 1) {
			gridpane.getChildren().set(1, root);
		} else {
			gridpane.getChildren().add(1, root);
		}
	}
	
	private static GridPane getGridpane(Parent parent) {
		return (GridPane)(((Parent)((Parent)parent.getChildrenUnmodifiable().get(1)).getChildrenUnmodifiable().get(0)).getChildrenUnmodifiable().get(0));
	}
}
