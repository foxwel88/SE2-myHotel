package org.common.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.common.utility.RoomType;

public class RoomPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<RoomType> roomType;
	
	public ArrayList<Integer> roomNum;
	
	public ArrayList<Double> roomPrice;	
	



}
