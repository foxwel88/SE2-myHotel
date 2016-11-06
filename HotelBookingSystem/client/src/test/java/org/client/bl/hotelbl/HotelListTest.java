package org.client.bl.hotelbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

import org.client.vo.HotelVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.HotelPO;
import org.common.utility.HotelFilter;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 对HotelList类的单元测试，协作对象中dao为mock，hotel为真实对象
 * @author Hirico
 *
 */
public class HotelListTest extends EasyMockSupport {

	HotelList hotelList;
	
	@Mock
	HotelDataService dao;
	
	@Before
	public void setUp() throws Exception {
		hotelList = new HotelList();
		dao = mock(HotelDataService.class);
		hotelList.setDAO(dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HotelFilter filter = new HotelFilter();
		filter.setPrice(0, 5000);
		HotelPO fake = new HotelPO("123", "123", "x", "y", "z", 1, 2, "good", "", "");
		List<HotelPO> fakeReturn = new ArrayList<HotelPO>();
		fakeReturn.add(fake);
		
		//record
		try {
			expect(dao.findHotels(filter)).andReturn(fakeReturn);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		replayAll();
		
		//verify
		hotelList.initList(filter);
		List<HotelVO> vo = hotelList.getVOs();
		verifyAll();
		assertEquals(2, hotelList.list.get(0).star);
		assertEquals("good", vo.get(0).facility);
	}

}
