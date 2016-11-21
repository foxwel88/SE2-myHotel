package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-未执行订单
 *
 */
public class HotelManagerUnexecutedOrder {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Button executeButton;

	@FXML
    void initialize() {
		assert executeButton != null : "fx:id=\"executeButton\" was not injected: check your FXML file '未执行订单详细信息界面.fxml'.";
	}
	
	@FXML
    void execute(ActionEvent event) {
		
	}
}

