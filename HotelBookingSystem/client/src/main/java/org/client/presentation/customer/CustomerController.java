package org.client.presentation.customer;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.client.bl.commentbl.CommentController;
import org.client.bl.hotelbl.HotelController;
import org.client.bl.orderbl.OrderController;
import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blservice.commentblservice.CommentBlService;
import org.client.blservice.hotelblservice.HotelBlService;
import org.client.blservice.orderblservice.OrderBlService;
import org.client.blservice.promotionblservice.PromotionBlService;
import org.client.blservice.userblservice.UserBlService;
import org.client.launcher.Resources;
import org.client.rmi.RMIHelper;
import org.client.vo.*;
import org.common.utility.HotelFilter;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * 客户界面-负责界面跳转(逻辑和动画)和界面向下调用logic层方法的controller
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class CustomerController {
	static Stage stage = null;
	
	static Customer_Guide customerGuideController;
	
	static UserBlService userBlService;
	
	static OrderBlService orderBlService;
	
	static HotelBlService hotelBlService;
	
	static PromotionBlService promotionBlService;
	
	static CommentBlService commentBlService;
	
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
	
	// 当此属性为true时，goBack操作才会被允许
	static boolean canBack = false;
	
	/*
	 * 下面三条属性用于记录返回上一界面所需要的信息
	 */
	// 记录当前显示的界面，便于返回方法（CustomerController_Main::goBack()）使用
	static CustomerBackableScene currentScene;
	
	static PreviousHotelSceneInfo previousHotelSceneInfo;
	
	static PreviousOrderSceneInfo previousOrderSceneInfo;
	/********************************************/
	
	private static void setStage(Stage stage) {
		CustomerController.stage = stage;
	}

	private static void setUser(String userID) {
		CustomerController.userID = userID;
	}
	
	/**
	 * 初始化工具类信息
	 * @param stage primaryStage
	 * @param userID 当前登录客户的标识ID
	 */
	public static void init(Stage stage, String userID) {
		userBlService = UserController.getInstance();
		promotionBlService = PromotionController.getInstance();
		orderBlService = OrderController.getInstance();
		hotelBlService = HotelController.getInstance();
		commentBlService = CommentController.getInstance();
		setStage(stage);
		setUser(userID);
	}
	
	public static UserVO getUserVO() {
		return userBlService
				.findbyID(userID);
	}
	
	public static List<CreditRecordVO> getRecordList() {
		return userBlService.findCreditRecord(userID);
	}
	
	public static ResultMessage modifyPassword(String oldPassword, String newPassword) {
		return userBlService
				.modifyPassword(getUserVO().userName, oldPassword, newPassword);
	}
	
	public static ResultMessage modifyInfo(UserVO vo) {
		return userBlService
				.modify(vo);
	}
	
	public static List<OrderVO> getFinishedOrderList() {
		return orderBlService.getUserOrderList(userID, OrderType.EXECUTED);
	}
	
	public static List<OrderVO> getCanceledOrderList() {
		return orderBlService.getUserOrderList(userID, OrderType.CANCELED);
	}
	
	public static List<OrderVO> getAbnormalOrderList() {
		return orderBlService.getUserOrderList(userID, OrderType.ABNORMAL);
	}
	
	public static List<OrderVO> getUnExecutedOrderList() {
		return orderBlService.getUserOrderList(userID, OrderType.UNEXECUTED);
	}
	
	public static ArrayList<OrderVO> getFinishedOrderListOfCurrentHotel() {
		ArrayList<OrderVO> allFinishedOrder = (ArrayList<OrderVO>)getFinishedOrderList();
		ArrayList<OrderVO> hotelFinishedOrder = new ArrayList<>();
		for (int i = 0; i < allFinishedOrder.size(); i++) {
			if (allFinishedOrder.get(i).hotelID.equals(hotelID)) {
				hotelFinishedOrder.add(allFinishedOrder.get(i));
			}
		}
		return hotelFinishedOrder;
	}
	
	public static ArrayList<OrderVO> getCanceledOrderListOfCurrentHotel() {
		ArrayList<OrderVO> allCanceledOrder = (ArrayList<OrderVO>)getCanceledOrderList();
		ArrayList<OrderVO> hotelCanceledOrder = new ArrayList<>();
		for (int i = 0; i < allCanceledOrder.size(); i++) {
			if (allCanceledOrder.get(i).hotelID.equals(hotelID)) {
				hotelCanceledOrder.add(allCanceledOrder.get(i));
			}
		}
		return hotelCanceledOrder;
	}

	public static int calculateLevel(double credit) {
		return promotionBlService.calculateLevel(credit);
	}

	/**添加评论，会添加评论的持久化对象，以及对订单做标记 */
	public static ResultMessage addComment(double rankValue, String commentContent) {
		CommentVO commentVO = null;
		try {
			commentVO = new CommentVO(getUserVO().userName, hotelID, orderID, RMIHelper.getInstance().getTimeServiceImpl().getDate()
								, rankValue, commentContent);
			OrderController.getInstance().comment(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return commentBlService.addComment(commentVO);
	}

	public static List<OrderVO> getAbnormalOrderListOfCurrentHotel() {
		List<OrderVO> allAbnormalOrder = getAbnormalOrderList();
		List<OrderVO> hotelAbnormalOrder = new ArrayList<>();
		for (int i = 0; i < allAbnormalOrder.size(); i++) {
			if (allAbnormalOrder.get(i).hotelID.equals(hotelID)) {
				hotelAbnormalOrder.add(allAbnormalOrder.get(i));
			}
		}
		return hotelAbnormalOrder;
	}
	
	public static int getLeftRoomNum(Date from, Date to, String hid, String roomTypeString) {
		return hotelBlService.getAvailableRoomNum(from, to, hid, RoomType.getType(roomTypeString));
	}

	public static List<PromotionVO> getBestPromotions(String hotelID, String userID, int num) {
		return promotionBlService.getPromotion(hotelID, userID, num);
	}

	public static int getAvailableRoomNum(Date from, Date to, String hotelID, RoomType type) {
		return hotelBlService.getAvailableRoomNum(from, to, hotelID, type);
	}

	public static HotelVO getHotelVO(String hotelID) {
		return hotelBlService.getHotelVO(hotelID);
	}

	public static ResultMessage cancelOrder(String orderID) {
		return orderBlService.cancelOrder(orderID);
	}

	/**获得某房间类型原价 */
	public static double getSingleRoomPrice(RoomType roomType) {
		List<Double> priceList = hotelBlService.getHotelVO(hotelID).roomPrice;
		switch (roomType) {
			case SINGLE:
				return priceList.get(0);
			case DOUBLE:
				return priceList.get(1);
			case BIG:
				return priceList.get(2);
		}
		return -1;
	}

	/**促销后的现价 */
	public static double getCurrentPrice(int roomNum, double rawPrice) {
		return promotionBlService.getPrice(userID, hotelID, roomNum, rawPrice);
	}

	/**获得酒店的全部评价 */
	public static List<CommentVO> getComments() {
		return commentBlService.getComment(hotelID);
	}

	/**获得客户当前订单中的评价 */
	public static CommentVO getComment() {
		String hotelID = getCurrentOrder().hotelID;
		List<CommentVO> commentVOList = commentBlService.getComment(hotelID);
		CommentVO commentVO = null;
		for (CommentVO tempVO:commentVOList) {
			if (tempVO.orderID.equals(CustomerController.orderID)) {
				commentVO = tempVO;
				break;
			}
		}
		return commentVO;
	}
	
	public static OrderVO getCurrentOrder() {
		return orderBlService.getOrder(orderID);
	}
	
	public static List<HotelVO> getFilteredHotels(HotelFilter filter, boolean historyOnly) {
		return hotelBlService.findHotels(filter, userID, historyOnly);
	}
	
	public static List<CityVO> getCities() {
		return new ArrayList<>(hotelBlService.getCitys());
	}
	
	public static List<AreaVO> getAreas(String city) {
		CityVO cityVO = new CityVO(city);
		return hotelBlService.getAreas(cityVO);
	}
	
	public static HotelVO getHotelVO() {
		return hotelBlService.getHotelVO(hotelID);
	}

	public static List<String> getAdvertisedHotels() {
		return promotionBlService.getAdvertisedHotels();
	}
	
	public static ResultMessage commitOrder(OrderVO orderVO) {
		return orderBlService.createOrder(orderVO);
	}
	
	/**
	 * 跳转到可能执行返回上一界面的操作的界面时被调用，记录目标界面的名称
	 * @param currentScene
	 */
	public static void savePreviousScene(CustomerBackableScene currentScene) {
		canBack = true;
		CustomerController.currentScene = currentScene;
	}

	public static List<PromotionVO> getHotelPromotions() {
		return promotionBlService.showHotelPromotion(hotelID);
	}

	public static List<PromotionVO> getWebSitePromotions() {
		return promotionBlService.showWebsitePromotion();
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
		canBack = true;
		CustomerController.orderID = orderID;
		turnToAnotherScene(gridpane, resource);
	}
	
	/**
	 * 此方法用于跳转到详细酒店信息界面
	 * @param gridpane
	 * @param hotelID 期望观看酒店的ID
	 */
	public static void turnToDetailedHotelScene(GridPane gridpane, String hotelID) {
		canBack = true;
		Resources resources = Resources.getInstance();
		CustomerController.hotelID = hotelID;
		turnToAnotherScene(gridpane, resources.customerCheckHotel);
	}
	
	/**
	 * 此方法用于跳转到生成订单界面
	 * @param gridpane
	 * @param hotelID 期望观看酒店的ID
	 */
	public static void turnToGenerateOrderScene(GridPane gridpane, String hotelID) {
		canBack = true;
		Resources resources = Resources.getInstance();
		CustomerController.hotelID = hotelID;
		turnToAnotherScene(gridpane, resources.customerGenerateOrder);
	}
	
	/**
	 * 此方法用于跳转到确认订单界面
	 * @param gridpane
	 * @param orderVO
	 */
	public static void turnToConfirmOrderScene(GridPane gridpane, OrderVO orderVO) {
		canBack = true;
		Resources resources = Resources.getInstance();
		CustomerController.toBeGeneratedOrder = orderVO;
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
	
	public static void showGuideAnimation(AnchorPane root, double startFromY) {
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), root);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.4), root);
		translateTransition.setFromX(-560);
		translateTransition.setFromY(startFromY);
		translateTransition.setToX(0);
		translateTransition.setToY(0);
		
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.4), root);
		scaleTransition.setFromX(0);
		scaleTransition.setFromY(0);
		scaleTransition.setToX(1);
		scaleTransition.setToY(1);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition, scaleTransition);
		parallelTransition.play();
	}
	
	public static void showOldSceneAnimation(AnchorPane root) {
		root.setVisible(true);
		
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.4), root);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.4), root);
		translateTransition.setFromX(0);
		translateTransition.setToX(-500);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition, translateTransition);
		parallelTransition.play();
	}

	public static void showNewSceneAnimation(AnchorPane root) {
		FadeTransition curtainFadeTransition = new FadeTransition(Duration.seconds(0.4), root);
		curtainFadeTransition.setFromValue(0);
		curtainFadeTransition.setToValue(1);
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.4), root);
		translateTransition.setFromX(-500);
		translateTransition.setToX(0);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(curtainFadeTransition, translateTransition);
		parallelTransition.play();
	}

	public static void setGuideController(Customer_Guide controller) {
		CustomerController.customerGuideController = controller;
	}


}
