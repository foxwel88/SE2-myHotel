package org.client.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.UserBlService;
import org.client.presentation.customer.CustomerHTTPPictureDownloader;
import org.client.presentation.customer.Customer_Guide;
import org.client.presentation.customer.CustomerController;
import org.client.presentation.hotelmanager.HotelManagerController;
import org.client.presentation.webmanager.WebManagerController;
import org.client.presentation.webmarketer.WebMarketerController;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		UserBlService userBl = UserController.getInstance();
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
					CustomerController.init(stage, uservo.ID);
					FXMLLoader loader1 = new FXMLLoader();
					root = loader1.load(getClass().getResource("/客户/导航_主界面.fxml").openStream());
					Customer_Guide customerController1 = (Customer_Guide) loader1.getController();
					CustomerController.setGuideController(customerController1);
					break;
				case "企业客户":
					CustomerController.init(stage, uservo.ID);
					FXMLLoader loader2 = new FXMLLoader();
					root = loader2.load(getClass().getResource("/客户/导航_主界面.fxml").openStream());
					Customer_Guide customerController2 = (Customer_Guide) loader2.getController();
					CustomerController.setGuideController(customerController2);
					break;
			}

			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					userBl.logout(account);
					CustomerHTTPPictureDownloader.clearTempFile();
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
		} else if (result == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Null result");

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
	void handleIPAction(MouseEvent event) {
		Stage stage = (Stage)accountField.getScene().getWindow();
		Resources resources = Resources.getInstance();
		Parent root = null;
		try {
			root = resources.load(resources.modifyIP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	@FXML
	private void handleRegisterAction(ActionEvent event) throws IOException {
		Stage stage = (Stage)accountField.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/注册界面.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
}
