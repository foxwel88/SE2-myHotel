package org.common.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 用来生成新的ID的接口
 * @author Foxwel
 * @version 2016/12/09 Foxwel
 */

public interface IDService extends Remote {

	public String getLastHotelID() throws RemoteException;
	
	public String generateNewUserID() throws RemoteException;
	
	public String generateNewHotelID() throws RemoteException;
}
