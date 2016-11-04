package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class OrderDataServiceImpl_stub extends UnicastRemoteObject implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -446301487541339431L;

	protected OrderDataServiceImpl_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		return new OrderPO(null, null, null, null, null, null, null, null, orderID, orderID, orderID, null, 100, 0, 0, false, orderID, orderID);
	}

	public ArrayList<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(type, null, null, null, null, null, null, null, userID, userID, userID, null, 100, 0, 0, false, userID, userID));
		return pos;
	}

	public ArrayList<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(type, null, null, null, null, null, null, null, hotelID, hotelID, hotelID, null, 100, 0, 0, false, hotelID, hotelID));
		return pos;
	}

	public ArrayList<OrderPO> getAbnormalOrderPO(Date date) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(OrderType.ABNORMAL, date, date, date, date, date, null, null, "", "", "", RoomType.BIG, 100, 0, 0, false, null, null));
		return pos;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(OrderPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}

}
