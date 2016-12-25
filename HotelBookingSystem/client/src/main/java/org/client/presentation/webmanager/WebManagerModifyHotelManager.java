package org.client.presentation.webmanager;

import java.io.IOException;

import org.client.presentation.util.CheckStyle;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-修改酒店工作人员信息
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class WebManagerModifyHotelManager {
	private UserVO nowvo;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private TextField userNameTextField;
	
	@FXML
    private TextField nameTextField;

	@FXML
    private TextField phoneTextField;

	void changeContent(UserVO vo) {
		nowvo = vo;
		userNameTextField.setText(nowvo.userName);
		nameTextField.setText(nowvo.name);
		phoneTextField.setText(nowvo.phoneNumber);
	}
	
	void returnPane(UserVO vo) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览酒店工作人员信息界面.fxml").openStream());
		WebManagerCheckHotelManager webController = (WebManagerCheckHotelManager) fxmlLoader.getController();
		webController.changeContent(vo);
		ChangePane.getInstance().turn(mypane);
	}
	
	@FXML
    void handleCancelAction(MouseEvent event) throws IOException {
		returnPane(nowvo);
	}

	boolean check() {

		if (! CheckStyle.checkUsername(userNameTextField.getText())) {
			resultLabel.setText("用户名格式不正确");
			return false;
		}
		
		if (! CheckStyle.checkName(nameTextField.getText())) {
			resultLabel.setText("请填写姓名");
			return false;
		}
		if (! CheckStyle.checkPhone(phoneTextField.getText())) {
			resultLabel.setText("手机号格式不正确");
			return false;
		}
		return true;
	}
	
	@FXML
    void handleModifyAction(MouseEvent event) throws IOException {
		if (check()) {
			UserVO newvo = new UserVO(nowvo.type,userNameTextField.getText(),nameTextField.getText(),nowvo.ID,nowvo.passWord,
					phoneTextField.getText(),nowvo.credit,nowvo.birthday,nowvo.companyName,nowvo.hotelID,nowvo.hotelAddress);
			
			ResultMessage message = WebManagerController.getInstance().modify(newvo);
			
			if (message == ResultMessage.WRONG_USERNAME) {
				resultLabel.setText("用户名已存在");
			}
			
			if (message == ResultMessage.SUCCESS) {
				resultLabel.setText("修改成功");
				FXMLLoader fxmlLoader = new FXMLLoader();
				Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览酒店工作人员信息界面.fxml").openStream());
				WebManagerCheckHotelManager webController = (WebManagerCheckHotelManager) fxmlLoader.getController();
				webController.changeContent(newvo);
				ChangePane.getInstance().turn(mypane);
			}
		}
	}
	
}
