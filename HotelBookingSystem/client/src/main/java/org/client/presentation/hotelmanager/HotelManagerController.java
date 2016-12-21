package org.client.presentation.hotelmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.orderbl.OrderController;
import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.PromotionVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * 酒店工作人员界面的总Controller，负责调用Logic层的方法
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerController {
	
	private Hotelblservice hotelbl;
	
	private Promotionblservice promotionbl;
	
	private Orderblservice orderbl;

	private Userblservice userbl;
	
	private static HotelManagerController controller;
	
	public String hotelID;

	public String hotelName;

	public String hotelAddress;

	public String managerUserName;
	
	public String managerName;
	
	public OrderVO currentOrder;
	
	//stub version
	private HotelManagerController(String hotelID, String managerName, String managerUserName) {
		hotelbl = HotelController.getInstance();
		promotionbl = PromotionController.getInstance();
		orderbl = OrderController.getInstance();
		userbl = UserController.getInstance();
		this.hotelID = hotelID;
		this.managerName = managerName;
		this.managerUserName = managerUserName;

		HotelVO hotelVO = getHotelInfo();
		this.hotelName = hotelVO.hotelName;
		this.hotelAddress = hotelVO.address;
	}
	
	/** 登录之后就要马上调用这个方法 */
	public static void init(String hotelID, String managerName, String managerUserName) {
		controller = new HotelManagerController(hotelID, managerName, managerUserName);
	}
	
	public static HotelManagerController getInstance() {
		return controller;
	}

	public void logOut() {
		userbl.logout(managerUserName);
	}
	
	public List<OrderVO> getUnexecutedOrders() {
		return orderbl.getHotelOrderList(hotelID, OrderType.UNEXECUTED);
	}
	
	public List<OrderVO> getExecutedOrders() {
		return orderbl.getHotelOrderList(hotelID, OrderType.EXECUTED);
	}
	
	public List<OrderVO> getCancelledOrders() {
		return orderbl.getHotelOrderList(hotelID, OrderType.CANCELED);
	}
	
	public List<OrderVO> getAbnormalOrders() {
		return orderbl.getHotelOrderList(hotelID, OrderType.ABNORMAL);
	}

	public List<OrderVO> getOfflineOrders() {
		return orderbl.getHotelOrderList(hotelID, OrderType.OFFLINE);
	}
	
	public List<PromotionVO> getPromotions() {
		return promotionbl.showHotelPromotion(hotelID);
	}
	
	public HotelVO getHotelInfo() {
		return hotelbl.getHotelVO(hotelID);
	}
	
	public ResultMessage modifyHotel(HotelVO vo) {
		return hotelbl.modifyHotel(vo);
	}

	/**把从logic层拿上来的vo换成string */
	public List<String> getCitys() {
		List<CityVO> voList = hotelbl.getCitys();
		List<String> result = new ArrayList<>();
		for (CityVO v: voList) {
			result.add(v.cityName);
		}
		return result;
	}

	/**把从logic层拿上来的vo换成string */
	public List<String> getAreas(String cityName) {
		List<AreaVO> voList = hotelbl.getAreas(new CityVO(cityName));
		List<String> result = new ArrayList<>();
		for (AreaVO v: voList) {
			result.add(v.address);
		}
		return result;
	}
	
	public ResultMessage executeOrder() {
		return orderbl.executeOrder(currentOrder.orderID);
	}
	
	public ResultMessage addPromotion(PromotionVO vo) {
		return promotionbl.add(vo);
	}
	
	public ResultMessage modifyPromotion(PromotionVO vo) {
		return promotionbl.modify(vo);
	}
	
	/**酒店可用房间数量增加，增加订单退房时间 */
	public ResultMessage checkOut() {
		ResultMessage result = orderbl.checkOut(currentOrder.orderID);
		currentOrder = orderbl.getOrder(currentOrder.orderID);
		return result;
	}

	public int getBookedRoomNum(RoomType type, Date from, Date to) {
		return orderbl.getBookedRoomNum(hotelID, type, from, to);
	}

	public ResultMessage addOfflineOrder(OrderVO vo) {
		return orderbl.createOffLineOrder(vo);
	}

	public void deletePromotion(String promotionID) {
		promotionbl.delete(promotionID);
	}
}
