package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-修改个人信息
 *
 */

public class CustomerModifyInfo {
	@FXML
	AnchorPane root;
	
	SwitchSceneUtil sceneSetter = new SwitchSceneUtil();
	
	@FXML
	void confirmChangeInfo() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看客户信息界面.fxml");
	}
	
	@FXML
	void cancelChangeInfo() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看客户信息界面.fxml");
	}
	
	@FXML
	void confirmChangePassword() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/修改客户信息界面.fxml");
	}
}
