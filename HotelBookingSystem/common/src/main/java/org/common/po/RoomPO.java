package org.common.po;

import java.io.Serializable;
import java.util.ArrayList;

import org.common.utility.RoomType;

public class RoomPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1398523663133493581L;

	public ArrayList<RoomType> roomType;
	
	public ArrayList<Integer> roomNum;
	
	public ArrayList<Double> roomPrice;	
	
	public RoomPO(ArrayList<RoomType> roomType, ArrayList<Integer> roomNum,
				ArrayList<Double> roomPrice) {
		this.roomType = new ArrayList<RoomType>(roomType);
		this.roomNum = new ArrayList<Integer>(roomNum);
		this.roomPrice = new ArrayList<Double>(roomPrice);
	}
	



}
