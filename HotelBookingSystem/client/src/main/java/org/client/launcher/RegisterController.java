package org.client.launcher;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javafx.scene.control.*;
import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.Userblservice;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController {
	@FXML
	private TextField userNameTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private PasswordField passwordField2;

	@FXML
    private Label birthLabel;

	@FXML
    private ChoiceBox<String> typeChoiceBox;

	@FXML
    private TextField phoneTextField;
	
	@FXML
    private TextField nameTextField;

	@FXML
	private DatePicker birthDatePicker;
	
	@FXML
	void initialize() {
		
		//设置客户类型的choiceBox
		ObservableList<String> userTypes = FXCollections.observableArrayList();
		userTypes.add(UserType.PERSONALCUSTOMER.getString());
		userTypes.add(UserType.COMPANYCUSTOMER.getString());
		typeChoiceBox.setItems(userTypes);
		typeChoiceBox.setValue(UserType.PERSONALCUSTOMER.getString());
		
		typeChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldIndex, newIndex) -> {
			if (userTypes.get((Integer)newIndex).equals(UserType.PERSONALCUSTOMER.getString())) {
				birthDatePicker.setDisable(false);
			} else {
				birthDatePicker.setDisable(true);
			}
		});
	}
	
	@FXML
	void handleSignUpAction(MouseEvent event) {
		Userblservice userBl = UserController.getInstance();
		if (passwordField.getText().equals(passwordField2.getText())) {

			//记录生日
			Date birthDate = null;
			
			if (!birthDatePicker.isDisabled()) {
				LocalDate localBirthDate = birthDatePicker.getValue();
				ZonedDateTime endZonedTime = localBirthDate.atStartOfDay(ZoneId.systemDefault());
				Instant endInstant = Instant.from(endZonedTime);
				birthDate = Date.from(endInstant);
			}

			UserVO vo = new UserVO(typeChoiceBox.getValue(), userNameTextField.getText(), nameTextField.getText(), null,
					passwordField.getText(), phoneTextField.getText(), 200, birthDate, null, null, null);
			
			ResultMessage message = userBl.add(vo);
			if (message == ResultMessage.SUCCESS) {
				backToLogin();
			}
		}
	
	}
	
	/**返回到登录界面 */
	@FXML
	void goBack(MouseEvent event) {
		backToLogin();
	}

	void backToLogin() {
		Stage stage = (Stage)userNameTextField.getScene().getWindow();
		Resources resources = Resources.getInstance();
		try {
			Parent root = resources.load(resources.login);
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
