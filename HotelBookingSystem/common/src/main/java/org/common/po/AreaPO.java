package org.common.po;

import java.io.Serializable;

public class AreaPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2645401662037528338L;
	
	public String address;
	
	public AreaPO(String address) {
		this.address = address;
	}

}
