package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.userbl.UserController;
import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.CreditOperation;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;

public class OrderUtil {
	
	private static OrderUtil util;
	
	private static OrderDataService dao;
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
	}
	
	public static OrderUtil getInstance() {
		if (util == null) {
			util = new OrderUtil();
		}
		return util;
	}
	
	private boolean check(OrderVO vo) {
		return true;
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		Order myorder = new Order();
		
		UserVO uservo = UserController.getInstance().findbyUserName(vo.customerName);
		
		if (uservo.credit == 0) {
			return ResultMessage.CREDITNOTENOUGH;
		}
		
		if (!check(vo)) {
			return ResultMessage.WRONGFORMAT;
		}
		
		myorder.setOrder(vo);
		OrderPO po = myorder.getOrderPO();
		try {
			return dao.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
	}
	
	public OrderVO getOrder (String orderID) {
		Order myorder = new Order();
		try {
			myorder.setOrder(dao.getOrderPO(orderID));
			return myorder.getOrderVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			OrderVO vo = new OrderVO(ResultMessage.CONNECTIONFAIL);
			return vo;
		}
	}
	
	public List<OrderVO> getAbnormalOrder () {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getAbnormalOrderPO());
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OrderVO> getUserOrderList (String userID, OrderType type) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getUserOrderPO(userID, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<OrderVO> getHotelOrderList (String hoteladdress, OrderType type) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getHotelOrderPO(hoteladdress, type));
			return mylist.getOrderListVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultMessage cancelOrder (String orderID) {
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		
		if (myorder.type != OrderType.UNEXECUTED) {
			return ResultMessage.NOTEXIST;
		}
		
		myorder.type = OrderType.CANCELED;
		myorder.cancelTime = null;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage executeOrder (String orderID) {
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		
		if ((myorder.type != OrderType.UNEXECUTED) || (myorder.type != OrderType.ABNORMAL)) {
			return ResultMessage.NOTEXIST;
		}
		
		myorder.type = OrderType.EXECUTED;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		

		UserVO uservo = UserController.getInstance().findbyID(myorder.userID);
		CreditRecordVO creditrecordvo = new CreditRecordVO(null, myorder.orderID, uservo.ID, myorder.totalPrice, uservo.credit + (myorder.totalPrice), CreditOperation.FINISHORDER.toString());
		UserController.getInstance().addCreditRecord(creditrecordvo);

		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		
		if (myorder.type != OrderType.ABNORMAL) {
			return ResultMessage.NOTEXIST;
		}
		
		myorder.type = OrderType.UNEXECUTED;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTIONFAIL;
		}
		

		UserVO uservo = UserController.getInstance().findbyID(myorder.userID);
		
		double temp = myorder.totalPrice / 2.0;
		if (isHalf) {
			temp = temp / 2.0;
		}
		
		CreditRecordVO creditrecordvo = new CreditRecordVO(null, myorder.orderID, uservo.ID, temp, uservo.credit + temp, CreditOperation.EXCEPTIONORDER.toString());
		UserController.getInstance().addCreditRecord(creditrecordvo);

		return ResultMessage.SUCCESS;
	}

	public List<String> getHistoryHotels(String userId) {
		OrderList mylist = new OrderList();
		try {
			mylist.setOrderList(dao.getUserOrderPO(userId, OrderType.EXECUTED));
			return mylist.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
