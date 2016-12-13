package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.client.rmi.RMIHelper;
import org.client.vo.LevelVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.common.utility.ResultMessage;

/**
 * 实现了和等级制度相关的逻辑
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class Level {
	private int levelNum;
	
	private ArrayList<Double> credits;
	
	Level() {
		RMIHelper rmihelper = RMIHelper.getInstance();
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		try {
			LevelPO levelPO = promotionDataService.showLevel();
			this.levelNum = levelPO.levelNum;
			this.credits = levelPO.credits;
		} catch (RemoteException rex) {
			System.out.println(ResultMessage.CONNECTION_FAIL);
		}
	}
	
	LevelVO showLevel() {
		return new LevelVO(levelNum, credits);
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
				return ResultMessage.CONNECTION_FAIL;
			}
		} else {
			return ResultMessage.WRONG_FORMAT;
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
	
	int calLevel(double credit) {
		for (int i = levelNum - 1; i >= 0; i--) {
			if (credit >= credits.get(i)) {
				return i + 1;
			}
		}
		return 0;
	}
}
