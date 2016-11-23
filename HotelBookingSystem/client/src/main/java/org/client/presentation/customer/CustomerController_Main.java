package org.client.presentation.customer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CustomerController_Main {
	@FXML
	GridPane gridpane;
	
	@FXML
	AnchorPane mainTab;
	
	@FXML
	AnchorPane infoTab;
	
	@FXML
	AnchorPane hotelTab;
	
	@FXML
	AnchorPane historyTab;
	
	@FXML
	AnchorPane unexcutedTab;
	
	@FXML
	Label welcomeLabel;
	
	private int presentGuide = 0;
	
	public GridPane getGridPane() {
		return gridpane;
	}
	
	@FXML
	void initialize() {
		welcomeLabel.setText("Welcome," + SwitchSceneUtil.getVO().name + "!");
	}
	
	/*
	 * 此方法用于改变被选中的导航栏样式
	 * 参数0-4分别表示改变主界面、客户信息、酒店列表、历史订单列表、未执行订单列表的导航栏
	 */
	private void changeGuideTab(int whichOne) {
		AnchorPane tempPane = ((AnchorPane)((GridPane)gridpane.getChildren().get(0)).getChildren().get(whichOne));
		((Label)tempPane.getChildren().get(0)).setStyle("-fx-text-fill: black");
		tempPane.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
		tempPane.setEffect(new DropShadow());
		presentGuide = whichOne;
	}
	
	/*
	 * 此方法用于将导航栏样式恢复到未选中状态
	 */
	private void initGuideTab() {
		AnchorPane tempPane = ((AnchorPane)((GridPane)gridpane.getChildren().get(0)).getChildren().get(presentGuide));
		Label tempLabel = (Label)tempPane.getChildren().get(0);
		tempLabel.setStyle("-fx-text-fill: white");
		tempPane.setEffect(null);
		switch (presentGuide) {
			case 0:
				tempPane.setStyle("-fx-background-color: rgba(0,0,0,0.56)");
				break;
			case 1:
				tempPane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
				break;
			case 2:
				tempPane.setStyle("-fx-background-color: rgba(0,0,0,0.44)");
				break;
			case 3:
				tempPane.setStyle("-fx-background-color: rgba(0,0,0,0.38)");
				break;
			case 4:
				tempPane.setStyle("-fx-background-color: rgba(0,0,0,0.32)");
				break;
		}
	}
	
	private void switchGuide(int whichOne) {
		initGuideTab();
		changeGuideTab(whichOne);
	}
	
	/*
	 * 此方法用于切换除了导航栏以外的界面
	 */
	private void turnToAnotherScene(String resource) {
		try {
			AnchorPane root = FXMLLoader.load(SwitchSceneUtil.class.getResource(resource));
			GridPane.setConstraints(root, 1, 0);
			if (gridpane.getChildren().size() > 1) {
				gridpane.getChildren().set(1, root);
			} else {
				gridpane.getChildren().add(1, root);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * 下面五个方法调用了导航栏的切换方法和页面的跳转方法
	 */
	@FXML
	void turnToCusController_Main() {
		switchGuide(0);
		turnToCustomerMain();
		SwitchSceneUtil.stage.show();
	}
	
	@FXML
	void turnToCusController_CusInfo() {
		switchGuide(1);
		turnToCustomerInfo();
	}
	
	@FXML
	void turnToCusController_HotelList() {
		switchGuide(2);
		turnToCustomerHotelList();
	}
	
	@FXML
	void turnToCusController_HistoryOrderList() {
		switchGuide(3);
		turnToCustomerHistoryOrderList();
	}
	
	@FXML
	void turnToCusController_UnexcutedOrderList() {
		switchGuide(4);
		turnToCustomerUnexcutedOrderList();
	}
	
	/*
	 * 下面的方法都是调用页面跳转的方法
	 */
	void turnToCustomerMain() {
		turnToAnotherScene("/客户/主界面.fxml");
	}
	
	void turnToCustomerInfo() {
		turnToAnotherScene("/客户/查看客户信息界面.fxml");
	}
	
	void turnToCustomerHotelList() {
		turnToAnotherScene("/客户/浏览酒店界面.fxml");
	}
	
	void turnToCustomerHistoryOrderList() {
		turnToAnotherScene("/客户/浏览客户历史订单界面.fxml");
	}
	
	void turnToCustomerUnexcutedOrderList() {
		turnToAnotherScene("/客户/浏览客户未执行订单界面.fxml");
	}
	
	void turnToCustomerGenerateOrder() {
		turnToAnotherScene("/客户/生成订单界面.fxml");
	}
}
