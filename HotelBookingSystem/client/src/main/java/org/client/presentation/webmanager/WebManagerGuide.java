package org.client.presentation.webmanager;

import java.io.IOException;

import org.client.launcher.PwModify;
import org.client.launcher.Resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * 
 * 网站管理人员的界面及其导航
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class WebManagerGuide {
	private static final int AVATAR_SIZE = 48;
	
	@FXML
	private Pane rootPane;
	
	@FXML
    private Label welcomeLabel;

	@FXML
	private MenuBar avatarBar;

	@FXML
	private Menu avatar;
	
	@FXML
	private GridPane mainPane;
	
	@FXML
	private AnchorPane toHomePane;

	@FXML
	private Label toHomeLabel;

	@FXML
	private AnchorPane toCustomerPane;

	@FXML
	private Label toCustomerLabel;

	@FXML
	private AnchorPane toNewPane;

	@FXML
	private Label toNewLabel;

	@FXML
	private AnchorPane toHotelPane;

	@FXML
	private Label toHotelLabel;

	@FXML
	private AnchorPane toWebPane;

	@FXML
	private Label toWebLabel;
	
	@FXML
	private Pane backPane;

	@FXML
	private Label backArrow;
	
	@FXML
	void handleSwitch(MouseEvent event) {
		AnchorPane source = (AnchorPane)event.getSource();
		if (source == toHomePane) {
			changeActive(GuideLabelType.HOME);
			Parent pane = null;
			try {
				pane = FXMLLoader.load(getClass().getResource("/网站管理人员/网站管理人员主界面.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changePane(pane);
		}
		if (source == toCustomerPane) {
			changeActive(GuideLabelType.CUSTOMER);
			Parent pane = null;
			try {
				pane = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览客户信息界面.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changePane(pane);
		}
		if (source == toHotelPane) {
			changeActive(GuideLabelType.HOTEL);
			Parent pane = null;
			try {
				pane = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览酒店工作人员信息界面.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changePane(pane);
		}
		if (source == toWebPane) {
			changeActive(GuideLabelType.WEB);
			Parent pane = null;
			try {
				pane = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changePane(pane);
		}
		if (source == toNewPane) {
			changeActive(GuideLabelType.NEW);
			Parent pane = null;
			try {
				pane = FXMLLoader.load(getClass().getResource("/网站管理人员/新增酒店界面.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			changePane(pane);
		}
	}

	void changeActive(GuideLabelType to) {
		switch(to) {
			case HOME:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(toHomeLabel, toHomePane, GuideLabelType.HOME);
				CurrentItem.getInstance().active();
				break;
			case CUSTOMER:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(toCustomerLabel, toCustomerPane, GuideLabelType.CUSTOMER);
				CurrentItem.getInstance().active();
				break;
			case HOTEL:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(toHotelLabel, toHotelPane, GuideLabelType.HOTEL);
				CurrentItem.getInstance().active();
				break;
			case WEB:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(toWebLabel, toWebPane, GuideLabelType.WEB);
				CurrentItem.getInstance().active();
				break;
			case NEW:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(toNewLabel, toNewPane, GuideLabelType.NEW);
				CurrentItem.getInstance().active();
				break;
		}
	}
	
	@FXML
	void handleBackAction(MouseEvent event) throws IOException {
		String currentId = mainPane.getChildren().get(1).getId();
		if (currentId == null) {
			return;
		}
		switch (currentId) {
			case "modifyCustomer":
				FXMLLoader fxmlLoader1 = new FXMLLoader();
				fxmlLoader1.load(getClass().getResource("/网站管理人员/修改客户信息界面.fxml").openStream());
				WebManagerModifyCustomer webController1 = (WebManagerModifyCustomer) fxmlLoader1.getController();
				webController1.returnPane(WebManagerController.getInstance().nowvo);
				break;
			case "modifyWebMarketer":
				FXMLLoader fxmlLoader2 = new FXMLLoader();
				fxmlLoader2.load(getClass().getResource("/网站管理人员/修改网站营销人员界面.fxml").openStream());
				WebManagerModifyWebMarketer webController2 = (WebManagerModifyWebMarketer) fxmlLoader2.getController();
				webController2.returnPane(WebManagerController.getInstance().nowvo);
				
				break;
			case "addWebMarketer":
				FXMLLoader fxmlLoader3 = new FXMLLoader();
				fxmlLoader3.load(getClass().getResource("/网站管理人员/新增网站营销人员界面.fxml").openStream());
				WebManagerAddWebMarketer webController3 = (WebManagerAddWebMarketer) fxmlLoader3.getController();
				webController3.returnPane(WebManagerController.getInstance().nowvo);
				break;
			case "modifyHotelManager":
				FXMLLoader fxmlLoader4 = new FXMLLoader();
				fxmlLoader4.load(getClass().getResource("/网站管理人员/修改酒店工作人员界面.fxml").openStream());
				WebManagerModifyHotelManager webController4 = (WebManagerModifyHotelManager) fxmlLoader4.getController();
				webController4.returnPane(WebManagerController.getInstance().nowvo);
				break;			
		}
	}
	
	void changePane(Parent pane) {
		/*
		mainPane.getChildren().set(1, pane);
		GridPane.setConstraints(pane, 1, 0);
		*/
		ChangePane.getInstance().turn(pane);
	}

	@FXML
	void initialize() {
		ChangePane.getInstance().setMainPane(mainPane);
		try {
			AnchorPane mypane = FXMLLoader.load(getClass().getResource("/网站管理人员/网站管理人员主界面.fxml"));
			mainPane.add(mypane, 1, 0);
			CurrentItem.setInstance(toHomeLabel, toHomePane, GuideLabelType.HOME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Resources resources = Resources.getInstance();
		Image avatarImg = new Image(resources.avatar.toString());
		ImageView avatarImgView = new ImageView();

		avatarImgView.setImage(avatarImg);
		avatarImgView.setFitHeight(AVATAR_SIZE);
		avatarImgView.setFitWidth(AVATAR_SIZE);
		avatar.setGraphic(avatarImgView);
		
		String userID = WebManagerController.getInstance().userID;
		String name = WebManagerController.getInstance().findbyID(userID).name;
		welcomeLabel.setText("Welcome, " + name + "!");
	}
	
	@FXML
	void logOut(ActionEvent event) {
		WebManagerController.getInstance().logOut();
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
	
	@FXML
	void modifyPassword() {
		AnchorPane mask = new AnchorPane();
		mask.setStyle("-fx-background-color:rgba(0,0,0,0.5)");
		mask.setLayoutX(0);
		mask.setLayoutY(0);
		mask.setPrefSize(1103.0, 683.0);
		rootPane.getChildren().add(mask);
		Resources resources = Resources.getInstance();
		Parent root = null;
		try {
			root = resources.load(resources.modify);
			((PwModify)resources.getCurrentController()).setParentPane(rootPane);
			((PwModify)resources.getCurrentController()).setUserName(WebManagerController.getInstance().findbyID(WebManagerController.getInstance().userID).userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mask.getChildren().add(root);
		AnchorPane.setLeftAnchor(root, 352.0);
		AnchorPane.setRightAnchor(root, 351.0);
		AnchorPane.setTopAnchor(root, 99.0);
	}
}