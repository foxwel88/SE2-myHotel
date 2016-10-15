package org.server.datastub;

import java.rmi.RemoteException;

import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

public class UserDataServiceImpl_stub implements UserDataService{

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
