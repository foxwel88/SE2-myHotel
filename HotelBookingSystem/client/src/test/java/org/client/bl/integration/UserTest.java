package org.client.bl.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.client.bl.userbl.UserController;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

import mySQL.DatabaseCommunicator;

public class UserTest {
	
	UserController controller;
	
	@Before
	public void setUp() {
		RMIHelper.getinstance().buildConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		
		DatabaseCommunicator.setTestConnection();
		controller = UserController.getInstance();
	}
	
	@Test
	public void testLogin() {
		String userName1 = "bob";
		String password1 = "123456";
		String userName2 = "a wrong name";
		String password2 = "a wrong password";
		
		ResultMessage info1 = controller.login(userName2, password1);
		ResultMessage info2 = controller.login(userName1, password2);
		ResultMessage info3 = controller.login(userName1, password1);
		ResultMessage info4 = controller.login(userName1, password1);
		
		assertEquals(ResultMessage.WRONG_USERNAME, info1);
		assertEquals(ResultMessage.WRONG_PASSWORD, info2);
		assertEquals(ResultMessage.SUCCESS, info3);
		assertEquals(ResultMessage.EXIST, info4);
	}
	
	@Test
	public void testLogout() {
		String userName1 = "root";
		String password1 = "123456";
		String userName2 = "a wrong name";
		
		ResultMessage info1 = controller.logout(userName1);
		ResultMessage info2 = controller.login(userName1, password1);
		ResultMessage info3 = controller.logout(userName1);
		ResultMessage info4 = controller.logout(userName2);
		
		assertEquals(ResultMessage.NOT_EXIST, info1);
		assertEquals(ResultMessage.SUCCESS, info2);
		assertEquals(ResultMessage.SUCCESS, info3);
		assertEquals(ResultMessage.NOT_EXIST, info4);
	}
	
	@Test
	public void testAdd() {
		UserVO vo = controller.findbyUserName("bob");
		ResultMessage info = controller.add(vo);
		
		assertEquals(ResultMessage.SUCCESS, vo.resultMessage);
		assertEquals(ResultMessage.EXIST, info);
	}
	
	@Test
	public void testDelete() {
		ResultMessage info = controller.deleteUser("a wrong name");
		
		assertEquals(ResultMessage.NOT_EXIST, info);
	}
	
	@Test
	public void testAddAndDelete() {
		UserVO vo = controller.findbyUserName("bob");
		vo.userName = "bobChange";
		vo.ID = null;
		
		ResultMessage info1 = controller.add(vo);
		ResultMessage info2 = controller.deleteUser("bobChange");
		
		assertEquals(ResultMessage.SUCCESS, info1);
		assertEquals(ResultMessage.SUCCESS, info2);
	}
	
	@Test
	public void testFindbyID1() {
		String id = "1234567890";
		UserVO vo = controller.findbyID(id);
		
		assertEquals(ResultMessage.SUCCESS, vo.resultMessage);
		assertEquals("个人客户", vo.type);
	}
	
	@Test
	public void testFindbyID2() {
		String id = "a wrong id";
		UserVO vo = controller.findbyID(id);
		
		assertEquals(ResultMessage.NOT_EXIST, vo.resultMessage);
	}
	
	@Test
	public void testFindbyUserName1() {
		String userName = "root";
		UserVO vo = controller.findbyUserName(userName);
		
		assertEquals(ResultMessage.SUCCESS, vo.resultMessage);
		assertEquals("网站管理人员", vo.type);
	}
	
	@Test
	public void testFindbyUserName2() {
		String userName = "a wrong name";
		UserVO vo = controller.findbyUserName(userName);
		
		assertEquals(ResultMessage.NOT_EXIST, vo.resultMessage);
	}
	
	@Test
	public void testModifyPassword1() {
		String userName = "bob";
		String oldPassword = "123456";
		String newPassword = "123457";
		
		ResultMessage info1 = controller.modifyPassword(userName, oldPassword, newPassword);
		UserVO vo1 = controller.findbyUserName(userName);
		ResultMessage info2 = controller.modifyPassword(userName, newPassword, oldPassword);
		UserVO vo2 = controller.findbyUserName(userName);
		
		assertEquals(ResultMessage.SUCCESS, info1);
		assertEquals("123457", vo1.passWord);
		assertEquals(ResultMessage.SUCCESS, info2);
		assertEquals("123456", vo2.passWord);
	}
	
	@Test
	public void testModifyPassword2() {
		String userName1 = "bob";
		String oldPassword1 = "123456";
		String newPassword = "233333";
		String userName2 = "a wrong name";
		String oldPassword2 = "a wrong password";
		
		ResultMessage info1 = controller.modifyPassword(userName1, oldPassword2, newPassword);
		ResultMessage info2 = controller.modifyPassword(userName2, oldPassword1, newPassword);
		
		assertEquals(ResultMessage.WRONG_PASSWORD, info1);
		assertEquals(ResultMessage.WRONG_USERNAME, info2);
	}
	
	@Test
	public void testAddCreditRecord() {
		List<CreditRecordVO> vos = controller.findCreditRecord("1234567890");
		vos.get(0).userId = "4433196829";
		ResultMessage info = controller.addCreditRecord(vos.get(0));
		List<CreditRecordVO> res = controller.findCreditRecord("4433196829");
		
		assertEquals(20, vos.size());
		assertEquals(ResultMessage.SUCCESS, info);
		assertEquals("4433196829", res.get(0).userId);
	}
	
	@Test
	public void testFindCreditRecord() {
		List<CreditRecordVO> vos = controller.findCreditRecord("a wrong id");
		
		assertEquals(true, vos.isEmpty());
	}
	
	@Test
	public void testGetLevel() {
		UserLevelVO vo1 = controller.getLevel("tom");
		UserLevelVO vo2 = controller.getLevel("a wrong name");
		
		assertEquals(ResultMessage.SUCCESS, vo1.resultMessage);
		assertEquals(ResultMessage.NOT_EXIST, vo2.resultMessage);
	}
	
	@After
	public void finish() {
		RMIHelper.getinstance().releaseConnection();
	}
}
