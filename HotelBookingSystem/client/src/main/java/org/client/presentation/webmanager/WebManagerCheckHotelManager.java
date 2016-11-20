package org.client.presentation.webmanager;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * 网站工作人员-浏览酒店工作人员信息
 *
 */
public class WebManagerCheckHotelManager {
	@FXML
    private URL location;

	@FXML
    private Label toCustomerLabel;

	@FXML
    private Label toHomeLabel;

	@FXML
    private Label toWebLabel;

	@FXML
    private Label toNewLabel;

	
	@FXML
    void initialize() throws IOException {
        assert toCustomerLabel != null : "fx:id=\"toCustomerLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert toHomeLabel != null : "fx:id=\"toHomeLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert toWebLabel != null : "fx:id=\"toWebLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
        assert toNewLabel != null : "fx:id=\"toNewLabel\" was not injected: check your FXML file '浏览酒店工作人员信息界面.fxml'.";
	}
	
	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		Label source = (Label)event.getSource();

		if (source == toCustomerLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览客户信息界面.fxml"));
		} else if (source == toHomeLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/网站管理人员主界面.fxml"));
		} else if (source == toWebLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/浏览网站营销人员信息界面.fxml"));
		} else if (source == toNewLabel) {
			root = FXMLLoader.load(getClass().getResource("/网站管理人员/新增酒店界面.fxml"));
		}
		
		Scene scene = new Scene(root,1099,680);
		Stage stage = (Stage)toCustomerLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
