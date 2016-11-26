package org.client.presentation.hotelmanager;

import java.io.IOException;
/**
 * FXML Controller
 * 酒店工作人员-修改酒店促销策略
 *
 */
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.text.Font;
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
	
	private DateFormat dateFormat;
	
	private PromotionVO vo;

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
        
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		ObservableList<Integer> levelList = FXCollections.observableArrayList((new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}))));
		levelBox.setItems(levelList);
		
		ObservableList<String> typeList = FXCollections.observableArrayList((new ArrayList<String>(Arrays.asList(new String[]{"生日促销","企业促销","三间以上促销","特定日期促销"}))));
		typeBox.setItems(typeList);

	}
	
	void setPromotionVO(PromotionVO vo) {
		this.vo = vo;
		nameLabel.setText(vo.name);
		nameLabel.setFont(Font.font("Microsoft YaHei", 15));
		nameLabel.setStyle("-fx-text-fill: white;-fx-background-color: rgba(255,255,255,0.1)");
		
		discountLabel.setText(String.valueOf(vo.discount));
		discountLabel.setFont(Font.font("Microsoft YaHei", 15));
		discountLabel.setStyle("-fx-text-fill: white;-fx-background-color: rgba(255,255,255,0.1)");
		
		startTimeLabel.setText(dateFormat.format(vo.startTime));
		startTimeLabel.setFont(Font.font("Microsoft YaHei", 15));
		startTimeLabel.setStyle("-fx-text-fill: white;-fx-background-color: rgba(255,255,255,0.1)");
		
		endTimeLabel.setText(dateFormat.format(vo.endTime));
		endTimeLabel.setFont(Font.font("Microsoft YaHei", 15));
		endTimeLabel.setStyle("-fx-text-fill: white;-fx-background-color: rgba(255,255,255,0.1)");
		
		levelBox.setValue(vo.level);
		levelBox.setStyle("-fx-text-fill: white");

		typeBox.setValue(vo.type);
		typeBox.setStyle("-fx-text-fill: white");
	}
}

