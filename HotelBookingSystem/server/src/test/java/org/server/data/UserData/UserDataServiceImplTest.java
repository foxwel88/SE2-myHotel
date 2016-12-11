package org.server.data.UserData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.List;

import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;
import org.junit.Before;
import org.junit.Test;
import org.server.data.datafactory.DataFactory;
import org.server.mySQL.DatabaseCommunicator;

/**
 * UserDataServiceImpl的测试类
 * @author gyue
 * @version gyue 2016/12/7
 */
public class UserDataServiceImplTest {
	UserDataService dao;

	@Before
	public void setUp() throws RemoteException {
		DatabaseCommunicator.setTestConnection();
		dao = DataFactory.getInstance().getUserDataServiceImpl();
	}

	@Test
	public void testAdd() throws RemoteException {
		UserPO po = dao.findbyUserName("imindividual");

		ResultMessage info = dao.add(po);
		
		assertEquals(ResultMessage.EXIST, info);
	}

	@Test
	public void testFindbyID1() throws RemoteException {
		UserPO po = dao.findbyID("1234567890");
		assertEquals("张客户", po.name);
	}

	@Test
	public void testFindbyID2() throws RemoteException {
		UserPO po = dao.findbyID("1234567891");
		// 未找到 返回null
		boolean info = (po == null);
		assertEquals(true, info);
	}

	@Test
	public void testFindbyUserName1() throws RemoteException {
		UserPO po = dao.findbyUserName("imindividual");
		assertEquals(po.name, "张客户");
	}

	@Test
	public void testFindbyUserName2() throws RemoteException {
		UserPO po = dao.findbyUserName("awrongusername");
		assertEquals(po == null, true);
	}

	@Test
	public void testModify1() throws RemoteException {
		UserPO po = dao.findbyUserName("imindividual");
		po.credit += 10;
		ResultMessage info = dao.modify(po);

		assertEquals(ResultMessage.WRONG_USERNAME, info);
	}

	@Test
	public void testModify2() throws RemoteException {
		UserPO po = dao.findbyUserName("imindividual");
		po.ID = "awrongid";
		ResultMessage info = dao.modify(po);

		assertEquals(ResultMessage.NOT_EXIST, info);
	}

	@Test
	public void testCheck1() throws RemoteException {
		ResultMessage info = dao.Check("imindividual", "person");
		assertEquals(ResultMessage.SUCCESS, info);
	}

	@Test
	public void testCheck2() throws RemoteException {
		ResultMessage info = dao.Check("a wrong username", "persion");
		assertEquals(ResultMessage.WRONG_USERNAME, info);
	}

	@Test
	public void testCheck3() throws RemoteException {
		ResultMessage info = dao.Check("imindividual", "a wrong password");
		assertEquals(ResultMessage.WRONG_PASSWORD, info);
	}

	@Test
	public void testAddCreditRecord() throws RemoteException {
		CreditRecordPO po = dao.findCreditRecords("1234567890").get(0);
		po.userId = "0000000000";
		ResultMessage info = dao.addCreditRecord(po);
		List<CreditRecordPO> list = dao.findCreditRecords("0000000000");
		assertEquals(ResultMessage.SUCCESS, info);
		assertEquals(list.get(0).orderID, po.orderID);
	}
	
	@Test
	public void testFindCreditRecords1() throws RemoteException {
		List<CreditRecordPO> list = dao.findCreditRecords("1234567890");
		assertEquals(20, list.size());
	}
	
	@Test
	public void testFindCreditRecords2() throws RemoteException {
		List<CreditRecordPO> list = dao.findCreditRecords("1234567891");
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testDeleteUser1() throws RemoteException {
		ResultMessage info = dao.deleteUser("awrongname");
		assertEquals(ResultMessage.NOT_EXIST, info);
	}
	
	@Test
	public void testDeleteUser2() throws RemoteException {
		UserPO oldpo = dao.findbyUserName("imindividual");
		oldpo.userName = "temp";
		ResultMessage res1 = dao.add(oldpo);
		UserPO po1 = dao.findbyUserName("temp");
		ResultMessage res2 = dao.deleteUser("temp");
		UserPO po2 = dao.findbyUserName("temp");
		
		assertEquals("temp", po1.userName);
		assertEquals(true, po2 == null);
		assertEquals(ResultMessage.SUCCESS, res1);
		assertEquals(ResultMessage.SUCCESS, res2);
	}
	
	@Test
	public void testDeleteNowUser() throws RemoteException {
		String userName = "test";
		dao.addNowUser(userName);
		ResultMessage info1 = dao.userIsExist(userName);
		ResultMessage info2 = dao.userIsExist("awrongname");
		ResultMessage info3 = dao.deleteNowUser(userName);
		ResultMessage info4 = dao.deleteNowUser(userName);
		
		assertEquals(ResultMessage.EXIST, info1);
		assertEquals(ResultMessage.NOT_EXIST, info2);
		assertEquals(ResultMessage.SUCCESS, info3);
		assertEquals(ResultMessage.NOT_EXIST, info4);
	}
}
