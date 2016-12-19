package org.client.presentation.customer;

import org.client.vo.CommentVO;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerCheckComment {
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
	Label rank;
	
	@FXML
	Label comment;
	
	@FXML
	void initialize() {
		OrderVO vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		String hotel = vo.hotelName + "，" + vo.hotelAddress;
		hotelInfo.setText(hotel);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		totalPrice.setText(String.valueOf(vo.totalPrice) + "元");
		CommentVO commentVO = SwitchSceneUtil.getComment();
		rank.setText(commentVO.rank + "分");
		comment.setText("评论： " + commentVO.comment);
	}
}
