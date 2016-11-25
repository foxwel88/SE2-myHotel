package org.client.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.common.po.CityPO;
import org.common.utility.ResultMessage;

public class CityVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8137334106595243657L;
	
	public String cityName;
	
	public ResultMessage resultMessage;
	
	public CityVO(String cityName) {
		this.cityName = cityName;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	/*For fast transfer from data to view, called from hotelLogic*/
	public static List<CityVO> generateVOList(List<CityPO> pos) {
		List<CityVO> vos = new ArrayList<CityVO>();
		for (CityPO p: pos) {
			CityVO vo = new CityVO(p.cityName);
			vos.add(vo);
		}
		return vos;
	}
	
	public static CityPO generatePO(CityVO vo) {
		return new CityPO(vo.cityName);
	}
	
	public CityVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
