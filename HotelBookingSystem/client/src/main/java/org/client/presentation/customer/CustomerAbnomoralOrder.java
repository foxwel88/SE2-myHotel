package org.client.presentation.customer;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-异常订单详细信息
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class CustomerAbnomoralOrder {
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
	
	@FXML
	Label lostCredit;
	
	private OrderVO vo;
	
	@FXML
	void initialize() {
		vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		hotelAddress.setText(vo.hotelAddress);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		appointedArrivalTime.setText(LiveDatePicker.dateToCoarseString(vo.schFrom));
		appointedLivingTime.setText(LiveDatePicker.dateToCoarseString(vo.schFrom) + " - " + LiveDatePicker.dateToCoarseString(vo.schTo));
		resident.setText(vo.customerName);
		totalPrice.setText(String.valueOf(vo.totalPrice));
		generatedTime.setText(LiveDatePicker.dateToCoarseString(vo.generatedDate));
		orderState.setText(vo.type);
		lostCredit.setText("-" + String.valueOf(vo.totalPrice));
	}
}
