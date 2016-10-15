package org.server.datastub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class OrderDataServiceImpl_stub implements OrderDataService{

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		return new OrderPO(null, null, null, null, null, null, null, orderID, orderID, orderID, null, 0, 0, false);
	}

	public ArrayList<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(type, null, null, null, null, null, null, userID, userID, userID, null, 0, 0, false));
		return pos;
	}

	public ArrayList<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(type, null, null, null, null, null, null, hotelID, hotelID, hotelID, null, 0, 0, false));
		return pos;
	}

	public ArrayList<OrderPO> getAbnormalOrderPO(Date date) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(new OrderPO(OrderType.ABNORMAL, date, date, date, date, null, null, "", "", "", RoomType.BIG, 0, 0, false));
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
