package org.common.po;

import java.io.Serializable;

public class AreaPO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String adress;
	
	public AreaPO(String adress){
		this.adress = adress;
	}

}
