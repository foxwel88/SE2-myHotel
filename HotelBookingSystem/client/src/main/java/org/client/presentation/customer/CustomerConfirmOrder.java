package org.client.presentation.customer;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-生成订单确认界面
 *
 */
public class CustomerConfirmOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Label orderID;
	
	@FXML
	Label address;
	
	@FXML
	Label roomType;
	
	@FXML
	Label roomNum;
	
	@FXML
	Label appointedArrivalTime;
	
	@FXML
	Label appointedLivingTime;
	
	@FXML
	Label resident;
	
	@FXML
	Label phoneNumber;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label generatedTime;
	
	@FXML
	Button cancelButton;
	
	@FXML
	Button confirmButton;
	
	private OrderVO order;
	
	@FXML
	void initialize() {
		order = SwitchSceneUtil.toBeGeneratedOrder;
		orderID.setText(order.orderID);;
		address.setText(order.hotelAddress);;
		roomType.setText(order.roomType);;
		roomNum.setText(String.valueOf(order.roomNum));;
		appointedArrivalTime.setText(order.schFrom.toString());;
		appointedLivingTime.setText(order.schFrom.toString() + "到" + order.schTo.toString());;
		resident.setText(order.customerName);;
		phoneNumber.setText(order.phoneNumber);;
		totalPrice.setText(String.valueOf(order.totalPrice));;
		generatedTime.setText(order.generatedDate.toString());;
	}
	
	@FXML
	void cancel() {
		SwitchSceneUtil.returnToGenerateOrderScene((GridPane)root.getParent());
	}
	
	@FXML
	void confirm() {
		
	}
}
