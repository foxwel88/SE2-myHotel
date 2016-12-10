package org.client.presentation.customer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.orderbl.OrderController;
import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.launcher.Resources;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.CreditRecordVO;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * 客户-工具类
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class SwitchSceneUtil {
	static Stage stage = null;
	
	static UserController userController;
	
	static OrderController orderController;
	
	static HotelController hotelController;
	
	static PromotionController promotionController;
	
	// 记录当前登录客户的客户ID
	static String userID;
	
	// 记录客户最近一次浏览（可能正在浏览）的详细订单的订单号
	static String orderID;
	
	// 记录客户最近一次浏览（可能正在浏览）的酒店的ID
	static String hotelID;
	
	// 临时保存即将生成的订单的vo，用于把订单信息从生成订单界面传递到确认订单界面
	static OrderVO toBeGeneratedOrder;
	
	// 调用返回方法的时候此字段被临时置为true，接下来跳转到的界面会访问这个属性，发现此属性为true则说明此界面是被返回回来的，则执行额外的初始化操作
	static boolean isBack = false;
	
	// 生成订单界面可能返回酒店列表界面，也可能返回酒店详细信息界面，因此需要这个字段进行记录
	static boolean isBackToDetail = false;
	
	/*
	 * 下面三条属性用于记录返回上一界面所需要的信息
	 */
	// 记录当前显示的界面，便于返回方法（CustomerController_Main::goBack()）使用
	static CustomerBackableScene currentScene;
	
	static PreviousHotelSceneInfo previousHotelSceneInfo;
	
	static PreviousOrderSceneInfo previousOrderSceneInfo;
	/********************************************/
	
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
		orderController = OrderController.getInstance();
		hotelController = HotelController.getInstance();
		setStage(stage);
		setUser(userID);
	}
	
	public static UserVO getUserVO() {
		return userController.findbyID(userID);
	}
	
	public static ArrayList<CreditRecordVO> getRecordList() {
		return (ArrayList<CreditRecordVO>)userController.findCreditRecord(userID);
	}
	
	public static ResultMessage modifyPassword(String oldPassword, String newPassword) {
		return userController.modifyPassword(getUserVO().userName, oldPassword, newPassword);
	}
	
	public static ResultMessage modifyInfo(UserVO vo) {
		return userController.modify(vo);
	}
	
	public static List<OrderVO> getFinishedOrderList() {
		return orderController.getUserOrderList(userID, OrderType.EXECUTED);
	}
	
	public static List<OrderVO> getCanceledOrderList() {
		return orderController.getUserOrderList(userID, OrderType.CANCELED);
	}
	
	public static List<OrderVO> getAbnormalOrderList() {
		return orderController.getUserOrderList(userID, OrderType.ABNORMAL);
	}
	
	public static List<OrderVO> getUnExcutedOrderList() {
		return orderController.getUserOrderList(userID, OrderType.UNEXECUTED);
	}
	
	public static OrderVO getCurrentOrder() {
		return orderController.getOrder(orderID);
	}
	
	public static ArrayList<HotelVO> getFilteredHotels(HotelFilter filter, boolean historyOnly) {
		return (ArrayList<HotelVO>)hotelController.findHotels(filter, userID, historyOnly);
	}
	
	public static ArrayList<CityVO> getCities() {
		return new ArrayList<>(hotelController.getCitys());
	}
	
	public static ArrayList<AreaVO> getAreas() {
		ArrayList<AreaVO> allAreas = new ArrayList<>();
		ArrayList<CityVO> allCities = getCities();
		for (CityVO vo : allCities) {
			allAreas.addAll(hotelController.getAreas(vo));
		}
		return allAreas;
	}
	
	public static HotelVO getHotelVO() {
		return hotelController.getHotelVO(hotelID);
	}
	
	/**
	 * 跳转到可能执行返回上一界面的操作的界面时被调用，记录目标界面的名称
	 * @param currentScene
	 */
	public static void savePreviousScene(CustomerBackableScene currentScene) {
		SwitchSceneUtil.currentScene = currentScene;
	}
	
	/**
	 * 跳转到可能执行返回上一界面的操作的界面时被调用，记录目标界面的名称和前一界面的信息
	 * @param currentScene
	 * @param previousHotelSceneInfo
	 */
	public static void savePreviousScene(CustomerBackableScene currentScene, PreviousHotelSceneInfo previousHotelSceneInfo) {
		SwitchSceneUtil.currentScene = currentScene;
		SwitchSceneUtil.previousHotelSceneInfo = previousHotelSceneInfo;
	}
	
	/**
	 * 跳转到可能执行返回上一界面的操作的界面时被调用，记录目标界面的名称和前一界面的信息
	 * @param currentScene
	 * @param previousOrderSceneInfo
	 */
	public static void savePreviousScene(CustomerBackableScene currentScene, PreviousOrderSceneInfo previousOrderSceneInfo) {
		SwitchSceneUtil.currentScene = currentScene;
		SwitchSceneUtil.previousOrderSceneInfo = previousOrderSceneInfo;
	}
	
	/**
	 * 此方法用于实现不同FXML文件所描述的界面之间的界面跳转
	 * @param gridpane
	 * @param resource
	 */
	public static void turnToAnotherScene(GridPane gridpane, URL resource) {
		try {
			Resources resources = Resources.getInstance();
			AnchorPane root = (AnchorPane)resources.load(resource);
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
	
	/*
	 * 以下界面跳转的方法都是用来跳转到需要初始化信息的界面的，都会调用到上面的turnToAnotherScene方法
	 */
	/**
	 * 此方法用于跳转到详细订单界面
	 * @param gridpane
	 * @param resource 被加载的界面样式，由订单类型决定
	 * @param orderID 某条订单的订单号
	 */
	public static void turnToDetailedOrderScene(GridPane gridpane, URL resource, String orderID) {
		SwitchSceneUtil.orderID = orderID;
		turnToAnotherScene(gridpane, resource);
	}
	
	/**
	 * 此方法用于跳转到详细酒店信息界面
	 * @param gridpane
	 * @param hotelID 期望观看酒店的ID
	 */
	public static void turnToDetailedHotelScene(GridPane gridpane, String hotelID) {
		Resources resources = Resources.getInstance();
		SwitchSceneUtil.hotelID = hotelID;
		turnToAnotherScene(gridpane, resources.customerCheckHotel);
	}
	
	/**
	 * 此方法用于跳转到生成订单界面
	 * @param gridpane
	 * @param hotelID 期望观看酒店的ID
	 */
	public static void turnToGenerateOrderScene(GridPane gridpane, String hotelID) {
		Resources resources = Resources.getInstance();
		SwitchSceneUtil.hotelID = hotelID;
		turnToAnotherScene(gridpane, resources.customerGenerateOrder);
	}
	
	/**
	 * 此方法用于跳转到确认订单界面
	 * @param gridpane
	 * @param orderVO
	 */
	public static void turnToConfirmOrderScene(GridPane gridpane, OrderVO orderVO) {
		Resources resources = Resources.getInstance();
		SwitchSceneUtil.toBeGeneratedOrder = orderVO;
		turnToAnotherScene(gridpane, resources.customerConfirmGenerateOrder);
	}
	
	/**
	 * 此方法用于从确认订单界面返回生成订单界面
	 * @param gridpane
	 */
	public static void returnToGenerateOrderScene(GridPane gridpane) {
		Resources resources = Resources.getInstance();
		turnToAnotherScene(gridpane, resources.customerGenerateOrder);
	}
}
