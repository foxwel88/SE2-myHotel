package org.common.utility;

public enum RoomType {
	SINGLE("单人间"), BIG("套间"), DOUBLE("标间");
	
	private String s;
	
	private RoomType(String s) 
	{
		this.s = s;
	}
	
	public String getString() 
	{
		return s;
	}
	
	public RoomType getType(String ss) 
	{
		if (ss.equals("单人间")) return RoomType.SINGLE;
		if (ss.equals("套间")) return RoomType.BIG;
		if (ss.equals("标间")) return RoomType.DOUBLE;
		return null;
	}
}
