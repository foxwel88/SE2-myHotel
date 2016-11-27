package org.client.presentation.customer;

import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-生成订单
 *
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
	ChoiceBox<Integer> startMonth;
	
	@FXML
	ChoiceBox<Integer> startDay;
	
	@FXML
	ChoiceBox<Integer> endMonth;
	
	@FXML
	ChoiceBox<Integer> endDay;
	
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
		// TODO 最晚入住时间
		if (user.type == "个人客户") {
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
//		OrderVO newOrder = new OrderVO(user.ID, user.type, generatedDate, schFrom, schTo,
//				actFrom, actTo, latestTime, cancelTime, hotelAddress, 
//				orderID, hotelName, roomType, totalPrice, roomNum, numOfPeople,
//				existsChild, customerName, phoneNumber);
		OrderVO newOrder = new OrderVO(ResultMessage.SUCCESS);
		SwitchSceneUtil.turnToConfirmOrderScene((GridPane)root.getParent(), newOrder);
	}
	
	@FXML
	void cancel() {
		SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), SwitchSceneUtil.hotelAddress);
	}
}
