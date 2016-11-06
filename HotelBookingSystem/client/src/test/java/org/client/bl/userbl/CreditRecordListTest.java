package org.client.bl.userbl;

import static org.easymock.EasyMock.expect;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.vo.CreditRecordVO;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.utility.CreditOperation;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CreditRecord.class, CreditRecordList.class, UserDataService.class})
public class CreditRecordListTest extends EasyMockSupport {
	
	CreditRecordList list;
	
	@Mock
	CreditRecord c;
	
	@Mock
	UserDataService dao;
	
	@Before
	public void setUp() throws Exception {
		list = new CreditRecordList();
		dao = mock(UserDataService.class);
		list.setDao(dao);
		c = mock(CreditRecord.class);
		PowerMockito.whenNew(CreditRecord.class).withNoArguments().thenReturn(c);
	}
	
	@Test
	public void test() {
		String id = "123";
		CreditRecordPO fake = new CreditRecordPO(null, id, 0, 0, CreditOperation.RECHARGE, id);
		List<CreditRecordPO> fakeReturn = new ArrayList<CreditRecordPO>();
		fakeReturn.add(fake);
		
		//record
		try {
			expect(dao.findCreditRecords(id)).andReturn(fakeReturn);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		expect(c.initbyPO(fake)).andReturn(c);
		expect(c.getCreditRecordVO()).andReturn(new CreditRecordVO(null, id, id, 0.0, 0.0, "信用充值"));
		replayAll();
		
		//verify
		list.initList(id);
		List<CreditRecordVO> voList = list.getVOs();
		
		//assert
		assertEquals(id, voList.get(0).userId);
	}

}
