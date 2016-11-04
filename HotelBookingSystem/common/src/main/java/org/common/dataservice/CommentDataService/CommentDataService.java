package org.common.dataservice.CommentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public interface CommentDataService extends Remote {
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public List<CommentPO> find(String hotelAddress) throws RemoteException;
	//按地址进行查找返回相应的CommentPO结果
	
	public ResultMessage insert(CommentPO po) throws RemoteException;
	//在数据库中插入一个po
	
	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
