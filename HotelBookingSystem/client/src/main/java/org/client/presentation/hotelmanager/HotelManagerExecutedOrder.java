package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.client.vo.OrderVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-已执行订单详细界面
 *
 */
public class HotelManagerExecutedOrder {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Label orderIDLabel;

	@FXML
    private Label roomTypeLabel;

	@FXML
    private Label roomNumLabel;

	@FXML
    private Label numOfPeopleLabel;

	@FXML
    private Label childrenLabel;

	@FXML
    private Label orderTypeLabel;

	@FXML
    private Label priceLabel;

	@FXML
    private Label actFromLabel;

	@FXML
    private Label customerNameLabel;

	@FXML
    private Button updateButton;

	@FXML
    void startUpdateEdit(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert orderIDLabel != null : "fx:id=\"orderIDLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert roomNumLabel != null : "fx:id=\"roomNumLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert numOfPeopleLabel != null : "fx:id=\"numOfPeopleLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert childrenLabel != null : "fx:id=\"childrenLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert orderTypeLabel != null : "fx:id=\"orderTypeLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert priceLabel != null : "fx:id=\"priceLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert actFromLabel != null : "fx:id=\"actFromLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert customerNameLabel != null : "fx:id=\"customerNameLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		
		OrderVO vo = HotelManagerController.getInstance().currentOrder;
		
		orderIDLabel.setText(vo.orderID);
		roomTypeLabel.setText(vo.roomType);
		roomNumLabel.setText(String.valueOf(vo.roomNum));
		numOfPeopleLabel.setText(String.valueOf(vo.numOfPeople));
		if (vo.existsChild) {
			childrenLabel.setText("有");
		} else {
			childrenLabel.setText("无");
		}
		orderTypeLabel.setText(vo.type);
		priceLabel.setText(String.valueOf(vo.totalPrice));
		customerNameLabel.setText(vo.customerName);
	}
}

