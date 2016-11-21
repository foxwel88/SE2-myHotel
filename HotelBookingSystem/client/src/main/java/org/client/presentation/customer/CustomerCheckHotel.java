package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-酒店详细信息
 *
 */

public class CustomerCheckHotel {
	@FXML
	AnchorPane root;
	
	SwitchSceneUtil sceneSetter = new SwitchSceneUtil();
	
	@FXML
	void turnToCustomerGenerateOrder() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/生成订单界面.fxml");
	}
}
