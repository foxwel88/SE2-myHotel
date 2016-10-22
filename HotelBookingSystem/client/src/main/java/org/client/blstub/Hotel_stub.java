package org.client.blstub;

import java.util.ArrayList;

import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.client.vo.UserVO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class Hotel_stub implements Hotelblservice{

	HotelVO hotelvo1=new HotelVO("goodhotel","aaa","bbb","ccc","xxxxx",4,3,"good","xixixi",null,null,null, null);
	HotelVO hotelvo2=new HotelVO("goodhotel","aaa","bbb","ccc","xxxxx",4,3,"good","xixixi",null,null,null, null);

	public ArrayList<HotelVO> findHotels(HotelFilter filter) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> vo=new ArrayList<HotelVO>();
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

	public ResultMessage changeRoom(RoomType type, int num) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public HotelVO getHotelVO(String hotelAddress) {
		// TODO Auto-generated method stub
		return hotelvo1;
	}

	public ArrayList<CityVO> getCitys() {
		// TODO Auto-generated method stub
		CityVO vo1=new CityVO("aaa");
		CityVO vo2=new CityVO("bbb");
		ArrayList<CityVO> vo=new ArrayList<CityVO>();
		vo.add(vo1);
		vo.add(vo2);
		return vo;
	}

	public ArrayList<AreaVO> getAreas(CityVO vo) {
		// TODO Auto-generated method stub
		AreaVO vo1=new AreaVO("a1");
		AreaVO vo2=new AreaVO("b2");
		ArrayList<AreaVO> vo3=new ArrayList<AreaVO>();
		vo3.add(vo1);
		vo3.add(vo2);
		return vo3;
	}

}
