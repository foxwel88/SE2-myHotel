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
 * 网站工作人员-修改网站营销人员
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class WebManagerModifyWebMarketer {
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

	/*
	返回上一界面恢复内容的操作
	 */
	public void returnPane(UserVO vo) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent myPane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
		WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
		webController.changeContent(vo);
		ChangePane.getInstance().turn(myPane);
	}

	/*
    取消修改按钮监听
	*/
	@FXML
    void handleCancelAction(MouseEvent event) throws IOException {
		returnPane(nowvo);
	}

	/*
	格式检查
	*/
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

	/*
    确认修改按钮监听
	*/
	@FXML
    void handleModifyAction(MouseEvent event) throws IOException {
		if (check()) {
			UserVO newvo = new UserVO(nowvo.type,userNameTextField.getText(),nameTextField.getText(),nowvo.ID,nowvo.passWord,
					phoneTextField.getText(),nowvo.credit,nowvo.birthday,nowvo.companyName,nowvo.hotelID, nowvo.hotelAddress);
			
			ResultMessage message = WebManagerController.getInstance().modify(newvo);
			
			
			if (message == ResultMessage.WRONG_USERNAME) {
				resultLabel.setText("用户名已存在");
			}
			
			
			if (message == ResultMessage.SUCCESS) {
				resultLabel.setText("修改成功");
				FXMLLoader fxmlLoader = new FXMLLoader();
				Parent myPane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
				WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
				webController.changeContent(newvo);
				ChangePane.getInstance().turn(myPane);
			}
		}
	}
	
	@FXML
	void initialize() {
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file '修改网站营销人员界面.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file '修改网站营销人员界面.fxml'.";
        assert phoneTextField != null : "fx:id=\"phoneTextField\" was not injected: check your FXML file '修改网站营销人员界面.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '修改网站营销人员界面.fxml'.";
	}
}
