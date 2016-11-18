package org.client.presentation.hotelmanager;

import java.util.List;

import org.client.blservice.commentblservice.Commentblservice;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.Comment_stub;
import org.client.blstub.Hotel_stub;
import org.client.blstub.Order_stub;
import org.client.blstub.Promotion_stub;
import org.client.blstub.User_stub;
import org.client.vo.PromotionVO;

/**
 * 酒店工作人员界面的总Controller，负责调用Logic层的方法
 * @author Hirico
 *
 */
public class HotelManagerController {
	private Userblservice userbl;
	
	private Hotelblservice hotelbl;
	
	private Promotionblservice promotionbl;
	
	private Orderblservice orderbl;
	
	private Commentblservice commentbl;
	
	private static HotelManagerController controller;
	
	private String hotelAddress;
	
	private HotelManagerController(String hotelAddress) { // stub version
		userbl = new User_stub();
		hotelbl = new Hotel_stub();
		promotionbl = new Promotion_stub();
		commentbl = new Comment_stub();
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
	
	public List<PromotionVO> getPromotions() {
		return promotionbl.showHotelPromotion(hotelAddress);
	}
	
	
}
