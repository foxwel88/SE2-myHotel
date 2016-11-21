package org.client.presentation.customer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwitchSceneUtil {
	static Stage stage = null;
	
	public static void setStage(Stage stage) {
		SwitchSceneUtil.stage = stage;
	}
	
	public void turnToAnotherScene(GridPane gridpane, String resource) {
		try {
			AnchorPane root = FXMLLoader.load(SwitchSceneUtil.class.getResource(resource));
			GridPane.setConstraints(root, 1, 0);
			if (gridpane.getChildren().size() > 1) {
				gridpane.getChildren().set(1, root);
			} else {
				gridpane.getChildren().add(1, root);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
