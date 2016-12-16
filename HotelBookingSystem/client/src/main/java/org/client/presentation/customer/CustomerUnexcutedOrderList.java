package org.client.presentation.customer;

import java.util.ArrayList;

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

/**
 * 
 * 客户-未执行订单列表
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class CustomerUnexcutedOrderList {
	@FXML
	AnchorPane root;
	
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
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	@FXML
	TextField toPage;
	
	private ArrayList<HBox> boxList;
	
	private ArrayList<OrderVO> unExcutedOrderList;
	
	private Resources resources;
	
	// 该字段表示同时显示的最大订单的数量
	private static final int MAX_ORDER_ONE_OAGE = 11;
	
	@FXML
	void initialize() {
		SwitchSceneUtil.canBack = false;
		resources = Resources.getInstance();
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
		showUnExcutedOrderList();
		
		if (SwitchSceneUtil.isBack) {
			int goalPage = checkGoalPage(SwitchSceneUtil.previousOrderSceneInfo.currentPage);
			currentPage.setText(String.valueOf(goalPage));
			showUnExcutedOrderList();
		}
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(currentPage.getText()) < calMaxPage(unExcutedOrderList)) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
			showUnExcutedOrderList();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(currentPage.getText()) > 1) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
			showUnExcutedOrderList();
		}
	}
	
	@FXML
	void turnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage;
			try {
				goalPage = Integer.parseInt(toPage.getText());
			} catch (NumberFormatException numFormex) {
				goalPage = (int)Double.parseDouble(toPage.getText());
			}
			goalPage = checkGoalPage(goalPage);
			currentPage.setText(String.valueOf(goalPage));
			showUnExcutedOrderList();
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
				if (((HBox)(event.getSource())).equals(boxList.get(i))) {
					orderID = unExcutedOrderList.get((page - 1) * MAX_ORDER_ONE_OAGE + i).orderID;
					SwitchSceneUtil.currentScene = CustomerBackableScene.UNEXECUTED_ORDER_SCENE;
					SwitchSceneUtil.previousOrderSceneInfo = new PreviousOrderSceneInfo(Integer.parseInt(currentPage.getText()));
					SwitchSceneUtil.turnToDetailedOrderScene((GridPane)root.getParent(), resources.customerCheckUnexecutedOrder, orderID);
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
	
	private void showUnExcutedOrderList() {
		unExcutedOrderList = new ArrayList<>(SwitchSceneUtil.getUnExcutedOrderList());
		setContent();
	}
	
	/*
	 * 这个方法的作用是设置订单列表全部订单的内容
	 */
	private void setContent() {
		for (int i = 0; i < MAX_ORDER_ONE_OAGE; i++) {
			if (hotelAddress(i) != null) {
				getDateLabel(boxList.get(i)).setText(date(i));
				getHotelAddressLabel(boxList.get(i)).setText(hotelAddress(i));
				getRoomTypeLabel(boxList.get(i)).setText(roomType(i));
				getRoomNumLabel(boxList.get(i)).setText(String.valueOf(roomNum(i)));
				getLatestTimeLabel(boxList.get(i)).setText(latestDate(i));
			} else {
				getDateLabel(boxList.get(i)).setText("");
				getHotelAddressLabel(boxList.get(i)).setText("");
				getRoomTypeLabel(boxList.get(i)).setText("");
				getRoomNumLabel(boxList.get(i)).setText("");
				getLatestTimeLabel(boxList.get(i)).setText("");
			}
		}
	}
	
	/*
	 * 此方法用于检查用户输入的目标跳转页面是否合法 （在第1页和最后一页之间）
	 * 此方法在用户敲击回车确认输入时被调用
	 * 此方法被调用之后会把文本框中的内容变为合法值
	 */
	int checkGoalPage(int inputPage) {
		int goalPage = inputPage;
		if (goalPage < 1) {
			goalPage = 1;
		}
		if (goalPage > calMaxPage(unExcutedOrderList)) {
			goalPage = calMaxPage(unExcutedOrderList);
		}
		toPage.setText(String.valueOf(goalPage));
		return goalPage;
	}
	
	/*
	 * 此方法用于计算订单列表能够展开的最大页数
	 */
	private int calMaxPage(ArrayList<OrderVO> voList) {
		return (voList.size() / MAX_ORDER_ONE_OAGE) + 1;
	}
	
	/*
	 * 下面5个方法分别用于获得单条订单的不同信息字段的Label的引用
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
	
	private Label getLatestTimeLabel(HBox order) {
		return (Label)(order.getChildren().get(4));
	}
	/********************************************************/
	
	/**
	 * 下面五种方法分别用来获得某个订单的订单时间、酒店地址、房间类型、房间数量、最晚执行时间的信息
	 * @param i 范围是 0 到 MAX_ORDER_ONE_OAGE - 1
	 */
	private String date(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return LiveDatePicker.dateToCoarseString(unExcutedOrderList.get(seq).generatedDate);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String hotelAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			return unExcutedOrderList.get(seq).hotelAddress;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String roomType(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			return unExcutedOrderList.get(seq).roomType;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private int roomNum(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			return unExcutedOrderList.get(seq).roomNum;
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	
	private String latestDate(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			return LiveDatePicker.dateToCoarseString(unExcutedOrderList.get(seq).latestTime);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	/**************************************************************************************/
}
