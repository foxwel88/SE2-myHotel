package org.server.timer;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.TimerTask;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.server.data.orderdata.OrderDataServiceImpl;

/**
 * 检测超过最晚入住时间的未执行订单，设为异常订单
 */
public class UpdateOrderTask extends TimerTask {
	OrderDataService orderDataService;
	
	UpdateOrderTask() {
	}
	
	@Override
	public void run() {
		try {
			orderDataService = new OrderDataServiceImpl();
			orderDataService.updateAbnormalOrders(Calendar.getInstance().getTime());
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
	}
}
