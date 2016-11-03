package org.client.datadriver;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;

public class HotelDataServiceImpl_driver {
	
	public static void main(String[] args) {
		HotelDataService stub = RMIHelper.getInstance().getHotelDataServiceImpl();
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
