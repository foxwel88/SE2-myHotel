package org.client.presentation.webmanager;

import java.io.IOException;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-浏览客户信息
 *
 */
public class WebManagerCheckCustomer {

	private WebManagerController controller;
	
	

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

	void clear() {
		typeLabel.setText("");
		nameLabel.setText("");
		phoneLabel.setText("");
		userNameLabel.setText("");
		creditLabel.setText("");
		levelLabel.setText("");
		birthLabel.setText("");
	}
	
	@FXML
	void initialize() {
		controller = WebManagerController.getInstance();
		clear();
	}
	
	@FXML
	void handleModifyAction(MouseEvent event) throws IOException {
		//Parent mypane = FXMLLoader.load(getClass().getResource("/网站管理人员/修改客户信息界面.fxml"));
	}
	
	@FXML
	void handleSearchAction(MouseEvent event) {
		clear();
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			if (vo.type.equals("个人客户") || vo.type.equals("企业客户")) {
				nameLabel.setText(vo.name);
				phoneLabel.setText(vo.phoneNumber);
				userNameLabel.setText(vo.userName);
				creditLabel.setText(Double.toString(vo.credit));
				typeLabel.setText(vo.type);
				if (vo.type.equals("个人客户")) {
					PorCLabel.setText("生日");
					birthLabel.setText(vo.birthday.toString());
				} else {
					PorCLabel.setText("企业名称");
					birthLabel.setText(vo.companyName);
				}
			}
		}
	}
}
