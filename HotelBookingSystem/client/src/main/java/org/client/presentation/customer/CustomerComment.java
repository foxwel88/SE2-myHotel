package org.client.presentation.customer;

import java.rmi.RemoteException;

import org.client.bl.commentbl.CommentController;
import org.client.bl.orderbl.OrderController;
import org.client.blservice.commentblservice.Commentblservice;
import org.client.launcher.Resources;
import org.client.rmi.RMIHelper;
import org.client.vo.CommentVO;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

/**
 * 
 * 客户-评价订单
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */

public class CustomerComment {
	@FXML
	AnchorPane root;
	
	@FXML
	TextArea comment;
	
	@FXML
	Button commitButton;
	
	@FXML
	Button rank1;
	
	@FXML
	Button rank2;
	
	@FXML
	Button rank3;
	
	@FXML
	Button rank4;
	
	@FXML
	Button rank5;
	
	@FXML
	Line chose1_1;
	
	@FXML
	Line chose1_2;
	
	@FXML
	Line chose2_1;
	
	@FXML
	Line chose2_2;
	
	@FXML
	Line chose3_1;
	
	@FXML
	Line chose3_2;
	
	@FXML
	Line chose4_1;
	
	@FXML
	Line chose4_2;
	
	@FXML
	Line chose5_1;
	
	@FXML
	Line chose5_2;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelInfo;
	
	@FXML
	Label roomType;
	
	@FXML
	Label roomNum;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label commentTip;
	
	@FXML
	Label scoreTip;
	
	private Resources resources;
	
	private Commentblservice commentController;
	
	private int selectedRank = -1;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		OrderVO vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		String hotel = vo.hotelName + "，" + vo.hotelAddress;
		hotelInfo.setText(hotel);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		totalPrice.setText(String.valueOf(vo.totalPrice) + "元");
	}
	
	@FXML
	void commitComment() {
		commentController = CommentController.getInstance();
		String commentContent = comment.getText();
		double rankValue = 5;
		if (selectedRank == -1) {
			scoreTip.setText("打分不能为空!");
		} else {
			rankValue = selectedRank;
			scoreTip.setText("");
			if (commentContent.length() >= 15) {
				commentTip.setText("");
				try {
					commentController.addComment(new CommentVO(SwitchSceneUtil.getUserVO().name, SwitchSceneUtil.getCurrentOrder().hotelID, SwitchSceneUtil.orderID, RMIHelper.getInstance().getTimeServiceImpl().getDate(), rankValue, commentContent));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				OrderController.getInstance().comment(orderID.getText());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("感谢您的评价！");
				alert.showAndWait();
				SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckExecutedOrder);
			} else {
				commentTip.setText("评论不能少于15字!");
			}
		}
	}
	
	@FXML
	void selectRank1() {
		hideSelection();
		chose1_1.setVisible(true);
		chose1_2.setVisible(true);
		selectedRank = 1;
	}
	
	@FXML
	void selectRank2() {
		hideSelection();
		chose2_1.setVisible(true);
		chose2_2.setVisible(true);
		selectedRank = 2;
	}
	
	@FXML
	void selectRank3() {
		hideSelection();
		chose3_1.setVisible(true);
		chose3_2.setVisible(true);
		selectedRank = 3;
	}
	
	@FXML
	void selectRank4() {
		hideSelection();
		chose4_1.setVisible(true);
		chose4_2.setVisible(true);
		selectedRank = 4;
	}
	
	@FXML
	void selectRank5() {
		hideSelection();
		chose5_1.setVisible(true);
		chose5_2.setVisible(true);
		selectedRank = 5;
	}
	
	/*
	 * 隐藏所有选中评分的勾
	 */
	private void hideSelection() {
		chose1_1.setVisible(false);
		chose1_2.setVisible(false);
		chose2_1.setVisible(false);
		chose2_2.setVisible(false);
		chose3_1.setVisible(false);
		chose3_2.setVisible(false);
		chose4_1.setVisible(false);
		chose4_2.setVisible(false);
		chose5_1.setVisible(false);
		chose5_2.setVisible(false);
	}
}
