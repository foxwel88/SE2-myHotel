package org.client.presentation.hotelmanager;

import java.util.Date;
import java.util.List;

import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.blstub.Hotel_stub;
import org.client.blstub.Order_stub;
import org.client.blstub.Promotion_stub;
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
 *
 */
public class HotelManagerController {
	
	private Hotelblservice hotelbl;
	
	private Promotionblservice promotionbl;
	
	private Orderblservice orderbl;
	
	private static HotelManagerController controller;
	
	private String hotelAddress;
	
	public OrderVO currentOrder;
	
	//stub version
	private HotelManagerController(String hotelAddress) { 
		hotelbl = new Hotel_stub();
		promotionbl = new Promotion_stub();
		orderbl = new Order_stub();
		this.hotelAddress = hotelAddress;
	}
	
	/*should be called right after login */
	public static void init(String hotelAddress) {
		controller = new HotelManagerController(hotelAddress);
	}
	
	public static HotelManagerController getInstance() throws NullPointerException {
		if (controller == null) {
			throw new NullPointerException();
		}
		return controller;
	}
	
	public List<OrderVO> getUnexecutedOrders() {
		return orderbl.getHotelOrderList(hotelAddress, OrderType.UNEXECUTED);
	}
	
	public List<OrderVO> getExecutedOrders() {
		return orderbl.getHotelOrderList(hotelAddress, OrderType.EXECUTED);
	}
	
	public List<OrderVO> getCancelledOrders() {
		return orderbl.getHotelOrderList(hotelAddress, OrderType.CANCELED);
	}
	
	public List<OrderVO> getAbnormalOrders() {
		return orderbl.getHotelOrderList(hotelAddress, OrderType.ABNORMAL);
	}
	
	public List<PromotionVO> getPromotions() {
		return promotionbl.showHotelPromotion(hotelAddress);
	}
	
	public HotelVO getHotelInfo() {
		return hotelbl.getHotelVO(hotelAddress);
	}
	
	public ResultMessage modifyHotel(HotelVO vo) {
		return hotelbl.modifyHotel(vo);
	}
	
	public List<CityVO> getCitys() {
		return hotelbl.getCitys();
	}
	
	public List<AreaVO> getAreas(CityVO vo) {
		return hotelbl.getAreas(vo);
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
	
	//Need orderbl's modify method 
	public ResultMessage checkout(Date checkoutDate) {
		currentOrder.actTo = checkoutDate;
		hotelbl.decreaseAvailableRoom(RoomType.getType(currentOrder.roomType), hotelAddress);
		return ResultMessage.SUCCESS;
	}
	
	
}
