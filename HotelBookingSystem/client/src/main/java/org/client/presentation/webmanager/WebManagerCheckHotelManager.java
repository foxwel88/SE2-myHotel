package org.client.presentation.webmanager;


import java.io.IOException;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-浏览酒店工作人员信息
 * @author Foxwel
 * @version 2016/12/16 Foxwel
 *
 */
public class WebManagerCheckHotelManager {
	
	private WebManagerController controller;
	
	private UserVO nowvo;	
	
	@FXML
	private Label resultLabel;
	
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
	private Label hotelLabel;
	
	void changeContent(UserVO vo) {
		nowvo = vo;
		if (vo != null) {
			nameLabel.setText(vo.name);
			phoneLabel.setText(vo.phoneNumber);
			userNameLabel.setText(vo.userName);
			hotelLabel.setText(vo.hotelAddress);
		}
	}
	
	void clear() {
		nowvo = null;
		nameLabel.setText("");
		phoneLabel.setText("");
		userNameLabel.setText("");
		hotelLabel.setText("");
	}
	
	@FXML
	void initialize() {
		assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert phoneLabel != null : "fx:id=\"phoneLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert hotelLabel != null : "fx:id=\"hotelLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";

		controller = WebManagerController.getInstance();
		modifyButton.setVisible(false);
		clear();
	}

	/*
 	修改信息按钮监听
	*/
	@FXML
	void handleModifyAction(MouseEvent event) throws IOException {
		if (!userNameLabel.getText().equals("")) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent myPane = fxmlLoader.load(getClass().getResource("/网站管理人员/修改酒店工作人员界面.fxml").openStream());
			WebManagerModifyHotelManager webController = (WebManagerModifyHotelManager) fxmlLoader.getController();
			webController.changeContent(nowvo);
			WebManagerController.getInstance().nowvo = nowvo;
			ChangePane.getInstance().turn(myPane);
		}
	}

	/*
	搜索按钮监听
	*/
	@FXML
	void handleSearchAction(MouseEvent event) {
		clear();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("酒店工作人员")) {
				resultLabel.setText("");
				changeContent(vo);
				modifyButton.setVisible(true);
			} else {
				resultLabel.setText("该用户不是酒店工作人员");
				modifyButton.setVisible(false);
			}
		} else {
			resultLabel.setText("用户名不存在");
			modifyButton.setVisible(false);
		}
	}
}
