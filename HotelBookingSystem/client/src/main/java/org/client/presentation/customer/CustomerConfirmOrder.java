package org.client.presentation.customer;

import java.time.LocalDate;

import org.client.launcher.Resources;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-生成订单确认界面
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class CustomerConfirmOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Label hotelname;
	
	@FXML
	Label address;
	
	@FXML
	Label roomType;
	
	@FXML
	Label roomNum;
	
	@FXML
	Label latestArrivalTime;
	
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
		hotelname.setText(order.hotelName);
		address.setText(order.hotelAddress);
		roomType.setText(order.roomType);
		roomNum.setText(String.valueOf(order.roomNum));
		latestArrivalTime.setText(LiveDatePicker.dateToDetaildString(order.latestTime));
		appointedLivingTime.setText(LiveDatePicker.dateToCoarseString(order.schFrom) + "到" + LiveDatePicker.dateToCoarseString(order.schTo));
		resident.setText(order.customerName);
		phoneNumber.setText(order.phoneNumber);
		totalPrice.setText(String.valueOf(order.totalPrice));
		generatedTime.setText(LocalDate.now().toString());
	}
	
	@FXML
	void cancel() {
		SwitchSceneUtil.returnToGenerateOrderScene((GridPane)root.getParent());
	}
	
	@FXML
	void confirm() {
		ResultMessage commitResult = SwitchSceneUtil.commitOrder(order);
		Alert alert;
		if (commitResult.equals(ResultMessage.SUCCESS)) {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText(null);
			alert.setContentText("成功生成订单");
			// 返回前一界面
			SwitchSceneUtil.isBack = true;
			if (SwitchSceneUtil.isBackToDetail) {
				SwitchSceneUtil.currentScene = CustomerBackableScene.HOTEL_INFO_SCENE;
				SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), SwitchSceneUtil.hotelID);
			} else {
				SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), Resources.getInstance().customerCheckHotelList);
			}
			SwitchSceneUtil.isBack = false;
		} else if (commitResult.equals(ResultMessage.ROOM_NOT_ENOUGH)) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("剩余房间数量不足");
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Unknown Error Occured, please connect with administrator.");
			alert.setHeaderText(null);
			alert.setContentText("生成订单失败");
		}
		alert.showAndWait();
	}
}
