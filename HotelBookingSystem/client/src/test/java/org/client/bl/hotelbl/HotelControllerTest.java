package org.client.bl.hotelbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.OrderBlService;
import org.client.blservice.userblservice.UserBlService;
import org.client.blstub.Order_stub;
import org.client.blstub.User_stub;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * hotelbl模块集成测试，用到的hotelbl类均为真实类，dao和其它bl模块的类为stub
 * @author Hirico
 *
 */
public class HotelControllerTest {
	
	HotelController controller;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		controller = HotelController.getInstance();
	}

	@Test
	public void testFindHotels() {
		HotelFilter filter = new HotelFilter();
		filter.setLocation("南京", "新街口");
		OrderBlService orderstub = new Order_stub();
		controller.setOrderblservice(orderstub);
				
		List<HotelVO> hotels = null;
		try {
			hotels = controller.findHotels(filter, "1234567890", false);
			assertEquals(false, hotels.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotels.isEmpty());
	}
	
	@Test
	public void testAddHotel() {	
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("仙林中心");
		HotelVO vo = new HotelVO("123","lovelive", "unknown", city, area, "niconiconi", 5, 5, "", "", null, null, null, null, "");
		UserVO uvo = new UserVO("酒店工作人员", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μs", null, null);
		UserBlService userstub = new User_stub();
		controller.setUserblservice(userstub);
		
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		
		//assert
		assertEquals(ResultMessage.SUCCESS, result);
	}
	
	@Test
	public void testAddHotel2() {
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("仙林中心");
		HotelVO vo = new HotelVO("","", "unknown", city, area, "niconiconi", 5, 5, "", "", null, null, null, null, "");
		UserVO uvo = new UserVO("酒店工作人员", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μs", null, null);
		UserBlService userstub = new User_stub();
		controller.setUserblservice(userstub);
				
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		
		//assert
		assertEquals(ResultMessage.WRONG_FORMAT, result);
	}
	
	@Test
	public void testModifyHotel() {	
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("仙林中心");
		List<String> roomType = new ArrayList<String>(Arrays.asList(new String[]{"单人间"}));
		List<Integer> roomNum = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
		List<Double> roomPrice = new ArrayList<Double>(Arrays.asList(new Double[]{21.21}));
		List<String> cooperators = new ArrayList<String>(Arrays.asList(new String[]{"μ's"}));
		HotelVO vo = new HotelVO("00001","lovelive", "unknown", city, area, "niconiconi", 5, 5, "", "", roomType, roomNum, roomPrice, cooperators, "");
		HotelVO vo2 = new HotelVO("00002", "123", "unknown", new CityVO(""), area, "niconiconi", 5, 5, "", "", roomType, roomNum, roomPrice, cooperators, "");
		
		//verify and assert
		ResultMessage result = controller.modifyHotel(vo);	
		assertEquals(ResultMessage.SUCCESS, result);
		result = controller.modifyHotel(vo2);
		assertEquals(ResultMessage.WRONG_FORMAT, result);
	}
	
	@Test
	public void testGetVO() {		
		//verify and assert
		HotelVO vo = controller.getHotelVO("00001");
		assertEquals(false, vo.city.cityName.isEmpty());
	}
	
	@Test
	public void testArea() {
		List<AreaVO> list = controller.getAreas(new CityVO("南京"));
		assertEquals(false, list.get(0).address.isEmpty());
	}
	
	@Test
	public void testCity() {
		List<CityVO> list = controller.getCitys();
		assertEquals(false, list.get(0).cityName.isEmpty());
	}
	
	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
