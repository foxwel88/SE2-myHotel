package org.client.presentation.customer;

import java.time.LocalDate;
import java.util.Date;

import org.client.launcher.Resources;
import org.client.presentation.util.CheckStyle;
import org.client.presentation.util.LiveDatePicker;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * 客户-修改个人信息
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */

public class CustomerModifyInfo {
	@FXML
	AnchorPane root;
	
	@FXML
	Label companyLabel;
	
	@FXML
	Label birthLabel;
	
	@FXML
	DatePicker birthday;
	
	@FXML
	TextField name;
	
	@FXML
	TextField phoneNumber;
	
	@FXML
	TextField company;
	
	@FXML
	TextField originPassword;
	
	@FXML
	TextField newPassword;

	@FXML
	TextField newPasswordAgain;
	
	private Resources resources;
	
	private UserVO vo;
	
	@FXML
	void initialize() {
		resources = Resources.getInstance();
		vo = SwitchSceneUtil.getUserVO();
		name.setText(vo.name);
		phoneNumber.setText(vo.phoneNumber);
		if (vo.type.equals(UserType.PERSONALCUSTOMER.getString())) {
			LiveDatePicker.initDatePicker(null, birthday);
			String[] dateStringArray = LiveDatePicker.dateToCoarseString(vo.birthday).split("/");
			birthday.setValue(LocalDate.of(Integer.parseInt(dateStringArray[0]), Integer.parseInt(dateStringArray[1]), Integer.parseInt(dateStringArray[2])));
			company.setDisable(true);
			companyLabel.setDisable(true);
		} else {
			company.setText(vo.companyName);
			birthday.setDisable(true);
			birthLabel.setDisable(true);
		}
	}
	
	@FXML
	void confirmChangeInfo() {
		boolean isFormatRight = true;
		if (!checkPhoneNumberFormat()) {
			isFormatRight = false;
		}
		if (!checkName()) {
			isFormatRight = false;
		}
		if (!checkCompanyName()) {
			isFormatRight = false;
		}
		Alert alert;
		if (isFormatRight) {
			UserVO userVO = SwitchSceneUtil.getUserVO();
			getModifiedUserVO(userVO);
			ResultMessage modifyInfoResult = SwitchSceneUtil.modifyInfo(userVO);
			if (modifyInfoResult.equals(ResultMessage.SUCCESS)) {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("修改成功");
				SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckInfo);
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Sorry, please check your entry again.");
				alert.setHeaderText(null);
				alert.setContentText(modifyInfoResult.toString());
			}
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("电话格式不正确(应为11位中国区号码)");
		}
		alert.showAndWait();
	}
	
	@FXML
	void cancelChangeInfo() {
		SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), resources.customerCheckInfo);
	}
	
	@FXML
	void confirmChangePassword() {
		// 检查两次输入的新密码是否一致
		String newPassword1 = newPassword.getText();
		String newPassword2 = newPasswordAgain.getText();
		Alert alert;
		if (newPassword1.equals(newPassword2)) {
			if (checkPasswordFormat(newPassword1)) {
				ResultMessage resultMessage = SwitchSceneUtil.modifyPassword(originPassword.getText(), newPassword1);
				if (!resultMessage.equals(ResultMessage.SUCCESS)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Sorry, please check your entry again.");
					alert.setHeaderText(null);
					alert.setContentText("原密码错误");
				} else {
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText(null);
					alert.setContentText("修改成功");
					SwitchSceneUtil.turnToAnotherScene((GridPane)root.getParent(), resources.customerModifyInfo);
				}
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Sorry, please check your entry again.");
				alert.setHeaderText(null);
				alert.setContentText("密码只能由字母或数字组成（支持大小写），且长度不小于6位");
			}
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("两次输入的密码不一致");
		}
		alert.showAndWait();
	}
	
	private UserVO getModifiedUserVO(UserVO vo) {
		vo.name = name.getText();
		vo.phoneNumber = phoneNumber.getText();
		if (UserType.getType(vo.type) == UserType.PERSONALCUSTOMER) {
			Date newBirthday = LiveDatePicker.toDate(birthday.getValue());			
			vo.birthday = newBirthday;
		} else {
			vo.companyName = company.getText();
		}
		return vo;
		
	}
	
	private boolean checkPhoneNumberFormat() {
		String phoneString = phoneNumber.getText();
		return CheckStyle.checkPhone(phoneString);
	}
	
	private boolean checkPasswordFormat(String password) {
		return CheckStyle.checkPassword(password);
	}
	
	private boolean checkCompanyName() {
		if (vo.type.equals(UserType.PERSONALCUSTOMER)) {
			if (companyLabel.getText().isEmpty()) {
				return true;
			} else {
				return false;
			}
		} else {
			return CheckStyle.checkCompanyname(companyLabel.getText());
		}
	}
	
	private boolean checkName() {
		if (vo.type.equals(UserType.COMPANYCUSTOMER)) {
			if (name.getText().isEmpty()) {
				return true;
			} else {
				return false;
			}
		} else {
			return CheckStyle.checkName(name.getText());
		}
	}
}
