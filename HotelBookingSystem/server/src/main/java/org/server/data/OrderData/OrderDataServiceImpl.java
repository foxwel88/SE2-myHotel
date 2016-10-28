package org.server.data.OrderData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.List;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511666908358074048L;

	public OrderDataServiceImpl() throws RemoteException {
		System.out.println("order start");
		// TODO Auto-generated constructor stub
	}

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> getAbnormalOrderPO(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modify(OrderPO po) throws RemoteException {
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
