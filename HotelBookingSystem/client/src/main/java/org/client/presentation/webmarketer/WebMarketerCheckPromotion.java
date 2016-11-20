package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * FXML Controller
 * 网站营销人员-管理网站促销策略
 *
 */
public class WebMarketerCheckPromotion {
	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private AnchorPane creditPane;

	@FXML
    private AnchorPane levelPane;

	@FXML
    private AnchorPane mainPane;

	@FXML
    private AnchorPane orderPane;
	
	@FXML
    void initialize() {
        assert creditPane != null : "fx:id=\"creditPane\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
        assert levelPane != null : "fx:id=\"levelPane\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
        assert orderPane != null : "fx:id=\"orderPane\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
	}
	
	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		AnchorPane source = (AnchorPane)event.getSource();

		if (source == creditPane) {
			root = FXMLLoader.load(getClass().getResource("/网站营销人员/信用充值界面.fxml"));
		} else if (source == levelPane) {
			root = FXMLLoader.load(getClass().getResource("/网站营销人员/修改会员等级制度界面.fxml"));
		} else if (source == mainPane) {
			root = FXMLLoader.load(getClass().getResource("/网站营销人员/网站营销人员主界面.fxml"));
		} else if (source == orderPane) {
			root = FXMLLoader.load(getClass().getResource("/网站营销人员/浏览异常订单界面.fxml"));
		}
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)creditPane.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
