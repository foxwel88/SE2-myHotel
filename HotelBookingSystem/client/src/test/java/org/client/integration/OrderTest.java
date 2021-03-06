
package org.client.integration;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.client.bl.orderbl.OrderController;
import org.client.blstub.User_stub;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;
import org.server.util.mysql.DatabaseCommunicator;


public class OrderTest {
	OrderController controller;
	
	OrderVO vo1 = new OrderVO("0000000001",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest1","13919191919",false,false);
	
	OrderVO vo2 = new OrderVO("0000000002",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest2","13919191919",false,false);
	
	OrderVO vo3 = new OrderVO("0000000003",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest3","13919191919",false,false);

	String orderID1 = null;
	
	String orderID2 = null;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		DatabaseCommunicator.setTestConnection();
		controller = OrderController.getInstance();
		controller.setUserblservice(new User_stub());
	}

	@Test
	public void testGetOrder1() {
		OrderVO vo = controller.getOrder("123456789020080606143055");
		//assert
		assertEquals("123456789020080606143055",vo.orderID);
		assertEquals("朗廷酒店",vo.hotelName);
	}
	
	@Test
	public void testGetOrder2() {
		OrderVO vo = controller.getOrder("123456789020090606130505");
		//assert
		assertEquals("123456789020090606130505",vo.orderID);
		assertEquals("朗廷酒店",vo.hotelName);
	}
	
	@Test
	public void testGetAbnormalOrder() {
		
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getAbnormalOrder();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("异常订单", orderList.get(i).type);
		}
		
	}
	
	@Test
	public void testGetUserOrderList1() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getUserOrderList("1234567890", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("未执行订单", orderList.get(i).type);
			assertEquals("1234567890", orderList.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList2() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getUserOrderList("1234567890", OrderType.EXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("已执行订单", orderList.get(i).type);
			assertEquals("1234567890", orderList.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList3() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getUserOrderList("1234567890", OrderType.ABNORMAL);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("异常订单", orderList.get(i).type);
			assertEquals("1234567890", orderList.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList4() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getUserOrderList("1234567890", OrderType.CANCELED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("已撤销订单", orderList.get(i).type);
			assertEquals("1234567890", orderList.get(i).userID);
		}
	}
	
	@Test
	public void testGetHotelOrderList1() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getHotelOrderList("00001", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("未执行订单", orderList.get(i).type);
			assertEquals("00001", orderList.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList2() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getHotelOrderList("00001", OrderType.EXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("已执行订单", orderList.get(i).type);
			assertEquals("00001", orderList.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList3() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getHotelOrderList("00001", OrderType.ABNORMAL);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("异常订单", orderList.get(i).type);
			assertEquals("00001", orderList.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList4() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getHotelOrderList("00001", OrderType.CANCELED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderList.isEmpty());
		//assert
		for (int i = 0; i < orderList.size(); ++i) {
			assertEquals("已撤销订单", orderList.get(i).type);
			assertEquals("00001", orderList.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHistoryHotels1() {
		List<String> hotellist = null;
		
		try {
			hotellist = controller.getHistoryHotels("1234567890");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotellist.isEmpty());
		for (int i = 0; i < hotellist.size(); ++i) {
			assertEquals("00001", hotellist.get(i));
		}
	}
	
	@Test
	public void testCreateOrder1() {
		ResultMessage message = controller.createOrder(vo3);
		List<OrderVO> orderList = controller.getUserOrderList("0000000003", OrderType.UNEXECUTED);

		//assert
		assertEquals(ResultMessage.SUCCESS, message);
		assertEquals(false, orderList.isEmpty());
	}

	@Test
	public void testCancelOrder1() {
		ResultMessage message1 = controller.createOrder(vo1);
		List<OrderVO> orderList = controller.getUserOrderList("0000000001", OrderType.UNEXECUTED);
		String orderID = orderList.get(orderList.size() - 1).orderID;
		ResultMessage message2 = controller.cancelOrder(orderID);
		OrderVO vo = controller.getOrder(orderID);
		
		//assert
		assertEquals(ResultMessage.SUCCESS, message1);
		assertEquals(ResultMessage.SUCCESS, message2);
		assertEquals("已撤销订单", vo.type);
	}
	
	@Test
	public void testExecuteOrder1() {
		ResultMessage message1 = controller.createOrder(vo2);
		List<OrderVO> orderList = controller.getUserOrderList("0000000002", OrderType.UNEXECUTED);
		String orderID = orderList.get(orderList.size() - 1).orderID;
		ResultMessage message2 = controller.executeOrder(orderID);
		OrderVO vo = controller.getOrder(orderID);
		
		//assert
		assertEquals(ResultMessage.SUCCESS, message1);
		assertEquals(ResultMessage.SUCCESS, message2);
		assertEquals("已执行订单", vo.type);
	}

	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
