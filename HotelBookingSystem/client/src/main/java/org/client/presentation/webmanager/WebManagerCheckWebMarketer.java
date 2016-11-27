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
 * 网站工作人员-浏览网站营销人员
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 *
 */
public class WebManagerCheckWebMarketer {
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
	private Button modifyButton;

	@FXML
	private Button searchButton;

	@FXML
	private Button addUserButton;

	void changeContent(UserVO vo) {
		nowvo = vo;
		nameLabel.setText(vo.name);
		phoneLabel.setText(vo.phoneNumber);
		userNameLabel.setText(vo.userName);
	}
	
	@FXML
	void handleAddAction(MouseEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/新增网站营销人员界面.fxml").openStream());
		WebManagerAddWebMarketer webController = (WebManagerAddWebMarketer) fxmlLoader.getController();
		webController.changeContent(nowvo);
		ChangePane.getInstance().turn(mypane);
	}

	void clear() {
		nameLabel.setText("");
		phoneLabel.setText("");
		userNameLabel.setText("");
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
			Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/修改网站营销人员界面.fxml").openStream());
			WebManagerModifyWebMarketer webController = (WebManagerModifyWebMarketer) fxmlLoader.getController();
			webController.changeContent(nowvo);
			ChangePane.getInstance().turn(mypane);
		}
	}

	@FXML
	void handleSearchAction(MouseEvent event) {
		clear();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("网站营销人员")) {
				changeContent(vo);
			}
		}
	}
}
