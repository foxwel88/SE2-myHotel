package org.client.presentation.hotelmanager;

import java.io.IOException;
/**
 * FXML Controller
 * 酒店工作人员-修改酒店促销策略
 *
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HotelManagerModifyPromotion {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private Button saveButton;

	@FXML
    private TextField nameLabel;

	@FXML
    private TextField discountLabel;

	@FXML
    private TextField startTimeLabel;

	@FXML
    private TextField endTimeLabel;

	@FXML
    private ChoiceBox<Integer> levelBox;

	@FXML
    private ChoiceBox<String> typeBox;

	@FXML
    void save(ActionEvent event) {

	}

	@FXML
    void initialize() {
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert discountLabel != null : "fx:id=\"discountLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert levelBox != null : "fx:id=\"levelBox\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
        assert typeBox != null : "fx:id=\"typeBox\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";

	}
}

