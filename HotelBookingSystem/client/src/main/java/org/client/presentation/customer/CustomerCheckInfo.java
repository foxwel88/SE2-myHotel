package org.client.presentation.customer;

import org.client.launcher.Resources;
import org.client.presentation.util.DateUtil;
import org.client.vo.UserVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.common.utility.UserType;

/**
 * 
 * 客户-查看客户信息
 * @author fraliphsoft
 * @version fraliphsoft 11/30
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
	Label birthcompanyLabel;
	
	@FXML
	Label birthday;
	
	private Resources resources;
	
	@FXML
	void initialize() {
		CustomerController.canBack = false;
		resources = Resources.getInstance();
		UserVO vo = CustomerController.getUserVO();
		account.setText(vo.userName);
		name.setText(vo.name);
		accountType.setText(vo.type);
		phoneNumber.setText(vo.phoneNumber);
		credit.setText(String.valueOf(vo.credit));
		level.setText(String.valueOf(CustomerController.calculateLevel(vo.credit)));
		if (vo.type.equals(UserType.PERSONALCUSTOMER.getString())) {
			birthday.setText(DateUtil.dateToCoarseString(vo.birthday));
			birthcompanyLabel.setText("生日");
		} else {
			birthday.setText(vo.companyName);
			birthcompanyLabel.setText("企业名称");
		}

		CustomerController.showGuideAnimation(root, -100);
	}
	
	@FXML
	void turnToCustomerCheckCredit() {
		CustomerController.savePreviousScene(CustomerBackableScene.CREDITS_RECORD_SCENE);
		CustomerController.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckCredits);
	}
	
	@FXML
	void turnToCustomerModifyInfo() {
		CustomerController.savePreviousScene(CustomerBackableScene.MODIFY_INFO_SCENE);
		CustomerController.turnToAnotherScene((GridPane)root.getParent(), resources.customerModifyInfo);
	}
}
