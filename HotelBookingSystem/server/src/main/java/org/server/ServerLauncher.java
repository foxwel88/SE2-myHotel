package org.server;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ServerLauncher extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/main.fxml"));
			Pane root = loader.load();
			ServerUtil.getInstance().setParent(root);
			Scene scene = new Scene(root,750,550);
			primaryStage.setTitle("酒店预订管理系统 - 服务器");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);		
	}

}
