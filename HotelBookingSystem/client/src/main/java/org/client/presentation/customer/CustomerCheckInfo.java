package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-查看客户信息
 *
 */

public class CustomerCheckInfo {
	@FXML
	AnchorPane root;
	
	SwitchSceneUtil sceneSetter = new SwitchSceneUtil();
	
	@FXML
	void turnToCustomerCheckCredit() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看信用记录界面.fxml");
	}
	
	@FXML
	void turnToCustomerModifyInfo() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/修改客户信息界面.fxml");
	}
}
