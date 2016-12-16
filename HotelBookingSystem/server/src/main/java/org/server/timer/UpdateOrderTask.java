package org.server.timer;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.TimerTask;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.server.data.OrderData.OrderDataServiceImpl;

public class UpdateOrderTask extends TimerTask {
	OrderDataService orderDataService;
	
	Date ddl;
	
	UpdateOrderTask(Date ddl) {
		this.ddl = ddl;
	}
	
	@Override
	public void run() {
		try {
			orderDataService = new OrderDataServiceImpl();
			orderDataService.updateAbnormalOrders(ddl);
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}
}
