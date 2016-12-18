package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
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
	
	private OrderPO po1;
	
	private OrderPO po2;
	
	private OrderPO po3;
	
	private OrderPO po4;
	
	protected OrderDataServiceImpl_stub() throws RemoteException {
		super();
		po1 = new OrderPO(OrderType.UNEXECUTED,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
					"00001","栖霞大酒店","000000000120161122112233","南京市仙林大道168号栖霞大酒店",RoomType.BIG,100,1,2,false, "foxwel","0000000001","13919191919",false,false);
		
		po2 = new OrderPO(OrderType.CANCELED,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00002","栖霞大酒店","000000000120161122112244","南京市仙林大道168号栖霞大酒店",RoomType.BIG,120,1,2,false, "foxwel","0000000001","13919191919",false,false);
	
		po3 = new OrderPO(OrderType.UNEXECUTED,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00002","七天连锁酒店","000001234520161122112255","栖七天连锁酒店大酒店",RoomType.SINGLE,150,1,2,false, "ct","0000012345","13645454545",false,false);
		
		po4 = new OrderPO(OrderType.ABNORMAL,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00001","七天连锁酒店","000001234520161122112266","栖七天连锁酒店大酒店",RoomType.SINGLE,350,1,2,false, "ct","0000012345","13645454545",false,false);
	
		// TODO Auto-generated constructor stub
	}

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		if (orderID.equals("000000000120161122112233")) {
			return po1;
		}
		
		if (orderID.equals("000000000120161122112244")) {
			return po2;
		}
		
		if (orderID.equals("000001234520161122112255")) {
			return po3;
		}
		
		if (orderID.equals("000001234520161122112266")) {
			return po4;
		}
		
		return null;
	}

	public ArrayList<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<>();
		
		if (userID.equals("0000000001")) {
			pos.add(po1);
			pos.add(po2);
		}
		
		if (userID.equals("0000012345")) {
			pos.add(po3);
			pos.add(po4);
		}
		
		return pos;
	}

	public ArrayList<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<>();
		
		if (hotelID.equals("00001")) {
			pos.add(po1);
			pos.add(po4);
		}
		
		if (hotelID.equals("00002")) {
			pos.add(po2);
			pos.add(po3);
		}
		
		return pos;
	}

	public ArrayList<OrderPO> getAbnormalOrderPO() throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<>();
		pos.add(po4);
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

	@Override
	public void updateAbnormalOrders(Date date) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
