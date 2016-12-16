package org.client.launcher;

import java.net.URL;
import java.util.ResourceBundle;

import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.client.presentation.util.CheckStyle;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * 修改密码界面
 * @author gyue
 * @version gyue 2016/12/16
 */
public class PwModify {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField oldPwField;

	@FXML
	private PasswordField newPwField;
	
	@FXML
    private PasswordField confirmPwField;

	@FXML
	private Button confirmButton;
	
	@FXML
	private Text infoLabel;
	
	@FXML
    private Button returnButton;
	
	private String userName;
	
	private Pane parent;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setParentPane(Pane parent) {
		this.parent = parent;
	}

	@FXML
	void handlePwModify(ActionEvent event) {
		String oldPassword = oldPwField.getText();
		String newPassword = newPwField.getText();
		String toCheck = confirmPwField.getText();
		
		if (!CheckStyle.checkPassword(newPassword)) {
			infoLabel.setText("新密码格式不正确");
			return;
		}
		if (!newPassword.equals(toCheck)) {
			infoLabel.setText("两次密码不一致");
			return;
		}
		Userblservice userbl = UserController.getInstance();
		ResultMessage info = userbl.modifyPassword(userName, oldPassword, newPassword);
		if (info == ResultMessage.WRONG_PASSWORD) {
			infoLabel.setText("原始密码错误");
		} else if (info == ResultMessage.CONNECTION_FAIL) {
			infoLabel.setText("服务器连接中断");
		} else if (info == ResultMessage.SUCCESS) {
			infoLabel.setText("修改成功");
			oldPwField.setText("");
			newPwField.setText("");
			confirmPwField.setText("");
		}
	}
	
	@FXML
	void handleReturn(ActionEvent event) {
		int size = parent.getChildren().size();
		AnchorPane pane = (AnchorPane) parent.getChildren().get(size - 1);
		pane.getChildren().clear();
		parent.getChildren().remove(size - 1);
	}

	@FXML
	void initialize() {
		assert oldPwField != null : "fx:id=\"oldPwField\" was not injected: check your FXML file '修改密码界面.fxml'.";
		assert newPwField != null : "fx:id=\"newPwField\" was not injected: check your FXML file '修改密码界面.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '修改密码界面.fxml'.";
		assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file '修改密码界面.fxml'.";
		assert confirmPwField != null : "fx:id=\"confirmPwField\" was not injected: check your FXML file '修改密码界面.fxml'.";
		assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file '修改密码界面.fxml'.";

	}
}