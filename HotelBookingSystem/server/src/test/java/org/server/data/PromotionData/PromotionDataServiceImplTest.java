package org.server.data.PromotionData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.Date;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.data.datafactory.DataFactory;

import mySQL.DatabaseCommunicator;

public class PromotionDataServiceImplTest {

	PromotionDataService promotionDAO;
	
	@Before
	public void setUp() throws RemoteException {
		DatabaseCommunicator.setTestConnection();
		promotionDAO = DataFactory.getInstance().getPromotionDataServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetNewID() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testAdd1() {
		try {
			PromotionPO po = new PromotionPO(promotionDAO.getNewID(), "hotel", PromotionType.BIRTHDAYBONUS, new Date("100000"), new Date("10000000"), "南京1号大酒店", "00001", 2, "新街口", 5, "大促销");
			assertEquals(ResultMessage.SUCCESS, promotionDAO.add(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}
	
	@Test
	public void testAdd2() {
		try {
			PromotionPO po = new PromotionPO(promotionDAO.getNewID(), "hotel", PromotionType.BIRTHDAYBONUS, new Date("100000"), new Date("10000000"), "南京1号大酒店", "00001", 2, "新街口", 5, "双十一促销");
			assertEquals(ResultMessage.WRONG_VALUE, promotionDAO.add(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}
	
	@Test
	public void testAdd3() {
		try {
			PromotionPO po = new PromotionPO(promotionDAO.getNewID(), "hotel", PromotionType.BIRTHDAYBONUS, new Date("100000"), new Date("10000000"), "南京1号大酒店", "07777", 2, "新街口", 5, "大促销");
			assertEquals(ResultMessage.NOT_EXIST, promotionDAO.add(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		try {
			PromotionPO po = new PromotionPO(promotionDAO.getNewID(), "hotel", PromotionType.BIRTHDAYBONUS, new Date("100000"), new Date("10000000"), "南京1号大酒店", "00001", 2, "新街口", 8, "大促销");
			assertEquals(ResultMessage.SUCCESS, promotionDAO.modify(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowHotelPromotion() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowWebsitePromotion() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowLevel() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testModifyLevel() {
		try {
			assertEquals("0000000003", promotionDAO.getNewID());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

}
