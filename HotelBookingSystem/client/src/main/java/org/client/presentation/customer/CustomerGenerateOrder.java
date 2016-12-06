package org.client.presentation.customer;

import java.util.Date;
import java.util.Objects;

import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;

import javafx.fxml.FXML;
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
	Label hotelPhoneNumber;
	
	@FXML
	Label latestArrivalTime;
	
	@FXML
	Label customerName;
	
	@FXML
	Label level;
	
	@FXML
	Label credit;
	
	@FXML
	Label roomPrice;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label currentPrice;
	
	@FXML
	ChoiceBox<String> roomType;
	
	@FXML
	DatePicker schFromDate;
	
	@FXML
	DatePicker schToDate;
	
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
//		hotelPhoneNumber.setText(hotel.);			// TODO 酒店联系方式
		LiveDatePicker.initDatePicker(null, schFromDate);
		LiveDatePicker.initDatePicker(schFromDate, schToDate);
		// TODO 最晚入住时间
		if (Objects.equals(user.type, "个人客户")) {
			customerName.setText(user.name);
		} else {
			customerName.setText(user.companyName);
		}
		level.setText(String.valueOf(SwitchSceneUtil.promotionController.calLevel(user.credit)));
		credit.setText(String.valueOf(user.credit));
	}
	
	/*
	 * 此方法会检查订单格式，如果格式正确则跳转到确认订单界面
	 */
	@FXML
	void commitOrder() {
		// TODO 检查订单格式
		// TODO 现在的生成的OrderVO的和日期有关的东西都是假的
		OrderVO newOrder = new OrderVO(user.ID, user.type, null, new Date(10000000), new Date(10000000),
				null, null, new Date(10000000), null, hotel.address, 
				 null, hotel.id, hotel.hotelName, roomType.getValue(), Double.parseDouble(totalPrice.getText().replaceAll("元", "")), Integer.parseInt(roomNum.getText()), Integer.parseInt(residentNum.getText()),
				hasChildren.isSelected(), user.name, phoneNumber.getText());
		SwitchSceneUtil.turnToConfirmOrderScene((GridPane)root.getParent(), newOrder);
	}
	
	@FXML
	void cancel() {
		SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), SwitchSceneUtil.hotelID);
	}
}
