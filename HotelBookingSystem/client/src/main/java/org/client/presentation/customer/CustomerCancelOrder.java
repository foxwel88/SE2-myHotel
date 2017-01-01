package org.client.presentation.customer;

import org.client.presentation.util.DateUtil;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-已撤销订单详细信息
 * @author fraliphsoft
 * @version Foxwel 12/13
 */
public class CustomerCancelOrder {
	@FXML
	private AnchorPane root;

	@FXML
	private Label orderIDLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private Label roomTypeLabel;

	@FXML
	private Label roomNumLabel;

	@FXML
	private Label numOfPeopleLabel;

	@FXML
	private Label childrenLabel;

	@FXML
	private Label customerNameLabel;

	@FXML
 	private Label phoneLabel;

	@FXML
	private Label schTimeLabel;

	@FXML
	private Label cancelTimeLabel;

	@FXML
	private Label priceLabel;
	
	@FXML
	private Label generatedTimeLabel;
	
	private OrderVO vo;
	
	@FXML
	void initialize() {
		vo = SwitchSceneUtil.getCurrentOrder();
		orderIDLabel.setText(vo.orderID);
		hotelAddressLabel.setText(vo.hotelAddress);
		hotelNameLabel.setText(vo.hotelName);
		roomTypeLabel.setText(vo.roomType);
		roomNumLabel.setText(String.valueOf(vo.roomNum));
		numOfPeopleLabel.setText(String.valueOf(vo.numOfPeople));
		if (vo.existsChild) {
			childrenLabel.setText("有");
		} else {
			childrenLabel.setText("无");
		}
		customerNameLabel.setText(vo.customerName);
		phoneLabel.setText(vo.phoneNumber);
		cancelTimeLabel.setText(DateUtil.dateToDetaildString(vo.cancelTime));
		schTimeLabel.setText(DateUtil.dateToCoarseString(vo.schFrom) + " - " + DateUtil.dateToCoarseString(vo.schTo));
		generatedTimeLabel.setText(DateUtil.dateToDetaildString(vo.generatedDate));
		priceLabel.setText(String.valueOf(vo.totalPrice));
		
		SwitchSceneUtil.showNewSceneAnimation(root);
	}
}
