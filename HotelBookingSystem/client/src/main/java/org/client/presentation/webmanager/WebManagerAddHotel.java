package org.client.presentation.webmanager;

import java.util.ArrayList;

import org.client.presentation.util.CheckStyle;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-新增酒店
 * @author Foxwel
 * @version 2016/12/15 Foxwel
 *
 */
public class WebManagerAddHotel {
	@FXML
	private Label resultLabel;
	
	@FXML
	private ChoiceBox< String > cityChoiceBox;

	@FXML
	private ChoiceBox< String > areaChoiceBox;

	@FXML
	private TextField hotelAddressTextField;

	@FXML
	private TextField hotelNameTextField;

	@FXML
	private ChoiceBox< Integer > StarChoiceBox;

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
	
	void clear() {
		hotelNameTextField.setText("");
		hotelAddressTextField.setText("");
		introduceTextArea.setText("");
		serverTextArea.setText("");
		userNameTextField.setText("");
		nameTextField.setText("");
		passwordField.setText("");
		passwordField2.setText("");
		phoneTextField.setText("");
	}

	@FXML
	void handleCancelAction(MouseEvent event) {
		clear();
	}

	boolean checkUser() {
		if (! passwordField.getText().equals(passwordField2.getText())) {
			resultLabel.setText("两次输入密码不一致");
			return false;
		}
		if (! CheckStyle.checkUsername(userNameTextField.getText())) {
			resultLabel.setText("用户名格式不正确");
			return false;
		}
		if (! CheckStyle.checkPassword(passwordField.getText())) {
			resultLabel.setText("密码格式不正确");
			return false;
		}
		if (! CheckStyle.checkName(nameTextField.getText())) {
			resultLabel.setText("请输入姓名");
			return false;
		}
		if (! CheckStyle.checkPhone(phoneTextField.getText())) {
			resultLabel.setText("联系方式格式不正确");
			return false;
		}
		return true;
	}
	
	@FXML
	void handleConfirmAction(MouseEvent event) {
		if (checkUser()) {
			UserVO hotelManagervo = new UserVO(UserType.HOTELMANAGER.getString(), userNameTextField.getText(), nameTextField.getText(), 
					null, passwordField.getText(), phoneTextField.getText(), 0, null, null, null, hotelAddressTextField.getText());
			HotelVO hotelvo = new HotelVO(null, hotelNameTextField.getText(), hotelAddressTextField.getText(), new CityVO(cityChoiceBox.getValue()),
						new AreaVO(areaChoiceBox.getValue()), introduceTextArea.getText(), 0, StarChoiceBox.getValue(), serverTextArea.getText(),
						null,null, null, null, null, "");
			ResultMessage message = WebManagerController.getInstance().addHotel(hotelvo, hotelManagervo);
			if (message == ResultMessage.EXIST) {
				resultLabel.setText("酒店地址或用户名重复");
			}
			if (message == ResultMessage.SUCCESS) {
				resultLabel.setText("添加成功");
				clear();
				return;
			}
		}
	}
	
	void initCity() {
		ObservableList<String> mycity = FXCollections.observableArrayList(); 
		ArrayList<CityVO> citylist = (ArrayList<CityVO>) WebManagerController.getInstance().getCitys();
		for (int i = 0; i < citylist.size(); ++i) {
			mycity.add(citylist.get(i).cityName);
		}
		cityChoiceBox.setItems(mycity);
		cityChoiceBox.setValue(citylist.get(0).cityName);
	}
	
	void initArea(String city) {
		CityVO cityvo = new CityVO(city);
		ObservableList<String> myarea = FXCollections.observableArrayList(); 
		ArrayList<AreaVO> arealist = (ArrayList<AreaVO>) WebManagerController.getInstance().getAreas(cityvo);
		for (int i = 0; i < arealist.size(); ++i) {
			myarea.add(arealist.get(i).address);
		}
		areaChoiceBox.setItems(myarea);
		areaChoiceBox.setValue(arealist.get(0).address);
	}
	
	void initStar() {
		ObservableList<Integer> mystar = FXCollections.observableArrayList();
		mystar.add(1);
		mystar.add(2);
		mystar.add(3);
		mystar.add(4);
		mystar.add(5);
		StarChoiceBox.setItems(mystar);
		StarChoiceBox.setValue(3);
	}
	
	@FXML
	void initialize() {
		initCity();
		cityChoiceBox.getSelectionModel().selectedItemProperty().addListener( (ObservableValue< ? extends String> observable, String oldValue, String newValue) -> {	
			initArea(newValue);
		});
		initArea(cityChoiceBox.getValue());
		initStar();
		resultLabel.setText("");
	}
}
