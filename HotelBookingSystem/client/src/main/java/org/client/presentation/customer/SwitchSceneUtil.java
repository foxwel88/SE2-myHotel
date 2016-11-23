package org.client.presentation.customer;

import java.io.IOException;

import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blstub.User_stub;
import org.client.vo.UserVO;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwitchSceneUtil {
	static Stage stage = null;
	
	static UserController userController;
	
	static PromotionController promotionController;
	
	static String userID;
	
	private static void setStage(Stage stage) {
		SwitchSceneUtil.stage = stage;
	}

	private static void setUser(String userID) {
		SwitchSceneUtil.userID = userID;
	}
	
	/**
	 * 初始化工具类信息
	 * @param stage primaryStage
	 * @param userID 当前登录客户的标识ID
	 */
	public static void init(Stage stage, String userID) {
		userController = UserController.getInstance();
		promotionController = PromotionController.getInstance();
		setStage(stage);
		setUser(userID);
	}
	
	// TODO 现在用的还是User_Stub
	public static UserVO getVO() {
		User_stub stub = new User_stub();
		return stub.findbyID(userID);
//		return userController.findbyID(userID);
	}
	
	/*
	 * 这个方法是唯一一个需要实例化后使用的方法，方法实现了页面跳转的逻辑
	 */
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
