package org.server.time;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.common.utility.TimeService;

public class TimeServiceImpl extends UnicastRemoteObject implements TimeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060614742404108924L;
	
	private SimpleDateFormat timeFormat;
	
	private String currentTime;

	public TimeServiceImpl() throws RemoteException {
		super();
		timeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	
	/** yyyy/MM/dd HH:mm:ss */
	public String getCurrentTime() throws RemoteException {
		currentTime = timeFormat.format(Calendar.getInstance().getTime());
		return currentTime;
	}

	public Date getDate() throws RemoteException {
		return Calendar.getInstance().getTime();
	}

}
