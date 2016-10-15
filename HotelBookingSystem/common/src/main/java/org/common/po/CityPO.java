package org.common.po;

import java.io.Serializable;

public class CityPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4774675473702136215L;
	
	public String cityName;
	
	public CityPO(String cityName){
		this.cityName = cityName;
	}
}
