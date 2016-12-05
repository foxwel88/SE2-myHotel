package org.client.bl.hotelbl;

import java.util.List;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.po.HotelPO;

/**
 * Hotel的领域对象实体类，持有hotel的基本信息，拥有po和vo的转换方法
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class Hotel {
	public String id;

	public String hotelName;

	public String address;
	
	public String city;
	
	public String area;
	
	public String introduction;
	
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
		return new HotelVO(id, hotelName, address, new CityVO(city), new AreaVO(area), introduction, rank, star, facility, checkInInfos, roomType, roomNum, roomPrice, cooperators);
	}
	
	/**
	 * 用po中的信息修改自己的保存值，并返回自己
	 * @param po
	 * @return this
	 */
	public Hotel initByPO(HotelPO po) {
		this.id = po.id;
		this.hotelName = po.hotelName;
		this.address = po.address;
		this.city = po.city;
		this.area = po.area;
		this.introduction = po.introduction;
		this.rank = po.rank;
		this.star = po.star;
		this.facility = po.facility;
		this.checkInInfos = po.checkInInfos;
		this.cooperators_po = po.cooperators;
		return this;
	}
	
	/**
	 * 用vo中的信息修改自己的保存值，并返回一个相应的po
	 * @param vo
	 * @return 对应的hotelPO
	 */
	public HotelPO modifyAndReturnPO(HotelVO vo) {
		this.id = vo.id;
		this.hotelName = vo.hotelName;
		this.address = vo.address;
		this.city = vo.city.cityName;
		this.area = vo.area.address;
		this.introduction = vo.introduction;
		this.rank = vo.rank;
		this.star = vo.star;
		this.facility = vo.facility;
		this.checkInInfos = vo.checkInInfos;
		this.roomType = vo.roomType;
		this.roomNum = vo.roomNum;
		this.roomPrice = vo.roomPrice;
		this.cooperators = vo.cooperators;
		
		//将vo中合作企业列表合并成存在po中的单条字符串
		if (cooperators != null) {       // 添加新酒店时，该条件为false
			StringBuilder sb = new StringBuilder();
			for (String s: cooperators) {
				sb.append(s);
				sb.append(","); // 英文逗号
			}
			this.cooperators_po = sb.toString();
		}
		
		return new HotelPO(id, hotelName, address, city, area, introduction, rank, star, facility, checkInInfos, cooperators_po);
	}
	
}
