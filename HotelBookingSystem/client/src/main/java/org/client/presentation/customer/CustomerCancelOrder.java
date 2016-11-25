package org.client.presentation.customer;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-已撤销订单详细信息
 *
 */
public class CustomerCancelOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelAddress;
	
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
	Label totalPrice;
	
	@FXML
	Label generatedTime;
	
	@FXML
	Label orderState;
	
	private OrderVO vo;
	
	@FXML
	void initialize() {
		vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		hotelAddress.setText(vo.hotelAddress);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		appointedArrivalTime.setText(vo.schFrom.toString());
		appointedLivingTime.setText(vo.schFrom.toString() + "-" + vo.schTo.toString());
		resident.setText(vo.customerName);
		totalPrice.setText(String.valueOf(vo.totalPrice));
		generatedTime.setText(vo.generatedDate.toString());
		orderState.setText(vo.type);
	}
}
