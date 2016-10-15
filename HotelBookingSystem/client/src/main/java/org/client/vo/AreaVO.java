package org.client.vo;

import java.io.Serializable;

public class AreaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305700000750388977L;
	
	public String address;
	
	public AreaVO(String address){
		this.address = address;
	}
}
