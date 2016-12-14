package module.hotel;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
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
import org.server.id.IDUtil;
import org.server.mySQL.DatabaseCommunicator;
import org.server.rmi.RMIHelper;

/**
 * hotel模块集成测试，用到的hotelbl类和hoteldao均为真实类，其它模块的类为stub
 * @author Hirico
 * @version 2016/12/08 Hirico
 */
public class HotelModuleTest {

	HotelController controller;

	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();

		DatabaseCommunicator.setTestConnection();
		controller = HotelController.getInstance();
	}

	@Test
	public void testFindHotels() {
		HotelFilter filter = new HotelFilter();
		filter.setLocation("南京", "新街口");
		filter.setPrice(-1, 1000);
		filter.setRank(1, 5);
		Orderblservice orderstub = new Order_stub();
		controller.setOrderblservice(orderstub);

		List<HotelVO> hotels = controller.findHotels(filter, null, false);
		assertTrue(!hotels.isEmpty());
	}

	@Test
	public void testAddHotel() throws RemoteException {
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("仙林中心");
		HotelVO vo = new HotelVO(null,"lovelive", org.client.rmi.RMIHelper.getInstance().getIDUtil().generateNewHotelID(), city, area, "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", null, "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", null, "unknown");
		Userblservice userstub = new User_stub();
		controller.setUserblservice(userstub);

		ResultMessage result = controller.addHotel(vo, uvo);

		assertEquals(ResultMessage.SUCCESS, result);
	}

	@Test
	public void testModifyHotel() {
		CityVO city = new CityVO("南京");
		AreaVO area = new AreaVO("新街口");
		List<String> roomType = new ArrayList<String>(Arrays.asList(new String[]{"单人间"}));
		List<Integer> roomNum = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
		List<Double> roomPrice = new ArrayList<Double>(Arrays.asList(new Double[]{21.21}));
		List<String> cooperators = new ArrayList<String>(Arrays.asList(new String[]{"μs"}));
		HotelVO vo = new HotelVO("00001","lovelive", "unknown", city, area, "niconiconi", 5, 5, null, null, roomType, roomNum, roomPrice, cooperators);

		ResultMessage result = controller.modifyHotel(vo);
		assertEquals(ResultMessage.SUCCESS, result);
	}

	@Test
	public void testChangeRoom() {
		controller.increaseAvailableRoom(RoomType.SINGLE, "00001", 1);
		ResultMessage result = controller.decreaseAvailableRoom(RoomType.SINGLE, "00001", 1);
		assertEquals(ResultMessage.SUCCESS, result);
	}

	@Test
	public void testGetVO() {
		//verify and assert
		HotelVO vo = controller.getHotelVO("00001");
		assertTrue(!vo.city.cityName.isEmpty());
	}

	@Test
	public void testArea() {
		List<AreaVO> list = controller.getAreas(new CityVO("南京"));
		assertTrue(!list.get(0).address.isEmpty());
	}

	@Test
	public void testCity() {
		List<CityVO> list = controller.getCitys();
		assertTrue(!list.get(0).cityName.isEmpty());
	}

	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
