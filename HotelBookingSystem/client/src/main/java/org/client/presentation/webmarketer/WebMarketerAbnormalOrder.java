package org.client.presentation.webmarketer;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML COntroller
 * 网站工作人员-异常订单详细信息
 * @author gyue
 * @version 2016/11/27 gyue
 */
public class WebMarketerAbnormalOrder {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane orderDetail;

	@FXML
	private Button cancelButton;

	@FXML
	private Text orderIdLabel;

	@FXML
	private Text hotelAddressLabel;

	@FXML
	private Text typeLabel;

	@FXML
	private Text numLabel;

	@FXML
	private Text arriveTimeLabel;

	@FXML
	private Text liveTimeLabel;

	@FXML
	private Text creditNumLabel;

	@FXML
	private Text nameLabel;

	@FXML
	private Text bookTimeLabel;

	@FXML
	private CheckBox allRecBox;

	@FXML
	private CheckBox halfRecBox;
	
	@FXML
	private Label resultLabel;
	
	private OrderVO vo;
	
	private DateFormat dateFormat;
	
	private WebMarketerController controller;

	@FXML
	void handleCancel(MouseEvent event) {
		boolean isAll = allRecBox.isSelected();
		boolean isHalf = halfRecBox.isSelected();
		if (!(isAll ^ isHalf)) { // both selected or neither selected
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT, 2000);
			allRecBox.setSelected(false);
			halfRecBox.setSelected(false);
			return;
		}
		
		ResultMessage info = controller.cancelOrder(vo.orderID, isHalf == true);
		
		if (info != ResultMessage.SUCCESS) { // check
			ResultInfoHelper.setResultLabel(resultLabel, info, 2000);
			allRecBox.setSelected(false);
			halfRecBox.setSelected(false);
			return;
		}
		ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.SUCCESS, 2000);
	}

	@FXML
	void initialize() {
		assert orderDetail != null : "fx:id=\"orderDetail\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert orderIdLabel != null : "fx:id=\"orderIdLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert hotelAddressLabel != null : "fx:id=\"hotelAddressLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert typeLabel != null : "fx:id=\"typeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert numLabel != null : "fx:id=\"numLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert arriveTimeLabel != null : "fx:id=\"arriveTimeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert liveTimeLabel != null : "fx:id=\"liveTimeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert creditNumLabel != null : "fx:id=\"creditNumLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert bookTimeLabel != null : "fx:id=\"bookTimeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert allRecBox != null : "fx:id=\"allRecBox\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert halfRecBox != null : "fx:id=\"halfRecBox\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		
		controller = WebMarketerController.getInstance();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //设置日期格式
		
	}
	
	void setOrderVO(OrderVO vo) {
		this.vo = vo;
		
		// show info
		orderIdLabel.setText(vo.orderID);
		hotelAddressLabel.setText(vo.hotelAddress);
		typeLabel.setText(vo.roomType);
		numLabel.setText(String.valueOf(vo.roomNum));
		arriveTimeLabel.setText(dateFormat.format(vo.schFrom));
		long days = (vo.schTo.getTime() - vo.schFrom.getTime()) / (24 * 60 * 60 * 1000); //获得住宿时间
		liveTimeLabel.setText(String.valueOf(days) + " 天");
		creditNumLabel.setText(String.valueOf(vo.totalPrice));
		nameLabel.setText(vo.customerName);
		bookTimeLabel.setText(dateFormat.format(vo.generatedDate));

	}
}
