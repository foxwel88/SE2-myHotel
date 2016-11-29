package org.common.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Time服务类接口
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public interface TimeService extends Remote {
	public String getCurrentTime() throws RemoteException;
	
	public Date getDate() throws RemoteException;
}
