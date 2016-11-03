package org.client.bl.userbl;

import org.common.utility.ResultMessage;

public class Account {
	
	private static Account account = null;
	
	private Account(){}
	
	public static Account getInstance(){
		if(account == null) {
			account = new Account();
		}
		return account;
	}
	
	public ResultMessage login(String userName, String password) {
		return null;
	}
	
	public ResultMessage logout(String ID) {
		return null;
	}
}
