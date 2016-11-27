package org.client.presentation.webmarketer;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 * FXML COntroller
 * 网站管理人员-修改促销策略界面
 * @author gyue
 * @version 2016/11/27 gyue
 */
public class WebMarketerModifyPromotion {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField nameLabel;

	@FXML
    private ComboBox<String> typeBox;

	@FXML
    private TextField fromDateLabel;

	@FXML
    private TextField toDateLabel;

	@FXML
    private ComboBox<Integer> levelBox;

	@FXML
    private TextField areaLabel;

	@FXML
    private TextField discountLabel;

	@FXML
    private Button confirmButton;
	
	private DateFormat dateFormat;
	
	private PromotionVO vo;
	
	private WebMarketerController controller;

	@FXML 
    void handleConfirm(MouseEvent event) {
		String name = nameLabel.getText();
		String type = typeBox.getValue();
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = dateFormat.parse(fromDateLabel.getText());
			toDate = dateFormat.parse(toDateLabel.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int level = levelBox.getValue();
		String area = areaLabel.getText();
		double discount = Double.parseDouble(discountLabel.getText());
		
		boolean isAdd = false;
		if (vo == null) {
			isAdd = true;
		}
		vo = new PromotionVO(type, fromDate, toDate, null, null, level, area, discount, name);
		
		if (isAdd) {
			ResultMessage info = controller.addPromotion(vo);
			if (info != ResultMessage.SUCCESS) { // check
				// TODO warning window
				return;
			}
		} else {
			ResultMessage info = controller.modifyPromotion(vo);
			if (info != ResultMessage.SUCCESS) { // check
				// TODO warning window
				return;
			}
		}
	}

	@FXML
	void initialize() {
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert typeBox != null : "fx:id=\"typeBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert fromDateLabel != null : "fx:id=\"fromDateLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert toDateLabel != null : "fx:id=\"toDateLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert levelBox != null : "fx:id=\"levelBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert areaLabel != null : "fx:id=\"areaLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert discountLabel != null : "fx:id=\"discountLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '修改促销策略界面.fxml'.";

		controller = WebMarketerController.getInstance();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ObservableList<Integer> levelList = FXCollections
				.observableArrayList((new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }))));
		levelBox.setItems(levelList);

		ObservableList<String> typeList = FXCollections.observableArrayList(
				(new ArrayList<String>(Arrays.asList(new String[] { "特定日期促销", "VIP促销", "商圈促销" }))));
		typeBox.setItems(typeList);

	}
	
	void setPromotionVO(PromotionVO vo) {
		this.vo = vo;
		
		nameLabel.setText(vo.name);
		nameLabel.setFont(Font.font("Microsoft YaHei", 15));
		
		discountLabel.setText(String.valueOf(vo.discount));
		discountLabel.setFont(Font.font("Microsoft YaHei", 15));
		
		fromDateLabel.setText(dateFormat.format(vo.startTime));
		fromDateLabel.setFont(Font.font("Microsoft YaHei", 15));
		
		toDateLabel.setText(dateFormat.format(vo.endTime));
		toDateLabel.setFont(Font.font("Microsoft YaHei", 15));
		
		levelBox.setValue(vo.level);
		areaLabel.setText(vo.area);
		typeBox.setValue(vo.type);
		
	}
}
