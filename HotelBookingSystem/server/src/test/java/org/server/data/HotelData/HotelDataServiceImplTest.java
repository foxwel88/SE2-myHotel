package org.server.data.HotelData;

import static org.junit.Assert.*;
import mySQL.DatabaseCommunicator;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.data.datafactory.DataFactory;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hirico
 * @version 2016/12/05 Hirico
 */
public class HotelDataServiceImplTest {

	HotelDataService dao;

	@Before
	public void setUp() throws RemoteException {
		DatabaseCommunicator.databaseInit();
		dao = DataFactory.getInstance().getHotelDataServiceImpl();
	}

	@Test
	public void testGetHotel() throws RemoteException {
		HotelPO po = dao.getHotelInfo("00001");
		assertEquals(true, po.address != null);
	}

	@Test
	public void testGetCityAndAreas() throws RemoteException {
		List<CityPO> list = dao.getCitys();
		assertEquals(true, list.size() > 0);
		for (CityPO cityPO : list) {
			System.out.println(cityPO.cityName);
		}

		List<AreaPO> areas = dao.getAreas(list.get(0));
		assertEquals(true, areas.size() > 0);
	}

	@Test
	public void testGetRooms() throws RemoteException {
		List<RoomPO> roomPOS = dao.getRooms("00001");
		assertEquals(true, roomPOS.size() > 0);
	}

	@Test
	public void testModifyHotel() throws RemoteException {
		HotelPO oldPO = dao.getHotelInfo("00001");
		assertEquals(true, oldPO.address != null);

		HotelPO newPO = new HotelPO(oldPO.id, "love hotel", "学生公寓1组团3栋", "南京", "仙林中心",
				"Welcome, boys!", 4.5, 4, "不断电不断网，空调四人间，自助售卖机", "B319,20150901,20170901;", "南大物业");

		ResultMessage result = dao.modifyHotelInfo(newPO);
		assertEquals(ResultMessage.SUCCESS, result);

		result = dao.modifyHotelInfo(oldPO);
		assertEquals(ResultMessage.SUCCESS, result);
	}

	@Test
	public void testModifyRooms() throws RemoteException {
		List<RoomPO> oldPOs = dao.getRooms("00001");
		assertEquals(true, oldPOs.size() > 0);

		List<RoomPO> newPOs = new ArrayList<>(Arrays.asList(new RoomPO[]{ new RoomPO(RoomType.BIG, 2, 400)}));

		ResultMessage result = dao.modifyRooms("00001", newPOs);
		assertEquals(ResultMessage.SUCCESS, result);

		result = dao.modifyRooms("00001", oldPOs);
		assertEquals(ResultMessage.SUCCESS, result);
	}



}
