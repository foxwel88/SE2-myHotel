package org.server.data.UserData;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.CreditOperation;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;
import org.junit.Before;
import org.junit.Test;
import org.server.data.datafactory.DataFactory;

import mySQL.DatabaseCommunicator;

/**
 * UserDataServiceImpl的测试类
 * @author gyue
 * @version gyue 2016/12/5
 */
public class UserDataServiceImplTest {
	UserDataService dao;

	@Before
	public void setUp() throws RemoteException {
		DatabaseCommunicator.databaseInit();
		dao = DataFactory.getInstance().getUserDataServiceImpl();
	}

	@Test
	public void testAdd1() throws RemoteException {
		UserPO po = new UserPO(UserType.PERSONALCUSTOMER, "Foxwel_Stub", "王小二", "1234567890", "password", "11122233333",
				1500, new Date(1000000), "无", null, "无");

		ResultMessage info = dao.add(po);

		assertEquals(info, ResultMessage.EXIST);
	}

	@Test
	public void testAdd2() throws RemoteException {
		UserPO po = new UserPO(UserType.PERSONALCUSTOMER, "Foxwel_Stub", "王小二", "2222222222", "password", "11122233333",
				1500, new Date(1000000), "无", null, "无");

		ResultMessage info = dao.add(po);

		assertEquals(info, ResultMessage.SUCCESS);
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
		UserPO po = dao.findbyUserName("233");
		assertEquals(po == null, true);
	}

	@Test
	public void testModify1() throws RemoteException {
		UserPO po = new UserPO(UserType.PERSONALCUSTOMER, "Foxwel_Stub", "王小二", "4433196829", "password", "11122233333",
				1500, new Date(1000000), "无", null, "无");
		ResultMessage info = dao.modify(po);

		assertEquals(ResultMessage.SUCCESS, info);
	}

	@Test
	public void testModify2() throws RemoteException {
		UserPO po = new UserPO(UserType.PERSONALCUSTOMER, "Foxwel_Stub", "王小二", "1111111111", "password", "11122233333",
				1500, new Date(1000000), "无", null, "无");
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
		ResultMessage info = dao.Check("a wrong username", "233");
		assertEquals(ResultMessage.WRONG_USERNAME, info);
	}

	@Test
	public void testCheck3() throws RemoteException {
		ResultMessage info = dao.Check("imindividual", "a wrong password");
		assertEquals(ResultMessage.WRONG_PASSWORD, info);
	}

	@Test
	public void testAddCreditRecord() throws RemoteException {
		CreditRecordPO po = new CreditRecordPO(new Date(), "000000000000000000000000", 0, 0, CreditOperation.CANCELORER,
				"0000000000");
		ResultMessage info = dao.addCreditRecord(po);
		List<CreditRecordPO> list = dao.findCreditRecords("0000000000");
		assertEquals(ResultMessage.SUCCESS, info);
		assertEquals(list.get(0).orderID, "000000000000000000000000");
	}
	
	@Test
	public void testFindCreditRecords1() throws RemoteException {
		List<CreditRecordPO> list = dao.findCreditRecords("1234567890");
		assertEquals(list.size(), 19);
	}
	
	@Test
	public void testFindCreditRecords2() throws RemoteException {
		List<CreditRecordPO> list = dao.findCreditRecords("1234567891");
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testGetNewID() throws RemoteException {
		String id = dao.getNewID();
		UserPO po = dao.findbyID(id);
		assertEquals(po == null, true);
		assertEquals(10, id.length());
	}
}
