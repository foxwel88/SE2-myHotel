package org.client.launcher;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javafx.scene.control.*;
import org.client.bl.userbl.UserController;
import org.client.blservice.userblservice.UserBlService;
import org.client.presentation.util.CheckStyle;
import org.client.presentation.util.DateUtil;
import org.client.presentation.util.ResultInfoHelper;
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

/**
 * 注册界面 FXML controller
 *
 */
public class RegisterController {
	@FXML
	private Label resultLabel;
	
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
	private TextField companyTextField;
	
	@FXML
	void initialize() {
		
		//设置客户类型的choiceBox
		ObservableList<String> userTypes = FXCollections.observableArrayList();
		userTypes.add(UserType.PERSONALCUSTOMER.getString());
		userTypes.add(UserType.COMPANYCUSTOMER.getString());
		typeChoiceBox.setItems(userTypes);
		typeChoiceBox.setValue(UserType.PERSONALCUSTOMER.getString());
		birthDatePicker.setValue(LocalDate.of(1990,1,1));
		resultLabel.setText("");
		typeChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldIndex, newIndex) -> {
			if (userTypes.get((Integer)newIndex).equals(UserType.PERSONALCUSTOMER.getString())) {
				birthLabel.setText("生日：");
				birthDatePicker.setVisible(true);
				companyTextField.setVisible(false);
			} else {
				birthLabel.setText("企业名称：");
				companyTextField.setVisible(true);
				birthDatePicker.setVisible(false);
			}
		});
	}
	
	void show(String s) {
		ResultInfoHelper.setResultLabel(resultLabel, s, 2000);
	}
	
	
	
	boolean check() {
		if (! passwordField.getText().equals(passwordField2.getText())) {
			show("两次输入密码不一致");
			return false;
		}
		if (! CheckStyle.checkUsername(userNameTextField.getText())) {
			show("用户名格式不正确");
			return false;
		}
		if (! CheckStyle.checkPassword(passwordField.getText())) {
			show("密码格式不正确");
			return false;
		}
		if (! CheckStyle.checkName(nameTextField.getText())) {
			show("请填写姓名");
			return false;
		}
		if (! CheckStyle.checkPhone(phoneTextField.getText())) {
			show("手机号格式不正确");
			return false;
		}
		if (typeChoiceBox.getValue().equals(UserType.PERSONALCUSTOMER.getString())) {
			
		} else {
			if (! CheckStyle.checkCompanyName(companyTextField.getText())) {
				show("请填写公司名称");
				return false;
			}
		}
		return true;
	}
	
	@FXML
	void handleSignUpAction(MouseEvent event) {
		UserBlService userBl = UserController.getInstance();
		
			
		if (check()) {
			ResultMessage message = null;
			if (typeChoiceBox.getValue().equals(UserType.PERSONALCUSTOMER.getString())) {
				//记录生日
				Date birthDate = DateUtil.toDate(birthDatePicker.getValue());
				
				UserVO vo = new UserVO(typeChoiceBox.getValue(), userNameTextField.getText(), nameTextField.getText(), null,
						passwordField.getText(), phoneTextField.getText(), 200, birthDate, null, null, null);
				
				message = userBl.add(vo);
			} else {
				UserVO vo = new UserVO(typeChoiceBox.getValue(), userNameTextField.getText(), nameTextField.getText(), null,
						passwordField.getText(), phoneTextField.getText(), 200, null, companyTextField.getText(), null, null);
				
				message = userBl.add(vo);
			}

			if (message == ResultMessage.EXIST) {
				show("用户名已存在");
			}
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
