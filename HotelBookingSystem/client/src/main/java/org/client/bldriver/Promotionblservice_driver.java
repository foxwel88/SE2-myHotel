package org.client.bldriver;

import java.util.ArrayList;
import java.util.Date;

import org.client.blstub.Promotion_stub;
import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.PromotionType;

public class Promotionblservice_driver {
	
	public static void main(String[] args){
		Promotion_stub stub= new Promotion_stub();
		
		System.out.println(stub.getPromotion("asd", "213e12"));
		System.out.println(stub.showHotelPromotion("vdxgn"));
		System.out.println(stub.showWebsitePromotion());
		System.out.println(stub.modify(new PromotionVO(PromotionType.COMPANYBONUS, new Date(), new Date(), "fds", 3, "sdf", 1.2)));
		System.out.println(stub.delete(new PromotionVO(PromotionType.COMPANYBONUS, new Date(), new Date(), "fds", 3, "sdf", 1.2)));
		System.out.println(stub.showLevel());
		System.out.println(stub.modifyLevel(new LevelVO(1, new ArrayList<Integer>())));
		System.out.println(stub.add(new PromotionVO(PromotionType.COMPANYBONUS, new Date(), new Date(), "fds", 3, "sdf", 1.2)));
	}
}
