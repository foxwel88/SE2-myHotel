package org.client.launcher;

import org.client.rmi.RMIHelper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = (GridPane)FXMLLoader.load
					(getClass().getResource("test2.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource
					("application.css").toExternalForm());
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
