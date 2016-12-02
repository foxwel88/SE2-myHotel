package org.client.presentation.hotelmanager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.vo.OrderVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller
 * 酒店工作人员-浏览酒店历史订单
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerHistoryOrder {
	static final int FIRST_PAGE_NUM = 1;
	
	static final int NUM_OF_ORDER_PER_PAGE = 5;

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Pane executedPane;

	@FXML
    private Label executedLabel;

	@FXML
    private Pane cancelledPane;

	@FXML
    private Label cancelledLabel;

	@FXML
    private Pane abnormalPane;

	@FXML
    private Label abnormalLabel;

	@FXML
    private AnchorPane contentPane;

	@FXML
    private Label prevPage;

	@FXML
    private Label nextPage;

	@FXML
    private TextField jumpField;

	@FXML
    private Label pageNumLabel;
	
	private int pageNum;
	
	@FXML
	private TextField searchField;
    
	//导航界面的GridPane
	private GridPane parentPane;
	
	private List<OrderVO> currentOrders;
	
	private ArrayList<OrderInfoPane> currentOrderPanes;

	@FXML
    void jump(ActionEvent event) {
		int toPageNum = Integer.parseInt(jumpField.getText().trim());
		if (toPageNum >= FIRST_PAGE_NUM) {					
			switchCurrentPage(toPageNum);
		}
	}

	@FXML
    void toAbnormalOrders(MouseEvent event) {
		currentOrders = HotelManagerController.getInstance().getAbnormalOrders();
		switchCurrentPage(FIRST_PAGE_NUM);
		CurrentTabItem.getInstance().deActive();
		CurrentTabItem.setInstance(abnormalPane, abnormalLabel);
		CurrentTabItem.getInstance().active();
	}

	@FXML
    void toCancelledOrders(MouseEvent event) {
		currentOrders = HotelManagerController.getInstance().getCancelledOrders();
		switchCurrentPage(FIRST_PAGE_NUM);
		CurrentTabItem.getInstance().deActive();
		CurrentTabItem.setInstance(cancelledPane, cancelledLabel);
		CurrentTabItem.getInstance().active();
	}

	@FXML
    void toExecutedOrders(MouseEvent event) {
		currentOrders = HotelManagerController.getInstance().getExecutedOrders();
		switchCurrentPage(FIRST_PAGE_NUM);
		CurrentTabItem.getInstance().deActive();
		CurrentTabItem.setInstance(executedPane, executedLabel);
		CurrentTabItem.getInstance().active();
	}

	@FXML
    void toNextPage(MouseEvent event) {
		switchCurrentPage(pageNum + 1);
	}

	@FXML
    void toPrevPage(MouseEvent event) {
		
		//检查是否有上一页
		if (pageNum > FIRST_PAGE_NUM) {			
			switchCurrentPage(pageNum - 1);
		}
	}

	@FXML
	void initialize() {
		assert executedPane != null : "fx:id=\"executedPane\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert executedLabel != null : "fx:id=\"executedLabel\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert cancelledPane != null : "fx:id=\"cancelledPane\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert cancelledLabel != null : "fx:id=\"cancelledLabel\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert abnormalPane != null : "fx:id=\"abnormalPane\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert abnormalLabel != null : "fx:id=\"abnormalLabel\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert prevPage != null : "fx:id=\"prevPage\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert jumpField != null : "fx:id=\"jumpField\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert pageNumLabel != null : "fx:id=\"pageNumLabel\" was not injected: check your FXML file '浏览酒店历史订单界面.fxml'.";
		assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file '执行订单界面.fxml'.";

		//默认查看已执行订单
		currentOrders = HotelManagerController.getInstance().getExecutedOrders();
	}
	
	/** 持有导航界面GridPane的引用，为了完成从浏览到编辑界面的跳转
	 *另外还包含了第一页显示的任务，因为初始化第一页的元素必须在获得gridPane之后 */
	void setParentGridPane(GridPane parent) {
		parentPane = parent;
		switchCurrentPage(FIRST_PAGE_NUM);
		CurrentTabItem.setInstance(executedPane, executedLabel);
		CurrentTabItem.getInstance().active();
	}
	
	/** 替换currentOrderPanes的内容，将其设为contentPane的子女显示，并更改pageNumLabel和pageNum */
	void switchCurrentPage(int toPageNum) {
		
		//修改currentOrderPanes
		currentOrderPanes = new ArrayList<>();
		for (int i = (toPageNum - 1) * NUM_OF_ORDER_PER_PAGE; i < (toPageNum - 1) * NUM_OF_ORDER_PER_PAGE + 
				Math.min(NUM_OF_ORDER_PER_PAGE, currentOrders.size() - NUM_OF_ORDER_PER_PAGE * (toPageNum - 1)); i++) {
			currentOrderPanes.add(new OrderInfoPane(currentOrders.get(i), parentPane));
		}
		
		//修改contentPane
		contentPane.getChildren().clear();
		for (int i = 0; i < currentOrderPanes.size(); i++) {
			OrderInfoPane tempOrderPane = currentOrderPanes.get(i);
			contentPane.getChildren().add(tempOrderPane);
			tempOrderPane.setLayoutY(73 * i);
		}
		
		//修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
	}
	
	@FXML
	void searchByName(ActionEvent event) {
		String name = searchField.getText().trim();
		currentOrders.removeIf(orderVO -> !orderVO.customerName.equals(name));
		switchCurrentPage(FIRST_PAGE_NUM);
	}
	
}
