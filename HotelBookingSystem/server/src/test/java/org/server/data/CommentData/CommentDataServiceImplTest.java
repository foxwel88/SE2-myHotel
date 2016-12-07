package org.server.data.CommentData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.server.data.PromotionData.PromotionDataServiceImplTest;
import org.server.data.datafactory.DataFactory;

import mySQL.DatabaseCommunicator;

public class CommentDataServiceImplTest {
	
	static CommentDataService commentDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		commentDAO = DataFactory.getInstance().getCommentDataServiceImpl();
		DatabaseCommunicator.setTestConnection();
	}

	/*
	 * 见PromotionDAO的测试类的tearDownAfterClass方法的说明。。
	 */
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
	public void testFind() {
		try {
			ArrayList<CommentPO> commentPOList = (ArrayList<CommentPO>)commentDAO.find("00001");
			boolean isThatHotel = true;
			for (int i = 0; i < commentPOList.size(); i++) {
				if (!commentPOList.get(i).hotelID.equals("00001")) {
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
	public void testInsert() {
		try {
			CommentPO commentPO = new CommentPO("username", "00003", new Date(1992, 3, 3), 4.4, "不怎么样，下次不来了，为了凑齐15个字，我决定再说一句话");
			assertEquals(ResultMessage.SUCCESS, commentDAO.insert(commentPO));
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}

}
