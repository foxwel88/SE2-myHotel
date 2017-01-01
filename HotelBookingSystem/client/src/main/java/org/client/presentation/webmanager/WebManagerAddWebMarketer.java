package org.client.presentation.webmanager;

import java.io.IOException;

import org.client.presentation.util.CheckStyle;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-添加网站营销人员
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 *
 */
public class WebManagerAddWebMarketer {
	private UserVO nowvo;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private TextField userNameTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private PasswordField passwordField2;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	void changeContent(UserVO vo) {
		nowvo = vo;
	}

	/*
	返回上一界面恢复内容的操作
 	*/
	public void returnPane(UserVO vo) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
		WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
		webController.changeContent(vo);
		ChangePane.getInstance().turn(mypane);
	}

	/*
	取消新增网站营销人员按钮监听
 	*/
	
	@FXML
	void handleCancelAction(MouseEvent event) throws IOException {
		returnPane(nowvo);
	}

	/*
	格式检查
	 */
	boolean checkUser() {
		if (! passwordField.getText().equals(passwordField2.getText())) {
			resultLabel.setText("两次输入密码不一致");
			return false;
		}
		if (! CheckStyle.checkUsername(userNameTextField.getText())) {
			resultLabel.setText("用户名格式不正确");
			return false;
		}
		if (! CheckStyle.checkPassword(passwordField.getText())) {
			resultLabel.setText("密码格式不正确");
			return false;
		}
		if (! CheckStyle.checkName(nameTextField.getText())) {
			resultLabel.setText("请输入姓名");
			return false;
		}
		if (! CheckStyle.checkPhone(phoneTextField.getText())) {
			resultLabel.setText("联系方式格式不正确");
			return false;
		}
		return true;
	}

	/*
	确认新增网站营销人员按钮监听
 	*/
	@FXML
	void handleConfirmAction(MouseEvent event) throws IOException {
		if (checkUser()) {
			UserVO newvo = new UserVO(UserType.WEBMARKETER.getString(), userNameTextField.getText(), nameTextField.getText(), 
					null, passwordField.getText(), phoneTextField.getText(), 0, null, null, null, null);
			ResultMessage message = WebManagerController.getInstance().add(newvo);
			if (message == ResultMessage.EXIST) {
				resultLabel.setText("用户名已存在");
			}
			if (message == ResultMessage.SUCCESS) {
				resultLabel.setText("添加成功");
				FXMLLoader fxmlLoader = new FXMLLoader();
				Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
				WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
				webController.changeContent(newvo);
				ChangePane.getInstance().turn(mypane);
			}
		}
	}
	
	@FXML
    void initialize() {
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert passwordField2 != null : "fx:id=\"passwordField2\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert phoneTextField != null : "fx:id=\"phoneTextField\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '新增网站营销人员界面.fxml'.";
	}
}
