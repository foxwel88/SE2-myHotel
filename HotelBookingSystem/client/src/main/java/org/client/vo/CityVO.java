package org.client.vo;

import java.io.Serializable;

public class CityVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8137334106595243657L;
	public String cityName;
	
	public CityVO(String cityName){
		this.cityName = cityName;
	}
}
