package org.client.presentation.webmarketer;

import java.net.URL;
import java.util.ResourceBundle;

import org.client.presentation.util.ResultInfoHelper;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * 
 * FXML Controller
 * 网站营销人员-信用充值界面
 * @author gyue
 * @version 2016/11/27 gyue
 *
 */
public class WebMarketerModifyCredit {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField searchTextField;

	@FXML
    private Button searchButton;

	@FXML
    private Text nameText;

	@FXML
    private Text idText;

	@FXML
    private Text currentCreditText;

	@FXML
    private TextField addCreditTextField;

	@FXML
    private Button confirmButton;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private Label searchResultLabel;
	
	private WebMarketerController controller;

	@FXML
    void initialize() {
		assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert currentCreditText != null : "fx:id=\"currentCreditText\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert addCreditTextField != null : "fx:id=\"addCreditTextField\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '信用充值界面.fxml'.";
		assert searchResultLabel != null : "fx:id=\"searchResultLabel\" was not injected: check your FXML file '信用充值界面.fxml'.";
		
		setDefaultText();
		
		controller = WebMarketerController.getInstance();
		
	}
	
	@FXML
    void handleConfirm(MouseEvent event) {
		String credit = addCreditTextField.getText();
		if (credit == null) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT);
		}
		
		double creditNum = 0;
		try {
			creditNum = Double.parseDouble(credit);
		} catch (RuntimeException e) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.CONNECTION_FAIL);
		}
		
		ResultMessage info = controller.addCredit(creditNum);
		if (info != ResultMessage.SUCCESS) { // check
			ResultInfoHelper.setResultLabel(resultLabel, info);
			return;
		}
		
		//set content
		String currentCredit = controller.getCurrentCreidt();
		currentCreditText.setText(currentCredit);
		ResultInfoHelper.setResultLabel(resultLabel, info);
		
	}

	@FXML
    void handleSearch(MouseEvent event) {
		String userName = searchTextField.getText();
		
		// initialize the userVO of controller
		ResultMessage info = controller.setUserVO(userName);
		if (info != ResultMessage.SUCCESS) {
			setDefaultText();
			ResultInfoHelper.setResultLabel(searchResultLabel, info);
			return;
		}
		// 搜索成功的话不会显示“成功”的label
		
		// get content
		String userId = controller.getCurrentId();
		String credit = controller.getCurrentCreidt();
		
		// set content
		nameText.setText(userName);
		idText.setText(userId);
		currentCreditText.setText(credit);
	}
	
	private void setDefaultText() {
		nameText.setText(" --- ");
		idText.setText(" --- ");
		currentCreditText.setText(" --- ");
	}

}
