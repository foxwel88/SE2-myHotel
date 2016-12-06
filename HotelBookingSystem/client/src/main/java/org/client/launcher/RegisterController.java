package org.client.launcher;

import java.io.IOException;
import java.util.Date;

import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.User_stub;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private ChoiceBox< String > typeChoiceBox;

	@FXML
    private TextField phoneTextField;
	
	@FXML
    private TextField nameTextField;

	@FXML
    private TextField birthTextField;
	
	@FXML
	void handleSignUpAction(MouseEvent event) {
		Userblservice userBl = new User_stub();
		Resources resources = Resources.getInstance();
		if (passwordField.getText().equals(passwordField2.getText())) {
			UserVO vo = new UserVO(UserType.PERSONALCUSTOMER.getString(), userNameTextField.getText(), nameTextField.getText(), null,
					passwordField.getText(), phoneTextField.getText(), 200, new Date(), null, null, null);
			
			ResultMessage message = userBl.add(vo);
			if (message == ResultMessage.SUCCESS) {
				Stage stage = (Stage)userNameTextField.getScene().getWindow();
				Parent root;
				try {
					root = resources.load(resources.register);
				
					Scene scene = new Scene(root);
					stage.setScene(scene);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	
	/**返回到登录界面 */
	@FXML
	void goBack(MouseEvent event) {
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
