package org.client.presentation.webmanager;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class WebManagerGuide {
	
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
	
	void changePane(Parent pane) {
		mainPane.getChildren().set(1, pane);
		GridPane.setConstraints(pane, 1, 0);
	}

	@FXML
	void initialize() {
		try {
			AnchorPane mypane = FXMLLoader.load(getClass().getResource("/网站管理人员/网站管理人员主界面.fxml"));
			mainPane.add(mypane, 1, 0);
			CurrentItem.setInstance(toHomeLabel, toHomePane, GuideLabelType.HOME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}