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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-浏览酒店历史订单
 *
 */
public class HotelManagerHistoryOrder {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	// the gridPane in Guide
	private GridPane parentPane;

	@FXML
    void initialize() {
		
	}
	
	void setParentGridPane(GridPane parent) {
		parentPane = parent;
	}
	
}
