package org.common.dataservice.OrderDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

/**
 * Order模块在data层的接口
 */
public interface OrderDataService extends Remote {

	/**
	 * 系统返回一条订单信息
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public OrderPO getOrderPO(String orderID) throws RemoteException;

	/**
	 * 返回某客户某种类全部订单po
	 * @param userID
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> getUserOrderPO (String userID, OrderType type) throws RemoteException;

	/**
	 * 返回某酒店某种类全部订单po
	 * @param hotelID
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> getHotelOrderPO (String hotelID, OrderType type) throws RemoteException;

	/**
	 * 返回当日全部异常订单po
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> getAbnormalOrderPO () throws RemoteException;

	/**
	 * 系统返回添加结果记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage add (OrderPO po) throws RemoteException;

	/**
	 * 更新一个orderPO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modify (OrderPO po) throws RemoteException;

	/**
	 * 将未执行订单中超过最晚入住时间的订单设为异常
	 * @param date，最晚入住时间
	 * @throws RemoteException
	 */
	public void updateAbnormalOrders(Date date) throws RemoteException;

	/**
	 * 返回一定期间内的某hotel的订单
	 * @param hotelID
	 * @param date
	 * @return 该酒店的订单中预定入住时间>=date，预定离开时间<=date的订单
	 * @throws RemoteException
	 */
	public List<OrderPO> getDateOrderPO (String hotelID, Date date) throws RemoteException;
}
