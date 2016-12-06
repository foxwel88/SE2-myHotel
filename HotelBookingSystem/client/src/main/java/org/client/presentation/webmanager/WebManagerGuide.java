package org.client.presentation.webmanager;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


/**
 * 
 * 网站管理人员的界面及其导航
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class WebManagerGuide {
	
	
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
	}
	
	@FXML
	void logOut(ActionEvent event) {
	}
}