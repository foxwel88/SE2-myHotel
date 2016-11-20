package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * 客户-查看客户信息
 *
 */

public class CustomerCheckInfo {
	@FXML
	AnchorPane root;
	
	@FXML
	void turnToCustomerCheckCredit() {
		SwitchSceneUtil.turnToCustomerCheckCredit(root);
	}
	
	@FXML
	void turnToCustomerModifyInfo() {
		SwitchSceneUtil.turnToCustomerModifyInfo(root);
	}
}
