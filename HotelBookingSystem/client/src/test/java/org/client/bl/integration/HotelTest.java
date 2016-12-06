package org.client.bl.integration;

import mySQL.DatabaseCommunicator;
import org.client.bl.hotelbl.HotelController;
import org.client.bl.orderbl.OrderController;
import org.client.bl.userbl.UserController;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.userblservice.Userblservice;
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

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 调用酒店模块bl接口的集成测试，所用类均为真实类
 * @author Hirico
 * @version 2016/12/06 Hirico
 */
public class HotelTest {

	HotelController controller;

	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();

		DatabaseCommunicator.databaseInit();
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("USE test ");
			DatabaseCommunicator.execute(preparedStatement);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		controller = HotelController.getInstance();
	}

	@Test
	public void testFindHotels() {
		HotelFilter filter = new HotelFilter();
		filter.setLocation("南京", "新街口");
		Orderblservice orderController = OrderController.getInstance();
		controller.setOrderblservice(orderController);

		List<HotelVO> hotels  = null;
		try {
			hotels = controller.findHotels(filter, null, false);
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
		HotelVO vo = new HotelVO(null,"lovelive", "unknown", city, area, "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", "", "unknown");
		Userblservice userController = UserController.getInstance();
		controller.setUserblservice(userController);

		//verify
		ResultMessage result = controller.addHotel(vo, uvo);

		//assert
		assertEquals(ResultMessage.SUCCESS, result);
	}

	@Test
	public void testAddHotel2() {
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("仙林中心");
		HotelVO vo = new HotelVO(null,"blabla", "unknown", city, area, "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", null, "unknown");
		Userblservice userController = UserController.getInstance();
		controller.setUserblservice(userController);

		//verify
		ResultMessage result = controller.addHotel(vo, uvo);

		//assert
		assertEquals(ResultMessage.EXIST, result);
	}

	@Test
	public void testChangeRoom() {
		ResultMessage resultIncrease = controller.increaseAvailableRoom(RoomType.DOUBLE, "00001");
		ResultMessage resultDecrease = controller.decreaseAvailableRoom(RoomType.DOUBLE, "00001");
		assertEquals(ResultMessage.SUCCESS, resultIncrease);
		assertEquals(ResultMessage.SUCCESS, resultDecrease);
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
