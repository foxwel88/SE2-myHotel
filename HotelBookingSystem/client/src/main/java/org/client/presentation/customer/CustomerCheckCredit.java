package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.List;

import org.client.presentation.util.DateUtil;
import org.client.vo.CreditRecordVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * 
 * 客户-查看信用记录
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */

public class CustomerCheckCredit {
	@FXML
	AnchorPane root;
	
	@FXML
	HBox record1;
	
	@FXML
	HBox record2;
	
	@FXML
	HBox record3;
	
	@FXML
	HBox record4;
	
	@FXML
	HBox record5;
	
	@FXML
	HBox record6;
	
	@FXML
	HBox record7;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	@FXML
	TextField toPage;
	
	private ArrayList<HBox> boxList;
	
	private List<CreditRecordVO> recordList;
	
	private static final int MAX_CREDITRECORD_ONE_PAGE = 7;
	
	@FXML
	void initialize() {
		boxList = new ArrayList<>();
		boxList.add(record1);
		boxList.add(record2);
		boxList.add(record3);
		boxList.add(record4);
		boxList.add(record5);
		boxList.add(record6);
		boxList.add(record7);
		recordList = CustomerController.getRecordList();
		showRecord();
	}
	
	/*
	 * 这个方法的作用是设置单页被显示的信用记录
	 */
	private void showRecord() {
		for (int i = 0; i < MAX_CREDITRECORD_ONE_PAGE; i++) {
			if (time(i) != null) {
				getOrderID(boxList.get(i)).setText(orderID(i));
				getTime(boxList.get(i)).setText(time(i));
				getOpType(boxList.get(i)).setText(opType(i));
				getCreditChangedValue(boxList.get(i)).setText(String.valueOf(creditChangedValue(i)));
				getResultCredit(boxList.get(i)).setText(resultCredit(i));
			} else {
				getOrderID(boxList.get(i)).setText("");
				getTime(boxList.get(i)).setText("");
				getOpType(boxList.get(i)).setText("");
				getCreditChangedValue(boxList.get(i)).setText("");
				getResultCredit(boxList.get(i)).setText("");
			}
		}
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(currentPage.getText()) < calMaxPage(recordList)) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
			showRecord();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(currentPage.getText()) > 1) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
			showRecord();
		}
	}
	
	@FXML
	void turnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage();
			currentPage.setText(String.valueOf(goalPage));
			showRecord();
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
		if (goalPage > calMaxPage(recordList)) {
			goalPage = calMaxPage(recordList);
		}
		toPage.setText(String.valueOf(goalPage));
		return goalPage;
	}
	
	/*
	 * 此方法用于计算信用记录列表能够展开的最大页数
	 */
	private int calMaxPage(List<CreditRecordVO> voList) {
		return (voList.size() / MAX_CREDITRECORD_ONE_PAGE) + 1;
	}
	
	/*
	 * 下面5个方法分别用于获得单条信用记录的不同信息字段的Label的引用
	 */
	private Label getOrderID(HBox credit) {
		return (Label)(credit.getChildren().get(0));
	}
	
	private Label getTime(HBox credit) {
		return (Label)(credit.getChildren().get(1));
	}
	
	private Label getOpType(HBox credit) {
		return (Label)(credit.getChildren().get(2));
	}
	
	private Label getCreditChangedValue(HBox credit) {
		return (Label)(credit.getChildren().get(3));
	}
	
	private Label getResultCredit(HBox credit) {
		return (Label)(credit.getChildren().get(4));
	}
	/********************************************************/
	
	/**
	 * 下面五种方法分别用来获得某个信用记录的订单号、信用变化时间、操作类型、信用变化值、信用变化结果
	 * @param i 范围是 0 到 MAX_ORDER_ONE_PAGE - 1
	 */
	private String orderID(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_CREDITRECORD_ONE_PAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return recordList.get(seq).orderID;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String time(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_CREDITRECORD_ONE_PAGE + i;
		try {
			return DateUtil.dateToCoarseString(recordList.get(seq).date);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String opType(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_CREDITRECORD_ONE_PAGE + i;
		try {
			return recordList.get(seq).op;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String creditChangedValue(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_CREDITRECORD_ONE_PAGE + i;
		try {
			return String.valueOf(recordList.get(seq).change);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String resultCredit(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_CREDITRECORD_ONE_PAGE + i;
		try {
			return String.valueOf(recordList.get(seq).result);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	/**************************************************************************************/
}
