package org.common.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeService extends Remote {
	public String getCurrentTime() throws RemoteException;
}
