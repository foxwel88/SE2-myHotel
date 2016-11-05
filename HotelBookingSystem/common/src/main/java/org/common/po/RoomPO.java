package org.common.po;

import java.io.Serializable;
import org.common.utility.RoomType;

public class RoomPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1398523663133493581L;

	public RoomType roomType;
	
	public int roomNum;
	
	public double roomPrice;	
	
	public RoomPO(String roomType, int roomNum, double roomPrice) {
		this.roomType = RoomType.getType(roomType);
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
	}
	
	public RoomPO(RoomType type, int roomNum, double roomPrice) {
		this.roomType = type;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;		
	}
	
	



}
