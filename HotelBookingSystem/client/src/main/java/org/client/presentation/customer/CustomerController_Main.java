package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-主界面
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
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
	
	@FXML
	void initialize() {
		welcomeLabel.setText("Welcome," + SwitchSceneUtil.getUserVO().name + "!");
	}
	
	/*
	 * 下面五个方法调用了导航栏的切换方法和页面的跳转方法
	 */
	@FXML
	void turnToCusController_Main() {
		initGuideTab();
		changeGuideTab(0);
		SwitchSceneUtil.turnToAnotherScene(gridpane, "/客户/主界面.fxml");
	}
	
	@FXML
	void turnToCusController_CusInfo() {
		initGuideTab();
		changeGuideTab(1);
		SwitchSceneUtil.turnToAnotherScene(gridpane, "/客户/查看客户信息界面.fxml");
	}
	
	@FXML
	void turnToCusController_HotelList() {
		initGuideTab();
		changeGuideTab(2);
		SwitchSceneUtil.turnToAnotherScene(gridpane, "/客户/浏览酒店界面.fxml");
	}
	
	@FXML
	void turnToCusController_HistoryOrderList() {
		initGuideTab();
		changeGuideTab(3);
		SwitchSceneUtil.turnToAnotherScene(gridpane, "/客户/浏览客户历史订单界面.fxml");
	}
	
	@FXML
	void turnToCusController_UnexcutedOrderList() {
		initGuideTab();
		changeGuideTab(4);
		SwitchSceneUtil.turnToAnotherScene(gridpane, "/客户/浏览客户未执行订单界面.fxml");
	}
	/*************************************************************/
	
	/*
	 * 此方法用于改变被选中的导航栏样式
	 * 参数0-4分别表示改变主界面、客户信息、酒店列表、历史订单列表、未执行订单列表的导航栏
	 */
	private void changeGuideTab(int whichOne) {
		AnchorPane tempPane = ((AnchorPane)((GridPane)gridpane.getChildren().get(0)).getChildren().get(whichOne));		// 
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
}
