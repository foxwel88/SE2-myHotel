package org.client.bl.integration;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.client.bl.orderbl.OrderController;
import org.client.blstub.Hotel_stub;
import org.client.blstub.User_stub;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

import mySQL.DatabaseCommunicator;

public class OrderTest {
	OrderController controller;
	
	OrderVO vo1 = new OrderVO("0000000001",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest1","13919191919");
	
	OrderVO vo2 = new OrderVO("0000000002",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest2","13919191919");
	
	OrderVO vo3 = new OrderVO("0000000003",OrderType.UNEXECUTED.getString(),null,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
			"00001","aaaaa某某某大酒店",null,"仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxweltest3","13919191919");

	String orderID1 = null;
	
	String orderID2 = null;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		DatabaseCommunicator.databaseInit();
		controller = OrderController.getInstance();
		controller.setUserblservice(new User_stub());
		controller.setHotelHelper(new Hotel_stub());
	}

	@Test
	public void testgetOrder1() {
		OrderVO vo = controller.getOrder("123456789020080606143055");
		//assert
		assertEquals("123456789020080606143055",vo.orderID);
		assertEquals("南京1号大酒店",vo.hotelName);
	}
	
	@Test
	public void testgetOrder2() {
		OrderVO vo = controller.getOrder("123456789020090606130505");
		//assert
		assertEquals("123456789020090606130505",vo.orderID);
		assertEquals("南京1号大酒店",vo.hotelName);
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
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("异常订单", orderlist.get(i).type);
		}
		
	}
	
	@Test
	public void testGetUserOrderList1() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getUserOrderList("1234567890", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("未执行订单", orderlist.get(i).type);
			assertEquals("1234567890", orderlist.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList2() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getUserOrderList("1234567890", OrderType.EXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("已执行订单", orderlist.get(i).type);
			assertEquals("1234567890", orderlist.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList3() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getUserOrderList("1234567890", OrderType.ABNORMAL);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("异常订单", orderlist.get(i).type);
			assertEquals("1234567890", orderlist.get(i).userID);
		}
	}
	
	@Test
	public void testGetUserOrderList4() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getUserOrderList("1234567890", OrderType.CANCELED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("已撤销订单", orderlist.get(i).type);
			assertEquals("1234567890", orderlist.get(i).userID);
		}
	}
	
	@Test
	public void testGetHotelOrderList1() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getHotelOrderList("00001", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("未执行订单", orderlist.get(i).type);
			assertEquals("00001", orderlist.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList2() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getHotelOrderList("00001", OrderType.EXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("已执行订单", orderlist.get(i).type);
			assertEquals("00001", orderlist.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList3() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getHotelOrderList("00001", OrderType.ABNORMAL);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("异常订单", orderlist.get(i).type);
			assertEquals("00001", orderlist.get(i).hotelID);
		}
	}
	
	@Test
	public void testGetHotelOrderList4() {
		List<OrderVO> orderlist = null;
		
		try {
			orderlist = controller.getHotelOrderList("00001", OrderType.CANCELED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals(false, orderlist.isEmpty());
		//assert
		for (int i = 0; i < orderlist.size(); ++i) {
			assertEquals("已撤销订单", orderlist.get(i).type);
			assertEquals("00001", orderlist.get(i).hotelID);
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
		List<OrderVO> orderlist = controller.getUserOrderList("0000000003", OrderType.UNEXECUTED);

		//assert
		assertEquals(ResultMessage.SUCCESS, message);
		assertEquals(false, orderlist.isEmpty());
	}

	@Test
	public void testCancelOrder1() {
		ResultMessage message1 = controller.createOrder(vo1);
		List<OrderVO> orderlist = controller.getUserOrderList("0000000001", OrderType.UNEXECUTED);
		String orderID = orderlist.get(orderlist.size() - 1).orderID;
		ResultMessage message2 = controller.cancelOrder(orderID);
		OrderVO vo = controller.getOrder(orderID);
		
		//assert
		assertEquals(ResultMessage.SUCCESS, message1);
		assertEquals(ResultMessage.SUCCESS, message2);
		assertEquals("已撤销订单", vo.type);
	}
	
	@Test
	public void testExcueteOrder1() {
		ResultMessage message1 = controller.createOrder(vo2);
		List<OrderVO> orderlist = controller.getUserOrderList("0000000002", OrderType.UNEXECUTED);
		String orderID = orderlist.get(orderlist.size() - 1).orderID;
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
