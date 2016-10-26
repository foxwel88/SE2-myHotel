package org.client.datadriver;

import java.rmi.RemoteException;

import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.server.datastub.PromotionDataServiceImpl_stub;

public class PromotionDataServiceImpl_driver {

	public static void main(String[] args) {
		PromotionDataServiceImpl_stub stub = new PromotionDataServiceImpl_stub();
		try {
			stub.init();
			System.out.println(stub.add(new PromotionPO(PromotionType.BIRTHDAYBONUS, null, null, null, 0, null, 0, null)));
			System.out.println(stub.modify(new PromotionPO(PromotionType.VIPLEVEL, null, null, null, 0, null, 0, null)));
			System.out.println(stub.modifyLevel(new LevelPO(5, null)));
			System.out.println(stub.showHotelPromotion("loveHotel"));
			System.out.println(stub.showLevel());
			System.out.println(stub.showWebsitePromotion());
			stub.finish();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
