package org.client.presentation.customer;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-评价订单
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */

public class CustomerComment {
	@FXML
	AnchorPane root;
	
	@FXML
	ChoiceBox score;
	
	@FXML
	TextArea comment;
	
	@FXML
	Button commitButton;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelAddress;
	
	@FXML
	Label roomType;
	
	@FXML
	Label roomNum;
	
	@FXML
	Label totalPrice;
	
	@FXML
	void initialize() {
		OrderVO vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		hotelAddress.setText(vo.hotelAddress);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		totalPrice.setText(String.valueOf(vo.totalPrice));
	}
	
	@FXML
	void commitComment() {
		SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), "/客户/已执行订单详细信息界面.fxml");
	}
}
