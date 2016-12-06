package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.Date;

import org.client.rmi.RMIHelper;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

/**
 * 实现了修改促销策略的逻辑
 * @author fraliphsoft
 * @version fraliphsoft 12/6
 */
public class Promotion {
	String promotionID;
	
	String provider;
	
	String type; 
	
	Date startTime;
	
	Date endTime;
	
	String hotelName;
	
	String hotelID;
	
	int level;
	
	String area;
	
	double discount;
	
	String name;
	
	Promotion(PromotionVO vo) {
		promotionID = vo.promotionID;
		
		provider = vo.provider;
		
		type = vo.type;
		
		startTime = vo.startTime;
		
		endTime = vo.endTime;
		
		hotelName = vo.hotelName;
		
		hotelID = vo.hotelID;
		
		level = vo.level;
		
		area = vo.area;
		
		discount = vo.discount;
		
		name = vo.name;
	}
	
	Promotion(PromotionPO po) {
		promotionID = po.promotionID;
		
		provider = po.provider;
		
		type = po.type.getString();
		
		startTime = po.startTime;
		
		endTime = po.endTime;
		
		hotelName = po.hotelName;
		
		level = po.level;
		
		area = po.area;
		
		discount = po.discount;
		
		name = po.name;
	}
	
	PromotionVO toVO() {
		return new PromotionVO(promotionID, provider, type, startTime, endTime, hotelName, hotelID, level, area, discount, hotelName);
	}
	
	PromotionPO toPO() {
		return new PromotionPO(promotionID, provider, PromotionType.getType(type), startTime, endTime, hotelName, hotelID, level, area, discount, hotelName);
	}
	
	ResultMessage modify (PromotionVO vo) {
		RMIHelper rmihelper = RMIHelper.getInstance();
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		promotionID = vo.promotionID;
		provider = vo.provider;
		type = vo.type;
		startTime = vo.startTime;
		endTime = vo.endTime;
		hotelName = vo.hotelName;
		level = vo.level;
		area = vo.area;
		discount = vo.discount;
		name = vo.name;
		
		PromotionPO po = new PromotionPO(promotionID, provider, PromotionType.getType(type), startTime, endTime, hotelName, hotelID, level, area, discount, name);
		try {
			promotionDataService.modify(po);
			return ResultMessage.SUCCESS;
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
}
