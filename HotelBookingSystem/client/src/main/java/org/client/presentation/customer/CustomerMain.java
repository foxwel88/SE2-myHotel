package org.client.presentation.customer;

import java.time.LocalDate;
import java.util.ArrayList;

import org.client.bl.promotionbl.PromotionController;
import org.client.presentation.util.DateUtil;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.PromotionVO;
import org.common.utility.HotelFilter;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class CustomerMain {
	@FXML
	AnchorPane root;

	@FXML
	AnchorPane promotionPane;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	@FXML
	Label promotion1;
	
	@FXML
	Label promotion2;
	
	@FXML
	Label promotion3;
	
	@FXML
	Label promotion4;
	
	@FXML
	Label hidePromotionButton;

	@FXML
	ChoiceBox<String> city;

	@FXML
	ChoiceBox<String> area;
	
	@FXML
	DatePicker startDate;

	@FXML
	DatePicker endDate;

	// 该字段表示同时显示的最大促销策略的数量
	private static final int MAX_PROMOTION_ONE_PAGE = 4;
	
	private ArrayList<Label> promotionLabelList;
	
	private ArrayList<PromotionVO> promotionVOList;

	@FXML
	void initialize() {
		setCity();
		city.setValue("南京");
		setArea();
		area.setValue("新街口");
		city.getSelectionModel().selectedItemProperty().addListener( (ObservableValue< ? extends String> observable, String oldValue, String newValue) -> {
			refreshAreas();
		});
		setStartDate();
		setEndDate();
				
		SwitchSceneUtil.showGuideAnimation(root, -200);
		
		promotionLabelList = new ArrayList<>();
		promotionLabelList.add(promotion1);
		promotionLabelList.add(promotion2);
		promotionLabelList.add(promotion3);
		promotionLabelList.add(promotion4);
		promotionVOList = (ArrayList<PromotionVO>)PromotionController.getInstance().showWebsitePromotion();
	}
	
	@FXML
	void search_causedByMouse() {
		search();
	}
	
	@FXML
	void search_causedByKeyboard(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.ENTER) {
			search();
		}
	}
	
	@FXML
	void search_fromPicture() {
		city.setValue("南京");
		refreshAreas();
		area.setValue("湖南路");
		search();
	}
	
	@FXML
	void refreshAreas() {
		setArea();
		area.setValue(area.getItems().get(0));
	}
	
	/**
	 * 保证todate一定实时保持在fromdate之后
	 */
	@FXML
	void refreshDatePicker() {
		if (!endDate.getValue().isAfter(startDate.getValue())) {
			endDate.setValue(startDate.getValue().plusDays(1));
		}
	}
	
	@FXML
	void showWebPromotion() {
		promotionPane.setVisible(true);
		setContent();
	}
	
	@FXML
	void hidePromotion() {
		promotionPane.setVisible(false);
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(currentPage.getText()) < calMaxPage(promotionVOList)) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
			showWebPromotion();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(currentPage.getText()) > 1) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
			showWebPromotion();
		}
	}
	
	// 跳转到酒店列表
	private void search() {
		HotelFilter hotelFilter = new HotelFilter();
		hotelFilter.setLocation(city.getValue(), area.getValue());
		hotelFilter.setSchFromDate(DateUtil.toDate(startDate.getValue()));
		hotelFilter.setSchToDate(DateUtil.toDate(endDate.getValue()));
		SwitchSceneUtil.previousHotelSceneInfo = new PreviousHotelSceneInfo(hotelFilter, false, 1);
		SwitchSceneUtil.isBack = true;
		SwitchSceneUtil.customerController.turnToCusController_HotelList();
	}
	
	private void setContent() {
		for (int i = 0; i < MAX_PROMOTION_ONE_PAGE; i++) {
			if (promotion(i) != null) {
				promotionLabelList.get(i).setVisible(true);
				promotionLabelList.get(i).setText(promotion(i));
			} else {
				promotionLabelList.get(i).setVisible(false);
				promotionLabelList.get(i).setText(null);
			}
		}
	}
	
	private void setCity() {
		ArrayList<String> cityNameList = new ArrayList<>();
		ArrayList<CityVO> cityVOList = SwitchSceneUtil.getCities();
		for (CityVO vo : cityVOList) {
			cityNameList.add(vo.cityName);
		}
		city.setItems(FXCollections.observableArrayList(cityNameList));
	}

	private void setArea() {
		ArrayList<String> areaNameList = new ArrayList<>();
		try {
			ArrayList<AreaVO> areaVOList = SwitchSceneUtil.getAreas(city.getValue());
			for (AreaVO vo : areaVOList) {
				areaNameList.add(vo.address);
			}
			area.setItems(FXCollections.observableArrayList(areaNameList));
		} catch (NullPointerException nullPointerException) {
			area.setItems(null);
		}
	}
	
	private void setStartDate() {
		DatePicker banBeforeTodayPicker = new DatePicker();
		banBeforeTodayPicker.setValue(LocalDate.now().minusDays(1));
		DateUtil.initDatePicker(banBeforeTodayPicker, startDate);
	}
	
	private void setEndDate() {
		DateUtil.initDatePicker(startDate, endDate);
	}
	
	private int calMaxPage(ArrayList<PromotionVO> voList) {
		return (voList.size() / MAX_PROMOTION_ONE_PAGE) + 1;
	}
	
	private String promotion(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_PROMOTION_ONE_PAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			StringBuilder sb = new StringBuilder();
			PromotionVO vo = promotionVOList.get(seq);
			sb.append(vo.name);
			for (int j = 0; j < 40 - vo.name.length(); j++) {
				sb.append(" ");
			}
			sb.append(vo.type);
			for (int j = 0; j < 40 - vo.name.length(); j++) {
				sb.append(" ");
			}
			sb.append(vo.discount);
			sb.append("折");
			return sb.toString();
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
}
