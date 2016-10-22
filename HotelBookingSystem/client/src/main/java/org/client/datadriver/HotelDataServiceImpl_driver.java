package org.client.datadriver;

import java.rmi.RemoteException;

import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.server.datastub.HotelDataServiceImpl_stub;

public class HotelDataServiceImpl_driver {
	
	public static void main(String[] args) {
		HotelDataServiceImpl_stub stub = new HotelDataServiceImpl_stub();
		try {
			stub.init();
			System.out.println(stub.addHotelInfo(new HotelPO(null, null, null, null, null, 0, 0, null, null, null)));
			System.out.println(stub.findHotels(new HotelFilter()));
			System.out.println(stub.getAreas(new CityPO("Nanjing")));
			System.out.println(stub.getCitys());
			System.out.println(stub.getHotelInfo("7days"));
			System.out.println(stub.getRooms("loveHotel"));
			System.out.println(stub.modifyHotelInfo(new HotelPO(null, null, null, null, null, 0, 0, null, null, null)));
			System.out.println(stub.modifyRooms("loveHotel", new RoomPO(null, null, null)));
			stub.finish();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
