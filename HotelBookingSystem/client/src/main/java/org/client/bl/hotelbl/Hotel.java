package org.client.bl.hotelbl;

import java.util.List;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.po.HotelPO;

public class Hotel {
	public String hotelName;

	public String address;
	
	public String city;
	
	public String area;
	
	public String introduce;
	
	public double rank;
	
	public int star;
	
	public String facility;
	
	public String checkInInfos;
	
	public String cooperators_po;
		
	public List<String> roomType;
	
	public List<Integer> roomNum;
	
	public List<Double> roomPrice;
	
	public List<String> cooperators;

	/**
	 * 根据自己保存的信息生成一个hotelVO
	 * @return hotelVO
	 */
	public HotelVO generateVO() {
		return new HotelVO(hotelName, address, new CityVO(city), new AreaVO(area), introduce, rank, star, facility, checkInInfos, roomType, roomNum, roomPrice, cooperators);
	}
	
	/**
	 * 用po中的信息修改自己的保存值，并返回自己
	 * @param po
	 * @return this
	 */
	public Hotel initByPO(HotelPO po) {
		this.hotelName = po.hotelName;
		this.address = po.address;
		this.city = po.city;
		this.area = po.area;
		this.introduce = po.introduce;
		this.rank = po.rank;
		this.star = po.star;
		this.facility = po.facility;
		this.checkInInfos = po.checkInInfos;
		this.cooperators_po = po.cooperators;
		return this;
	}
	
	/**
	 * 用vo中的信息修改自己的保存值，并返回一个相应的po
	 * @param hotelVO
	 * @return 对应的hotelPO
	 */
	public HotelPO modify(HotelVO vo) {
		this.hotelName = vo.hotelName;
		this.address = vo.address;
		this.city = vo.city.cityName;
		this.area = vo.area.address;
		this.introduce = vo.introduce;
		this.rank = vo.rank;
		this.star = vo.star;
		this.facility = vo.facility;
		this.checkInInfos = vo.checkInInfos;
		this.roomType = vo.roomType;
		this.roomNum = vo.roomNum;
		this.roomPrice = vo.roomPrice;
		this.cooperators = vo.cooperators;
		
		//deformat the cooperators'info
		if (cooperators != null) {       // in the add hotel case this is null
			StringBuilder sb = new StringBuilder();
			for (String s: cooperators) {
				sb.append(s);
				sb.append(","); // english
			}
			this.cooperators_po = sb.toString();
		}
		
		return new HotelPO(hotelName, address, city, area, introduce, rank, star, facility, checkInInfos, cooperators_po);
	}
	
}
