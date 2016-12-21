package org.client.presentation.hotelmanager;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller
 * 酒店工作人员-异常订单详细界面
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerAbnormalOrder {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Label orderIDLabel;

	@FXML
    private Label roomTypeLabel;

	@FXML
    private Label roomNumLabel;

	@FXML
    private Label numOfPeopleLabel;

	@FXML
    private Label childrenLabel;

	@FXML
    private Label orderTypeLabel;
	
	@FXML
    private Button executeButton;
	
	@FXML
    private Label resultLabel;
	
	@FXML
    private Label customerNameLabel;

	@FXML
    private Label startTimeLabel; // sch from

	@FXML
    private Label endTimeLabel;  // sch to
	
	@FXML
	private Label latestTimeLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	void execute(ActionEvent event) {
		ResultMessage result = HotelManagerController.getInstance().executeOrder();
		switch(result) {
			case SUCCESS:
				ResultInfoHelper.setResultLabel(resultLabel, "执行完成", 2000);
				break;
			default:
				ResultInfoHelper.setResultLabel(resultLabel, "执行遇到错误", 2000);
				break;
		}
	}

	@FXML
	void initialize() {
        assert orderIDLabel != null : "fx:id=\"orderIDLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
        assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
        assert roomNumLabel != null : "fx:id=\"roomNumLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
        assert numOfPeopleLabel != null : "fx:id=\"numOfPeopleLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
        assert childrenLabel != null : "fx:id=\"childrenLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
        assert orderTypeLabel != null : "fx:id=\"orderTypeLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert executeButton != null : "fx:id=\"executeButton\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '异常订单详细信息界面.fxml'.";
		
		OrderVO vo = HotelManagerController.getInstance().currentOrder;
		
		orderIDLabel.setText(vo.orderID);
		roomTypeLabel.setText(vo.roomType);
		roomNumLabel.setText(String.valueOf(vo.roomNum));
		numOfPeopleLabel.setText(String.valueOf(vo.numOfPeople));
		if (vo.existsChild) {
			childrenLabel.setText("有");
		} else {
			childrenLabel.setText("无");
		}
		orderTypeLabel.setText(vo.type);
		
		customerNameLabel.setText(vo.customerName);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		startTimeLabel.setText(dateFormat.format(vo.schFrom));
		endTimeLabel.setText(dateFormat.format(vo.schTo));
		latestTimeLabel.setText(datetimeFormat.format(vo.latestTime));
		phoneLabel.setText(vo.phoneNumber);
	}
}

