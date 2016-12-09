package org.client.bl.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.client.bl.promotionbl.PromotionController;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.server.data.PromotionData.PromotionDataServiceImplTest;
import org.server.rmi.RMIHelper;

import mySQL.DatabaseCommunicator;

public class PromotionTest {

	PromotionController controller;

	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();

		DatabaseCommunicator.setTestConnection();
		controller = PromotionController.getInstance();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// TODO Attention！！！！！！这是个服务器的测试类。。。我只是懒得把测试的sql再在client拷一份了。。。。
		URL testDataBaseURL = PromotionDataServiceImplTest.class.getResource("/org/server/data/PromotionData/hotelbookingsystemfortest.sql");
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
	}
	
	@Test
	public void testAdd1() {
		PromotionVO vo = new PromotionVO(null, "hotel", PromotionType.BIRTHDAYBONUS.getString(), new Date(100000), new Date(100000), "查大'酒店", "00008", 10, "南京", "湖南路", 2, "两折大促销");
		assertEquals(ResultMessage.SUCCESS, controller.add(vo));
	}
	
	@Test
	public void testAdd2() {
		PromotionVO vo = new PromotionVO(null, "hotel", PromotionType.BIRTHDAYBONUS.getString(), new Date(100000), new Date(100000), "查大'酒店", "98888", 10, "南京", "中关村", 2, "两折大促销");
		assertEquals(ResultMessage.NOT_EXIST, controller.add(vo));
	}
	
	@Test
	public void testGetPromotion() {
		ArrayList<PromotionVO> promotionVOList = (ArrayList<PromotionVO>)controller.getPromotion("00001", "1234567890");
		assertEquals(2, promotionVOList.size());
	}
	
	@Test
	public void testShowHotelPromotion() {
		ArrayList<PromotionVO> promotionVOList = (ArrayList<PromotionVO>)controller.showHotelPromotion("00001");
		assertEquals(2, promotionVOList.size());
	}
	
	@Test
	public void testShowWebsitePromotion() {
		ArrayList<PromotionVO> promotionVOList = (ArrayList<PromotionVO>)controller.showWebsitePromotion();
		assertEquals(1, promotionVOList.size());
	}
	
	@Test
	public void testModify() {
		PromotionVO vo = new PromotionVO("0000000005", "hotel", PromotionType.BIRTHDAYBONUS.getString(), new Date(100000), new Date(100000), "查大'酒店", "00003", 10, "南京", "中关村", 2, "两折大促销");
		assertEquals(ResultMessage.SUCCESS, controller.modify(vo));
		ArrayList<PromotionVO> promotionVOList = (ArrayList<PromotionVO>)controller.showHotelPromotion("00003");
		PromotionVO modifiedVO = promotionVOList.get(0);
		assertEquals("查大'酒店", modifiedVO.hotelName);
		assertEquals("两折大促销", modifiedVO.name);
		assertEquals("中关村", modifiedVO.area);
		assertEquals(2, modifiedVO.discount);
	}
	
	@Test
	public void testDelete() {
		assertEquals(ResultMessage.SUCCESS, controller.delete("0000000003"));
	}
	
	@Test
	public void testShowLevel() {
		assertEquals(20, controller.showLevel().levelNum);
	}
	
	@Test
	public void testModifyLevel() {
		ArrayList<Double> creditList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			creditList.add((double)((i + 1) * 300));
		}
		LevelVO vo = new LevelVO(20, creditList);
		assertEquals(ResultMessage.SUCCESS, controller.modifyLevel(vo));
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(10, controller.getPrice("1234567890", "00001", 100));
	}
	
	@Test
	public void testCalLevel() {
		// 由于junit测试没有规定顺序，因此测试此方法时，modifyLevel测试方法可能已经执行，也可能未执行，所以考虑两种情况
		int level = controller.calLevel(2810);
		boolean isRight = (level == 5) || (level == 9);
		assertTrue(isRight);
	}
}
