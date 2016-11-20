package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-酒店详细信息
 *
 */

public class CustomerCheckHotel {
	@FXML
	AnchorPane root;
	
	@FXML
	void turnToCustomerGenerateOrder() {
		SwitchSceneUtil.turnToCustomerGenerateOrder(root);
	}
}
