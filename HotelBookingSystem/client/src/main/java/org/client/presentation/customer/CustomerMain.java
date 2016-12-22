package org.client.presentation.customer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.client.bl.promotionbl.PromotionController;
import org.client.rmi.RMIHelper;
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
	Label time;
	
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
	AnchorPane promotionPane;
	
	@FXML
	Label hidePromotionButton;
	
	// 该字段表示同时显示的最大促销策略的数量
	private static final int MAX_PROMOTION_ONE_OAGE = 4;
	
	private ArrayList<Label> promotionLabelList;
	
	private ArrayList<PromotionVO> promotionVOList;

	@FXML
	void initialize() {
		assert time != null : "fx:id=\"time\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";

		SwitchSceneUtil.showGuideAnimation(root, -200);
		
		// clock
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), actionEvent -> {
			try {
				time.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
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
