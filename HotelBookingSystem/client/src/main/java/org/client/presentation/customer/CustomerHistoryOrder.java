package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * 
 * 客户-浏览客户历史订单
 *
 */
public class CustomerHistoryOrder {
	
	@FXML
	Pane finishedOrder;
	
	@FXML
	Pane canceledOrder;
	
	@FXML
	Pane exceptionOrder;
	
	@FXML
	TextField toPage;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label cuerentPage;
	
	@FXML
	Label nextPage;
	
	/*
	 * 下面所有的标签标识了该界面显示的订单列表中6个订单的全部信息（包括时间、酒店地址、房型、房间数量）
	 */
	@FXML
	Label date1;
	
	@FXML
	Label date2;
	
	@FXML
	Label date3;
	
	@FXML
	Label date4;
	
	@FXML
	Label date5;
	
	@FXML
	Label date6;
	
	@FXML
	Label hotelAddress1;
	
	@FXML
	Label hotelAddress2;
	
	@FXML
	Label hotelAddress3;
	
	@FXML
	Label hotelAddress4;
	
	@FXML
	Label hotelAddress5;
	
	@FXML
	Label hotelAddress6;
	
	@FXML
	Label roomType1;
	
	@FXML
	Label roomType2;
	
	@FXML
	Label roomType3;
	
	@FXML
	Label roomType4;
	
	@FXML
	Label roomType5;
	
	@FXML
	Label roomType6;
	
	@FXML
	Label roomNum1;
	
	@FXML
	Label roomNum2;
	
	@FXML
	Label roomNum3;
	
	@FXML
	Label roomNum4;
	
	@FXML
	Label roomNum5;
	
	@FXML
	Label roomNum6;
	
	/**
	 * 切换三种订单列表
	 * @param whichOne 0表示切换至已执行订单，1表示切换为已撤销订单，2表示切换为异常订单
	 */
	void switchTab(int whichOne) {
		
	}
}
