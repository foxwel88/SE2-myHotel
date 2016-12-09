package org.client.presentation.customer;

import java.rmi.RemoteException;

import org.client.bl.commentbl.CommentController;
import org.client.launcher.Resources;
import org.client.rmi.RMIHelper;
import org.client.vo.CommentVO;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
	ChoiceBox<Double> score;
	
	@FXML
	TextArea comment;
	
	@FXML
	Button commitButton;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelAddress;
	
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
	
	private CommentController commentController;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		score.setContextMenu(new ContextMenu(new MenuItem("1"), new MenuItem("2"), new MenuItem("3"), new MenuItem("4"), new MenuItem("5")));
		OrderVO vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		hotelAddress.setText(vo.hotelAddress);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		totalPrice.setText(String.valueOf(vo.totalPrice));
	}
	
	@FXML
	void commitComment() {
		commentController = CommentController.getInstance();
		String commentContent = comment.getText();
		double rankValue = 5;
		try {
			rankValue = score.getValue();
			if (commentContent.length() >= 15) {
				try {
					commentController.addComment(new CommentVO(SwitchSceneUtil.getUserVO().name, SwitchSceneUtil.getHotelVO().hotelName, RMIHelper.getInstance().getTimeServiceImpl().getDate(), rankValue, commentContent));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckExecutedOrder);
			} else {
				commentTip.setText("评论不能少于15字!");
			}
		} catch (NullPointerException nullPointerException) {
			scoreTip.setText("打分不能为空!");
		}
	}
}
