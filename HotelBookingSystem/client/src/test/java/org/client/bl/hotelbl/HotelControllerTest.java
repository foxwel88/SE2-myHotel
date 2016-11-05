package org.client.bl.hotelbl;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.Order_stub;
import org.client.blstub.User_stub;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;
import org.easymock.*;

public class HotelControllerTest extends EasyMockSupport {
	
	HotelController controller;
	
	HotelUtil util;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();	
		org.client.rmi.RMIHelper.getInstance().init();
		controller = HotelController.getInstance();
		util = strictMock(HotelUtil.class);
		controller.util = util;
	}

	@Test
	public void testFindHotels() {
		HotelFilter filter = new HotelFilter();
		filter.setLocation("南京", "仙林中心");
		filter.setPrice(-1, 1000);
		filter.setRank(1, 5);
		Orderblservice orderstub = new Order_stub();
		controller.setOrderblservice(orderstub);
		
		//record the whole processing path
		util.getHotelList(filter);
		replayAll();
				
		//verify step
		List<HotelVO> hotels = null;
		try {
			hotels = controller.findHotels(filter, "小红", true);
			assertEquals(false, hotels.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		verifyAll();
		
		//assert
		assertEquals(false, hotels.isEmpty());
	}
	
	@Test
	public void testAddHotel() {		
		HotelVO vo = new HotelVO("lovelive", "unknown", "南京", "仙林中心", "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", 0, 10, null);
		Userblservice userstub = new User_stub();
		controller.setUserblservice(userstub);
		
		//record 
		expect(util.addHotel(vo)).andReturn(ResultMessage.SUCCESS);
		replayAll();
		
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		verifyAll();
		
		//assert
		assertEquals(ResultMessage.SUCCESS, result);
	}
	
	@Test
	public void testAddHotel2() {		
		HotelVO vo = new HotelVO("", "unknown", "南京", "仙林中心", "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", 0, 10, null);
		Userblservice userstub = new User_stub();
		controller.setUserblservice(userstub);
		
		//record 
		expect(util.addHotel(vo)).andReturn(ResultMessage.WRONGFORMAT);
		replayAll();
		
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		verifyAll();
		
		//assert
		assertEquals(ResultMessage.WRONGFORMAT, result);
	}
	
	@Test
	public void testModifyHotel() {		
		List<String> roomType = new ArrayList<String>(Arrays.asList(new String[]{"九人房"}));
		List<Integer> roomNum = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
		List<Double> roomPrice = new ArrayList<Double>(Arrays.asList(new Double[]{21.21}));
		List<String> cooperators = new ArrayList<String>(Arrays.asList(new String[]{"μ's"}));
		HotelVO vo = new HotelVO("lovelive", "unknown", "南京", "仙林中心", "niconiconi", 5, 5, "", "", roomType, roomNum, roomPrice, cooperators);
		HotelVO vo2 = new HotelVO("123", "unknown", "", "仙林中心", "niconiconi", 5, 5, "", "", roomType, roomNum, roomPrice, cooperators);
		
		//record
		expect(util.modify(vo)).andReturn(ResultMessage.SUCCESS);
		expect(util.modify(vo2)).andReturn(ResultMessage.WRONGFORMAT);
		replayAll();
		
		//verify and assert
		ResultMessage result = controller.modifyHotel(vo);	
		assertEquals(ResultMessage.SUCCESS, result);
		result = controller.modifyHotel(vo2);
		assertEquals(ResultMessage.WRONGFORMAT, result);
		verifyAll();
	}
	
	@Test
	public void testChangeRoom() {
		ResultMessage result = controller.changeRoom(RoomType.DOUBLE, 2, "123");
		assertEquals(ResultMessage.SUCCESS, result);
	}
	
	@Test
	public void testGetVO() {
		//record
		util.getHotel("123");
		replayAll();
		
		//verify and assert
		HotelVO vo = controller.getHotelVO("123");
		assertEquals(false, vo.address.isEmpty());
		verifyAll();
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
