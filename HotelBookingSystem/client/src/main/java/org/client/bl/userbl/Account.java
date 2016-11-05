package org.client.bl.userbl;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.utility.ResultMessage;

public class Account {
	
	private static Account account = null;
	
	private Account() { 
		
	}
	
	public static Account getInstance() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
	
	public ResultMessage login(String userName, String password) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		ResultMessage message = null;
		try {
			message = dao.Check(userName, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public ResultMessage logout(String ID) {
		return ResultMessage.SUCCESS;
	}
}
