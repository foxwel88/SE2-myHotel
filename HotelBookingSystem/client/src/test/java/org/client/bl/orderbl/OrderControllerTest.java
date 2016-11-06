package org.client.bl.orderbl;

import static org.junit.Assert.*;
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
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * Orderbl模块集成测试，用到的Orderbl类均为真实类，dao和其它bl模块的类为stub
 *
 */
public class OrderControllerTest {
	
	OrderController controller;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();	
		org.client.rmi.RMIHelper.getInstance().init();
		controller = OrderController.getInstance();
		controller.setUserblservice(new User_stub());
	}

	@Test
	public void testCreateOrder1() {
		
		OrderVO vo = new OrderVO(OrderType.UNEXECUTED.getString(),new Date(),new Date(),new Date(),new Date(),new Date(),
				new Date(),new Date(),"南京市仙林大道168号栖霞大酒店","000000000120161122112233","栖霞大酒店",RoomType.BIG.toString(),100,1,2,false, "foxwel","13919191919");

		ResultMessage result = null;
		
		try {
			result = controller.createOrder(vo);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.SUCCESS, result);
	}
	
	@Test
	public void testCreateOrder2() {
		
		OrderVO vo = new OrderVO(OrderType.UNEXECUTED.getString(),new Date(),new Date(),new Date(),new Date(),new Date(),
				new Date(),new Date(),"南京市仙林大道168号栖霞大酒店","000000000120161122112233","栖霞大酒店",RoomType.BIG.toString(),100,1,2,false, "foxwel","139191919");

		ResultMessage result = null;
		
		try {
			result = controller.createOrder(vo);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.WRONGFORMAT, result);
	}
	
	@Test
	public void testgetOrder1() {
		
		OrderVO vo = null;
		try {
			vo = controller.getOrder("000000000120161122112233");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		//assert
		assertEquals("000000000120161122112233", vo.orderID);
	}
	
	@Test
	public void testgetOrder2() {
		
		OrderVO vo = null;
		
		try {
			vo = controller.getOrder("9999");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.WRONGFORMAT, vo.resultMessage);
	}
	
	@Test
	public void testgetOrder3() {
		
		OrderVO vo = null;
		
		vo = controller.getOrder("000000000120161122112200");
		
		//assert
		assertEquals(ResultMessage.NOTEXIST, vo.resultMessage);
	}
	
	@Test
	public void testGetAbnormalOrder() {
		
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getAbnormalOrder();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, orderlist.isEmpty());
	}
	
	@Test
	public void testGetUserOrderList1() {
		
		List<OrderVO> orderlist = null;
		String username = null;
		
		try {
			orderlist = controller.getUserOrderList("0000000001", OrderType.UNEXECUTED);
			username = orderlist.get(0).customerName;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, orderlist.isEmpty());
		assertEquals("foxwel", username);
	}
	
	@Test
	public void testGetUserOrderList2() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getUserOrderList("0000000002", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(true, orderlist.isEmpty());
	}
	
	@Test
	public void testGetHotelOrderList1() {
		
		List<OrderVO> hotellist = null;
		String hotelAdress = null;
		
		try {
			hotellist = controller.getHotelOrderList("南京市仙林大道168号栖霞大酒店", OrderType.UNEXECUTED);
			hotelAdress = hotellist.get(0).hotelAddress;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotellist.isEmpty());
		assertEquals("南京市仙林大道168号栖霞大酒店", hotelAdress);
	}
	
	@Test
	public void testGetHotelOrderList2() {
		List<OrderVO> hotellist = null;
		
		try {
			hotellist = controller.getHotelOrderList("我不是个酒店", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(true, hotellist.isEmpty());
	}
	
	@Test
	public void testGetHistoryHotels1() {
		List<String> hotellist = null;
		String hoteladdress = null;
		try {
			hotellist = controller.getHistoryHotels("0000000001");
			hoteladdress = hotellist.get(0);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotellist.isEmpty());
		assertEquals("南京市仙林大道168号栖霞大酒店",hoteladdress);
	}
	
	
	@Test
	public void testGetHistoryHotels2() {
		List<String> hotellist = null;
		
		try {
			hotellist = controller.getHistoryHotels("0000001111");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(true, hotellist.isEmpty());
	}
	
	@Test
	public void testCancelOrder1() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.cancelOrder("000000000120161122112233");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.SUCCESS, resultmessage);
	}
	
	@Test
	public void testCancelOrder2() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.cancelOrder("000001234520161122112266");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.NOTEXIST, resultmessage);
	}
	
	@Test
	public void testExecuteOrder1() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.executeOrder("000001234520161122112266");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.SUCCESS, resultmessage);

	}
	
	@Test
	public void testExecuteOrder2() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.executeOrder("000000000120161122112244");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.NOTEXIST, resultmessage);
	}
	
	@Test
	public void testCancelAbnormalOrder1() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.cancelAbnormalOrder("000001234520161122112266",true);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.SUCCESS, resultmessage);

	}
	
	@Test
	public void testCancelAbnormalOrder2() {
		
		ResultMessage resultmessage = null;
		
		try {
			resultmessage = controller.cancelAbnormalOrder("000000000120161122112244",true);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(ResultMessage.NOTEXIST, resultmessage);
	}
	
	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
