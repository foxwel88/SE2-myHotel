package org.client.bl.hotelbl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.client.bl.userbl.UserController;
import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.Order_stub;
import org.client.blstub.User_stub;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.server.rmi.RMIHelper;
import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;

public class HotelControllerTest extends EasyMockSupport {
	
	@Rule
    public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	HotelController controller = HotelController.getInstance();
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();	
		org.client.rmi.RMIHelper.getInstance().init();
		controller = HotelController.getInstance();
		
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
				
		//verify step
		List<HotelVO> hotels = controller.findHotels(filter, "小红", true);
		
		assertEquals(false, hotels.isEmpty());
	}
	
	@Test
	public void testAddHotel() {
		
		//List<String> roomType = new ArrayList<String>(Arrays.asList(new String[]{"九人房"}));
		//List<Integer> roomNum = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
		//List<Double> roomPrice = new ArrayList<Double>(Arrays.asList(new Double[]{21.21}));
		//List<String> cooperators = new ArrayList<String>(Arrays.asList(new String[]{"μ's"}));
		HotelVO vo = new HotelVO("lovelive", "unknown", "南京", "仙林中心", "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", 0, 10, null);
		Userblservice userstub = new User_stub();
		controller.setUserblservice(userstub);
		
		//record 
		
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		
		assertEquals(ResultMessage.SUCCESS, result);
	}
	
	@Test
	public void testAddHotel2() {
		
		//List<Integer> roomNum = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
		//List<Double> roomPrice = new ArrayList<Double>(Arrays.asList(new Double[]{21.21}));
		//List<String> cooperators = new ArrayList<String>(Arrays.asList(new String[]{"μ's"}));
		HotelVO vo = new HotelVO("", "unknown", "南京", "仙林中心", "niconiconi", 5, 5, "", "", null, null, null, null);
		UserVO uvo = new UserVO("客户", "X", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", 0, 10, null);
		Userblservice userstub = new User_stub();
		controller.setUserblservice(userstub);
		
		//record 
		
		//verify
		ResultMessage result = controller.addHotel(vo, uvo);
		
		assertEquals(ResultMessage.WRONGFORMAT, result);
	}
	
	@Test
	public void testModifyHotel() {
		
	}
	
	@Test
	public void testChangeRoom() {
		
	}
	
	@Test
	public void testGetVO() {
		
	}
	
	@Test
	public void testArea() {
		
	}
	
	@Test
	public void testCity() {
		
	}
	
	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
