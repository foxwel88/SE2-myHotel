package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * 
 * 客户-浏览酒店
 *
 */

public class CustomerCheckHotelList {
	@FXML
	ChoiceBox city;
	
	@FXML
	ChoiceBox area;
	
	@FXML
	ChoiceBox lowerStar;
	
	@FXML
	ChoiceBox upperStar;
	
	@FXML
	ChoiceBox lowerScore;
	
	@FXML
	ChoiceBox upperScore;
	
	@FXML
	ChoiceBox fromDate;
	
	@FXML
	ChoiceBox toDate;
	
	@FXML
	ChoiceBox roomType;
	
	@FXML
	TextField hotelName;
	
	@FXML
	TextField fromPrice;
	
	@FXML
	TextField toPrice;
	
	@FXML
	TextField roomNum;
	
	@FXML
	CheckBox everOrdered;
	
	/*
	 * 接下来的7个成员变量是酒店信息的容器
	 */
	@FXML
	VBox pictureBox;			// 酒店缩略示意图列表
	
	@FXML
	VBox hotelNameBox;			// 酒店姓名列表
	
	@FXML
	VBox starAndScoreBox;		// 酒店星级和评分列表，注意：这个VBox的子组件比其他多
	
	@FXML
	VBox hotelAddressBox;		// 酒店地址列表
	
	@FXML
	VBox priceBox;				// 酒店最低价
	
	@FXML
	VBox leftRoomNumBox;		// 酒店剩余房间
	
	@FXML
	VBox makeOrderBox;			// 预定该酒店
	
	@FXML
	void initialize() {
		
	}
	
	private void showHotelList() {
		
	}
}
