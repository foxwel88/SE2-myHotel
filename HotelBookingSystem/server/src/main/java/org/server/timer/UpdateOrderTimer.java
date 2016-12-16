package org.server.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

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
		orderUpdater.schedule(new UpdateOrderTask(baselineTime), baselineTime, 24 * 60 * 60 * 1000);
	}
	
	public void startTimer(int hour, int minite, int second) {
		setBaseline(hour, minite, second);
		Timer orderUpdater = new Timer();
		baselineTime = calendar.getTime();
		orderUpdater.schedule(new UpdateOrderTask(baselineTime), baselineTime, 24 * 60 * 60 * 1000);
	}
	
	private void setBaseline(int hour, int minite, int second) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minite);
		calendar.set(Calendar.SECOND, second);
	}
}
