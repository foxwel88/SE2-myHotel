package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.launcher.Resources;
import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller
 * 网站营销人员-浏览异常订单界面
 * @author gyue
 * @version 2016/11/27 gyue
 */
public class WebMarketerAbnormalOrderList {
	/**
	 * 起始页码
	 */
	private static final int FIRST_PAGE_NUM = 1;
	
	/**
	 * 每个页面上的促销策略数量
	 */
	private static final int NUM_OF_ORDER_PER_PAGE = 5;

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField orderNumLabel;

	@FXML
    private Button searchButton;

	@FXML
    private Label prevPage;

	@FXML
    private Label pageNumLabel;

	@FXML
    private Label nextPage;

	@FXML
    private TextField jumpField;
	
	@FXML
	private GridPane contentGridPane;
	
	@FXML
	private Label infoLabel;
	
	private WebMarketerController controller;
	
	/**
	 * 当前页码
	 */
	private int pageNum;
	
	/**
	 * 导航界面的GridPane
	 */
	private GridPane parentPane;
	
	/**
	 * 异常订单的VO的list
	 */
	private List<OrderVO> orderList;
	
	/**
	 * 当前页面中显示的OrderPane的list
	 */
	private List<OrderPane> currentOrderPanes;

	@FXML
    void handleSearch(MouseEvent event) {
		String id = orderNumLabel.getText();
		if (id == null || id.equals("")) { //如果没有输入订单号
			infoLabel.setText("请输入订单号");
			return;
		}
		OrderVO vo = controller.getAbnormalOrder(id);
		if (vo.resultMessage != ResultMessage.SUCCESS) { //如果没有成功得到OrderVO
			ResultInfoHelper.setResultLabel(infoLabel, vo.resultMessage, 2000);
			orderList = controller.getAbnormalOrders();
			switchCurrentPage(FIRST_PAGE_NUM);
			return;
		}
		infoLabel.setText("搜索成功");
		orderList = new ArrayList<>();
		orderList.add(vo);
		switchCurrentPage(FIRST_PAGE_NUM);
	}

	@FXML
    void jumpPage(ActionEvent event) {
		int toPageNum = pageNum;
		try {
			toPageNum = Integer.parseInt(jumpField.getText().trim());
		} catch (RuntimeException e) {
			switchCurrentPage(pageNum);
		}
		if (toPageNum >= FIRST_PAGE_NUM) {					
			switchCurrentPage(toPageNum);
		}
	}

	@FXML
    void toNextPage(MouseEvent event) {
		switchCurrentPage(pageNum + 1);
	}

	@FXML
	void toPrevPage(MouseEvent event) {
		// 检查是否有上一页
		if (pageNum > FIRST_PAGE_NUM) {
			switchCurrentPage(pageNum - 1);
		}
	}

	/**
	 * 替换OrderPane的内容，将其设为contentGridPane的子女显示 
	 * 并更改pageNumLabel和pageNum
	 * @param page
	 */
	private void cancelOrder(OrderVO vo) {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			modifyRoot = resources.load(resources.webMarketerAbnormalOrder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
		
		((WebMarketerAbnormalOrder)resources.getCurrentController()).setOrderVO(vo);
	}
	
	void switchCurrentPage(int toPageNum) {
		// 修改currentNamePanes和currentDetailPanes
		currentOrderPanes = new ArrayList<>();
		// 当前页面要显示的第一个订单信息在list中的位置
		int fromNum = (toPageNum - 1) * NUM_OF_ORDER_PER_PAGE;
		// 当前页面要显示的最后一个订单信息在list中的位置
		int toNum = (toPageNum - 1) * NUM_OF_ORDER_PER_PAGE + Math.min(NUM_OF_ORDER_PER_PAGE,
				orderList.size() - NUM_OF_ORDER_PER_PAGE * (toPageNum - 1));
		// 当前页面显示的订单信息总数
		int orderNums = toNum - fromNum;
		// 订单信息可能的最大页数
		int maxPageNum = (orderList.size() + NUM_OF_ORDER_PER_PAGE - 1) / NUM_OF_ORDER_PER_PAGE;
		// 如果将要调到的页面上的订单信息数量不大于0并且不是第一页
		// 那么跳到最后一页
		if ((orderNums <= 0) && (toPageNum > FIRST_PAGE_NUM)) { 
			switchCurrentPage(maxPageNum);
			return;
		}
		for (int i = fromNum; i < toNum; i++) {
			currentOrderPanes.add(new OrderPane(orderList.get(i)));
		}

		// 修改contentGridPane
		contentGridPane.getChildren().clear();
		int lastIndex = 0;
		for (int i = 0; i < orderNums; i++) {
			OrderPane orderPane = currentOrderPanes.get(i);
			contentGridPane.add(orderPane, 0, i * 2);
			lastIndex++;
		}
		for (int i = lastIndex; i < NUM_OF_ORDER_PER_PAGE; i++) {
			AnchorPane blackPane = new AnchorPane();
			blackPane.setStyle("-fx-background-color: rgba(0,20,81,0.45)");
			contentGridPane.add(blackPane, 0, i * 2);
		}

		// 修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
		jumpField.setText("");
	}
	
	/**
	 * 获得导航界面GridPane的引用以完成到编辑界面的跳转
	 * @param pane
	 */
	void setParentGridPane(GridPane pane) {
		parentPane = pane;
	}
	
	/**
	 * 对orderVO进行排序
	 * 使用冒泡排序
	 * @param list
	 */
	private void sort(List<OrderVO> list) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		for (int i = list.size(); i >= 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				long former = Integer.parseInt(format.format(list.get(j).schFrom));
				long later = Integer.parseInt(format.format(list.get(j + 1).schFrom));
				if (former < later) {
					OrderVO temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
	
	@FXML
    void initialize() {
        assert orderNumLabel != null : "fx:id=\"orderNumLabel\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert prevPage != null : "fx:id=\"prevPage\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert pageNumLabel != null : "fx:id=\"pageNumLabel\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert jumpField != null : "fx:id=\"jumpField\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert contentGridPane != null : "fx:id=\"contentGridPane\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file '浏览异常订单界面.fxml'.";
        

		controller = WebMarketerController.getInstance();
		orderList = controller.getAbnormalOrders();
		sort(orderList);
		
		// show first page
		switchCurrentPage(FIRST_PAGE_NUM);
        
	}
	
	/**
	 * 内部类。每个页面上包含若干个OrderPane，每个OrderPane上显示一个订单的信息。
	 * @author gyue
	 */
	class OrderPane extends AnchorPane {
		Text orderNum;
		
		Text hotel;
		
		Text date;
		
		Button detail;
		
		OrderPane(OrderVO vo) {
			orderNum = new Text(vo.orderID);
			hotel = new Text(vo.hotelName);
			detail = new Button("详情");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date = new Text(format.format(vo.schFrom));
			
			// set effect
			this.setStyle("-fx-background-color: rgba(0,20,81,0.45)");
			orderNum.setFont(Font.font("Microsoft YaHei", 17));
			orderNum.setStyle("-fx-fill: white");
			hotel.setFont(Font.font("Microsoft YaHei UI Light", 20));
			hotel.setStyle("-fx-fill: white");
			hotel.setWrappingWidth(240.0);
			hotel.setTextAlignment(TextAlignment.CENTER);
			detail.setFont(Font.font("Microsoft YaHei", 15));
			detail.setStyle("-fx-background-color: rgba(0,20,81,0.45); -fx-text-fill: white");
			date.setFont(Font.font("Microsoft YaHei UI Light", 20));
			date.setStyle("-fx-fill: white");
			date.setWrappingWidth(154.0);
			date.setTextAlignment(TextAlignment.CENTER);
			
			this.getChildren().add(detail);
			this.getChildren().add(hotel);
			this.getChildren().add(orderNum);
			this.getChildren().add(date);
			
			// set location
			AnchorPane.setBottomAnchor(orderNum, 12.0);
			AnchorPane.setLeftAnchor(orderNum, 14.0);
			
			AnchorPane.setBottomAnchor(hotel, 11.0);
			AnchorPane.setLeftAnchor(hotel, 312.0);
			AnchorPane.setRightAnchor(hotel, 237.0);
			
			AnchorPane.setBottomAnchor(detail, 10.0);
			AnchorPane.setLeftAnchor(detail, 704.0);
			AnchorPane.setRightAnchor(detail, 14.0);
			AnchorPane.setTopAnchor(detail, 10.0);
			
			AnchorPane.setBottomAnchor(date, 11.0);
			AnchorPane.setLeftAnchor(date, 525.0);
			AnchorPane.setRightAnchor(date, 110.0);
			
			// add listener
			detail.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					cancelOrder(vo);
				}
			});
		}
	}
}
