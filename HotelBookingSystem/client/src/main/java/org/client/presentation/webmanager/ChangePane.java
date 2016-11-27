package org.client.presentation.webmanager;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

/**
 * 
 * webmanage.ChangePane类负责网站管理人员的界面跳转
 * 提供界面跳转的方法
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 *
 */

public class ChangePane {
	private static ChangePane changepane;
	
	private GridPane mainPane;
	
	private ChangePane() {
		
	}
	
	public static ChangePane getInstance() {
		if (changepane == null) {
			changepane = new ChangePane();
		}
		return changepane;
	}
	
	public void setMainPane(GridPane pane) {
		this.mainPane = pane;
	}
	
	//跳转页面
	public void turn(Parent turntopane) {
		mainPane.getChildren().set(1, turntopane);
		GridPane.setConstraints(turntopane, 1, 0);
	}
}
