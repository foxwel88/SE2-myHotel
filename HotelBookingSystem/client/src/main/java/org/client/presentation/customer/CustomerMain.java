package org.client.presentation.customer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import org.client.bl.promotionbl.PromotionController;
import org.client.rmi.RMIHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.PromotionVO;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CustomerMain {
	@FXML
	AnchorPane root;

	@FXML
	AnchorPane promotionPane;

	@FXML
	Label showPromotionLabel;
	
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

	// 该字段表示同时显示的最大促销策略的数量
	private static final int MAX_PROMOTION_ONE_OAGE = 4;
	
	private ArrayList<Label> promotionLabelList;
	
	private ArrayList<PromotionVO> promotionVOList;

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

	@FXML
	void refreshAreas() {
		setArea();
		area.setValue(area.getItems().get(0));
	}

	@FXML
	void initialize() {
		setCity();
		city.setValue("南京");
		setArea();


		area.setValue("新街口");

		city.getSelectionModel().selectedItemProperty().addListener( (ObservableValue< ? extends String> observable, String oldValue, String newValue) -> {
			refreshAreas();
		});

		SwitchSceneUtil.showGuideAnimation(root, -200);
		promotionLabelList = new ArrayList<>();
		promotionLabelList.add(promotion1);
		promotionLabelList.add(promotion2);
		promotionLabelList.add(promotion3);
		promotionLabelList.add(promotion4);
		promotionVOList = (ArrayList<PromotionVO>)PromotionController.getInstance().showWebsitePromotion();
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
	
	private void setContent() {
		for (int i = 0; i < MAX_PROMOTION_ONE_OAGE; i++) {
			if (promotion(i) != null) {
				promotionLabelList.get(i).setVisible(true);
				promotionLabelList.get(i).setText(promotion(i));
			} else {
				promotionLabelList.get(i).setVisible(false);
				promotionLabelList.get(i).setText(null);
			}
		}
	}
	
	private int calMaxPage(ArrayList<PromotionVO> voList) {
		return (voList.size() / MAX_PROMOTION_ONE_OAGE) + 1;
	}
	
	private String promotion(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_PROMOTION_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return promotionVOList.get(seq).name;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
}
