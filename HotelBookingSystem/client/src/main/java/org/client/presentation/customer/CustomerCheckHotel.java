package org.client.presentation.customer;

import java.util.ArrayList;
import java.util.Date;

import org.client.bl.promotionbl.PromotionController;
import org.client.presentation.util.LiveDatePicker;
import org.client.vo.CommentVO;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.PromotionVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * 客户-酒店详细信息-第一页
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */

public class CustomerCheckHotel {
	@FXML
	AnchorPane root;
	
	@FXML
	AnchorPane promotionPane;
	
	@FXML
	Label hotelName;

	@FXML
	Label introduce;

	@FXML
	Label address;
	
	/*
	 * 下面9个Label显示了酒店的三种房源信息
	 */
	
	@FXML
	Label leftNum1;
	
	@FXML
	Label rawPrice1;
	
	@FXML
	Label currentPrice1;
	
	@FXML
	Label leftNum2;
	
	@FXML
	Label rawPrice2;
	
	@FXML
	Label currentPrice2;
	
	@FXML
	Label leftNum3;
	
	@FXML
	Label rawPrice3;
	
	@FXML
	Label currentPrice3;
	/**********************************************************/
	
	@FXML
	Label service;
	
	@FXML
	ImageView picture;
	
	@FXML
	Button makeOrderButton;
	
	@FXML
	VBox vbox;

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
	Label timeLabel1;
	
	@FXML
	Label timeLabel2;
	
	@FXML
	Label roomTypeLabel1;
	
	@FXML
	Label roomTypeLabel2;
	
	@FXML
	Label roomNumLabel1;
	
	@FXML
	Label roomNumLabel2;
	
	@FXML
	Label priceLabel1;
	
	@FXML
	Label priceLabel2;
	
	@FXML
	Label orderPreviousPage;
	
	@FXML
	Label orderNextPage;
	
	@FXML
	Label orderCurrentPage;
	
	@FXML
	Label scoreLabel1;
	
	@FXML
	Label scoreLabel2;
	
	@FXML
	Label scoreLabel3;
	
	@FXML
	Label commentLabel1;
	
	@FXML
	Label commentLabel2;
	
	@FXML
	Label commentLabel3;
	
	@FXML
	Label commenterInfoLabel1;
	
	@FXML
	Label commenterInfoLabel2;
	
	@FXML
	Label commenterInfoLabel3;
	
	@FXML
	Label commentPreviousPage;
	
	@FXML
	Label commentNextPage;
	
	@FXML
	Label commentCurrentPage;
	
	@FXML
	Label showPromotionLabel;
	
	@FXML
	Label hidePromotionButton;
	
	@FXML
	Label promotion1;
	
	@FXML
	Label promotion2;
	
	@FXML
	Label promotion3;
	
	@FXML
	Label promotion4;
	
	@FXML
	Label promotionPreviousPage;
	
	@FXML
	Label promotionCurrentPage;
	
	@FXML
	Label promotionNextPage;
	
	@FXML
	TextField orderToPage;
	
	@FXML
	TextField commentToPage;
	
	private static final int MAX_ORDER_ONE_OAGE = 2;
	
	private static final int MAX_COMMENT_ONE_OAGE = 3;

	private static final int MAX_PROMOTION_ONE_OAGE = 4;
	
	private int currentLabel = 0;
	
	private ArrayList<OrderVO> executedOrderList;
	
	private ArrayList<OrderVO> canceledOrderList;
	
	private ArrayList<OrderVO> abnormalOrderList;
	
	private ArrayList<CommentVO> commentList;

	private ArrayList<Label> orderDateList;
	
	private ArrayList<Label> orderRoomTypeList;
	
	private ArrayList<Label> orderRoomNumList;
	
	private ArrayList<Label> orderPriceList;
	
	private ArrayList<Label> commentRankList;
	
	private ArrayList<Label> commentContentList;
	
	private ArrayList<Label> commentDateAndMakerList;
	
	private ArrayList<Label> promotionLabelList;
	
	private ArrayList<PromotionVO> promotionVOList;
	
	private HotelVO hotel;
	
	@FXML
	void initialize() {
		hotel = SwitchSceneUtil.getHotelVO();
		hotelName.setText(hotel.hotelName);
		introduce.setText(hotel.introduction);
		address.setText(hotel.address);
		for (int i = 0; i < hotel.roomType.size(); i++) {
			switch (hotel.roomType.get(i)) {
				case "单人间":
					leftNum1.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice1.setText(String.valueOf(hotel.roomPrice.get(i)));
					currentPrice1.setText(String.valueOf(SwitchSceneUtil.getCurrentPrice(1, hotel.roomPrice.get(i))));
					break;
				case "套间":
					leftNum2.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice2.setText(String.valueOf(hotel.roomPrice.get(i)));
					currentPrice2.setText(String.valueOf(SwitchSceneUtil.getCurrentPrice(1, hotel.roomPrice.get(i))));
					break;
				case "标间":
					leftNum3.setText(String.valueOf(hotel.roomNum.get(i)));
					rawPrice3.setText(String.valueOf(hotel.roomPrice.get(i)));
					currentPrice3.setText(String.valueOf(SwitchSceneUtil.getCurrentPrice(1, hotel.roomPrice.get(i))));
					break;
			}
		}
		
		orderDateList = new ArrayList<>();
		orderRoomTypeList = new ArrayList<>();
		orderRoomNumList = new ArrayList<>();
		orderPriceList = new ArrayList<>();
		orderDateList.add(timeLabel1);
		orderDateList.add(timeLabel2);
		orderRoomTypeList.add(roomTypeLabel1);
		orderRoomTypeList.add(roomTypeLabel2);
		orderRoomNumList.add(roomNumLabel1);
		orderRoomNumList.add(roomNumLabel2);
		orderPriceList.add(priceLabel1);
		orderPriceList.add(priceLabel2);
		
		commentRankList = new ArrayList<>();
		commentContentList = new ArrayList<>();
		commentDateAndMakerList = new ArrayList<>();
		commentRankList.add(scoreLabel1);
		commentRankList.add(scoreLabel2);
		commentRankList.add(scoreLabel3);
		commentContentList.add(commentLabel1);
		commentContentList.add(commentLabel2);
		commentContentList.add(commentLabel3);
		commentDateAndMakerList.add(commenterInfoLabel1);
		commentDateAndMakerList.add(commenterInfoLabel2);
		commentDateAndMakerList.add(commenterInfoLabel3);
		
		showExecutedOrderList();
		showCommentList();
		
		promotionLabelList = new ArrayList<>();
		promotionLabelList.add(promotion1);
		promotionLabelList.add(promotion2);
		promotionLabelList.add(promotion3);
		promotionLabelList.add(promotion4);
		promotionVOList = (ArrayList<PromotionVO>)PromotionController.getInstance().showHotelPromotion(SwitchSceneUtil.hotelID);
	}
	
	@FXML
	void turnToCustomerGenerateOrder() {
		SwitchSceneUtil.isBackToDetail = true;
		SwitchSceneUtil.currentScene = CustomerBackableScene.GENERATE_ORDER_SCENE;
		SwitchSceneUtil.turnToGenerateOrderScene((GridPane)root.getParent(), hotel.id);
	}
	
	/*
	 * 以下三种方法用于切换三种订单列表
	 */
	@FXML
	void switchToExecutedOrder() {
		executedOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		canceledOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		abnormalOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		executedOrderText.setStyle("-fx-text-fill: white");
		canceledOrderText.setStyle("-fx-text-fill: black");
		abnormalOrderText.setStyle("-fx-text-fill: black");
		currentLabel = 0;
		orderCurrentPage.setText(String.valueOf(1));
		showExecutedOrderList();
	}
	
	@FXML
	void switchToCanceledOrder() {
		executedOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		canceledOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		abnormalOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		executedOrderText.setStyle("-fx-text-fill: black");
		canceledOrderText.setStyle("-fx-text-fill: white");
		abnormalOrderText.setStyle("-fx-text-fill: black");
		currentLabel = 1;
		orderCurrentPage.setText(String.valueOf(1));
		showCanceledOrderList();
	}
	
	@FXML
	void switchToAbnormalOrder() {
		executedOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		canceledOrder.setStyle("-fx-background-color:  rgba(255,255,255,0.2)");
		abnormalOrder.setStyle("-fx-background-color:  rgba(0,0,0,0.3)");
		executedOrderText.setStyle("-fx-text-fill: black");
		canceledOrderText.setStyle("-fx-text-fill: black");
		abnormalOrderText.setStyle("-fx-text-fill: white");
		currentLabel = 2;
		orderCurrentPage.setText(String.valueOf(1));
		showAbnormalOrderList();
	}
	/************************************************************************************/
	
	@FXML
	void orderTurnToNextPage() {
		switch (currentLabel) {
			case 0:
				if (Integer.parseInt(orderCurrentPage.getText()) < calOrderMaxPage(executedOrderList)) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) + 1));
					showExecutedOrderList();
				}
				break;
			case 1:
				if (Integer.parseInt(orderCurrentPage.getText()) < calOrderMaxPage(canceledOrderList)) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) + 1));
					showCanceledOrderList();
				}
				break;
			case 2:
				if (Integer.parseInt(orderCurrentPage.getText()) < calOrderMaxPage(abnormalOrderList)) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) + 1));
					showAbnormalOrderList();
				}
				break;
		}
	}
	
	@FXML
	void commentTurnToNextPage() {
		if (Integer.parseInt(commentCurrentPage.getText()) < calCommentMaxPage(commentList)) {
			commentCurrentPage.setText(String.valueOf(Integer.parseInt(commentCurrentPage.getText()) + 1));
			showCommentList();
		}
	}
	
	@FXML
	void orderTurnToPreviousPage() {
		switch (currentLabel) {
			case 0:
				if (Integer.parseInt(orderCurrentPage.getText()) > 1) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) - 1));
					showExecutedOrderList();
				}
				break;
			case 1:
				if (Integer.parseInt(orderCurrentPage.getText()) > 1) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) - 1));
					showCanceledOrderList();
				}
				break;
			case 2:
				if (Integer.parseInt(orderCurrentPage.getText()) > 1) {
					orderCurrentPage.setText(String.valueOf(Integer.parseInt(orderCurrentPage.getText()) - 1));
					showAbnormalOrderList();
				}
				break;
		}
	}
	
	@FXML
	void commentTurnToPreviousPage() {
		if (Integer.parseInt(commentCurrentPage.getText()) > 1) {
			commentCurrentPage.setText(String.valueOf(Integer.parseInt(commentCurrentPage.getText()) - 1));
			showExecutedOrderList();
		}
	}
	
	@FXML
	void orderTurnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage(true);
			orderCurrentPage.setText(String.valueOf(goalPage));
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
	
	@FXML
	void commentTurnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage(false);
			commentCurrentPage.setText(String.valueOf(goalPage));
			showCommentList();
		}
	}
	
	@FXML
	void showHotelPromotion() {
		promotionPane.setVisible(true);
		setPromotionContent();
	}
	
	@FXML
	void hidePromotion() {
		promotionPane.setVisible(false);
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(promotionCurrentPage.getText()) < calPromotionMaxPage(promotionVOList)) {
			promotionCurrentPage.setText(String.valueOf(Integer.parseInt(promotionCurrentPage.getText()) + 1));
			showHotelPromotion();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(promotionCurrentPage.getText()) > 1) {
			promotionCurrentPage.setText(String.valueOf(Integer.parseInt(promotionCurrentPage.getText()) - 1));
			showHotelPromotion();
		}
	}
	
	/*
	 * 此方法用于检查用户输入的目标跳转页面是否合法 （在第1页和最后一页之间）
	 * 此方法在用户敲击回车确认输入时被调用
	 * 此方法被调用之后会把文本框中的内容变为合法值
	 */
	int checkGoalPage(boolean isOrder) {
		int goalPage;
		if (isOrder) {
			try {
				goalPage = Integer.parseInt(orderToPage.getText());
			} catch (NumberFormatException numFormex) {
				goalPage = (int)Double.parseDouble(orderToPage.getText());
			}
			if (goalPage < 1) {
				goalPage = 1;
			}
			switch (currentLabel) {
				case 0:
					if (goalPage > calOrderMaxPage(executedOrderList)) {
						goalPage = calOrderMaxPage(executedOrderList);
					}
					break;
				case 1:
					if (goalPage > calOrderMaxPage(canceledOrderList)) {
						goalPage = calOrderMaxPage(canceledOrderList);
					}
					break;
				case 2:
					if (goalPage > calOrderMaxPage(abnormalOrderList)) {
						goalPage = calOrderMaxPage(abnormalOrderList);
					}
					break;
			}
			orderToPage.setText(String.valueOf(goalPage));
		} else {
			try {
				goalPage = Integer.parseInt(commentToPage.getText());
			} catch (NumberFormatException numFormex) {
				goalPage = (int)Double.parseDouble(commentToPage.getText());
			}
			if (goalPage > calCommentMaxPage(commentList)) {
				goalPage = calCommentMaxPage(commentList);
			}
			commentToPage.setText(String.valueOf(goalPage));
		}
		return goalPage;
	}
	
	void showExecutedOrderList() {
		executedOrderList = new ArrayList<>(SwitchSceneUtil.getFinishedOrderListOfCurrentHotel());
		setOrderContent();
	}
	
	void showCanceledOrderList() {
		canceledOrderList = new ArrayList<>(SwitchSceneUtil.getCanceledOrderListOfCurrentHotel());
		setOrderContent();
	}
	
	void showAbnormalOrderList() {
		abnormalOrderList = new ArrayList<>(SwitchSceneUtil.getAbnormalOrderListOfCurrentHotel());
		setOrderContent();
	}
	
	void showCommentList() {
		commentList = SwitchSceneUtil.getComments();
		setCommentContent();
	}
	
	private void setOrderContent() {
		for (int i = 0; i < MAX_ORDER_ONE_OAGE; i++) {
			if (orderRoomType(i) != null) {
				orderDateList.get(i).setText(orderDate(i));
				orderRoomTypeList.get(i).setText(orderRoomType(i));
				orderRoomNumList.get(i).setText(String.valueOf(orderRoomNum(i)));
				orderPriceList.get(i).setText(String.valueOf(orderPrice(i)));
			} else {
				orderDateList.get(i).setText("");
				orderRoomTypeList.get(i).setText("");
				orderRoomNumList.get(i).setText("");
				orderPriceList.get(i).setText("");
			}
		}
	}
	
	private void setCommentContent() {
		for (int i = 0; i < MAX_COMMENT_ONE_OAGE; i++) {
			if (commentRank(i) != -1) {
				commentRankList.get(i).setText(String.valueOf(commentRank(i)));
				commentContentList.get(i).setText(commentContent(i));
				commentDateAndMakerList.get(i).setText("-——" + commentDate(i) + "          " + commentMaker(i));
			} else {
				commentRankList.get(i).setText("");
				commentContentList.get(i).setText("");
				commentDateAndMakerList.get(i).setText("");
			}
		}
	}
	
	private int calOrderMaxPage(ArrayList<OrderVO> voList) {
		return (voList.size() / MAX_ORDER_ONE_OAGE) + 1;
	}
	
	private int calCommentMaxPage(ArrayList<CommentVO> voList) {
		return (voList.size() / MAX_COMMENT_ONE_OAGE) + 1;
	}
	
	/**
	 * 下面四种方法分别用来获得某个订单的订单时间、房间类型、房间数量、订单价格的信息
	 * @param i 范围是 0 到 MAX_ORDER_ONE_OAGE - 1
	 */
	private String orderDate(int i) {
		int seq = (Integer.parseInt(orderCurrentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
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
	
	private String orderRoomType(int i) {
		int seq = (Integer.parseInt(orderCurrentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
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
	
	private int orderRoomNum(int i) {
		int seq = (Integer.parseInt(orderCurrentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
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
	
	private double orderPrice(int i) {
		int seq = (Integer.parseInt(orderCurrentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			if (currentLabel == 0) {
				return executedOrderList.get(seq).totalPrice;
			} else if (currentLabel == 1) {
				return canceledOrderList.get(seq).totalPrice;
			} else {
				return abnormalOrderList.get(seq).totalPrice;
			}
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	/**************************************************************************************/
	
	/**
	 * 下面四种方法分别用来获得某个评论的评价时间、评价者、评分、评论内容的信息
	 * @param i 范围是 0 到 MAX_COMMENT_ONE_OAGE - 1
	 */
	private String commentDate(int i) {
		int seq = (Integer.parseInt(commentCurrentPage.getText()) - 1) * MAX_COMMENT_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		Date tempDate;
		try {
			tempDate = commentList.get(seq).date;
			return LiveDatePicker.dateToCoarseString(tempDate);
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String commentMaker(int i) {
		int seq = (Integer.parseInt(commentCurrentPage.getText()) - 1) * MAX_COMMENT_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return commentList.get(seq).userName;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private String commentContent(int i) {
		int seq = (Integer.parseInt(commentCurrentPage.getText()) - 1) * MAX_COMMENT_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return commentList.get(seq).comment;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private double commentRank(int i) {
		int seq = (Integer.parseInt(orderCurrentPage.getText()) - 1) * MAX_ORDER_ONE_OAGE + i;
		try {
			return commentList.get(seq).rank;
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	/**************************************************************************************/
	
	/**
	 * 下面的方法用于promotion
	 */
	private void setPromotionContent() {
		for (int i = 0; i < MAX_PROMOTION_ONE_OAGE; i++) {
			if (promotion(i) != null) {
				promotionLabelList.get(i).setVisible(true);
				promotionLabelList.get(i).setText(promotion(i));
			} else {
				promotionLabelList.get(i).setVisible(false);
				promotionLabelList.get(i).setText(null);
			}
		}
	}
	
	private int calPromotionMaxPage(ArrayList<PromotionVO> voList) {
		return (voList.size() / MAX_PROMOTION_ONE_OAGE) + 1;
	}
	
	private String promotion(int i) {
		int seq = (Integer.parseInt(promotionCurrentPage.getText()) - 1) * MAX_PROMOTION_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return promotionVOList.get(seq).name;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	/**************************************************************************************/
}
