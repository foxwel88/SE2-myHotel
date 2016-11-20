package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import org.client.rmi.RMIHelper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-主界面
 *
 */
public class HotelManagerMain {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private Label infoLabel;

	@FXML
    private Label executeLabel;

	@FXML
    private Label historyLabel;

	@FXML
    private Label promotionLabel;
	
	@FXML
    private Label timeLabel;

	@FXML
    void initialize() {
		assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		assert timeLabel != null : "fx:id=\"timeLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		try {
			timeLabel.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		Label source = (Label)event.getSource();

		if (source == infoLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/维护酒店信息界面.fxml"));
		} else if (source == executeLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/执行订单界面.fxml"));
		} else if (source == historyLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/浏览酒店历史订单界面.fxml"));
		} else if (source == promotionLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/管理酒店促销策略界面.fxml"));
		}
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)infoLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}



