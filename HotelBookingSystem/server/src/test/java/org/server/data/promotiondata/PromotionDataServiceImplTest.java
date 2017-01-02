package org.server.data.promotiondata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.server.data.datafactory.DataFactory;
import org.server.util.mysql.DatabaseCommunicator;


public class PromotionDataServiceImplTest {

	static PromotionDataService promotionDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws RemoteException {
		DatabaseCommunicator.setTestConnection();
		promotionDAO = DataFactory.getInstance().getPromotionDataServiceImpl();
	}

/*	*//**
	 * 自动还原测试用数据库，然而因为数据库也不算小，还原起来比较慢，需要大概半分钟吧
	 * （不过因为是子线程在重新导入数据库，所以不会影响测试速度，但不建议快速连续测试）
	 *//*
	@AfterClass
	public static void tearDown() throws Exception {
		URL testDataBaseURL = PromotionDataServiceImplTest.class.getResource("/org/server/data/promotiondata/hotelbookingsystemfortest.sql");
		String testDataBasePath = testDataBaseURL.getPath().toString();
		testDataBasePath = new String(testDataBasePath.substring(1));

		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("mysql -uroot -p1234");
		OutputStream outputStream = process.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(outputStream);
		writer.write("use hotelbookingsystemfortest" + "\r\n" + "source " + testDataBasePath);
		writer.flush();
		writer.close();
		outputStream.close();
	}*/

	@Test
	public void testAdd1() {
		try {
			PromotionPO po = new PromotionPO("0000000004", "hotel", PromotionType.BIRTHDAYBONUS, new Date(1999, 9, 9), new Date(1999, 9, 9), DatabaseCommunicator.getStorableQuote("南京1号'大酒店"), "00001", 2, "南京", "新街口", 5, "新的大促销1");
			promotionDAO.add(po);
			assertEquals(ResultMessage.WRONG_VALUE, promotionDAO.add(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}
	
	@Test
	public void testAdd2() {
		try {
			PromotionPO po = new PromotionPO("0000000005", "hotel", PromotionType.BIRTHDAYBONUS, new Date(1999, 9, 9), new Date(1999, 9, 9), "南京1号大酒店", "00001", 2, "南京", "新街口", 5, "双十一促销");
			promotionDAO.add(po);
			assertEquals(ResultMessage.WRONG_VALUE, promotionDAO.add(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		try {
			PromotionPO po = new PromotionPO("0000000001", "hotel", PromotionType.BIRTHDAYBONUS, new Date(1999, 9, 9), new Date(1999, 9, 9), "南京1号大酒店", "00001", 2, "南京", "新街口", 8, "修改的三间以上促销");
			assertEquals(ResultMessage.SUCCESS, promotionDAO.modify(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			assertEquals(ResultMessage.SUCCESS, promotionDAO.delete("0000000002"));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowHotelPromotion() {
		try {
			boolean isThatHotel = true;
			ArrayList<PromotionPO> hotelPromotionList = (ArrayList<PromotionPO>)promotionDAO.showHotelPromotion("00001");
			for (int i = 0; i < hotelPromotionList.size(); i++) {
				if (!hotelPromotionList.get(i).hotelID.equals("00001")) {
					isThatHotel = false;
					break;
				}
			}
			assertTrue(isThatHotel);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowWebsitePromotion() {
		try {
			boolean isWebPromotion = true;
			ArrayList<PromotionPO> webPromotionList = (ArrayList<PromotionPO>)promotionDAO.showWebsitePromotion();
			for (int i = 0; i < webPromotionList.size(); i++) {
				if (!webPromotionList.get(i).provider.equals("web")) {
					isWebPromotion = false;
					break;
				}
			}
			assertTrue(isWebPromotion);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testShowLevel() {
		try {
			assertEquals(20, promotionDAO.showLevel().levelNum);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

	@Test
	public void testModifyLevel() {
		try {
			ArrayList<Double> creditList = new ArrayList<>();
			for (int i = 0; i < 20; i++) {
				creditList.add((double)((i + 1) * 300));
			}
			LevelPO po = new LevelPO(20, creditList);
			assertEquals(ResultMessage.SUCCESS, promotionDAO.modifyLevel(po));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

}
