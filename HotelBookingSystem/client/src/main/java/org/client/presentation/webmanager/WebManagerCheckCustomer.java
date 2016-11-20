package org.client.presentation.webmanager;

import java.io.IOException;
import java.net.URL;

import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * 网站工作人员-浏览客户信息
 *
 */
public class WebManagerCheckCustomer {

	private WebManagerController controller;
	
	@FXML
	private AnchorPane anchorpane;
	
	@FXML
	private GridPane gridpane;
	
	@FXML
    private URL location;

	@FXML
	private Label PorCLabel;
	
	@FXML
    private Label toHomeLabel;

	@FXML
    private Label toHotelLabel;

	@FXML
    private Label toWebLabel;

	@FXML
    private Label toNewLabel;

	@FXML
    private Label nameLabel;

	@FXML
    private Label phoneLabel;

	@FXML
    private Label userNameLabel;

	@FXML
    private TextField userNameTextField;

	@FXML
    private Button searchButton;

	@FXML
    private Button modifyButton;

	@FXML
    private Label creditLabel;

	@FXML
    private Label levelLabel;

	@FXML
    private Label birthLabel;

	@FXML
    private Label typeLabel;




	@FXML
    void initialize() {
		controller = WebManagerController.getInstance();
        assert toHomeLabel != null : "fx:id=\"toHomeLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert toHotelLabel != null : "fx:id=\"toHotelLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert toWebLabel != null : "fx:id=\"toWebLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert toNewLabel != null : "fx:id=\"toNewLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert phoneLabel != null : "fx:id=\"phoneLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert creditLabel != null : "fx:id=\"creditLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert levelLabel != null : "fx:id=\"levelLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert birthLabel != null : "fx:id=\"birthLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
        assert typeLabel != null : "fx:id=\"typeLabel\" was not injected: check your FXML file '浏览客户信息界面.fxml'.";
		nameLabel.setText("");
		phoneLabel.setText("");
		userNameLabel.setText("");
		creditLabel.setText("");
		typeLabel.setText("");
		birthLabel.setText("");
	}

	
	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		Label source = (Label)event.getSource();

		if (source == toHomeLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/网站管理人员主界面.fxml"));
		} else if (source == toHotelLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览酒店工作人员信息界面.fxml"));
		} else if (source == toWebLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml"));
		} else if (source == toNewLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/新增酒店界面.fxml"));
		}
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)toHomeLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	void handleModifyAction(MouseEvent event) throws IOException {
		/*
		Parent root = FXMLLoader.load(getClass().getResource("/网站管理人员/修改客户信息界面.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)toHomeLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		*/
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("/网站管理人员/temp.fxml"));
		gridpane.getChildren().set(1,root);
		GridPane.setConstraints(root, 1, 0);
	}
	
	@FXML
	void handleSearchAction(MouseEvent event) {
		UserVO vo = controller.findbyUserName(userNameTextField.getText());
		if (vo.resultMessage == ResultMessage.SUCCESS) {
			nameLabel.setText(vo.name);
			phoneLabel.setText(vo.phoneNumber);
			userNameLabel.setText(vo.userName);
			creditLabel.setText(Double.toString(vo.credit));
			typeLabel.setText(vo.type);
			if (vo.type.equals("个人客户")) {
				birthLabel.setText(vo.birthday.toString());
			} else {
				PorCLabel.setText("企业名称");
				birthLabel.setText(vo.companyName);
			}
		}
	}
}
