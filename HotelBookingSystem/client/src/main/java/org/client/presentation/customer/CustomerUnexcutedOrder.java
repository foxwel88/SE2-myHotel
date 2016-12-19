package org.client.presentation.customer;

import org.client.bl.orderbl.OrderController;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.launcher.Resources;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-未执行订单详细信息
 * @author fraliphsoft
 * @version Foxwel 12/13
 */
public class CustomerUnexcutedOrder {
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
	private Label generatedTimeLabel;
	
	private OrderVO vo;
	
	private Orderblservice orderController;
	
	private Resources resources;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
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
		latestTimeLabel.setText(LiveDatePicker.dateToDetaildString(vo.latestTime));
		schTimeLabel.setText(LiveDatePicker.dateToCoarseString(vo.schFrom) + " - " + LiveDatePicker.dateToCoarseString(vo.schTo));
		generatedTimeLabel.setText(LiveDatePicker.dateToDetaildString(vo.generatedDate));
		priceLabel.setText(String.valueOf(vo.totalPrice));
	}
	
	@FXML
	void cancelOrder() {
		ResultMessage resultMessage = cancel();
		if (ResultMessage.SUCCESS == resultMessage) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.setContentText("成功撤销订单");
			alert.showAndWait();
			SwitchSceneUtil.turnToAnotherScene((GridPane)(root.getParent()), resources.customerCheckUnexecutedOrderList);
		} else {
			// TODO
		}
	}
	
	private ResultMessage cancel() {
		orderController = OrderController.getInstance();
		return orderController.cancelOrder(vo.orderID);
	}
}
