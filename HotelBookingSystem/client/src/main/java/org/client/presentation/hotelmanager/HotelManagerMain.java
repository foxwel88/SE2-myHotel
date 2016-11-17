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
    void initialize() {
        assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
        assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
        assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
        assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";

	}
	
	@FXML
    void handleInfoLabel(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/酒店工作人员/维护酒店信息界面.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)infoLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}



