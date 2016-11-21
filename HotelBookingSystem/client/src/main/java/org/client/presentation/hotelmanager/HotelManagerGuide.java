package org.client.presentation.hotelmanager;

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

public class HotelManagerGuide {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private GridPane belowGridPane;

	@FXML
    private AnchorPane mainLabelPane;

	@FXML
    private Label mainLabel;

	@FXML
    private AnchorPane infoLabelPane;

	@FXML
    private Label infoLabel;

	@FXML
    private AnchorPane executeLabelPane;

	@FXML
    private Label executeLabel;

	@FXML
    private AnchorPane historyLabelPane;

	@FXML
    private Label historyLabel;

	@FXML
    private AnchorPane promotionLabelPane;

	@FXML
    private Label promotionLabel;

	@FXML
    void handleSwitch(MouseEvent event) {
		
		//change visual effect and gridpane content
		Label source = (Label)event.getSource();
		if (source == mainLabel) { //main
			changeActive(GuideLabelType.MAIN);
			changeContent(GuideLabelType.MAIN);			
		} else if (source == infoLabel) { //info
			changeActive(GuideLabelType.INFO);
			changeContent(GuideLabelType.INFO);
		} else if (source == executeLabel) { //execute
			changeActive(GuideLabelType.EXECUTE);
			changeContent(GuideLabelType.EXECUTE);
		} else if (source == historyLabel) { //history
			changeActive(GuideLabelType.HISTORY);
			changeContent(GuideLabelType.HISTORY);
		} else if (source == promotionLabel) {  //promotion
			changeActive(GuideLabelType.PROMOTION);
			changeContent(GuideLabelType.PROMOTION);
		}
		
	}
	
	/*Visually change active guideLabel(and its pane) */
	void changeActive(GuideLabelType to) {
		switch(to) {
			case MAIN:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(mainLabel, mainLabelPane, GuideLabelType.MAIN);
				CurrentItem.getInstance().active();
				break;
			case INFO:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(infoLabel, infoLabelPane, GuideLabelType.INFO);
				CurrentItem.getInstance().active();
				break;
			case EXECUTE:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(executeLabel, executeLabelPane, GuideLabelType.EXECUTE);
				CurrentItem.getInstance().active();
				break;
			case HISTORY:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(historyLabel, historyLabelPane, GuideLabelType.HISTORY);
				CurrentItem.getInstance().active();
				break;
			case PROMOTION:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(promotionLabel, promotionLabelPane, GuideLabelType.PROMOTION);
				CurrentItem.getInstance().active();
				break;
		}
	}
	
	/*change the content of the gridpane */
	void changeContent(GuideLabelType to) {
		Parent root = null;
		try {
			switch(to) {
				case MAIN:
					root = FXMLLoader.load(getClass().getResource("/酒店工作人员/酒店工作人员主界面.fxml"));
					break;
				case INFO:
					root = FXMLLoader.load(getClass().getResource("/酒店工作人员/维护酒店信息界面.fxml"));
					break;
				case EXECUTE:
					root = FXMLLoader.load(getClass().getResource("/酒店工作人员/执行订单界面.fxml"));
					break;
				case HISTORY:
					root = FXMLLoader.load(getClass().getResource("/酒店工作人员/浏览酒店历史订单界面.fxml"));
					break;
				case PROMOTION:
					root = FXMLLoader.load(getClass().getResource("/酒店工作人员/管理酒店促销策略界面.fxml"));
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		belowGridPane.getChildren().set(1, root);
		GridPane.setConstraints(root, 1, 0);
	}

	@FXML
	void initialize() {
		assert belowGridPane != null : "fx:id=\"belowGridPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabelPane != null : "fx:id=\"mainLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert infoLabelPane != null : "fx:id=\"infoLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert executeLabelPane != null : "fx:id=\"executeLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert historyLabelPane != null : "fx:id=\"historyLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabelPane != null : "fx:id=\"promotionLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file 'guide.fxml'.";
		try {
			belowGridPane.add((Node) FXMLLoader.load(getClass().getResource("/酒店工作人员/酒店工作人员主界面.fxml")), 1, 0);
			CurrentItem.setInstance(mainLabel, mainLabelPane, GuideLabelType.MAIN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

