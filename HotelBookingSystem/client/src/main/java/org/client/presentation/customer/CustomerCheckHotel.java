package org.client.presentation.customer;

import org.client.vo.HotelVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-酒店详细信息-第一页
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */

public class CustomerCheckHotel {
	@FXML
	AnchorPane root;
	
	@FXML
	Label hotelName;

	@FXML
	Label introduce;

	@FXML
	Label address;
	
	/*
	 * 下面9个Label显示了酒店的三种房源信息
	 */
	
	@FXML
	Label leftNum1;
	
	@FXML
	Label rawPrice1;
	
	@FXML
	Label currentPrice1;
	
	@FXML
	Label leftNum2;
	
	@FXML
	Label rawPrice2;
	
	@FXML
	Label currentPrice2;
	
	@FXML
	Label leftNum3;
	
	@FXML
	Label rawPrice3;
	
	@FXML
	Label currentPrice3;
	/**********************************************************/
	
	@FXML
	Label service;
	
	@FXML
	ImageView picture;
	
	@FXML
	Button makeOrderButton;
	
	private HotelVO hotel;
	
	@FXML
	void initialize() {
		hotel = SwitchSceneUtil.getHotelVO();
		hotelName.setText(hotel.hotelName);
		introduce.setText(hotel.introduction);
		address.setText(hotel.address);
		for (int i = 0; i < hotel.roomType.size(); i++) {
			switch (hotel.roomType.get(i)) {
				case "单人间":
					leftNum1.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice1.setText(String.valueOf(hotel.roomPrice.get(i)));
					// TODO 计算现价 promotion stub还没更新接口
					break;
				case "套间":
					leftNum2.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice2.setText(String.valueOf(hotel.roomPrice.get(i)));
					// TODO 计算现价 promotion stub还没更新接口
					break;
				case "标间":
					leftNum3.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice3.setText(String.valueOf(hotel.roomPrice.get(i)));
					// TODO 计算现价 promotion stub还没更新接口
					break;
			}
		}
	}
	
	@FXML
	void turnToCustomerGenerateOrder() {
		SwitchSceneUtil.isBackToDetail = true;
		SwitchSceneUtil.currentScene = CustomerBackableScene.GENERATE_ORDER_SCENE;
		SwitchSceneUtil.turnToGenerateOrderScene((GridPane)root.getParent(), hotel.address);
	}
}
