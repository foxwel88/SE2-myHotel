package org.client.presentation.customer;

import org.client.blservice.commentblservice.Commentblservice;
import org.client.launcher.Resources;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * 
 * 客户-评价订单
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */

public class CustomerComment {
	@FXML
	AnchorPane root;
	
	@FXML
	TextArea comment;
	
	@FXML
	Button commitButton;
	
	@FXML
	Button rank1;
	
	@FXML
	Button rank2;
	
	@FXML
	Button rank3;
	
	@FXML
	Button rank4;
	
	@FXML
	Button rank5;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelInfo;
	
	@FXML
	Label roomType;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label commentTip;
	
	@FXML
	Label scoreTip;
	
	private Resources resources;
	
	private Commentblservice commentController;
	
	private int selectedRank = -1;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		OrderVO vo = CustomerController.getCurrentOrder();
		orderID.setText(vo.orderID);
		String hotel = vo.hotelName + "，" + vo.hotelAddress;
		hotelInfo.setText(hotel);
		roomType.setText(vo.roomType + " " + String.valueOf(vo.roomNum) + "间");
		totalPrice.setText(String.valueOf(vo.totalPrice) + "元");
	}
	
	@FXML
	void commitComment() {
		String commentContent = comment.getText();
		double rankValue = 5;
		if (selectedRank == -1) {
			scoreTip.setText("打分不能为空!");
		} else {
			rankValue = selectedRank;
			scoreTip.setText("");
			if (commentContent.length() >= 15) {
				commentTip.setText("");
				CustomerController.addComment(rankValue, commentContent);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("感谢您的评价！");
				alert.showAndWait();
				CustomerController.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckExecutedOrder);
			} else {
				commentTip.setText("评论不能少于15字!");
			}
		}
	}
	
	@FXML
	void selectRank1() {
		selectedRank = 1;
		hideSelection();
		activeRank1Button();
	}
	
	@FXML
	void selectRank2() {
		selectedRank = 2;
		hideSelection();
		activeRank2Button();
	}
	
	@FXML
	void selectRank3() {
		selectedRank = 3;
		hideSelection();
		activeRank3Button();
	}
	
	@FXML
	void selectRank4() {
		selectedRank = 4;
		hideSelection();
		activeRank4Button();
	}
	
	@FXML
	void selectRank5() {
		selectedRank = 5;
		hideSelection();
		activeRank5Button();
	}
	
	@FXML
	void activeRank1Button() {
		rank1.setStyle("-fx-background-color: rgba(243,223,136,0.7)");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.web("f3df88"));
		shadow.setSpread(0.5);
		rank1.setEffect(shadow);
	}
	
	@FXML
	void activeRank2Button() {
		rank2.setStyle("-fx-background-color: rgba(243,223,136,0.7)");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.web("f3df88"));
		shadow.setSpread(0.5);
		rank2.setEffect(shadow);
	}
	
	@FXML
	void activeRank3Button() {
		rank3.setStyle("-fx-background-color: rgba(243,223,136,0.7)");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.web("f3df88"));
		shadow.setSpread(0.5);
		rank3.setEffect(shadow);
	}
	
	@FXML
	void activeRank4Button() {
		rank4.setStyle("-fx-background-color: rgba(243,223,136,0.7)");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.web("f3df88"));
		shadow.setSpread(0.5);
		rank4.setEffect(shadow);
	}
	
	@FXML
	void activeRank5Button() {
		rank5.setStyle("-fx-background-color: rgba(243,223,136,0.7)");
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.web("f3df88"));
		shadow.setSpread(0.5);
		rank5.setEffect(shadow);
	}
	
	@FXML
	void deactiveRank1Button() {
		if (selectedRank != 1) {
			rank1.setEffect(null);
			rank1.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
		}
	}
	
	@FXML
	void deactiveRank2Button() {
		if (selectedRank != 2) {
			rank2.setEffect(null);
			rank2.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
		}
	}
	
	@FXML
	void deactiveRank3Button() {
		if (selectedRank != 3) {
			rank3.setEffect(null);
			rank3.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
		}
	}
	
	@FXML
	void deactiveRank4Button() {
		if (selectedRank != 4) {
			rank4.setEffect(null);
			rank4.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
		}
	}
	
	@FXML
	void deactiveRank5Button() {
		if (selectedRank != 5) {
			rank5.setEffect(null);
			rank5.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
		}
	}
	
	/*
	 * 隐藏所有选中评分的特效
	 */
	private void hideSelection() {
		deactiveRank1Button();
		deactiveRank2Button();
		deactiveRank3Button();
		deactiveRank4Button();
		deactiveRank5Button();
	}
}
