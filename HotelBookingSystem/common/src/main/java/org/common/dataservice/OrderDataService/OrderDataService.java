package org.common.dataservice.OrderDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public interface OrderDataService extends Remote
{
	public OrderPO getOrderPO(String orderID) throws RemoteException;
	//系统返回一条订单信息
	
	public ArrayList<OrderPO> getUserOrderPO (String userID, OrderType type) throws RemoteException;
	//返回某客户某种类全部订单po
	
	public ArrayList<OrderPO> getHotelOrderPO (String hotelID, OrderType type) throws RemoteException;
	//返回某酒店某种类全部订单po
	
	public ArrayList<OrderPO> getAbnormalOrderPO (Date date) throws RemoteException;
	//返回当日全部异常订单po
	
	public ResultMessage add (OrderPO po) throws RemoteException;
	//系统返回添加结果记录
	
	public ResultMessage modify (OrderPO po) throws RemoteException;
	//更新一个po
	
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
