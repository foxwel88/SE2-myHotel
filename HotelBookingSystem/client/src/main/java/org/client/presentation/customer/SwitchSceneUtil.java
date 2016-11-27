package org.client.presentation.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blstub.Hotel_stub;
import org.client.blstub.Order_stub;
import org.client.blstub.User_stub;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.OrderType;

import javafx.fxml.FXMLLoader;
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
	
	static PromotionController promotionController;
	
	// 记录当前登录客户的客户ID
	static String userID;
	
	// 记录客户最近一次浏览（可能正在浏览）的详细订单的订单号
	static String orderID;
	
	// 记录客户最近一次浏览（可能正在浏览）的酒店的地址
	static String hotelAddress;
	
	// 临时保存即将生成的订单的vo，用于把订单信息从生成订单界面传递到确认订单界面
	static OrderVO toBeGeneratedOrder;
	
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
	public static UserVO getUserVO() {
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
	
	// TODO 现在用的还是Order_stub
	public static OrderVO getCurrentOrder() {
		Order_stub stub = new Order_stub();
		return stub.getOrder(orderID);
	}
	
	// TODO 现在用的还是Hotel_stub
	public static ArrayList<HotelVO> getFilteredHotels(HotelFilter filter, boolean historyOnly) {
		Hotel_stub stub = new Hotel_stub();
		return stub.findHotels(filter, userID, historyOnly);
	}
	
	// TODO 现在用的还是Hotel_stub
	public static ArrayList<CityVO> getCities() {
		Hotel_stub stub = new Hotel_stub();
		return new ArrayList<>(stub.getCitys());
	}
	
	// TODO 现在用的还是Hotel_stub
	public static ArrayList<AreaVO> getAreas() {
		Hotel_stub stub = new Hotel_stub();
		ArrayList<AreaVO> allAreas = new ArrayList<>();
		ArrayList<CityVO> allCities = getCities();
		for (CityVO vo : allCities) {
			allAreas.addAll(stub.getAreas(vo));
		}
		return allAreas;
	}
	
	// TODO 现在用的还是Hotel_stub
	public static HotelVO getHotelVO() {
		Hotel_stub stub = new Hotel_stub();
		return stub.getHotel(hotelAddress);
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
	
	/*
	 * 以下界面跳转的方法都是用来跳转到需要初始化信息的界面的，都会调用到上面的turnToAnotherScene方法
	 */
	/**
	 * 此方法用于跳转到详细订单界面
	 * @param gridpane
	 * @param resource 被加载的界面样式，由订单类型决定
	 * @param orderID 某条订单的订单号
	 */
	public static void turnToDetailedOrderScene(GridPane gridpane, String resource, String orderID) {
		SwitchSceneUtil.orderID = orderID;
		turnToAnotherScene(gridpane, resource);
	}
	
	/**
	 * 此方法用于跳转到详细酒店信息界面
	 * @param gridpane
	 * @param hotelAddress 期望观看酒店的地址
	 */
	public static void turnToDetailedHotelScene(GridPane gridpane, String hotelAddress) {
		SwitchSceneUtil.hotelAddress = hotelAddress;
		turnToAnotherScene(gridpane, "/客户/酒店详细信息界面-1.fxml");
	}
	
	/**
	 * 此方法用于跳转到生成订单界面
	 * @param gridpane
	 * @param hotelAddress 期望观看酒店的地址
	 */
	public static void turnToGenerateOrderScene(GridPane gridpane, String hotelAddress) {
		SwitchSceneUtil.hotelAddress = hotelAddress;
		turnToAnotherScene(gridpane, "/客户/生成订单界面.fxml");
	}
	
	/**
	 * 此方法用于跳转到确认订单界面
	 * @param gridpane
	 * @param orderVO
	 */
	public static void turnToConfirmOrderScene(GridPane gridpane, OrderVO orderVO) {
		SwitchSceneUtil.toBeGeneratedOrder = orderVO;
		turnToAnotherScene(gridpane, "/客户/生成订单确认界面.fxml");
	}
	
	/**
	 * 此方法用于从确认订单界面返回生成订单界面
	 * @param gridpane
	 */
	public static void returnToGenerateOrderScene(GridPane gridpane) {
		turnToAnotherScene(gridpane, "/客户/生成订单界面.fxml");
	}
}
