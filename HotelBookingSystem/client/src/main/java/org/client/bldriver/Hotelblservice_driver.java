package org.client.bldriver;

import java.util.ArrayList;
import java.util.Date;

import org.client.blstub.Hotel_stub;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.RoomType;
import org.common.utility.UserType;

public class Hotelblservice_driver {
	
	public static void main(String[] args){
		Hotel_stub stub = new Hotel_stub();
		
		System.out.println(stub.findHotels(new HotelFilter()));
		System.out.println(stub.getHotel("dsfc"));
		System.out.println(stub.addHotel(new HotelVO("dvs", "wqd", "vxvsd", "qwd", "cszq", 2.2, 9, "XAa", "346fv", new ArrayList<RoomType>(), new ArrayList<Integer>(), new ArrayList<Double>()), new UserVO(UserType.CUSTOMER, "123", "123", "123", "312", "ce", 1.1, new Date(), "2142ew", 5, 6.6, "sad")));
		System.out.println(stub.modifyHotel(new HotelVO("dvs", "wqd", "vxvsd", "qwd", "cszq", 2.2, 9, "XAa", "346fv", new ArrayList<RoomType>(), new ArrayList<Integer>(), new ArrayList<Double>())));
		System.out.println(stub.changeRoom(RoomType.BIG, 6));
		System.out.println(stub.getHotelVO("ddl"));
		System.out.println(stub.getCitys());
		System.out.println(stub.getAreas(new CityVO("sc")));
	}
}
