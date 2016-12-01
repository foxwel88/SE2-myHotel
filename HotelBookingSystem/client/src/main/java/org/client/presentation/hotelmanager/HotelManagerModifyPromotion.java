package org.client.presentation.hotelmanager;

/**
 * FXML Controller
 * 酒店工作人员-修改酒店促销策略
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.util.Callback;

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
		//界面先自己检查
		if (!isFormatCorrect()) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT);
			return;
		} 
		
		//赋值
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
		
		ResultMessage result;
		if (modifyMode) {
			result = HotelManagerController.getInstance().modifyPromotion(vo);
		} else {
			result = HotelManagerController.getInstance().addPromotion(vo);
		}
		ResultInfoHelper.setResultLabel(resultLabel, result);
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
		
		ObservableList<Integer> levelList = FXCollections.observableArrayList((new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}))));
		levelBox.setItems(levelList);
		
		ObservableList<String> typeList = FXCollections.observableArrayList((new ArrayList<>(Arrays.asList(new String[]{"生日促销", "企业促销", "三间以上促销", "特定日期促销"}))));
		typeBox.setItems(typeList);

		//起始时间必须先于结束时间
		
		startTimePicker.setValue(LocalDate.now());
		Callback<DatePicker, DateCell> endDayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(startTimePicker.getValue()) || item.isEqual(startTimePicker.getValue())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		
		endTimePicker.setDayCellFactory(endDayCellFactory);
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
	
	boolean isFormatCorrect() {
		//time order
		if (startTimePicker.getValue().isAfter(endTimePicker.getValue()) || startTimePicker.getValue().isEqual(endTimePicker.getValue())) {
			return false;
		}
		
		//discount range
		try {
			if (Double.parseDouble(discountLabel.getText()) <= 0 || Double.parseDouble(discountLabel.getText()) >= 10) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
}

