package org.client.bl.promotionbl;

import java.util.ArrayList;

import org.client.vo.LevelVO;
import org.common.utility.ResultMessage;

public class Level {

	public LevelVO showLevel(){
		return new LevelVO(0, new ArrayList<Integer>());
	}
	
	public ResultMessage modifyLevel (LevelVO vo){
		return null;
	}
}
