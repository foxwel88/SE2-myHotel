package org.client.presentation.webmanager;


import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-浏览酒店工作人员信息
 *
 */
public class WebManagerCheckHotelManager {
	
	private WebManagerController controller;
	
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
	
	void clear() {
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
	void handleModifyAction(MouseEvent event) {

	}

	@FXML
	void handleSearchAction(MouseEvent event) {
		clear();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("酒店工作人员")) {
				nameLabel.setText(vo.name);
				phoneLabel.setText(vo.phoneNumber);
				userNameLabel.setText(vo.userName);
				hotelLabel.setText(vo.hotelAddress);
			}
		}
	}
}
