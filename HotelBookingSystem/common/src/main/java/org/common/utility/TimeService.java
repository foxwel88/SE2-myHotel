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
	
	/**返回服务器当前时间， "yyyy/MM/dd HH:mm:ss" */
	public String getCurrentTime() throws RemoteException;
	
	/**返回服务器当前date */
	public Date getDate() throws RemoteException;
}
