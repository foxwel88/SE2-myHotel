package org.client.bl.hotelbl;

import org.client.bl.orderbl.OrderController;
import org.client.bl.userbl.UserController;
import org.common.utility.HotelFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.server.rmi.RMIHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.easymock.Mock;

@RunWith(EasyMockRunner.class)
public class HotelControllerTest extends EasyMockSupport {
	@TestSubject
	HotelController controller;
	
	@Mock
	UserController userMock;
	
	@Mock
	OrderController orderMock;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();
		controller = HotelController.getInstance();
		controller.setOrderblservice(orderMock);
		controller.setUserblservice(userMock);
	}

	@Test
	public void testFindHotels() {
		HotelFilter filter = new HotelFilter();
		filter.setLocation("南京", "仙林中心");
		filter.setPrice(-1, 1000);
		filter.setRank(1, 5);
		
		//replay()
		controller.findHotels(filter, "小红", true);
		//assertEquals();
	}
	
	@Test
	public void testAddHotel() {
		
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
