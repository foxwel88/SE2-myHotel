package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class WebMarketerGuide {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private GridPane belowGridPane;
	
	@FXML
    private AnchorPane orderPane;

	@FXML
    private Label orderLabel;

	@FXML
    private AnchorPane levelPane;

	@FXML
    private Label levelLabel;

	@FXML
    private AnchorPane promotionPane;

	@FXML
    private Label promotionLabel;

	@FXML
    private AnchorPane creditPane;

	@FXML
    private Label creditLabel;

	@FXML
    private AnchorPane mainPane;

	@FXML
    private Label mainLabel;
	
	@FXML
	void initialize() {
		assert belowGridPane != null : "fx:id=\"belowGridPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert creditPane != null : "fx:id=\"creditPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert creditLabel != null : "fx:id=\"creditLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert levelPane != null : "fx:id=\"levelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert levelLabel != null : "fx:id=\"levelLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionPane != null : "fx:id=\"promotionPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert orderPane != null : "fx:id=\"orderPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert orderLabel != null : "fx:id=\"orderLabel\" was not injected: check your FXML file 'guide.fxml'.";
		try {
			if (belowGridPane == null) {
				System.out.println("find!");
				return;
			}
			belowGridPane.add((Node) FXMLLoader.load(getClass().getResource("/网站营销人员/网站营销人员主界面.fxml")), 1, 0);
			CurrentItem.setInstance(mainLabel, mainPane, GuideLabelType.MAIN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
    void handleSwitch(MouseEvent event) {

		Label source = (Label)event.getSource();
		if (source == mainLabel) {
			changeActive(GuideLabelType.MAIN);
			changeContent(GuideLabelType.MAIN);			
		} else if (source == creditLabel) {
			changeActive(GuideLabelType.CREDIT);
			changeContent(GuideLabelType.CREDIT);
		} else if (source == levelLabel) {
			changeActive(GuideLabelType.LEVEL);
			changeContent(GuideLabelType.LEVEL);
		} else if (source == promotionLabel) {
			changeActive(GuideLabelType.PROMOTION);
			changeContent(GuideLabelType.PROMOTION);
		} else if (source == orderLabel) {
			changeActive(GuideLabelType.ORDER);
			changeContent(GuideLabelType.ORDER);
		}
		
	}
	
	void changeActive(GuideLabelType to) {
		switch(to) {
			case MAIN:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(mainLabel, mainPane, GuideLabelType.MAIN);
				CurrentItem.getInstance().active();
				break;
			case CREDIT:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(creditLabel, creditPane, GuideLabelType.CREDIT);
				CurrentItem.getInstance().active();
				break;
			case LEVEL:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(levelLabel, levelPane, GuideLabelType.LEVEL);
				CurrentItem.getInstance().active();
				break;
			case PROMOTION:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(promotionLabel, promotionPane, GuideLabelType.PROMOTION);
				CurrentItem.getInstance().active();
				break;
			case ORDER:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(orderLabel, orderPane, GuideLabelType.ORDER);
				CurrentItem.getInstance().active();
				break;
		}
	}
	
	void changeContent(GuideLabelType to) {
		Parent root = null;
		try {
			switch(to) {
				case MAIN:
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/网站营销人员主界面.fxml"));
					break;
				case CREDIT:
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/信用充值界面.fxml"));
					break;
				case LEVEL:
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/修改会员等级制度界面.fxml"));
					break;
				case PROMOTION:
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/管理促销策略界面.fxml"));
					break;
				case ORDER:
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/浏览异常订单界面.fxml"));
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		belowGridPane.getChildren().set(1, root);
		GridPane.setConstraints(root, 1, 0);
	}

	
	
}
