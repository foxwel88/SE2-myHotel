package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.promotionbl.PromotionController;
import org.client.presentation.util.CheckStyle;
import org.client.presentation.util.LiveDatePicker;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.PromotionVO;
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
import javafx.scene.layout.Pane;

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
	Label webPromotionLabel;
	
	@FXML
	Label hotelPromotionLabel;
	
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
	
	@FXML
	Label promotionLabel;
	
	@FXML
	Pane promotionPane;
	
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
		schFromDate.setValue(LiveDatePicker.toLocalDate(SwitchSceneUtil.previousHotelSceneInfo.hotelFilter.schFrom));
		schToDate.setValue(LiveDatePicker.toLocalDate(SwitchSceneUtil.previousHotelSceneInfo.hotelFilter.schTo));
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
			int tempRoomNum = 0;
			int tempResidentNum = 0;
			try {
				tempRoomNum = Integer.parseInt(roomNum.getText());
				tempResidentNum = Integer.parseInt(residentNum.getText());
			} catch (NumberFormatException numberFormatException) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Sorry, please check your entry again.");
				alert.setHeaderText(null);
				alert.setContentText("住宿人姓名、房间数量和入住人数均不能为空");
				alert.showAndWait();
			}
			if (tempRoomNum > 0 && tempResidentNum > 0) {
				int tempAvailableRoomNum = HotelController.getInstance().getAvailableRoomNum(LiveDatePicker.toDate(schFromDate.getValue()), LiveDatePicker.toDate(schToDate.getValue()), hotel.id, RoomType.getType(roomType.getValue()));
				if (tempRoomNum <= tempAvailableRoomNum) {
					OrderVO newOrder = new OrderVO(user.ID, OrderType.UNEXECUTED.getString(), null, LiveDatePicker.toDate(schFromDate.getValue()), LiveDatePicker.toDate(schToDate.getValue()),
							new Date(0, 0, 1), new Date(0, 0, 1), LiveDatePicker.toDate(schFromDate.getValue().plusDays(1)), new Date(0, 0, 1), hotel.id, 
							hotel.hotelName, null, hotel.address, roomType.getValue(), getCurrentTotalPrice(), tempRoomNum, tempResidentNum,
							hasChildren.isSelected(), user.name, phoneNumber.getText(), false, false);
					SwitchSceneUtil.turnToConfirmOrderScene((GridPane)root.getParent(), newOrder);
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Sorry, please check your entry again.");
					alert.setHeaderText(null);
					alert.setContentText("抱歉，剩余房间数量不足");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Sorry, please check your entry again.");
				alert.setHeaderText(null);
				alert.setContentText("房间数量和入住人数必须大于0");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Sorry, please check your entry again.");
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
	void showPromotion() {
		int tempRoomNum;
		PromotionVO webPromotionVO = null;
		PromotionVO hotelPromotionVO = null;
		try {
			tempRoomNum = Integer.parseInt(roomNum.getText());
		} catch (NumberFormatException numberFormatException) {
			tempRoomNum = 0;
		}
		ArrayList<PromotionVO> bestPromotions = new ArrayList<>(PromotionController.getInstance().getPromotion(hotel.id, user.ID, tempRoomNum));
		if (bestPromotions.size() == 2) {
			if (bestPromotions.get(0).provider.equals("web")) {
				webPromotionVO = bestPromotions.get(0);
				hotelPromotionVO = bestPromotions.get(1);
			}
		} else if (bestPromotions.size() == 1) {
			if (bestPromotions.get(0).provider.equals("web")) {
				webPromotionVO = bestPromotions.get(0);
			} else {
				hotelPromotionVO = bestPromotions.get(0);
			}
		} else {
			// nothing to do, both promotions are null
		}
		
		//then show promotion in screen
		if (webPromotionVO != null) {
			webPromotionLabel.setText(webPromotionVO.name + "," + webPromotionVO.discount + "折折扣");
		} else {
			webPromotionLabel.setText("您当前不享用任何网站促销活动");
		}
		if (hotelPromotionVO != null) {
			hotelPromotionLabel.setText(hotelPromotionVO.name + "," + hotelPromotionVO.discount + "折折扣");
		} else {
			hotelPromotionLabel.setText("您当前不享用任何酒店促销活动");
		}
		promotionLabel.setVisible(true);
		promotionPane.setVisible(true);
	}
	
	@FXML
	void hidePromotion() {
		promotionLabel.setVisible(false);
		promotionPane.setVisible(false);
	}
	
	@FXML
	void refreshPrice() {
		setSingleRoomPrice();
		setRawPrice();
		setTotalPrice();
	}
	
	/**
	 * 保证todate一定实时保持在fromdate之后
	 */
	@FXML
	void refreshDatePicker() {
		if (!schToDate.getValue().isAfter(schFromDate.getValue())) {
			schToDate.setValue(schFromDate.getValue().plusDays(1));
		}
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
			double price = SwitchSceneUtil.getCurrentPrice(getRoomNum(), getCurrentRawPrice());
			totalPrice.setText(String.valueOf(price) + "元");
		} catch (NullPointerException nullPointerException) {
			totalPrice.setText("0.0元");
		}
	}
	
	private int getRoomNum() {
		try {
			int rooms = Integer.parseInt(roomNum.getText());
			return rooms;
		} catch (NumberFormatException unNumberFormatException) {
			return 0;
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
		return CheckStyle.checkPhone(phoneString);
	}
}
