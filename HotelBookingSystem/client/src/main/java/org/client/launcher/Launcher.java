package org.client.launcher;


import org.client.rmi.RMIHelper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * 登录
 *
 */
public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/登录界面.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root,450,550);
			primaryStage.setTitle("酒店预订管理系统");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		RMIHelper.getInstance().init();
		launch(args);		
	}
	
	public void exit() {
		
	}
}
