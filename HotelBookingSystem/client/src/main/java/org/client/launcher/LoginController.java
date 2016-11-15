package org.client.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField accountField;

	@FXML
    private TextField pwField;

	@FXML
    private Button loginButton;

	@FXML
    private Button registerButton;

	@FXML
	void initialize() {
		assert accountField != null : "fx:id=\"accountField\" was not injected: check your FXML file '登录界面.fxml'.";
		assert pwField != null : "fx:id=\"pwField\" was not injected: check your FXML file '登录界面.fxml'.";
		assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file '登录界面.fxml'.";
		assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file '登录界面.fxml'.";

	}
	
	@FXML
	private void handleLoginAction(ActionEvent event) throws IOException {
		String account = accountField.getText().trim();
		String passWord = pwField.getText().trim();
		Userblservice userBl = UserController.getInstance();
		ResultMessage result = userBl.login(account, passWord);
		if (result == ResultMessage.SUCCESS) {
			switch(userBl.findbyUserName(account).type) {
				case "酒店工作人员":
				case "网站管理人员":
				case "网站营销人员":
				case "客户":
					break;
			}
		}
		else if (result == ResultMessage.CONNECTION_FAIL) {
			
		}
		
	}
	
	@FXML
	private void handleRegisterAction(ActionEvent event) throws IOException {
		System.out.println("hello!!!");
	}
	
	
	
	
}
