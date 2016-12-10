package org.client.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.client.presentation.customer.SwitchSceneUtil;
import org.client.presentation.hotelmanager.HotelManagerController;
import org.client.presentation.webmanager.WebManagerController;
import org.client.presentation.webmarketer.WebMarketerController;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 启动界面
 *
 */
public class LoginController {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField accountField;

	@FXML
    private PasswordField pwField;

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
		Stage stage = (Stage)accountField.getScene().getWindow();
		Parent root = null;
		Resources resources = Resources.getInstance();
		if (result == ResultMessage.SUCCESS) {
			UserVO uservo = userBl.findbyUserName(account);
			switch(uservo.type) {
				case "酒店工作人员":
					HotelManagerController.init(uservo.hotelID, uservo.name, uservo.userName);
					root = resources.load(resources.hotelManagerGuide);
					break;
				case "网站管理人员":
					WebManagerController.getInstance().init(uservo.ID);
					root = FXMLLoader.load(getClass().getResource("/网站管理人员/导航.fxml"));
					break;
				case "网站营销人员":
					WebMarketerController.getInstance().init(uservo);
					root = FXMLLoader.load(getClass().getResource("/网站营销人员/guide.fxml"));
					break;
				case "个人客户":
					SwitchSceneUtil.init(stage, uservo.ID);
					root = FXMLLoader.load(getClass().getResource("/客户/导航_主界面.fxml"));
					break;
				case "企业客户":
					SwitchSceneUtil.init(stage, uservo.ID);
					root = FXMLLoader.load(getClass().getResource("/客户/导航_主界面.fxml"));
					break;
			}

			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					userBl.logout(account);
				}
			});

			Scene scene = new Scene(root);
			stage.setScene(scene);
		} else if (result == ResultMessage.CONNECTION_FAIL) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("连接失败");

			alert.showAndWait();
		} else if (result == ResultMessage.WRONG_USERNAME || result == ResultMessage.WRONG_PASSWORD) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("用户名或密码错误");

			alert.showAndWait();
		} else if (result == ResultMessage.EXIST) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("该用户已登录");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText(result.toString());

			alert.showAndWait();
		}



		
	}
	
	@FXML
	private void handleRegisterAction(ActionEvent event) throws IOException {
		Stage stage = (Stage)accountField.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/注册界面.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
}
