package org.client.blstub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
	
	AreaVO area3 = new AreaVO("西四环");
	
	AreaVO area4 = new AreaVO("奥体中心");
	
	String checkInInfo = "";
	
	List<String> cooperators = new ArrayList<>(Arrays.asList
			(new String[]{"这是一家公司的名字", "这也是一家公司的名字"}));
	
	List<String> roomTypes = new ArrayList<>(Arrays.asList
			(new String[]{"单人间", "双人间"}));
	
	List<Integer> roomNums = new ArrayList<>(Arrays.asList
			(new Integer[]{30, 20}));
	
	List<Double> roomPrices = new ArrayList<>(Arrays.asList
			(new Double[]{198.0, 298.0}));

	HotelVO hotelvo1 = new HotelVO("123","goodhotel","XianLin Campus"
			,city1,area1,"a good hotel",4,3,"good",
			checkInInfo, roomTypes, roomNums, roomPrices, cooperators, "");
	
	HotelVO hotelvo2 = new HotelVO("123","goodhotel","aaa"
			,city1,area2,"xxxxx",4,3,"good",
			checkInInfo, roomTypes, roomNums, roomPrices, cooperators, "");

	public ArrayList<HotelVO> findHotels(HotelFilter filter, String id, boolean historyOnly) {
		ArrayList<HotelVO> vo = new ArrayList<>();
		vo.add(hotelvo1);
		vo.add(hotelvo2);
		return vo;
	}

	public HotelVO getHotel(String hotelID) {
		return hotelvo1;
	}

	public ResultMessage addHotel(HotelVO hotelVO, UserVO userVO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modifyHotel(HotelVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getAvailableRoomNum(Date schFrom, Date schTo, String hotelId, RoomType type) {
		return 10;
	}

	public HotelVO getHotelVO(String hotelID) {
		return hotelvo1;
	}

	public List<CityVO> getCitys() {
		ArrayList<CityVO> vo = new ArrayList<>();
		vo.add(city1);
		vo.add(city2);
		return vo;
	}

	public List<AreaVO> getAreas(CityVO vo) {
		ArrayList<AreaVO> vo3 = new ArrayList<>();
		if (vo.cityName.equals("南京")) {
			vo3.add(area1);
			vo3.add(area2);
		}
		if (vo.cityName.equals("北京")) {
			vo3.add(area3);
			vo3.add(area4);
		}
		return vo3;
	}
}
