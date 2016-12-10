package org.client.presentation.customer;

import java.io.IOException;

import org.client.bl.userbl.UserController;
import org.client.launcher.Resources;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * 客户-主界面
 * @author fraliphsoft
 * @version fraliphsoft 11/30
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
	
	@FXML
	Label backArrow;
	
	@FXML
	MenuBar avatarBar;

	@FXML
	Menu avatar;
	
	private static final int AVATAR_SIZE = 48;
	
	private int presentGuide = 0;
	
	private Resources resources;
	
	@FXML
	void initialize() {
		welcomeLabel.setText("Welcome," + SwitchSceneUtil.getUserVO().name + "!");
		resources = Resources.getInstance();
		
		ImageView avatarImgView = new ImageView();
		avatarImgView.setImage(new Image(resources.avatar.toString()));
		avatarImgView.setFitHeight(AVATAR_SIZE);
		avatarImgView.setFitWidth(AVATAR_SIZE);
		avatar.setGraphic(avatarImgView);
	}
	
	@FXML
	void logOut() {
		UserController.getInstance().logout(SwitchSceneUtil.getUserVO().userName);
		Stage stage = (Stage)welcomeLabel.getScene().getWindow();
		Resources resources = Resources.getInstance();
		try {
			Parent root = resources.load(resources.login);
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 下面五个方法调用了导航栏的切换方法和页面的跳转方法
	 */
	@FXML
	void turnToCusController_Main() {
		initGuideTab();
		changeGuideTab(0);
		SwitchSceneUtil.turnToAnotherScene(gridpane, resources.customerMain);
	}
	
	@FXML
	void turnToCusController_CusInfo() {
		initGuideTab();
		changeGuideTab(1);
		SwitchSceneUtil.turnToAnotherScene(gridpane, resources.customerCheckInfo);
	}
	
	@FXML
	void turnToCusController_HotelList() {
		initGuideTab();
		changeGuideTab(2);
		SwitchSceneUtil.turnToAnotherScene(gridpane, resources.customerCheckHotelList);
	}
	
	@FXML
	void turnToCusController_HistoryOrderList() {
		initGuideTab();
		changeGuideTab(3);
		SwitchSceneUtil.turnToAnotherScene(gridpane, resources.customerCheckHistoryOrderList);
	}
	
	@FXML
	void turnToCusController_UnexcutedOrderList() {
		initGuideTab();
		changeGuideTab(4);
		SwitchSceneUtil.turnToAnotherScene(gridpane, resources.customerCheckUnexecutedOrderList);
	}
	/*************************************************************/
	
	/**
	 * 控制返回按钮的方法
	 */
	@FXML
	void goBack() {
		if (SwitchSceneUtil.canBack) {
			try {
				switch (SwitchSceneUtil.currentScene) {
					case CREDITS_RECORD_SCENE:
						turnToCusController_CusInfo();
						break;
					case MODIFY_INFO_SCENE:
						turnToCusController_CusInfo();
						break;
					case HOTEL_INFO_SCENE:
						SwitchSceneUtil.isBack = true;
						turnToCusController_HotelList();
						SwitchSceneUtil.isBack = false;
						break;
					case EXECUTED_ORDER_SCENE:
						SwitchSceneUtil.isBack = true;
						turnToCusController_HistoryOrderList();
						SwitchSceneUtil.isBack = false;
						break;
					case CANCELED_ORDER_SCENE:
						SwitchSceneUtil.isBack = true;
						turnToCusController_HistoryOrderList();
						SwitchSceneUtil.isBack = false;
						break;
					case ABNORMAL_ORDER_SCENE:
						SwitchSceneUtil.isBack = true;
						turnToCusController_HistoryOrderList();
						SwitchSceneUtil.isBack = false;
						break;
					case UNEXECUTED_ORDER_SCENE:
						SwitchSceneUtil.isBack = true;
						turnToCusController_UnexcutedOrderList();
						SwitchSceneUtil.isBack = false;
						break;
					case MAKE_COMMENT_SCENE:
						SwitchSceneUtil.isBack = true;
						SwitchSceneUtil.turnToDetailedOrderScene(gridpane, Resources.getInstance().customerCheckExecutedOrder, SwitchSceneUtil.orderID);
						SwitchSceneUtil.currentScene = CustomerBackableScene.EXECUTED_ORDER_SCENE;
						SwitchSceneUtil.isBack = false;
						break;
					case GENERATE_ORDER_SCENE:
						SwitchSceneUtil.isBack = true;
						if (SwitchSceneUtil.isBackToDetail) {
							SwitchSceneUtil.currentScene = CustomerBackableScene.HOTEL_INFO_SCENE;
							SwitchSceneUtil.turnToDetailedHotelScene(gridpane, SwitchSceneUtil.hotelID);
						} else {
							turnToCusController_HotelList();
						}
						SwitchSceneUtil.isBack = false;
						break;
				}
			} catch (NullPointerException nullPointerException) {
				// nothing to do
			}
		}
	}
	
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
