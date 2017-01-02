package org.client.bl.orderbl;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;

import org.client.blstub.User_stub;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * Orderbl模块集成测试，用到的Orderbl类均为真实类，dao和其它bl模块的类为stub
 *
 */
@Ignore
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
		
		OrderVO vo = new OrderVO("i'm a userid",OrderType.UNEXECUTED.getString(),new Date(),new Date(),new Date(),new Date(),new Date(),
				new Date(),new Date(),"00001","南京某酒店","000000000120161122112233","南京市仙林大道168号栖霞大酒店",RoomType.BIG.toString(),100,1,2,false, "Tom","13919191919",false,false);

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
	public void testgetOrder1() {
		
		OrderVO vo = null;
		try {
			vo = controller.getOrder("000000000120161122112233");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		//assert
		System.out.println(vo.orderID);
		assertEquals("000000000120161122112233", vo.orderID);
	}
	
	@Test
	public void testgetOrder3() {
		
		OrderVO vo = null;
		
		vo = controller.getOrder("000000000120161122112200");
		
		//assert
		assertEquals(ResultMessage.NOT_EXIST, vo.resultMessage);
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
		assertEquals(false, orderList.isEmpty());
	}
	
	@Test
	public void testGetUserOrderList1() {
		
		List<OrderVO> orderList = null;
		String username = null;
		
		try {
			orderList = controller.getUserOrderList("0000000001", OrderType.UNEXECUTED);
			username = orderList.get(0).customerName;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, orderList.isEmpty());
		assertEquals("foxwel", username);
	}
	
	@Test
	public void testGetUserOrderList2() {
		List<OrderVO> orderList = null;
		
		try {
			orderList = controller.getUserOrderList("0000000002", OrderType.UNEXECUTED);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(true, orderList.isEmpty());
	}
	
	@Test
	public void testGetHotelOrderList1() {
		
		List<OrderVO> hotellist = null;
		String hotelAddress = null;
		
		try {
			hotellist = controller.getHotelOrderList("00001", OrderType.UNEXECUTED);
			hotelAddress = hotellist.get(0).hotelAddress;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotellist.isEmpty());
		assertEquals("南京市仙林大道168号栖霞大酒店", hotelAddress);
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
		String hotelID = null;
		try {
			hotellist = controller.getHistoryHotels("0000000001");
			hotelID = hotellist.get(0);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		//assert
		assertEquals(false, hotellist.isEmpty());
		assertEquals("00001",hotelID);
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
		assertEquals(ResultMessage.NOT_EXIST, resultmessage);
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
		assertEquals(ResultMessage.NOT_EXIST, resultmessage);
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
		assertEquals(ResultMessage.NOT_EXIST, resultmessage);
	}
	
	@After
	public void tearDown() throws Exception {
		RMIHelper.getinstance().releaseConnection();
	}

}
