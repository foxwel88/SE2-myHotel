package org.client.presentation.webmanager;


import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.Hotel_stub;
import org.client.blstub.User_stub;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

public class WebManagerController {
	
	private Hotelblservice hotelbl;
	
	private Userblservice userbl;
	
	private static WebManagerController controller;
	
	private WebManagerController() {
		hotelbl = new Hotel_stub();
		userbl = new User_stub();
	}
	
	public static WebManagerController getInstance() {
		if (controller == null) {
			controller = new WebManagerController();
		}
		return controller;
	}
	
	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		return hotelbl.addHotel(hotelVO, userVO);
	}
	
	public ResultMessage add(UserVO vo) {
		return userbl.add(vo);
	}
	
	public UserVO findbyID(String ID) {
		return userbl.findbyID(ID);
	}
	
	public UserVO findbyUserName(String userName) {
		return userbl.findbyUserName(userName);
	}
	
	public ResultMessage modify(UserVO vo) {
		return userbl.modify(vo);
	}
	
}
