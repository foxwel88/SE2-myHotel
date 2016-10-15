package org.common.dataservice.HotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.common.po.HotelPO;
import org.common.utility.ResultMessage;

public interface HotelDataService extends Remote
{
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中插入一个po
	
	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中更新一个po
	
	public ResultMessage getHotelInfo(String hotelAddress) throws RemoteException;
	//在数据库中增加订单的流转信息
	
	public ResultMessage findHotels(HotelFilter filter) throws RemoteException;
	//在数据库中增加订单的流转信息
	
	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
