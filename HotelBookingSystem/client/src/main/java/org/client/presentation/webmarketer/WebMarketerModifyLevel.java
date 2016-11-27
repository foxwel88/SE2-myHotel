package org.client.presentation.webmarketer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.client.vo.LevelVO;
import org.common.utility.ResultMessage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 
 * FXML Controller
 * 网站营销人员-修改会员等级制度界面
 * @author gyue
 * @version 2016/11/27
 *
 */
public class WebMarketerModifyLevel {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private TextField levelOneTextField;

	@FXML
    private TextField levelTwoTextField;

	@FXML
    private TextField levelThreeTextField;

	@FXML
    private TextField levelFourTextField;

	@FXML
    private TextField levelFiveTextField;

	@FXML
    private Button cancelButton;

	@FXML
    private Button confirmButton;
	
	private WebMarketerController controller;
	
	private final int MAX_LEVEL_NUM = 5;
	
	@FXML
    void initialize() {
		assert levelOneTextField != null : "fx:id=\"levelOneTextField\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert levelTwoTextField != null : "fx:id=\"levelTwoTextField\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert levelThreeTextField != null : "fx:id=\"levelThreeTextField\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert levelFiveTextField != null : "fx:id=\"levelFiveTextField\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		
		controller = WebMarketerController.getInstance();
		
		setCurrentLevel();
	}

	@FXML
    void cancelButtom(MouseEvent event) {
		setCurrentLevel();
	}

	@FXML
    void handleConfirm(MouseEvent event) {
		// get contents in terms of string
		String[] levels = new String[MAX_LEVEL_NUM];
		levels[0] = levelOneTextField.getText();
		levels[1] = levelTwoTextField.getText();
		levels[2] = levelThreeTextField.getText();
		levels[3] = levelFourTextField.getText();
		levels[4] = levelFiveTextField.getText();
		
		// change string to integer
		int[] levelNums = new int[]{-1, -1, -1, -1, -1};
		for (int i = 0; i < MAX_LEVEL_NUM; i++) {
			if ((levels[i] != "") && (levels[i] != " --- ")) {
				try {
					levelNums[i] = Integer.parseInt(levels[i]);
				} catch (RuntimeException e) {
					// TODO warning window
					return;
				}
			}
		}
		
		// check integrity of input
		boolean flag = false;
		for (int i = 0; i < MAX_LEVEL_NUM; i++) {
			if (flag) {
				if (levelNums[i] != -1) {
					// TODO warning window
					return;
				}
				if (levelNums[i] == -1) {
					flag = true;
				}
			}
		}
		
		// modify level
		int levelNum = 0;
		while ((levelNums[levelNum] != -1) && (levelNum <= 5)) {
			levelNum++;
		}
		ArrayList<Integer> credits = new ArrayList<>();
		for (int i = 0; i < levelNum; i++) {
			credits.add(levelNums[i]);
		}
		LevelVO levelVO = new LevelVO(levelNum, credits);
		ResultMessage info = controller.modifyLevel(levelVO);
		if (info != ResultMessage.SUCCESS) { // check
			// TODO warning window
			return;
		}
		
		// update content
		setCurrentLevel();
	}
	
	private void setCurrentLevel() {
		String[] levels = controller.getCurrentLevel();
		levelOneTextField.setText(levels[0]);
		levelTwoTextField.setText(levels[1]);
		levelThreeTextField.setText(levels[2]);
		levelFourTextField.setText(levels[3]);
		levelFiveTextField.setText(levels[4]);
	}
	
}
