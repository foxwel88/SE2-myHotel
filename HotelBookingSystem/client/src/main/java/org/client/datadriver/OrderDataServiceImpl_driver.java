package org.client.datadriver;

import java.rmi.RemoteException;
import java.sql.Date;

import org.client.rmi.RMIHelper;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;

public class OrderDataServiceImpl_driver {

	public static void main(String[] args) {
		OrderDataService stub = RMIHelper.getInstance().getOrderDataServiceImpl();
		try {
			stub.init();
			System.out.println(stub.add(new OrderPO(null, null, null, null, null, null, null, null, null, null, null, null, 100, 0, 0, false, null, null)));
			System.out.println(stub.getAbnormalOrderPO(new Date(0)));
			System.out.println(stub.getHotelOrderPO("loveHotel", OrderType.UNEXECUTED));
			System.out.println(stub.getOrderPO("012345678920161015211206"));
			System.out.println(stub.getUserOrderPO("0123456788", OrderType.ABNORMAL));
			System.out.println(stub.modify(new OrderPO(null, null, null, null, null, null, null, null, null, null, null, null, 100, 0, 0, false, null, null)));
			stub.finish();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
