package org.client.presentation.webmarketer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.LevelVO;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WebMarketerModifyLevel {
	
	/**
	 * 起始页码
	 */
	private static final int FIRST_PAGE_NUM = 1;
	
	/**
	 * 每个页面上的等级数量
	 */
	private static final int NUM_OF_LEVEL_PER_PAGE = 5;
	
	/**
	 * 最大页数
	 */
	private static final int MAX_PAGE_NUM = 4;
	
	private static final int MAX_LEVEL_NUM = 20;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button cancelButton;

	@FXML
	private Button confirmButton;

	@FXML
	private Label prevPage;

	@FXML
	private Label pageNumLabel;

	@FXML
	private Label nextPage;

	@FXML
	private TextField jumpField;
	
	@FXML
	private GridPane contentGridPane;
	
	@FXML
	private Label resultLabel;
	
	/**
	 * 当前页码
	 */
	private int pageNum;
	
	/**
	 * 各等级所需信用值的list
	 */
	private List<Double> credits; 
	
	/**
	 * 当前页面显示的levelPane
	 */
	private List<LevelPane> currentLevelPanes;
	
	/**
	 * 所有的levelPane
	 */
	private List<LevelPane> allLevelPanes;
	
	/**
	 * 所有的levelPane的copy，为了实现cancel
	 */
	private List<LevelPane> allLevelPanesCopy;
	
	private WebMarketerController controller;

	@FXML
	void handleCancel(MouseEvent event) {
		// 清空修改
		allLevelPanes.clear();
		// 将修改前保存的副本复制到list中
		for (int i = 0; i < allLevelPanesCopy.size(); i++) {
			LevelPane before = allLevelPanesCopy.get(i);
			LevelPane now = new LevelPane(before.levelNum, before.getCredit());
			allLevelPanes.add(now);
		}
		// 更改界面显示，并跳转到第一页
		switchCurrentPage(FIRST_PAGE_NUM);
	}

	@FXML
	void handleConfirm(MouseEvent event) {
		// 检查格式
		boolean flag = false;
		for (int i = 1; i < allLevelPanes.size(); i++) {
			if (allLevelPanes.get(i).getCredit() <= allLevelPanes.get(i - 1).getCredit()) {
				flag = true;
				break;
			}
		}
		if (flag) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT);
			return;
		}
		// 获得levelVO
		int levelNum = 0;
		ArrayList<Double> credits = new ArrayList<>();
		for (int i = 0; i < allLevelPanes.size(); i++) {
			if (allLevelPanes.get(i).getCredit() > 0) {
				levelNum++;
				credits.add(allLevelPanes.get(i).getCredit());
			} else {
				break;
			}
		}
		LevelVO levelvo = new LevelVO(levelNum, credits);
		ResultMessage info = controller.modifyLevel(levelvo);
		if (info != ResultMessage.SUCCESS) {
			ResultInfoHelper.setResultLabel(resultLabel, info);
			return;
		}
		// 如果修改成功，将copyList改为修改之后的，即无法取消
		ResultInfoHelper.setResultLabel(resultLabel, info);
		allLevelPanesCopy.clear();
		for (int i = 0; i < allLevelPanes.size(); i++) {
			LevelPane before = allLevelPanes.get(i);
			LevelPane now = new LevelPane(before.levelNum, before.getCredit());
			allLevelPanesCopy.add(now);
		}
	}

	@FXML
	void jumpPage(ActionEvent event) {
		int toPageNum = pageNum;
		try {
			toPageNum = Integer.parseInt(jumpField.getText().trim());
		} catch (RuntimeException e) {
			switchCurrentPage(pageNum);
		}
		if (toPageNum >= FIRST_PAGE_NUM) {					
			switchCurrentPage(toPageNum);
		}
	}

	@FXML
	void toNextPage(MouseEvent event) {
		switchCurrentPage(pageNum + 1);
	}

	@FXML
	void toPrevPage(MouseEvent event) {
		// 检查是否有上一页
		if (pageNum > FIRST_PAGE_NUM) {
			switchCurrentPage(pageNum - 1);
		}
	}
	
	void switchCurrentPage(int toPageNum) {
		// 修改currentNamePanes和currentDetailPanes
		currentLevelPanes = new ArrayList<>();
		// 当前页面要显示的第一个等级制度在list中的位置
		int fromNum = (toPageNum - 1) * NUM_OF_LEVEL_PER_PAGE;
		// 当前页面要显示的最后一个等级制度在list中的位置
		int toNum = fromNum + NUM_OF_LEVEL_PER_PAGE;
		if (toPageNum > MAX_PAGE_NUM) { // 页数过大
			switchCurrentPage(MAX_PAGE_NUM);
			return;
		}
		for (int i = fromNum; i < toNum; i++) {
			currentLevelPanes.add(allLevelPanes.get(i));
		}

		// 修改contentGridPane
		contentGridPane.getChildren().clear();
		for (int i = 0; i < NUM_OF_LEVEL_PER_PAGE; i++) {
			LevelPane levelPane = currentLevelPanes.get(i);
			contentGridPane.add(levelPane, 0, i * 2);
		}

		// 修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
		jumpField.setText("");
	}

	@FXML
	void initialize() {
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert prevPage != null : "fx:id=\"prevPage\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert pageNumLabel != null : "fx:id=\"pageNumLabel\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert jumpField != null : "fx:id=\"jumpField\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert contentGridPane != null : "fx:id=\"contentGridPane\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '修改会员等级制度界面.fxml'.";
		
		controller = WebMarketerController.getInstance();
		allLevelPanes = new ArrayList<>();
		allLevelPanesCopy = new ArrayList<>();
		credits = controller.getCurrentLevel();
		for (int i = 0; i < MAX_LEVEL_NUM; i++) {
			if (i < credits.size()) {
				allLevelPanes.add(new LevelPane(i + 1, credits.get(i)));
				allLevelPanesCopy.add(new LevelPane(i + 1, credits.get(i)));
			} else {
				allLevelPanes.add(new LevelPane(i + 1, -1));
				allLevelPanesCopy.add(new LevelPane(i + 1, -1));
			}
		}
		switchCurrentPage(FIRST_PAGE_NUM);

	}
	
	class LevelPane extends AnchorPane {
		Text levelName;
		
		TextField credit;
		
		int levelNum;
		
		LevelPane(int levelNum, double creditNum) {
			this.levelNum = levelNum;
			String level = "等级 " + levelNum;
			
			levelName = new Text(level);
			credit = new TextField();
			if (creditNum > 0) {
				credit.setText(String.valueOf(creditNum));
			}
			
			// set effect
			this.setStyle("-fx-background-color:rgba(0,0,0,0.45)");
			levelName.setFont(Font.font("Microsoft YaHei Light", 20));
			levelName.setStyle("-fx-fill: white");
			credit.setFont(Font.font("Microsoft YaHei", 16));
			credit.setStyle("-fx-background-color:rgba(255,255,255,0.1); -fx-text-fill: white");
			
			this.getChildren().add(levelName);
			this.getChildren().add(credit);
			
			// set location
			AnchorPane.setBottomAnchor(levelName, 6.0);
			AnchorPane.setLeftAnchor(levelName, 37.0);
			AnchorPane.setTopAnchor(levelName, 7.0);
			
			AnchorPane.setBottomAnchor(credit, 6.0);
			AnchorPane.setLeftAnchor(credit, 280.0);
			AnchorPane.setRightAnchor(credit, 225.0);
			AnchorPane.setTopAnchor(credit, 6.0);
		}
		
		double getCredit() {
			double creditNum = -1;
			try {
				creditNum = Double.parseDouble(credit.getText());
			} catch (RuntimeException e) {
				
			}
			return creditNum;
		}
		
	}
}
