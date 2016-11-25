package org.client.presentation.customer;

import java.io.IOException;
import java.util.List;

import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blstub.Order_stub;
import org.client.blstub.User_stub;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.OrderType;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SwitchSceneUtil {
	static Stage stage = null;
	
	static UserController userController;
	
	static PromotionController promotionController;
	
	// 记录当前登录客户的客户ID
	static String userID;
	
	// 记录客户最近一次浏览（可能正在浏览）的详细订单的订单号
	static String orderID;
	
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
	
	// TODO 现在用的还是Order_Stub
	public static List<OrderVO> getFinishedOrderList() {
		Order_stub stub = new Order_stub();
		return stub.getUserOrderList(userID, OrderType.EXECUTED);
	}
	
	// TODO 现在用的还是Order_Stub
	public static List<OrderVO> getCanceledOrderList() {
		Order_stub stub = new Order_stub();
		return stub.getUserOrderList(userID, OrderType.CANCELED);
	}
	
	// TODO 现在用的还是Order_Stub
	public static List<OrderVO> getAbnormalOrderList() {
		Order_stub stub = new Order_stub();
		return stub.getUserOrderList(userID, OrderType.ABNORMAL);
	}
	
	// TODO 现在用的还是Order_Stub
	public static List<OrderVO> getUnExcutedOrderList() {
		Order_stub stub = new Order_stub();
		return stub.getUserOrderList(userID, OrderType.UNEXECUTED);
	}
	
	public static OrderVO getCurrentOrder() {
		Order_stub stub = new Order_stub();
		return stub.getOrder(orderID);
	}
	
	/**
	 * 此方法用于实现不同FXML文件所描述的界面之间的界面跳转
	 * @param gridpane
	 * @param resource
	 */
	public static void turnToAnotherScene(GridPane gridpane, String resource) {
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
	
	/**
	 * 此方法overload了上面的方法，用于跳转到需要特殊初始化信息的界面（详细订单界面）
	 * @param gridpane
	 * @param resource 被加载的界面样式，由订单类型决定
	 * @param orderID 某条订单的订单号
	 */
	public static void turnToAnotherScene(GridPane gridpane, String resource, String orderID) {
		SwitchSceneUtil.orderID = orderID;
		turnToAnotherScene(gridpane, resource);
	}
}
