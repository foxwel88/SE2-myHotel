package org.server.datastub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderDataServiceImpl_stub implements OrderDataService{

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getAbnormalOrderPO(Date date) throws RemoteException {
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
