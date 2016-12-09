package org.client.presentation.customer;

import org.client.bl.orderbl.OrderController;
import org.client.launcher.Resources;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-未执行订单详细信息
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */
public class CustomerUnexcutedOrder {
	@FXML
	AnchorPane root;
	
	@FXML
	Label orderID;
	
	@FXML
	Label hotelAddress;
	
	@FXML
	Label roomType;
	
	@FXML
	Label roomNum;
	
	@FXML
	Label appointedArrivalTime;
	
	@FXML
	Label appointedLivingTime;
	
	@FXML
	Label resident;
	
	@FXML
	Label totalPrice;
	
	@FXML
	Label generatedTime;
	
	@FXML
	Button cancelButton;
	
	private OrderVO vo;
	
	private OrderController orderController;
	
	private Resources resources;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		vo = SwitchSceneUtil.getCurrentOrder();
		orderID.setText(vo.orderID);
		hotelAddress.setText(vo.hotelAddress);
		roomType.setText(vo.roomType);
		roomNum.setText(String.valueOf(vo.roomNum));
		appointedArrivalTime.setText(LiveDatePicker.dateToCoarseString(vo.schFrom));
		appointedLivingTime.setText(LiveDatePicker.dateToCoarseString(vo.schFrom) + " - " + LiveDatePicker.dateToCoarseString(vo.schTo));
		resident.setText(vo.customerName);
		totalPrice.setText(String.valueOf(vo.totalPrice));
		generatedTime.setText(LiveDatePicker.dateToCoarseString(vo.generatedDate));
	}
	
	@FXML
	void cancelOrder() {
		ResultMessage resultMessage = cancel();
		if (ResultMessage.SUCCESS == resultMessage) {
			SwitchSceneUtil.turnToAnotherScene((GridPane)(root.getParent()), resources.customerCheckUnexecutedOrderList);
		} else {
			// TODO
		}
	}
	
	private ResultMessage cancel() {
		orderController = OrderController.getInstance();
		return orderController.cancelOrder(vo.orderID);
	}
}
