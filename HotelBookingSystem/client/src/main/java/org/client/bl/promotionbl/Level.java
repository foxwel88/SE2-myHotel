package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.client.rmi.RMIHelper;
import org.client.vo.LevelVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.utility.ResultMessage;

public class Level {
	private int levelNum;
	
	private ArrayList<Integer> credits;
	
	private static Level level;
	
	private Level(int levelNum, ArrayList<Integer> credits) {
		this.levelNum = levelNum;
		
		this.credits = credits;
	}
	
	static Level getInstance() {
		if (level == null) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
			
			try {
				LevelPO levelPO = promotionDataService.showLevel();
				
				level = new Level(levelPO.levelNum, levelPO.credits);
			} catch (RemoteException rex) {
				System.out.println(ResultMessage.CONNECTIONFAIL);
			}
		}
		return level;
	}
	
	LevelVO showLevel() {
		if (level != null) {
			return new LevelVO(levelNum, credits);
		} else {
			return new LevelVO(ResultMessage.NOTEXIST);
		}
	}
	
	ResultMessage modifyLevel (LevelVO vo) {
		if (checkLevelFormat(vo)) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
			
			levelNum = vo.levelNum;
			
			credits = vo.credits;
			
			LevelPO po = new LevelPO(levelNum, credits);
			
			try {
				promotionDataService.modifyLevel(po);
				
				return ResultMessage.SUCCESS;
			} catch (RemoteException rex) {
				return ResultMessage.CONNECTIONFAIL;
			}
		} else {
			return ResultMessage.WRONGFORMAT;
		}
	}
	
	private boolean checkLevelFormat(LevelVO vo) {
		boolean isOK = true;
		
		if (vo.levelNum < 1) {
			isOK = false;
		}
		
		if (vo.credits.size() != vo.levelNum) {
			isOK = false;
		}
		
		for (int i = 0; i < vo.credits.size(); i++) {
			if (vo.credits.get(i) <= 0) {
				isOK = false;
				break;
			}
		}
		
		return isOK;
	}
}
