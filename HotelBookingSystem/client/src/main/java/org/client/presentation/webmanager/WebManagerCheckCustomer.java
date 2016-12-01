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
 * 网站工作人员-浏览客户信息
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 *
 */
public class WebManagerCheckCustomer {

	private WebManagerController controller;
	
	private UserVO nowvo;

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
				birthLabel.setText(vo.birthday.toString());
			} else {
				PorCLabel.setText("企业名称");
				birthLabel.setText(vo.companyName);
			}
		}
	}
	
	@FXML
	void initialize() {
		controller = WebManagerController.getInstance();
		clearContent();
	}
	
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
	
	@FXML
	void handleSearchAction(MouseEvent event) {
		clearContent();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("个人客户") || vo.type.equals("企业客户")) {
				changeContent(vo);
			}
		}
	}
}
