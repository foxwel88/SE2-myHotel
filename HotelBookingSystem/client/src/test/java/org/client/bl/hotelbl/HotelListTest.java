package org.client.bl.hotelbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.HotelPO;
import org.common.utility.HotelFilter;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 对HotelList类的单元测试，协作对象中dao和hotel为mock
 * @author Hirico
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest( { Hotel.class, HotelList.class, HotelDataService.class})
public class HotelListTest extends EasyMockSupport {

	HotelList hotelList;
	
	@Mock
	Hotel h;
	
	@Mock
	HotelDataService dao;
	
	@Before
	public void setUp() throws Exception {
		hotelList = new HotelList();
		dao = mock(HotelDataService.class);
		hotelList.setDAO(dao);
		h = mock(Hotel.class);
		PowerMockito.whenNew(Hotel.class).withNoArguments().thenReturn(h);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HotelFilter filter = new HotelFilter();
		filter.setPrice(0, 5000);
		HotelPO fake = new HotelPO("id", "123", "123", "x", "y", "z", 1, 2, "good", "", "");
		List<HotelPO> fakeReturn = new ArrayList<HotelPO>();
		fakeReturn.add(fake);
		
		//record
		try {
			expect(dao.findHotels(filter)).andReturn(fakeReturn);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		expect(h.initByPO(fake, null)).andReturn(h);
		expect(h.generateVO()).andReturn(new HotelVO("id", "123", "123", new CityVO("x"), new AreaVO("y"), "z", 1, 2, "good", "", null, null, null, null));
		replayAll();
		
		//verify
		hotelList.initList(filter);
		List<HotelVO> vo = hotelList.getVOs();
		verifyAll();
		assertEquals("good", vo.get(0).facility);
	}

}
