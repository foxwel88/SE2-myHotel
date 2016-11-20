package org.client.blstub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class Hotel_stub implements Hotelblservice {	
	CityVO city1 = new CityVO("南京");
	
	CityVO city2 = new CityVO("北京");
	
	AreaVO area1 = new AreaVO("仙林中心");
	
	AreaVO area2 = new AreaVO("新街口");
	
	String checkInInfo = "";
	
	List<String> cooperators = new ArrayList<String>(Arrays.asList
			(new String[]{"这是一家公司的名字","这也是一家公司的名字"}));
	
	List<String> roomTypes = new ArrayList<String>(Arrays.asList
			(new String[]{"单人间","双人间"}));
	
	List<Integer> roomNums = new ArrayList<Integer>(Arrays.asList
			(new Integer[]{30,20}));
	
	List<Double> roomPrices = new ArrayList<Double>(Arrays.asList
			(new Double[]{198.0,298.0}));

	HotelVO hotelvo1 = new HotelVO("goodhotel","XianLin Campus"
			,city1,area1,"a good hotel",4,3,"good",
			checkInInfo, roomTypes, roomNums, roomPrices, cooperators);
	
	HotelVO hotelvo2 = new HotelVO("goodhotel","aaa"
			,city1,area2,"xxxxx",4,3,"good",
			checkInInfo, roomTypes, roomNums, roomPrices, cooperators);

	public ArrayList<HotelVO> findHotels(HotelFilter filter, String id, boolean historyOnly) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> vo = new ArrayList<HotelVO>();
		vo.add(hotelvo1);
		vo.add(hotelvo2);
		return vo;
	}

	public HotelVO getHotel(String hotelAddress) {
		// TODO Auto-generated method stub
		return hotelvo1;
	}

	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage changeRoom(RoomType type, int num, String hotelAddress) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public HotelVO getHotelVO(String hotelAddress) {
		// TODO Auto-generated method stub
		return hotelvo1;
	}

	public ArrayList<CityVO> getCitys() {
		// TODO Auto-generated method stub
		ArrayList<CityVO> vo = new ArrayList<CityVO>();
		vo.add(city1);
		vo.add(city2);
		return vo;
	}

	public ArrayList<AreaVO> getAreas(CityVO vo) {
		// TODO Auto-generated method stub
		ArrayList<AreaVO> vo3 = new ArrayList<AreaVO>();
		vo3.add(area1);
		vo3.add(area2);
		return vo3;
	}

}
