package org.client.presentation.webmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-修改客户信息
 *
 */
public class WebManagerModifyCustomer {
	@FXML
	private TextField userNameTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private ChoiceBox< ? > typeChoiceBox;

	@FXML
	private TextField birthTextField;

	@FXML
	private TextField companyTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	@FXML
	void handleCancelAction(MouseEvent event) {

	}

	@FXML
	void handleConfirmAction(MouseEvent event) {

	}
}
