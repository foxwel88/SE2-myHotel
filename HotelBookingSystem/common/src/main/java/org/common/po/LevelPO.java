package org.common.po;

import java.io.Serializable;
import java.util.ArrayList;

public class LevelPO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2360607519386548756L;
	
	/**
	 * 等级的总个数
	 */
	public int levelNum;
	
	/**
	 * 每一等级需要的信用值
	 */
	public ArrayList<Integer> credits;
	
	public LevelPO(int levelNum, ArrayList<Integer> credits) {
		this.levelNum = levelNum;
		this.credits = credits;
	}

}
