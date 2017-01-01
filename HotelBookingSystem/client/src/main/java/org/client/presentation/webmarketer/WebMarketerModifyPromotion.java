package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.client.launcher.Resources;
import org.client.presentation.util.DateUtil;
import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

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
	private AnchorPane modifyPromotion;

	@FXML
	private TextField nameLabel;

	@FXML
	private ComboBox<String> typeBox;

	@FXML
	private DatePicker startTimePicker;

	@FXML
	private DatePicker endTimePicker;

	@FXML
	private ComboBox<Integer> levelBox;

	@FXML
	private ComboBox<String> cityBox;

	@FXML
	private ComboBox<String> areaBox;

	@FXML
	private TextField discountLabel;

	@FXML
	private Button confirmButton;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private Button deleteButton;
	
	@FXML
	private Label delResultLabel;
	
	private PromotionVO vo;
	
	private WebMarketerController controller;
	
	private List<CityVO> cityvos;
	
	private List<String> citys;
	
	/**
	 * true表示修改；false表示增加
	 */
	private boolean isModify;
	
	/**
	 * 导航界面的GridPane
	 */
	private GridPane parentPane;
	
	@FXML
	void changeEditable(ActionEvent event) {
		setVisible();
	}
	
	@FXML
	void setAreaBox(ActionEvent event) {
		String city = cityBox.getValue();
		int index = citys.indexOf(city);
		List<AreaVO> areavos = controller.getAreas(cityvos.get(index));
		List<String> areas = new ArrayList<>();
		for (AreaVO vo : areavos) {
			areas.add(vo.address);
		}
		ObservableList<String> areaList = FXCollections.observableArrayList(areas);
		areaBox.setItems(areaList);
		
	}

	@FXML
	void handleDelete(MouseEvent event) {
		ResultMessage info = controller.deletePromotion(vo.promotionID);
		ResultInfoHelper.setResultLabel(delResultLabel, info, 2000);
		if (info == ResultMessage.SUCCESS) {
			Parent root = null;
			Resources resources = Resources.getInstance();
			try {
				root = resources.load(resources.webMarketerCheckPromotion);
			} catch (IOException e) {
				e.printStackTrace();
			}
			parentPane.getChildren().set(1, root);
			GridPane.setConstraints(root, 1, 0);
			((WebMarketerCheckPromotion)resources.getCurrentController()).setParentGridPane(parentPane);
		}
	}
	
	@FXML 
    void handleConfirm(MouseEvent event) {
		if (typeBox.getValue() == null) {
			return;
		}
		if (!isModify) {
			vo = new PromotionVO();
			vo.provider = "web";
		}
		if (!isFormatCorrect()) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT, 2000);
			return;
		}
		//赋值
		vo.type = typeBox.getValue();
		vo.discount = Double.parseDouble(discountLabel.getText());
		vo.name = nameLabel.getText();
		if (!areaBox.isDisable()) {
			vo.area = areaBox.getValue();
		}
		if (!startTimePicker.isDisable()) {
			//startTime, at the start of the day
			vo.startTime = DateUtil.toDate(startTimePicker.getValue());
			
			//endTime, at the start of the day
			vo.endTime = DateUtil.toDate(endTimePicker.getValue());
		}
		if (!levelBox.isDisable()) {
			vo.level = levelBox.getValue();
		}
		ResultMessage result;
		if (isModify) {
			result = WebMarketerController.getInstance().modifyPromotion(vo);
		} else {
			result = WebMarketerController.getInstance().addPromotion(vo);
		}
		ResultInfoHelper.setResultLabel(resultLabel, result, 2000);
		
		// 如果是增加促销策略界面且增加成功，则返回上一个界面
		if ((!isModify) && (result == ResultMessage.SUCCESS)) {
			Parent root = null;
			Resources resources = Resources.getInstance();
			try {
				root = resources.load(resources.webMarketerCheckPromotion);
			} catch (IOException e) {
				e.printStackTrace();
			}
			parentPane.getChildren().set(1, root);
			GridPane.setConstraints(root, 1, 0);
			((WebMarketerCheckPromotion)resources.getCurrentController()).setParentGridPane(parentPane);
		}
	}

	@FXML
	void initialize() {
        assert modifyPromotion != null : "fx:id=\"modifyPromotion\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert typeBox != null : "fx:id=\"typeBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert startTimePicker != null : "fx:id=\"startTimePicker\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert endTimePicker != null : "fx:id=\"endTimePicker\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert levelBox != null : "fx:id=\"levelBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert cityBox != null : "fx:id=\"cityBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert areaBox != null : "fx:id=\"areaBox\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert discountLabel != null : "fx:id=\"discountLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        assert delResultLabel != null : "fx:id=\"delRedultLabel\" was not injected: check your FXML file '修改促销策略界面.fxml'.";
        
        // 初始化controller
		controller = WebMarketerController.getInstance();

		// 初始化levelBox
		int levelNum = controller.getCurrentLevel().size();
		ArrayList<Integer> levelNums = new ArrayList<>();
		for (int i = 0; i < levelNum; i++) {
			levelNums.add(i + 1);
		}
		ObservableList<Integer> levelList = FXCollections.observableArrayList(levelNums);
		levelBox.setItems(levelList);

		// 初始化typeBox
		ObservableList<String> typeList = FXCollections.observableArrayList(
				(new ArrayList<>(Arrays.asList(new String[]{"特定日期促销", "VIP促销", "商圈促销"}))));
		typeBox.setItems(typeList);
		
		// 初始化cityBox
		cityvos = controller.getCitys();
		citys = new ArrayList<>();
		for (CityVO vo : cityvos) {
			citys.add(vo.cityName);
		}
		ObservableList<String> cityList = FXCollections.observableArrayList(citys);
		cityBox.setItems(cityList);
		
		// 起始时间必须先于结束时间
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
		
		// 未选择促销类型则无法选择其他选项
		setVisible();
	}
	
	/**
	 * 获得导航界面GridPane的引用以完成到编辑界面的跳转
	 * @param pane
	 */
	void setParentGridPane(GridPane pane) {
		parentPane = pane;
	}
	
	void setPromotionVO(PromotionVO vo) {
		this.vo = vo;
		
		// show info
		// firstly show type,name and discount
		typeBox.setValue(vo.type);
		nameLabel.setText(vo.name);
		nameLabel.setFont(Font.font("Microsoft YaHei", 15));
		discountLabel.setText(String.valueOf(vo.discount));
		discountLabel.setFont(Font.font("Microsoft YaHei", 15));
		// define which part is disable
		setVisible();
		// then show other parts 
		// startTimePicker.setValue(LocalDate.from(Instant.ofEpochMilli(vo.startTime.getTime())));
		// endTimePicker.setValue(LocalDate.from(Instant.ofEpochMilli(vo.endTime.getTime())));
		startTimePicker.setValue(Instant.ofEpochMilli(vo.startTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		endTimePicker.setValue(Instant.ofEpochMilli(vo.endTime.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

		if (!levelBox.isDisable()) {
			levelBox.setValue(vo.level);
		}
		if (!cityBox.isDisable()) {
			cityBox.setValue(vo.city);
			areaBox.setValue(vo.area);
		}
		
		typeBox.setValue(vo.type);
		
		// set isModify
		isModify = true;
		
		// show editable
		setVisible();
	}
	
	/**
	 * 根据促销类型设置各个组件是否可编辑
	 */
	private void setVisible() {
		String type = typeBox.getValue();
		if (isModify) {
			deleteButton.setVisible(true);
		} else {
			deleteButton.setVisible(false);
		}
		if (type == null) {
			levelBox.setDisable(true);
			cityBox.setDisable(true);
			areaBox.setDisable(true);
		} else if (type.equals("特定日期促销")) {
			levelBox.setDisable(true);
			cityBox.setDisable(true);
			areaBox.setDisable(true);
		} else if (type.equals("VIP促销")) {
			levelBox.setDisable(false);
			cityBox.setDisable(true);
			areaBox.setDisable(true);
		} else if (type.equals("商圈促销")) {
			levelBox.setDisable(false);
			cityBox.setDisable(false);
			areaBox.setDisable(false);
		}

	}
	
	/**
	 * check format
	 * @return
	 */
	boolean isFormatCorrect() {
		//time order
		if (startTimePicker.getValue() == null || endTimePicker.getValue() == null) {
			return false;
		}
		
		if (startTimePicker.getValue().isAfter(endTimePicker.getValue())
				|| startTimePicker.getValue().isEqual(endTimePicker.getValue())) {
			return false;
		}
		
		
		//select level
		if (!levelBox.isDisable()) {
			if (levelBox.getValue() == null) {
				return false;
			}
		}
		
		//select area
		if (!areaBox.isDisable()) {
			if (areaBox.getValue() == null || areaBox.getValue().equals("")) {
				return false;
			}
		}
		
		//discount range
		try {
			if (Double.parseDouble(discountLabel.getText()) <= 0 || Double.parseDouble(discountLabel.getText()) >= 10) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
		//has a name
		return !(nameLabel.getText() == null || nameLabel.getText().equals(""));
	}
}
