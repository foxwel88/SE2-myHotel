package org.common.dataservice.UserDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

public interface UserDataService extends Remote {
	public ResultMessage add(UserPO po) throws RemoteException;
	//在数据库中增加一个UserPO记录
	
	public UserPO findbyID(String ID) throws RemoteException;
	//按ID进行查找返回相应的UserPO记录
	
	public UserPO findbyUserName(String userName) throws RemoteException;
	//按UserName进行查找返回相应的UserPO记录
	
	public ResultMessage modify(UserPO po) throws RemoteException;
	//更新一个PO
	
	public ResultMessage Check (String userName, String password) throws RemoteException;
	//系统检查是否存在账户账户密码是否对应
	
	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException;
	//在数据库中增加一个CreditRecordPO记录
	
	public CreditRecordPO findCreditRecord(String ID) throws RemoteException;
	//按ID进行查找返回相应的CreditRecordPO记录
	
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public void finish() throws RemoteException;
	//结束持久化数据库的使用
}
