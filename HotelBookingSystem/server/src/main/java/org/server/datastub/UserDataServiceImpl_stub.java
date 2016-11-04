package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

public class UserDataServiceImpl_stub extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6141135701304906056L;

	protected UserDataServiceImpl_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(UserPO po) throws RemoteException {
		if (po.userName.equals("gz")) {
			return ResultMessage.EXIST;
		}
		return ResultMessage.SUCCESS;
	}

	public UserPO findbyID(String ID) throws RemoteException {
		return new UserPO(null, ID, ID, ID, ID, ID, 0, null, ID, 0, 0, ID);
	}

	public UserPO findbyUserName(String userName) throws RemoteException {
		if (userName.equals("gz")) {
			return new UserPO(null, userName, userName, userName, userName, userName, 0, null, userName, 0, 0, userName);
		}
		return null;
	}

	public ResultMessage modify(UserPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Check(String userName, String password) throws RemoteException {
		if (userName.equals("gz") && password.equals("123")) {
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.WRONGVALUE;
	}

	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public CreditRecordPO findCreditRecord(String ID) throws RemoteException {
		return new CreditRecordPO(null, ID, 0, 0, null, ID);
	}

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}

}
