package org.client.bl.orderbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;

import org.client.vo.OrderVO;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 对OrderList类的单元测试，协作对象中order为mock
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest( { Order.class, OrderList.class})
public class OrderListTest extends EasyMockSupport {

	OrderList orderList;
	
	@Mock
	Order myOrder;

	@Before
	public void setUp() throws Exception {
		orderList = new OrderList();
		myOrder = mock(Order.class);
		PowerMockito.whenNew(Order.class).withNoArguments().thenReturn(myOrder);
	}

	@Test
	public void test() {
		OrderPO po1 = new OrderPO(OrderType.UNEXECUTED,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00001","南京某酒店","000000000120161122112233","南京市仙林大道168号栖霞大酒店",RoomType.BIG,100,1,2,false, "foxwel","0000000001","13919191919",false,false);

		expect(myOrder.setOrder(po1)).andReturn(ResultMessage.SUCCESS);
		
		expect(myOrder.getOrderVO()).andReturn(new OrderVO("i'm a userid",OrderType.UNEXECUTED.getString(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00002","南京某酒店","000000000120161122112233","南京市仙林大道168号栖霞大酒店",RoomType.BIG.getString(),100,1,2,false, "foxwel","13919191919",false,false));
		
		replayAll();
		
		//verify
		List<OrderPO> poList = new ArrayList<OrderPO>();
		poList.add(po1);
		ResultMessage resultmessage = orderList.setOrderList(poList);
		List<OrderVO> voList = orderList.getOrderListVO();
		verifyAll();
		
		assertEquals(ResultMessage.SUCCESS, resultmessage);
		assertEquals("南京市仙林大道168号栖霞大酒店", voList.get(0).hotelAddress);
	}


}
