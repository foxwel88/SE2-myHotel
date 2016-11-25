package org.common.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface TimeService extends Remote {
	public String getCurrentTime() throws RemoteException;
	
	public Date getDate() throws RemoteException;
}
