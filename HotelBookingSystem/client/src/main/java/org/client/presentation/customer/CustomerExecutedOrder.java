package org.client.presentation.customer;

import org.client.launcher.Resources;
import org.client.presentation.util.DateUtil;
import org.client.vo.OrderVO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-已执行订单详细信息
 * @author fraliphsoft
 * @version Foxwel 12/13
 */
public class CustomerExecutedOrder {
	@FXML
	private AnchorPane root;

	@FXML
	private Label orderIDLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Label hotelAddressLabel;

	@FXML
	private Label roomTypeLabel;

	@FXML
	private Label roomNumLabel;

	@FXML
	private Label numOfPeopleLabel;

	@FXML
	private Label childrenLabel;

	@FXML
	private Label customerNameLabel;

	@FXML
 	private Label phoneLabel;

	@FXML
	private Label actFromLabel;

	@FXML
	private Button commentButton;

	@FXML
	private Label resultLabel;

	@FXML
	private Label actToLabel;

	@FXML
	private Label priceLabel;
	
	@FXML
	private Label generatedTimeLabel;
	
	private OrderVO vo;
	
	private Resources resources;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		vo = CustomerController.getCurrentOrder();
		resources = Resources.getInstance();
		vo = CustomerController.getCurrentOrder();
		orderIDLabel.setText(vo.orderID);
		hotelAddressLabel.setText(vo.hotelAddress);
		hotelNameLabel.setText(vo.hotelName);
		roomTypeLabel.setText(vo.roomType);
		roomNumLabel.setText(String.valueOf(vo.roomNum));
		numOfPeopleLabel.setText(String.valueOf(vo.numOfPeople));
		if (vo.existsChild) {
			childrenLabel.setText("有");
		} else {
			childrenLabel.setText("无");
		}
		customerNameLabel.setText(vo.customerName);
		phoneLabel.setText(vo.phoneNumber);
		actFromLabel.setText(DateUtil.dateToDetailedString(vo.actFrom));
		actToLabel.setText(DateUtil.dateToDetailedString(vo.actTo));
		generatedTimeLabel.setText(DateUtil.dateToDetailedString(vo.generatedDate));
		priceLabel.setText(String.valueOf(vo.totalPrice));
		if (vo.isCommented) {
			commentButton.setText("查看评价");
		}
		
		CustomerController.showNewSceneAnimation(root);
	}
	
	@FXML
	void commentOrder(MouseEvent event) {
		makeComment();
	}
	
	@FXML
	void makeComment() {
		if (CustomerController.getCurrentOrder().isCommented) {
			CustomerController.currentScene = CustomerBackableScene.MAKE_COMMENT_SCENE;
			CustomerController.turnToAnotherScene((GridPane)(root.getParent()), resources.customerCheckComment);
		} else {
			CustomerController.currentScene = CustomerBackableScene.MAKE_COMMENT_SCENE;
			CustomerController.turnToAnotherScene((GridPane)(root.getParent()), resources.customerMakeComments);
		}
	}
}
