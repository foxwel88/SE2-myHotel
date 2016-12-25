package org.client.launcher;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.client.rmi.RMIHelper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Foxwel on 2016/12/21.
 */
public class ModifyIPController {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField ipTextField;

	@FXML
    private Button cancelButton;

	@FXML
    private Button confirmButton;

	@FXML
    void handleCancelAction(MouseEvent event) {
		turnToLogin();
	}

	@FXML
    void handleConfirmAction(MouseEvent event) {
		RMIHelper.getInstance().setIP(ipTextField.getText());
		RMIHelper.getInstance().init();
		turnToLogin();
	}

	void turnToLogin() {
		Resources resources = Resources.getInstance();
		Stage stage = (Stage)ipTextField.getScene().getWindow();
		Parent root = null;
		try {
			root = resources.load(resources.login);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	@FXML
	void initialize() {
	    assert ipTextField != null : "fx:id=\"ipTextField\" was not injected: check your FXML file '设置服务器界面.fxml'.";
	    assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '设置服务器界面.fxml'.";
	    assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '设置服务器界面.fxml'.";
	    	ipTextField.setText(RMIHelper.getInstance().getIP());
	}
}
