package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-管理酒店促销策略
 *
 */
public class HotelManagerCheckPromotion {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	private List<PromotionVO> promotionList;

	@FXML
    void initialize() {
		promotionList = HotelManagerController.getInstance().getPromotions();
	}
	
}
