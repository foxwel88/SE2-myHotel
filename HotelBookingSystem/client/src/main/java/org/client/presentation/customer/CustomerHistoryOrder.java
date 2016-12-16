package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;

import org.client.launcher.Resources;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
 * @version fraliphsoft 11/30
 */
public class CustomerHistoryOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Pane executedOrder;
	
	@FXML
	Pane canceledOrder;
	
	@FXML
	Pane abnormalOrder;
	
	@FXML
	Label executedOrderText;
	
	@FXML
	Label canceledOrderText;
	
	@FXML
	Label abnormalOrderText;
	
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
	
	private ArrayList<OrderVO> executedOrderList;
	
	private ArrayList<OrderVO> canceledOrderList;
	
	private ArrayList<OrderVO> abnormalOrderList;
	
	private ArrayList<HBox> boxList;
	
	private Resources resources;
	
	// 该字段表示同时显示的最大订单的数量
	private static final int MAX_ORDER_ONE_OAGE = 6;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		boxList = new ArrayList<>();
		boxList.add(order1);
		boxList.add(order2);
		boxList.add(order3);
		boxList.add(order4);
		boxList.add(order5);
		boxList.add(order6);
		showExecutedOrderList();
		if (SwitchSceneUtil.isBack) {
			switch (SwitchSceneUtil.currentScene) {
				case EXECUTED_ORDER_SCENE:
					switchToExecutedOrder();
					break;
				case CANCELED_ORDER_SCENE:
					switchToCanceledOrder();
					break;
				case ABNORMAL_ORDER_SCENE:
					switchToAbnormalOrder();
					break;
			}
			currentPage.setText(String.valueOf(SwitchSceneUtil.previousOrderSceneInfo.currentPage));
			switch (SwitchSceneUtil.currentScene) {
				case EXECUTED_ORDER_SCENE:
					showExecutedOrderList();
					break;
				case CANCELED_ORDER_SCENE:
					showCanceledOrderList();
					break;
				case ABNORMAL_ORDER_SCENE:
					showAbnormalOrderList();
					break;
			}
		}
	}
	
	/*
	 * 以下三种方法用于切换三种订单列表
	 */
	@FXML
	void switchToExecutedOrder() {
		active_innerGuide(0);
		deactive_innerGuide(1);
		deactive_innerGuide(2);
		currentLabel = 0;
		currentPage.setText(String.valueOf(1));
		showExecutedOrderList();
	}
	
	@FXML
	void switchToCanceledOrder() {
		deactive_innerGuide(0);
		active_innerGuide(1);
		deactive_innerGuide(2);
		currentLabel = 1;
		currentPage.setText(String.valueOf(1));
		showCanceledOrderList();
	}
	
	@FXML
	void switchToAbnormalOrder() {
		deactive_innerGuide(0);
		deactive_innerGuide(1);
		active_innerGuide(2);
		currentLabel = 2;
		currentPage.setText(String.valueOf(1));
		showAbnormalOrderList();
	}
	/************************************************************************************/
	
	@FXML
	void turnToNextPage() {
		switch (currentLabel) {
			case 0:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(executedOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showExecutedOrderList();
				}
				break;
			case 1:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(canceledOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showExecutedOrderList();
				}
				break;
			case 2:
				if (Integer.parseInt(currentPage.getText()) < calMaxPage(abnormalOrderList)) {
					currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
					showExecutedOrderList();
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
					showExecutedOrderList();
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
					showAbnormalOrderList();
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
					showExecutedOrderList();
					break;
				case 1:
					showCanceledOrderList();
					break;
				case 2:
					showAbnormalOrderList();
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
					SwitchSceneUtil.previousOrderSceneInfo = new PreviousOrderSceneInfo(Integer.parseInt(currentPage.getText()));
					switch (currentLabel) {
						case 0:
							orderID = executedOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.currentScene = CustomerBackableScene.EXECUTED_ORDER_SCENE;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), resources.customerCheckExecutedOrder, orderID);
							break;
						case 1:
							orderID = canceledOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.currentScene = CustomerBackableScene.CANCELED_ORDER_SCENE;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), resources.customerCheckCanceledOrder, orderID);
							break;
						case 2:
							orderID = abnormalOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
							SwitchSceneUtil.currentScene = CustomerBackableScene.ABNORMAL_ORDER_SCENE;
							SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), resources.customerCheckAbnormalOrder, orderID);
							break;
					}
					break;
				}
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// 点击无订单的订单列表区域会出现此异常，可以忽略
		}
	}
	
	@FXML
	void active(MouseEvent mouseEvent) {
		HBox hbox = (HBox)mouseEvent.getSource();
		if (!((Label)hbox.getChildren().get(0)).getText().isEmpty()) {
			for (int i = 0; i < hbox.getChildren().size(); i++) {
				hbox.getChildren().get(i).setStyle("-fx-text-fill: white");
			}
			hbox.setStyle("-fx-background-color: rgba(255,255,255,0.14)");
			hbox.setEffect(new DropShadow());
		}
	}
	
	@FXML
	void deactive(MouseEvent mouseEvent) {
		HBox hbox = (HBox)mouseEvent.getSource();
		if (!((Label)hbox.getChildren().get(0)).getText().isEmpty()) {
			hbox.setStyle(null);
			hbox.setEffect(null);
			for (int i = 0; i < hbox.getChildren().size(); i++) {
				hbox.getChildren().get(i).setStyle(null);
			}
		}
	}
	
	@FXML
	void activeExecutedOrderGuide() {
		active_innerGuide(0);
	}
	
	@FXML
	void activeCanceledOrderGuide() {
		active_innerGuide(1);
	}
	
	@FXML
	void activeAbnormalOrderGuide() {
		active_innerGuide(2);
	}
	
	@FXML
	void deactiveExecutedOrderGuide() {
		if (currentLabel != 0) {
			deactive_innerGuide(0);
		}
	}
	
	@FXML
	void deactiveCanceledOrderGuide() {
		if (currentLabel != 1) {
			deactive_innerGuide(1);
		}
	}
	
	@FXML
	void deactiveAbnormalOrderGuide() {
		if (currentLabel != 2) {
			deactive_innerGuide(2);
		}
	}
	
	/**
	 * 
	 * @param whichOne 0-2
	 */
	private void active_innerGuide(int whichOne) {
		switch (whichOne) {
			case 0:
				executedOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
				executedOrderText.setStyle("-fx-text-fill: white");
				break;
			case 1:
				canceledOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
				canceledOrderText.setStyle("-fx-text-fill: white");
				break;
			case 2:
				abnormalOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
				abnormalOrderText.setStyle("-fx-text-fill: white");
				break;
		}
	}
	
	private void deactive_innerGuide(int whichOne) {
		switch (whichOne) {
			case 0:
				executedOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
				executedOrderText.setStyle("-fx-text-fill: black");
				break;
			case 1:
				canceledOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
				canceledOrderText.setStyle("-fx-text-fill: black");
				break;
			case 2:
				abnormalOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
				abnormalOrderText.setStyle("-fx-text-fill: black");
				break;
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
				if (goalPage > calMaxPage(executedOrderList)) {
					goalPage = calMaxPage(executedOrderList);
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
	
	void showExecutedOrderList() {
		executedOrderList = new ArrayList<>(SwitchSceneUtil.getFinishedOrderList());
		setContent();
	}
	
	void showCanceledOrderList() {
		canceledOrderList = new ArrayList<>(SwitchSceneUtil.getCanceledOrderList());
		setContent();
	}
	
	void showAbnormalOrderList() {
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
		try {
			if (currentLabel == 0) {
				tempDate = executedOrderList.get(seq).generatedDate;
			} else if (currentLabel == 1) {
				tempDate = canceledOrderList.get(seq).generatedDate;
			} else {
				tempDate = abnormalOrderList.get(seq).generatedDate;
			}
			return LiveDatePicker.dateToCoarseString(tempDate);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String hotelAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			if (currentLabel == 0) {
				return executedOrderList.get(seq).hotelAddress;
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
				return executedOrderList.get(seq).roomType;
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
				return executedOrderList.get(seq).roomNum;
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
