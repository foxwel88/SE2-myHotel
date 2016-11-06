package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.Date;

import org.client.rmi.RMIHelper;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;

public class Promotion {
	String type; 
	
	Date startTime;
	
	Date endTime;
	
	String hotelName;
	
	int level;
	
	String area;
	
	double discount;
	
	String name;
	
	Promotion(PromotionVO vo) {
		type = vo.type;
		
		startTime = vo.startTime;
		
		endTime = vo.endTime;
		
		hotelName = vo.hotelName;
		
		level = vo.level;
		
		area = vo.area;
		
		discount = vo.discount;
		
		name = vo.name;
	}
	
	Promotion(PromotionPO po) {
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
		return new PromotionVO(type, startTime, endTime, hotelName, level, area, discount, hotelName);
	}
	
	PromotionPO toPO() {
		return new PromotionPO(PromotionType.getType(type), startTime, endTime, hotelName, level, area, discount, hotelName);
	}
	
	ResultMessage modify (PromotionVO vo) {
		if (PromotionUtil.checkPromotionFormat(vo, false)) {
			RMIHelper rmihelper = RMIHelper.getInstance();
			
			PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
			
			type = vo.type;
			
			startTime = vo.startTime;
			
			endTime = vo.endTime;
			
			hotelName = vo.hotelName;
			
			level = vo.level;
			
			area = vo.area;
			
			discount = vo.discount;
			
			name = vo.name;
			
			PromotionPO po = new PromotionPO(PromotionType.getType(type), startTime, endTime, hotelName, level, area, discount, name);
			
			try {
				promotionDataService.modify(po);
				
				return ResultMessage.SUCCESS;
			} catch (RemoteException rex) {
				return ResultMessage.CONNECTIONFAIL;
			}
		} else {
			return ResultMessage.WRONGFORMAT;
		}
	}
}
