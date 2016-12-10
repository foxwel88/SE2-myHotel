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
 * @version 2016/11/27 Foxwel
 *
 */
public class WebManagerCheckHotelManager {
	
	private WebManagerController controller;
	
	private UserVO nowvo;
	
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
		controller = WebManagerController.getInstance();
		clear();
	}
	
	@FXML
	void handleModifyAction(MouseEvent event) throws IOException {
		if (!userNameLabel.getText().equals("")) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/修改酒店工作人员界面.fxml").openStream());
			WebManagerModifyHotelManager webController = (WebManagerModifyHotelManager) fxmlLoader.getController();
			webController.changeContent(nowvo);
			WebManagerController.getInstance().nowvo = nowvo;
			ChangePane.getInstance().turn(mypane);
		}
	}

	@FXML
	void handleSearchAction(MouseEvent event) {
		clear();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("酒店工作人员")) {
				changeContent(vo);
			}
		}
	}
}
