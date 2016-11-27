package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;

import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * 
 * 客户-浏览客户历史订单
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class CustomerHistoryOrder {
	@FXML
	AnchorPane root;
	
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
	
	// currentLabel 表示当前显示的订单列表中订单的类型
	// 0表示当前显示的是已执行订单界面，1表示是已撤销订单界面，2表示异常订单界面
	private int currentLabel = 0;
	
	private ArrayList<OrderVO> finishedOrderList;
	
	private ArrayList<OrderVO> canceledOrderList;
	
	private ArrayList<OrderVO> abnormalOrderList;
	
	private ArrayList<HBox> boxList;
	
	// 该字段表示同时显示的最大订单的数量
	private static final int MAX_ORDER_ONE_OAGE = 6;
	
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
	
	/*
	 * 以下三种方法用于切换三种订单列表
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
		currentPage.setText(String.valueOf(1));
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
		currentPage.setText(String.valueOf(1));
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
		currentPage.setText(String.valueOf(1));
		showExceptionOrderList();
	}
	/************************************************************************************/
	
	@FXML
	void turnToNextPage() {
		switch (currentLabel) {
			case 0:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(finishedOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showFinishedOrderList();
				}
				break;
			case 1:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(canceledOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showFinishedOrderList();
				}
				break;
			case 2:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(abnormalOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showFinishedOrderList();
				}
				break;
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		switch (currentLabel) {
			case 0:
				if (Integer.parseInt(currentPage.getText()) > 1) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
					showFinishedOrderList();
				}
				break;
			case 1:
				if (Integer.parseInt(currentPage.getText()) > 1) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
					showCanceledOrderList();
				}
				break;
			case 2:
				if (Integer.parseInt(currentPage.getText()) > 1) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
					showExceptionOrderList();
				}
				break;
		}
	}
	
	@FXML
	void turnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage();
			currentPage.setText(String.valueOf(goalPage));
			switch (currentLabel) {
				case 0:
					showFinishedOrderList();
					break;
				case 1:
					showCanceledOrderList();
					break;
				case 2:
					showExceptionOrderList();
					break;
			}
		}
	}
	
	/*
	 * 此方法用于跳转到某条详细订单信息界面
	 */
	@FXML
	void checkDetailedOrder(MouseEvent event) {
		String orderID;
		int page = Integer.parseInt(currentPage.getText());
		try {
			for (int i = 0; i < MAX_ORDER_ONE_OAGE; i++) {
				HBox clickedBox = (HBox)(event.getSource());
				if (clickedBox.equals(boxList.get(i))) {
					switch (currentLabel) {
						case 0:
							orderID = finishedOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), "/客户/已执行订单详细信息界面.fxml", orderID);
							break;
						case 1:
							orderID = canceledOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), "/客户/已撤销订单详细信息界面.fxml", orderID);
							break;
						case 2:
							orderID = abnormalOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), "/客户/异常订单详细信息界面.fxml", orderID);
							break;
					}
					break;
				}
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// 点击无订单的订单列表区域会出现此异常，可以忽略
		}
	}
	
	/*
	 * 此方法用于检查用户输入的目标跳转页面是否合法 （在第1页和最后一页之间）
	 * 此方法在用户敲击回车确认输入时被调用
	 * 此方法被调用之后会把文本框中的内容变为合法值
	 */
	int checkGoalPage() {
		int goalPage;
		try {
			goalPage = Integer.parseInt(toPage.getText());
		} catch (NumberFormatException numFormex) {
			goalPage = (int)Double.parseDouble(toPage.getText());
		}
		if (goalPage < 1) {
			goalPage = 1;
		}
		switch (currentLabel) {
			case 0:
				if (goalPage > calMaxPage(finishedOrderList)) {
					goalPage = calMaxPage(finishedOrderList);
				}
				break;
			case 1:
				if (goalPage > calMaxPage(canceledOrderList)) {
					goalPage = calMaxPage(canceledOrderList);
				}
				break;
			case 2:
				if (goalPage > calMaxPage(abnormalOrderList)) {
					goalPage = calMaxPage(abnormalOrderList);
				}
				break;
		}
		toPage.setText(String.valueOf(goalPage));
		return goalPage;
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
	 * 此方法用于计算某种订单列表能够展开的最大页数
	 */
	private int calMaxPage(ArrayList<OrderVO> voList) {
		return (voList.size() / MAX_ORDER_ONE_OAGE) + 1;
	}
	
	/*
	 * 这个方法的作用是设置单个订单列表全部订单的内容
	 */
	private void setContent() {
		for (int i = 0; i < MAX_ORDER_ONE_OAGE; i++) {
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
	/********************************************************/
	
	/**
	 * 下面四种方法分别用来获得某个订单的订单时间、酒店地址、房间类型、房间数量的信息
	 * @param i 范围是 0 到 MAX_ORDER_ONE_OAGE - 1
	 */
	private String date(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
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
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
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
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
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
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
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
	/**************************************************************************************/
}
