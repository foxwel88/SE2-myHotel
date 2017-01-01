package org.client.presentation.webmanager;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-浏览客户信息
 * @author Foxwel
 * @version 2016/12/16 Foxwel
 *
 */
public class WebManagerCheckCustomer {

	private WebManagerController controller;
	
	private UserVO nowvo;
	
	@FXML
	private Label resultLabel;

	@FXML
	private Label PorCLabel;

	@FXML
    private Label nameLabel;

	@FXML
    private Label phoneLabel;

	@FXML
    private Label userNameLabel;

	@FXML
    private TextField userNameTextField;

	@FXML
    private Button searchButton;

	@FXML
    private Button modifyButton;

	@FXML
    private Label creditLabel;

	@FXML
    private Label levelLabel;

	@FXML
    private Label birthLabel;

	@FXML
    private Label typeLabel;

	void clearContent() {
		typeLabel.setText("");
		nameLabel.setText("");
		phoneLabel.setText("");
		userNameLabel.setText("");
		creditLabel.setText("");
		levelLabel.setText("");
		birthLabel.setText("");
		nowvo = null;
	}
	
	void changeContent(UserVO vo) {
		nowvo = vo;
		if (vo != null) {
			nameLabel.setText(vo.name);
			phoneLabel.setText(vo.phoneNumber);
			userNameLabel.setText(vo.userName);
			creditLabel.setText(Double.toString(vo.credit));
			typeLabel.setText(vo.type);
			levelLabel.setText(Integer.toString(controller.getLevel(vo.ID).level));
			if (vo.type.equals("个人客户")) {
				PorCLabel.setText("生日");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
				birthLabel.setText(dateFormat.format(vo.birthday));
			} else {
				PorCLabel.setText("企业名称");
				birthLabel.setText(vo.companyName);
			}
		}
	}
	
	@FXML
	void initialize() {
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert phoneLabel != null : "fx:id=\"phoneLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert creditLabel != null : "fx:id=\"creditLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert PorCLabel != null : "fx:id=\"PorCLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert levelLabel != null : "fx:id=\"levelLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert birthLabel != null : "fx:id=\"birthLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert typeLabel != null : "fx:id=\"typeLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
		controller = WebManagerController.getInstance();
		modifyButton.setVisible(false);
		clearContent();
	}

	/*
 	修改信息按钮监听
	*/
	@FXML
	void handleModifyAction(MouseEvent event) throws IOException {
		if (!userNameLabel.getText().equals("")) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/修改客户信息界面.fxml").openStream());
			WebManagerModifyCustomer webController = (WebManagerModifyCustomer) fxmlLoader.getController();
			webController.changeContent(nowvo);
			WebManagerController.getInstance().nowvo = nowvo;
			ChangePane.getInstance().turn(mypane);
		}
	}

	/*
 	搜索按钮监听
	*/
	@FXML
	void handleSearchAction(MouseEvent event) {
		clearContent();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals(UserType.PERSONALCUSTOMER.getString()) || vo.type.equals(UserType.COMPANYCUSTOMER.getString())) {
				resultLabel.setText("");
				changeContent(vo);
				modifyButton.setVisible(true);
			} else {
				resultLabel.setText("该用户不是客户");
				modifyButton.setVisible(false);
			}
		} else {
			resultLabel.setText("用户名不存在");
			modifyButton.setVisible(false);
		}
	}
}
