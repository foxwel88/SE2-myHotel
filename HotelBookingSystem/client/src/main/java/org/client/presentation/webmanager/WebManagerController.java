package org.client.presentation.webmanager;


import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.HotelBlService;
import org.client.blservice.userblservice.UserBlService;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

/**
 * 
 * 负责WebManager对应逻辑的方法接口
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 *
 */

public class WebManagerController {
	
	UserVO nowvo;
	
	private HotelBlService hotelbl;
	
	private UserBlService userbl;
	
	String userID;
	
	private static WebManagerController controller;
	
	private WebManagerController() {
		hotelbl = HotelController.getInstance();
		userbl = UserController.getInstance();
	}
	
	public static WebManagerController getInstance() {
		if (controller == null) {
			controller = new WebManagerController();
		}
		return controller;
	}
	
	public void init(String userID) {
		this.userID = userID;
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
	
	public UserLevelVO getLevel(String ID) {
		return userbl.getLevel(ID);
	}
	
	public List<CityVO> getCitys() {
		return hotelbl.getCitys();
	}
	
	public List<AreaVO> getAreas(CityVO vo) {
		return hotelbl.getAreas(vo);
	}
	
	public ResultMessage logOut() {
		return userbl.logout(userbl.findbyID(userID).userName);
	}
}
