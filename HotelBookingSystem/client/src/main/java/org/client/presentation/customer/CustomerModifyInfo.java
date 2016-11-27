package org.client.presentation.customer;

import org.client.blstub.User_stub;
import org.client.vo.UserVO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-修改个人信息
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */

public class CustomerModifyInfo {
	@FXML
	AnchorPane root;
	
	@FXML
	Label companyLabel;
	
	@FXML
	TextField name;
	
	@FXML
	TextField phoneNumber;
	
	@FXML
	TextField birthday;
	
	@FXML
	TextField company;
	
	@FXML
	TextField originPassword;
	
	@FXML
	TextField newPassword;
	
	@FXML
	TextField newPasswordAgain;
	
	@FXML
	void initialize() {
		UserVO vo = SwitchSceneUtil.getUserVO();
		name.setText(vo.name);
		phoneNumber.setText(vo.phoneNumber);
		company.setText(vo.companyName);
		StringBuilder dateBuilder = new StringBuilder();
		dateBuilder.append(vo.birthday.getYear());
		dateBuilder.append("/");
		dateBuilder.append(vo.birthday.getMonth() + 1);
		dateBuilder.append("/");
		dateBuilder.append(vo.birthday.getDate());
		birthday.setText(dateBuilder.toString());
	}
	
	@FXML
	void confirmChangeInfo() {
		SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看客户信息界面.fxml");
	}
	
	@FXML
	void cancelChangeInfo() {
		SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), "/客户/查看客户信息界面.fxml");
	}
	
	@FXML
	void confirmChangePassword() {
		User_stub stub = new User_stub();
		// 检查两次输入的新密码是否一致
		String newPassword1 = newPassword.getText();
		String newPassword2 = newPasswordAgain.getText();
		if (newPassword1.equals(newPassword2)) {
			stub.modifyPassword(SwitchSceneUtil.getUserVO().userName, originPassword.getText(), newPassword1);
			System.out.println("ok");
			SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), "/客户/修改客户信息界面.fxml");
			System.out.println("ok2");
		}
		System.out.println("no");
	}
}
