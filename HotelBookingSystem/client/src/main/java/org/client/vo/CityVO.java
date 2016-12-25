package org.client.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.common.po.CityPO;

public class CityVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8137334106595243657L;
	
	public String cityName;

	public CityVO(String cityName) {
		this.cityName = cityName;
	}
	
	/*For fast transfer from data to view, called from hotelLogic*/
	public static List<CityVO> generateVOList(List<CityPO> pos) {
		List<CityVO> vos = new ArrayList<>();
		for (CityPO p: pos) {
			CityVO vo = new CityVO(p.cityName);
			vos.add(vo);
		}
		return vos;
	}
	
	public static CityPO generatePO(CityVO vo) {
		return new CityPO(vo.cityName);
	}
}
