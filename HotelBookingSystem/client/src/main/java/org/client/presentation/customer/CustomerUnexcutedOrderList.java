package org.client.presentation.customer;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

/**
 * 
 * 客户-浏览客户未执行订单
 *
 */
public class CustomerUnexcutedOrderList {
	
	/*
	 * 以下11个Hbox分别表示单页上11个订单的信息的容器，每个容器含有5个Label显示单条订单的5个信息字段
	 */
	@FXML
	HBox order1;
	
	@FXML
	HBox order2;
	
	@FXML
	HBox order3;
	
	@FXML
	HBox order4;
	
	@FXML
	HBox order5;
	
	@FXML
	HBox order6;
	
	@FXML
	HBox order7;
	
	@FXML
	HBox order8;
	
	@FXML
	HBox order9;
	
	@FXML
	HBox order10;
	
	@FXML
	HBox order11;
	
	private ArrayList<HBox> boxList;
	
	@FXML
	void initialize() {
		boxList = new ArrayList<>();
		boxList.add(order1);
		boxList.add(order2);
		boxList.add(order3);
		boxList.add(order4);
		boxList.add(order5);
		boxList.add(order6);
		boxList.add(order7);
		boxList.add(order8);
		boxList.add(order9);
		boxList.add(order10);
		boxList.add(order11);
	}
}
