package org.client.presentation.webmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-新增酒店
 *
 */
public class WebManagerAddHotel {
	@FXML
	private ChoiceBox< ? > cityChoiceBox;

	@FXML
	private ChoiceBox< ? > areaChoiceBox;

	@FXML
	private TextField hotelAddressTextField;

	@FXML
	private TextField hotelNameTextField;

	@FXML
	private ChoiceBox< ? > StarChoiceBox;

	@FXML
	private TextArea introduceTextArea;

	@FXML
	private TextArea serverTextArea;

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

	@FXML
	void handleCancelAction(MouseEvent event) {

	}

	@FXML
	void handleConfirmAction(MouseEvent event) {

	}
}
