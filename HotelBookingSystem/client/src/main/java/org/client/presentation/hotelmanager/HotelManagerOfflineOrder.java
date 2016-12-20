package org.client.presentation.hotelmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.client.vo.OrderVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Hirico
 * @version 2016/12/20 Hirico
 */
public class HotelManagerOfflineOrder {

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
	private Label phoneLabel;

	@FXML
	private Label schFromLabel;

	@FXML
	private Label customerNameLabel;

	@FXML
	private Label schToLabel;

	@FXML
	void initialize() {
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
		phoneLabel.setText(vo.phoneNumber);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		schFromLabel.setText(dateFormat.format(vo.schFrom));
		schToLabel.setText(dateFormat.format(vo.schTo));
		customerNameLabel.setText(vo.customerName);
	}
}
