package org.client.vo;

import java.io.Serializable;

import org.common.utility.ResultMessage;

public class UserLevelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public double creditToNext;
	
	public int level;
	
	public ResultMessage resultMessage;
	
	public UserLevelVO(double creditToNext, int level) {
		this.level = level;
		this.creditToNext = creditToNext;
		this.resultMessage = ResultMessage.SUCCESS;
	}
	
	public UserLevelVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}

}
