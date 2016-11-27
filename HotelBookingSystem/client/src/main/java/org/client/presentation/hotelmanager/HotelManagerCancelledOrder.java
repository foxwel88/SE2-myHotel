package org.client.presentation.hotelmanager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller
 * 酒店工作人员-已撤销订单详细界面
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerCancelledOrder {

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
    private Label cancelTimeLabel;

	@FXML
	void initialize() {
		assert orderIDLabel != null : "fx:id=\"orderIDLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert roomNumLabel != null : "fx:id=\"roomNumLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert numOfPeopleLabel != null : "fx:id=\"numOfPeopleLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert childrenLabel != null : "fx:id=\"childrenLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert orderTypeLabel != null : "fx:id=\"orderTypeLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		assert cancelTimeLabel != null : "fx:id=\"cancelTimeLabel\" was not injected: check your FXML file '已撤销订单详细信息界面.fxml'.";
		
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

		SimpleDateFormat dateFormat = new SimpleDateFormat();
		cancelTimeLabel.setText(dateFormat.format(vo.cancelTime));
	}
}

