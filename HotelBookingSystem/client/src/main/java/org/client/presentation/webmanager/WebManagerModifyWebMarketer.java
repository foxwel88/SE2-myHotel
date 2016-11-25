package org.client.presentation.webmanager;

import java.io.IOException;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 网站工作人员-修改网站营销人员
 *
 */
public class WebManagerModifyWebMarketer {
	private UserVO nowvo;
	
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
	
	@FXML
    void handleCancelAction(MouseEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
		WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
		webController.changeContent(nowvo);
		ChangePane.getInstance().turn(mypane);
	}

	@FXML
    void handleModifyAction(MouseEvent event) throws IOException {
		UserVO newvo = new UserVO(nowvo.type,userNameTextField.getText(),nameTextField.getText(),nowvo.ID,nowvo.passWord,
				phoneTextField.getText(),nowvo.credit,nowvo.birthday,nowvo.companyName,nowvo.hotelAddress);
		
		ResultMessage message = WebManagerController.getInstance().modify(newvo);
		if (message == ResultMessage.SUCCESS) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent mypane = fxmlLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml").openStream());
			WebManagerCheckWebMarketer webController = (WebManagerCheckWebMarketer) fxmlLoader.getController();
			webController.changeContent(newvo);
			ChangePane.getInstance().turn(mypane);
		}
	}
}
