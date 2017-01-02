package org.server.util.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 以输入的时间为起始点，每24小时执行一次UpdateOrderTask来更新订单状态
 *
 */
public class UpdateOrderTimer {
	private Date baselineTime;
	
	private Calendar calendar;
	
	public UpdateOrderTimer() {
		calendar = Calendar.getInstance();
	}
	
	public void startTimer() {
		setBaseline(24, 0, 0);
		Timer orderUpdater = new Timer();
		baselineTime = calendar.getTime();
		orderUpdater.schedule(new UpdateOrderTask(), baselineTime, 24 * 60 * 60 * 1000);
	}

	public void startTimer(int hour, int minite, int second) {
		setBaseline(hour, minite, second);
		Timer orderUpdater = new Timer();
		baselineTime = calendar.getTime();
		orderUpdater.schedule(new UpdateOrderTask(), baselineTime, 24 * 60 * 60 * 1000);
	}
	
	private void setBaseline(int hour, int minite, int second) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minite);
		calendar.set(Calendar.SECOND, second);
	}
}
