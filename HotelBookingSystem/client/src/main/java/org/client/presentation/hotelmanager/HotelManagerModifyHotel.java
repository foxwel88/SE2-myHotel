package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-维护酒店信息
 *
 */
public class HotelManagerModifyHotel {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private Label mainLabel;

	@FXML
    private Label executeLabel;

	@FXML
    private Label historyLabel;

	@FXML
    private Label promotionLabel;

	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		Label source = (Label)event.getSource();

		if (source == executeLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/执行订单界面.fxml"));
		} else if (source == historyLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/浏览酒店历史订单界面.fxml"));
		} else if (source == mainLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/酒店工作人员主界面.fxml"));
		} else if (source == promotionLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/管理酒店促销策略界面.fxml"));
		}
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)executeLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
    void initialize() {
        assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
        assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
        assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
        assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";

	}
}


