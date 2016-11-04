package org.server.data.UserData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2823256785769392090L;

	public UserDataServiceImpl() throws RemoteException {
		System.out.println("user start");
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO findbyID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO findbyUserName(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage Check(String userName, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditRecordPO findCreditRecord(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
