package org.client.bl.integration;

import static org.junit.Assert.assertEquals;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Date;

import org.client.bl.promotionbl.PromotionController;
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
		PromotionVO vo = new PromotionVO(null, "hotel", PromotionType.BIRTHDAYBONUS.getString(), new Date(100000), new Date(100000), "查大'酒店", "00008", 10, "南京", "中关村", 2, "两折大促销");
		assertEquals(ResultMessage.NOT_EXIST, controller.add(vo));
	}
	
	@Test
	public void testAdd3() {
		PromotionVO vo = new PromotionVO(null, "hotel", PromotionType.BIRTHDAYBONUS.getString(), new Date(100000), new Date(100000), "查大'酒店", "00008", 10, "南京", "中关村", 2, "两折大促销");
		assertEquals(ResultMessage.SUCCESS, controller.add(vo));
	}
	
	@Test
	public void testGetPromotion() {
		
	}
	
	@Test
	public void testShowHotelPromotion() {
		
	}
	
	@Test
	public void testShowWebsitePromotion() {
		
	}
	
	@Test
	public void testModify() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testShowLevel() {
		
	}
	
	@Test
	public void testModifyLevel() {
		
	}
	
	@Test
	public void testGetPrice() {
		
	}
	
	@Test
	public void testCalLevel() {
		
	}
}
