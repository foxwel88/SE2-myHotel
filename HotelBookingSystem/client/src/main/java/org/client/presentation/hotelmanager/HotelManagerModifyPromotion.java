package org.client.presentation.hotelmanager;

/**
 * FXML Controller
 * 酒店工作人员-修改酒店促销策略
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import org.client.presentation.util.DateUtil;
import org.client.presentation.util.ResultInfoHelper;
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
    private ChoiceBox<String> typeBox;
	
	@FXML
	private Label resultLabel;
	
	private PromotionVO vo;
	
	private boolean modifyMode;

	@FXML
    void save(ActionEvent event) {
		if (!modifyMode) {
			vo = new PromotionVO();
			vo.provider = "hotel";
		}
		vo.hotelID = HotelManagerController.getInstance().hotelID;
		vo.hotelName = HotelManagerController.getInstance().hotelName;
		//界面先自己检查
		if (!isFormatCorrect()) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT, 2000);
			return;
		} 
		
		//赋值
		vo.discount = Double.parseDouble(discountLabel.getText());
		vo.name = nameLabel.getText();

		//startTime, at the start of the day
		vo.startTime = DateUtil.toDate(startTimePicker.getValue());

		//endTime, at the start of the day
		vo.endTime = DateUtil.toDate(endTimePicker.getValue());

		vo.type = typeBox.getValue();
		
		ResultMessage result;
		if (modifyMode) {
			result = HotelManagerController.getInstance().modifyPromotion(vo);
		} else {
			result = HotelManagerController.getInstance().addPromotion(vo);
		}
		ResultInfoHelper.setResultLabel(resultLabel, result, 2000);
	}

	@FXML
	void initialize() {
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert discountLabel != null : "fx:id=\"discountLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert startTimePicker != null : "fx:id=\"startTimePicker\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert endTimePicker != null : "fx:id=\"endTimePicker\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert typeBox != null : "fx:id=\"typeBox\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '修改酒店促销策略界面.fxml'.";
		
		ObservableList<String> typeList = FXCollections.observableArrayList((new ArrayList<>(Arrays.asList(new String[]{"生日促销", "企业促销", "三间以上促销", "特定日期促销"}))));
		typeBox.setItems(typeList);

		//起始时间必须先于结束时间，起始时间不能早于当前时间
		
		startTimePicker.setValue(LocalDate.now());
		Callback<DatePicker, DateCell> startDayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(LocalDate.now())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		startTimePicker.setDayCellFactory(startDayCellFactory);

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
		endTimePicker.setValue(LocalDate.now().plusDays(1));
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
		
		typeBox.setValue(vo.type);
		
		modifyMode = true;

		if (vo.startTime != null) {
			startTimePicker.setValue(LocalDate.of(vo.startTime.getYear() + 1900, vo.startTime.getMonth() + 1, vo.startTime.getDate()));
		}

		if (vo.endTime != null) {
			endTimePicker.setValue(LocalDate.of(vo.endTime.getYear() + 1900, vo.endTime.getMonth() + 1, vo.endTime.getDate()));
		}
	}
	
	boolean isFormatCorrect() {
		//time order
		if (startTimePicker.getValue().isBefore(LocalDate.now()) || startTimePicker.getValue().isAfter(endTimePicker.getValue()) || startTimePicker.getValue().isEqual(endTimePicker.getValue())) {
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

