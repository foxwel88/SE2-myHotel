package org.common.dataservice.OrderDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public interface OrderDataService extends Remote {
	public OrderPO getOrderPO(String orderID) throws RemoteException;
	//系统返回一条订单信息
	
	public List<OrderPO> getUserOrderPO (String userID, OrderType type) throws RemoteException;
	//返回某客户某种类全部订单po
	
	public List<OrderPO> getHotelOrderPO (String hotelID, OrderType type) throws RemoteException;
	//返回某酒店某种类全部订单po
	
	public List<OrderPO> getAbnormalOrderPO () throws RemoteException;
	//返回当日全部异常订单po
	
	public ResultMessage add (OrderPO po) throws RemoteException;
	//系统返回添加结果记录
	
	public ResultMessage modify (OrderPO po) throws RemoteException;
	//更新一个po

	public void updateAbnormalOrders(Date date) throws RemoteException;
	
	public List<OrderPO> getDateOrderPO (String hotelID, Date date) throws RemoteException;
}
