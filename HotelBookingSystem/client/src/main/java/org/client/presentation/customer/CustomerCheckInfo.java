package org.client.presentation.customer;

import org.client.vo.UserVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
	
	@FXML
	Label account;
	
	@FXML
	Label name;
	
	@FXML
	Label accountType;
	
	@FXML
	Label phoneNumber;
	
	@FXML
	Label credit;
	
	@FXML
	Label level;
	
	@FXML
	Label birthday;
	
	SwitchSceneUtil sceneSetter = new SwitchSceneUtil();
	
	public CustomerCheckInfo() {
		UserVO vo = SwitchSceneUtil.getVO();
		account.setText(vo.userName);
		name.setText(vo.name);
		accountType.setText(vo.type);
		phoneNumber.setText(vo.phoneNumber);
		credit.setText(String.valueOf(vo.credit));
		level.setText(String.valueOf(SwitchSceneUtil.promotionController.calLevel(vo.credit)));
		birthday.setText(vo.birthday.toString());
	}
	
	@FXML
	void turnToCustomerCheckCredit() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看信用记录界面.fxml");
	}
	
	@FXML
	void turnToCustomerModifyInfo() {
		sceneSetter.turnToAnotherScene((GridPane)root.getParent(), "/客户/修改客户信息界面.fxml");
	}
}
