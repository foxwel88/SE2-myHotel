package org.client.bl.userbl;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.utility.ResultMessage;

/**
 * 管理登录登出的工具类
 * @author gyue
 * @version 2016/11/27 gyue
 */
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
		if (dao == null) {
			return ResultMessage.CONNECTION_FAIL;
		}
		ResultMessage message = null;
		// 检查用户名/密码是否正确
		try {
			message = dao.Check(userName, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		if (message != ResultMessage.SUCCESS) {
			return message;
		}
		//检查该用户是否已登录
		try {
			message = dao.userIsExist(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		if (message == ResultMessage.EXIST) {
			return message;
		}
		//告诉服务器该用户已登录
		try {
			dao.addNowUser(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage logout(String userName) {
		UserDataService dao = RMIHelper.getInstance().getUserDataServiceImpl();
		//告诉服务器该用户登出
		ResultMessage info;
		try {
			info = dao.deleteNowUser(userName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return info;
	}
}
