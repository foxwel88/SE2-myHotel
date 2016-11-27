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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
	private DatePicker startTimePicker;

	@FXML
	private DatePicker endTimePicker;

	@FXML
    private ChoiceBox<Integer> levelBox;

	@FXML
    private ChoiceBox<String> typeBox;
	
	@FXML
	private Label resultLabel;
	
	private PromotionVO vo;
	
	private boolean modifyMode;

	@FXML
    void save(ActionEvent event) {
		if (!modifyMode) {
			vo = new PromotionVO();
		}
		vo.discount = Double.parseDouble(discountLabel.getText());
		vo.name = nameLabel.getText();
		
		//startTime, at the start of the day
		LocalDate startDate = startTimePicker.getValue();
		
		ZonedDateTime startZonedTime = startDate.atStartOfDay(ZoneId.systemDefault());
		Instant startInstant = Instant.from(startZonedTime);
		vo.startTime = Date.from(startInstant);
		
		//endTime, at the start of the day
		LocalDate endDate = endTimePicker.getValue();
		
		ZonedDateTime endZonedTime = endDate.atStartOfDay(ZoneId.systemDefault());
		Instant endInstant = Instant.from(endZonedTime);
		vo.endTime = Date.from(endInstant);
				
		vo.level = levelBox.getValue();
		vo.type = typeBox.getValue();
		
		ResultMessage result = null;
		if (modifyMode) {
			result = HotelManagerController.getInstance().modifyPromotion(vo);
		} else {
			result = HotelManagerController.getInstance().addPromotion(vo);
		}
		switch(result) {
			case SUCCESS:
				resultLabel.setText("编辑成功");
				break;
			case WRONG_FORMAT:
				resultLabel.setText("输入信息格式有误");
				break;
			default:
				resultLabel.setText("错误");
				break;
		}
	}

	@FXML
	void initialize() {
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert discountLabel != null : "fx:id=\"discountLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert startTimePicker != null : "fx:id=\"startTimePicker\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert endTimePicker != null : "fx:id=\"endTimePicker\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert levelBox != null : "fx:id=\"levelBox\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert typeBox != null : "fx:id=\"typeBox\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		
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
		
		levelBox.setValue(vo.level);
		levelBox.setStyle("-fx-text-fill: white");

		typeBox.setValue(vo.type);
		typeBox.setStyle("-fx-text-fill: white");
		
		modifyMode = true;
	}
}

