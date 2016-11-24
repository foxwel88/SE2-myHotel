package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
	Label finishedOrderText;
	
	@FXML
	Label canceledOrderText;
	
	@FXML
	Label exceptionOrderText;
	
	@FXML
	TextField toPage;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	/*
	 * 下面6个标签标识了单页显示的订单列表中6个订单的信息（包括时间、酒店地址、房型、房间数量）的容器
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
	
	// 0表示当前显示的是已执行订单界面，1表示是已撤销订单界面，2表示异常订单界面
	private int currentLabel = 0;
	
	private ArrayList<OrderVO> finishedOrderList;
	
	private ArrayList<OrderVO> canceledOrderList;
	
	private ArrayList<OrderVO> abnormalOrderList;
	
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
		showFinishedOrderList();
	}
	
	/**
	 * 切换三种订单列表
	 * @param whichOne 0表示切换至已执行订单，1表示切换为已撤销订单，2表示切换为异常订单
	 */
	@FXML
	void switchToFinishedOrder() {
		finishedOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		canceledOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		exceptionOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		finishedOrderText.setStyle("-fx-text-fill: white");
		canceledOrderText.setStyle("-fx-text-fill: black");
		exceptionOrderText.setStyle("-fx-text-fill: black");
		currentLabel = 0;
		showFinishedOrderList();
	}
	
	@FXML
	void switchToCanceledOrder() {
		finishedOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		canceledOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		exceptionOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		finishedOrderText.setStyle("-fx-text-fill: black");
		canceledOrderText.setStyle("-fx-text-fill: white");
		exceptionOrderText.setStyle("-fx-text-fill: black");
		currentLabel = 1;
		showCanceledOrderList();
	}
	
	@FXML
	void switchToExceptionOrder() {
		finishedOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		canceledOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		exceptionOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		finishedOrderText.setStyle("-fx-text-fill: black");
		canceledOrderText.setStyle("-fx-text-fill: black");
		exceptionOrderText.setStyle("-fx-text-fill: white");
		currentLabel = 2;
		showExceptionOrderList();
	}
	
	void showFinishedOrderList() {
		finishedOrderList = new ArrayList<>(SwitchSceneUtil.getFinishedOrderList());
		setContent();
	}
	
	void showCanceledOrderList() {
		canceledOrderList = new ArrayList<>(SwitchSceneUtil.getCanceledOrderList());
		setContent();
	}
	
	void showExceptionOrderList() {
		abnormalOrderList = new ArrayList<>(SwitchSceneUtil.getAbnormalOrderList());
		setContent();
	}
	
	/*
	 * 这个方法的作用是设置界面上显示的内容
	 */
	private void setContent() {
		for (int i = 0; i < 6; i++) {
			if (hotelAddress(i) != null) {
				getDateLabel(boxList.get(i)).setText(date(i));
				getHotelAddressLabel(boxList.get(i)).setText(hotelAddress(i));
				getRoomTypeLabel(boxList.get(i)).setText(roomType(i));
				getRoomNumLabel(boxList.get(i)).setText(String.valueOf(roomNum(i)));
			} else {
				getDateLabel(boxList.get(i)).setText("");
				getHotelAddressLabel(boxList.get(i)).setText("");
				getRoomTypeLabel(boxList.get(i)).setText("");
				getRoomNumLabel(boxList.get(i)).setText("");
			}
		}
	}
	
	/*
	 * 下面4个方法分别用于获得单条订单的不同信息字段的Label的引用
	 */
	private Label getDateLabel(HBox order) {
		return (Label)(order.getChildren().get(0));
	}
	
	private Label getHotelAddressLabel(HBox order) {
		return (Label)(order.getChildren().get(1));
	}
	
	private Label getRoomTypeLabel(HBox order) {
		return (Label)(order.getChildren().get(2));
	}
	
	private Label getRoomNumLabel(HBox order) {
		return (Label)(order.getChildren().get(3));
	}
	
	/**
	 * 下面四种方法分别用来获得某个订单的订单时间、酒店地址、房间类型、房间数量的信息
	 * @param i 范围是0到5
	 */
	private String date(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * 6 + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		Date tempDate;
		StringBuilder sb = new StringBuilder();
		try {
			if (currentLabel == 0) {
				tempDate = finishedOrderList.get(seq).generatedDate;
			} else if (currentLabel == 1) {
				tempDate = canceledOrderList.get(seq).generatedDate;
			} else {
				tempDate = abnormalOrderList.get(seq).generatedDate;
			}
			sb.append(tempDate.getYear() + "/" + (tempDate.getMonth() + 1) + "/" + tempDate.getDate());
			return sb.toString();
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String hotelAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * 6 + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			if (currentLabel == 0) {
				return finishedOrderList.get(seq).hotelAddress;
			} else if (currentLabel == 1) {
				return canceledOrderList.get(seq).hotelAddress;
			} else {
				return abnormalOrderList.get(seq).hotelAddress;
			}
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String roomType(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * 6 + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			if (currentLabel == 0) {
				return finishedOrderList.get(seq).roomType;
			} else if (currentLabel == 1) {
				return canceledOrderList.get(seq).roomType;
			} else {
				return abnormalOrderList.get(seq).roomType;
			}
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private int roomNum(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * 6 + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			if (currentLabel == 0) {
				return finishedOrderList.get(seq).roomNum;
			} else if (currentLabel == 1) {
				return canceledOrderList.get(seq).roomNum;
			} else {
				return abnormalOrderList.get(seq).roomNum;
			}
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
}
