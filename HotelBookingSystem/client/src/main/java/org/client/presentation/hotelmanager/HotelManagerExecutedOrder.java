package org.client.presentation.hotelmanager;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.client.vo.OrderVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * FXML Controller
 * 酒店工作人员-已执行订单详细界面
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerExecutedOrder {
	private static final int CHECK_OUT_ROW = 2;
	
	private static final int CHECK_OUT_COLUMN = 3;
	
	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private GridPane gridPane;
	
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
    private Label priceLabel;

	@FXML
    private Label actFromLabel;

	@FXML
    private Label customerNameLabel;

	@FXML
    private Button updateButton;
	
	private Label actToLabel;
	
	@FXML
	void checkOut() {
		ResultMessage result = HotelManagerController.getInstance().checkOut();
		if (result == ResultMessage.SUCCESS) {
			gridPane.getChildren().remove(updateButton);
			
			DateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			actToLabel = new Label(timeFormat.format(HotelManagerController.getInstance().currentOrder.actTo));
			actToLabel.setFont(Font.font("Microsoft YaHei", 15));
			actToLabel.setStyle("-fx-text-fill: white");
			actToLabel.setAlignment(Pos.CENTER);
			actToLabel.setPrefWidth(287.0);
			gridPane.getChildren().add(actToLabel);
			GridPane.setConstraints(actToLabel, CHECK_OUT_COLUMN, CHECK_OUT_ROW);
		}
	}

	@FXML
	void initialize() {
		assert gridPane != null : "fx:id=\"gridPane\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert orderIDLabel != null : "fx:id=\"orderIDLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert roomNumLabel != null : "fx:id=\"roomNumLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert numOfPeopleLabel != null : "fx:id=\"numOfPeopleLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert childrenLabel != null : "fx:id=\"childrenLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert orderTypeLabel != null : "fx:id=\"orderTypeLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert priceLabel != null : "fx:id=\"priceLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert actFromLabel != null : "fx:id=\"actFromLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert customerNameLabel != null : "fx:id=\"customerNameLabel\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		assert updateButton != null : "fx:id=\"updateButton\" was not injected: check your FXML file '已执行订单详细信息界面.fxml'.";
		
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
		priceLabel.setText(String.valueOf(vo.totalPrice));
		customerNameLabel.setText(vo.customerName);
		
		//在没有退房信息（尚未退房）时，显示更新退房信息按钮（controller已内嵌），
		//否则显示退房时间
		if (vo.actTo != null) {
			gridPane.getChildren().remove(updateButton);
			
			DateFormat timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			actToLabel = new Label(timeFormat.format(vo.actTo));
			actToLabel.setFont(Font.font("Microsoft YaHei", 15));
			actToLabel.setStyle("-fx-text-fill: white");
			actToLabel.setAlignment(Pos.CENTER);
			actToLabel.setPrefWidth(287.0);
			gridPane.getChildren().add(actToLabel);
			GridPane.setConstraints(actToLabel, CHECK_OUT_COLUMN, CHECK_OUT_ROW);
		}
	}
}

