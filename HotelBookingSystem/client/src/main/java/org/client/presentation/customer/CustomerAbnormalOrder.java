package org.client.presentation.customer;

import org.client.presentation.util.DateUtil;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-异常订单详细信息
 * @author fraliphsoft
 * @version Foxwel 12/13
 */
public class CustomerAbnormalOrder {
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
	private Button cancelButton;

	@FXML
	private Label latestTimeLabel;

	@FXML
	private Label priceLabel;
	
	@FXML
	private Label creditLabel;
	
	@FXML
	private Label generatedTimeLabel;
	
	private OrderVO vo;
	
	@FXML
	void initialize() {
		vo = CustomerController.getCurrentOrder();
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
		latestTimeLabel.setText(DateUtil.dateToDetailedString(vo.latestTime));
		schTimeLabel.setText(DateUtil.dateToCoarseString(vo.schFrom) + " - " + DateUtil.dateToCoarseString(vo.schTo));
		generatedTimeLabel.setText(DateUtil.dateToDetailedString(vo.generatedDate));
		priceLabel.setText(String.valueOf(vo.totalPrice));
		creditLabel.setText("-" + String.valueOf(vo.totalPrice));
		
		CustomerController.showNewSceneAnimation(root);
	}
}
