package org.client.vo;

import java.io.Serializable;
import java.util.ArrayList;

import org.common.utility.ResultMessage;

public class LevelVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7419581915792268695L;

	public int levelNum;
	
	/**
	 * 每一等级需要的信用值
	 */
	public ArrayList<Integer> credits;
	
	public ResultMessage resultMessage;
	
	public LevelVO(int levelNum, ArrayList<Integer> credits) {
		this.levelNum = levelNum;
		this.credits = credits;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public LevelVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
