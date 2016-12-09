package org.client.presentation.webmanager;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-修改客户信息
 * @author Foxwel
 * @version 2016/11/27 Foxwel
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
	private ChoiceBox< String > typeChoiceBox;

	@FXML
	private TextField birthTextField;

	@FXML
	private TextField companyTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private UserVO nowvo;
	
	void changeContent(UserVO vo) {
		nowvo = vo;
		userNameTextField.setText(nowvo.userName);
		nameTextField.setText(nowvo.name);
		phoneTextField.setText(nowvo.phoneNumber);
		birthTextField.setText(nowvo.birthday.toString());
		companyTextField.setText(nowvo.companyName);
		typeChoiceBox.setItems(FXCollections.observableArrayList("个人客户","企业客户"));
		typeChoiceBox.setValue(nowvo.type);
	}
	
	public void returnPane(UserVO vo) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览客户信息界面.fxml").openStream());
		WebManagerCheckCustomer webController = (WebManagerCheckCustomer) fxmlLoader.getController();
		webController.changeContent(vo);
		ChangePane.getInstance().turn(mypane);
	}
	
	@FXML
	void handleCancelAction(MouseEvent event) throws IOException {
		returnPane(nowvo);
	}

	@FXML
	void handleConfirmAction(MouseEvent event) throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date DateObj = null;
		try {
			DateObj = dateFormat.parse(birthTextField.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserVO newvo = new UserVO(typeChoiceBox.getValue(),userNameTextField.getText(),nameTextField.getText(),nowvo.ID,nowvo.passWord,
				phoneTextField.getText(),nowvo.credit,DateObj,companyTextField.getText(),nowvo.hotelID,nowvo.hotelAddress);
		
		ResultMessage message = WebManagerController.getInstance().modify(newvo);
		if (message == ResultMessage.SUCCESS) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览客户信息界面.fxml").openStream());
			WebManagerCheckCustomer webController = (WebManagerCheckCustomer) fxmlLoader.getController();
			webController.changeContent(newvo);
			ChangePane.getInstance().turn(mypane);
		}
	}
}
