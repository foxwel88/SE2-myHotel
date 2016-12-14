package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.OrderType;
import org.common.utility.RoomType;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-生成订单
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class CustomerGenerateOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Label hotelName;
	
	@FXML
	Label hotelAddress;
	
	@FXML
	Label city;
	
	@FXML
	Label area;
	
	@FXML
	Label level;
	
	@FXML
	Label credit;
	
	@FXML
	Label roomPrice;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label rawPrice;
	
	@FXML
	ChoiceBox<String> roomType;
	
	@FXML
	DatePicker schFromDate;
	
	@FXML
	DatePicker schToDate;
	
	@FXML
	TextField customerName;
	
	@FXML
	TextField phoneNumber;
	
	@FXML
	TextField roomNum;
	
	@FXML
	TextField residentNum;
	
	@FXML
	CheckBox hasChildren;
	
	@FXML
	Button confirmButton;
	
	@FXML
	Button cancelButton;
	
	private HotelVO hotel;
	
	private UserVO user;
	
	@FXML
	void initialize() {
		hotel = SwitchSceneUtil.getHotelVO();
		user = SwitchSceneUtil.getUserVO();
		hotelName.setText(hotel.hotelName);
		hotelAddress.setText(hotel.address);
		city.setText(hotel.city.cityName);
		area.setText(hotel.area.address);
		LiveDatePicker.initDatePicker(null, schFromDate);
		LiveDatePicker.initDatePicker(schFromDate, schToDate);
		if (Objects.equals(user.type, "个人客户")) {
			customerName.setText(user.name);
		} else {
			customerName.setText(user.companyName);
		}
		level.setText(String.valueOf(SwitchSceneUtil.promotionController.calLevel(user.credit)));
		credit.setText(String.valueOf(user.credit));
		phoneNumber.setText(user.phoneNumber);
		setRoomType();
		roomType.setValue("单人间");
		roomNum.setText("1");
		refreshPrice();
	}
	
	/*
	 * 此方法会检查订单格式，如果格式正确则跳转到确认订单界面
	 */
	@FXML
	void commitOrder() {
		if (checkPhoneNumberFormat()) {
			try {
				OrderVO newOrder = new OrderVO(user.ID, OrderType.UNEXECUTED.getString(), null, LiveDatePicker.toDate(schFromDate.getValue()), LiveDatePicker.toDate(schToDate.getValue()),
						new Date(0, 0, 1), new Date(0, 0, 1), LiveDatePicker.toDate(schFromDate.getValue().plusDays(1)), new Date(0, 0, 1), hotel.id, 
						hotel.hotelName, null, hotel.address, roomType.getValue(), getCurrentTotalPrice(), Integer.parseInt(roomNum.getText()), Integer.parseInt(residentNum.getText()),
						hasChildren.isSelected(), user.name, phoneNumber.getText());
				SwitchSceneUtil.turnToConfirmOrderScene((GridPane)root.getParent(), newOrder);
			} catch (NumberFormatException numberFormatException) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText(null);
				alert.setContentText("住宿人姓名、房间数量和入住人数均不能为空");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText(null);
			alert.setContentText("电话格式不正确(应为11位中国区号码)");
			alert.showAndWait();
		}
	}
	
	@FXML
	void cancel() {
		SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), SwitchSceneUtil.hotelID);
	}
	
	@FXML
	void refreshPrice() {
		setSingleRoomPrice();
		setRawPrice();
		setTotalPrice();
	}
	
	private void setRoomType() {
		RoomType[] roomTypeArray = RoomType.values();
		ArrayList<String> roomTypeList = new ArrayList<>();
		for (int i = 0; i < roomTypeArray.length; i++) {
			roomTypeList.add(roomTypeArray[i].getString());
		}
		roomType.setItems(FXCollections.observableArrayList(roomTypeList));
	}
	
	private void setSingleRoomPrice() {
		double price = SwitchSceneUtil.getSingleRoomPrice(RoomType.getType(roomType.getValue()));
		roomPrice.setText(String.valueOf(price) + "元");
	}
	
	private void setRawPrice() {
		try {
			rawPrice.setText(String.valueOf(getCurrentSingleRoomPrice() * Double.parseDouble(roomNum.getText())) + "元");
		} catch (NullPointerException nullPointerException) {
			rawPrice.setText("0.0元");
		} catch (NumberFormatException numberFormatException) {
			rawPrice.setText("0.0元");
		}
	}
	
	private void setTotalPrice() {
		try {
			double price = SwitchSceneUtil.getCurrentPrice(getCurrentRawPrice());
			totalPrice.setText(String.valueOf(price) + "元");
		} catch (NullPointerException nullPointerException) {
			totalPrice.setText("0.0元");
		}
		
	}
	
	private double getCurrentSingleRoomPrice() {
		try {
			return Double.parseDouble(roomPrice.getText().replaceAll("元", ""));
		} catch (NumberFormatException numberFormatException) {
			return 0;
		}
	}
	
	private double getCurrentRawPrice() {
		try {
			return Double.parseDouble(rawPrice.getText().replaceAll("元", ""));
		} catch (NumberFormatException numberFormatException) {
			return 0;
		}
	}
	
	private double getCurrentTotalPrice() {
		try {
			return Double.parseDouble(totalPrice.getText().replaceAll("元", ""));
		} catch (NumberFormatException numberFormatException) {
			return 0;
		}
	}
	
	private boolean checkPhoneNumberFormat() {
		String phoneString = phoneNumber.getText();
		if (phoneString.length() != 11) {
			return false;
		}
		for (int i = 0; i < 11; i++) {
			if (!isNumeric(phoneString.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isNumeric(char c) {
		if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}
}
