package org.client.bl.userbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import mySQL.DatabaseCommunicator;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * userBl模块集成测试，用到的userBl类均为真实类，DAO为stub
 * @author gyue
 *
 */
public class UserControllerTest {
	
	UserController controller;
	
	@Before
	public void setUp() throws Exception {
		org.server.rmi.RMIHelper.getinstance().buildStubConnection();
		org.client.rmi.RMIHelper.getInstance().init();

		DatabaseCommunicator.setTestConnection();
		controller = UserController.getInstance();
	}
	
	@Test
	public void testLogin() {
		// verify
		ResultMessage message1 = controller.login("gz", "123");
		ResultMessage message2 = controller.login("gy", "123");
		
		// assert
		assertEquals(ResultMessage.SUCCESS, message1);
		assertEquals(ResultMessage.WRONG_VALUE, message2);
		
	}
	
	@Test
	public void testLogout() {
		// verify
		ResultMessage message = controller.logout("gz");
		
		// assert
		assertEquals(ResultMessage.SUCCESS, message);
	}
	
	@Test
	public void testAdd() {
		UserVO vo1 = new UserVO("个人客户", "Saber", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", null, null);
		UserVO vo2 = new UserVO("个人客户", "gz", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", null, null);
		
		// verify
		ResultMessage message1 = controller.add(vo1);
		ResultMessage message2 = controller.add(vo2);
		
		// assert
		assertEquals(ResultMessage.SUCCESS, message1);
		assertEquals(ResultMessage.EXIST, message2);
	}
	
	@Test
	public void testFindbyID() {
		String id = "233";
		UserVO vo = controller.findbyID(id);
		
		// verify
		boolean result = (vo == null);
		
		// assert
		assertEquals(false, result);
	}
	
	@Test
	public void testFindbyUserName() {
		String user1 = "gz";
		String user2 = "Saber";
		UserVO vo1 = controller.findbyUserName(user1);
		UserVO vo2 = controller.findbyUserName(user2);
		
		// verify
		boolean result1 = (vo1 == null);
		boolean result2 = (vo2.resultMessage == ResultMessage.NOT_EXIST);
		
		// assert
		assertEquals(false, result1);
		assertEquals("gz", vo1.userName);
		assertEquals(true, result2);
		
	}
	
	@Test
	public void testModifyPassword() {
		String user1 = "gz";
		String password1 = "123";
		String password2 = "456";
		String password3 = "123456789";
		
		// verify
		ResultMessage message1 = controller.modifyPassword(user1, password1, password2);
		ResultMessage message2 = controller.modifyPassword(user1, password2, password1);
		ResultMessage message3 = controller.modifyPassword(user1, password1, password3);
		
		// assert
		assertEquals(ResultMessage.WRONG_FORMAT, message1);
		assertEquals(ResultMessage.WRONG_VALUE, message2);
		assertEquals(ResultMessage.SUCCESS, message3);
		
	}
	
	@Test
	public void testModify() {
		UserVO vo = new UserVO("个人客户", "Saber", "Y", "1234567890", "first0xaa55", "12233345678", 21.21, new Date(19890604), "μ's", null, null);
		
		// verify
		ResultMessage message = controller.modify(vo);
		
		// assert
		assertEquals(ResultMessage.SUCCESS, message);
	}
	
	@Test
	public void testAddCreditRecord() {
		CreditRecordVO vo = new CreditRecordVO(new Date(), "123456789", "9876645321", 233.33, 12450, "信用充值");
		
		// verify
		ResultMessage message = controller.addCreditRecord(vo);
		
		// assert
		assertEquals(ResultMessage.SUCCESS, message);
	}
	
	@Test
	public void testFindCreditREcord() {
		// verify
		List<CreditRecordVO> list = controller.findCreditRecord("123");
		
		// assert
		assertEquals(false, list.isEmpty());
	}
	
	@After
	public void tearDowm() throws Exception {
		org.server.rmi.RMIHelper.getinstance().releaseConnection();
	}

}
