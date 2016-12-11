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
import org.junit.*;
import org.server.data.PromotionData.PromotionDataServiceImplTest;
import org.server.data.datafactory.DataFactory;
import org.server.mySQL.DatabaseCommunicator;


public class CommentDataServiceImplTest {
	
	static CommentDataService commentDAO;

	@Before
	public void setUp() throws Exception {
		commentDAO = DataFactory.getInstance().getCommentDataServiceImpl();
		DatabaseCommunicator.setTestConnection();
	}

/*	*//*
	 * 见PromotionDAO的测试类的tearDownAfterClass方法的说明。。
	 *//*
	@After
	public void tearDown() throws Exception {

	}*/

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
