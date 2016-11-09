package org.client.bl.orderbl;

import java.rmi.RemoteException;
import java.util.List;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.HotelVO;
import org.client.vo.OrderVO;
import org.client.vo.UserVO;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.CreditOperation;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class OrderUtil {
	
	private static OrderUtil util;
	
	private OrderDataService dao;
	
	protected Userblservice userController;
	
	protected Hotelblservice hotelController;
	
	private OrderUtil() {
		dao = RMIHelper.getInstance().getOrderDataServiceImpl();
		userController = UserController.getInstance();
		hotelController = HotelController.getInstance();
	}
	
	public static OrderUtil getInstance() {
		if (util == null) {
			util = new OrderUtil();
		}
		return util;
	}
	
	public void setUserblservice(Userblservice userController) {
		this.userController = userController;
	}
	
	public void setHotelblservice(Hotelblservice hotelController) {
		this.hotelController = hotelController;
	}
	
	private boolean check(OrderVO vo) {
		if (vo.phoneNumber.length() != 11) {
			return false;
		}
		
		for (int i = 0; i < 11; ++i) {
			if (!((vo.phoneNumber.charAt(i) <= '9') && (vo.phoneNumber.charAt(i) >= '0'))) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkOrderID(String ID) {
		if (ID.length() != 24) {
			return false;
		}
	
		for (int i = 0; i < 11; ++i) {
			if (!((ID.charAt(i) <= '9') && (ID.charAt(i) >= '0'))) {
				return false;
			}
		}
		
		return true;
	}
	
	public ResultMessage createOrder(OrderVO vo) {
		Order myorder = new Order();
		
		UserVO uservo = userController.findbyUserName(vo.customerName);
		
		if (uservo.credit <= 0) {
			return ResultMessage.CREDIT_NOT_ENOUGH;
		}
		
		if (!check(vo)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		HotelVO hotelvo = hotelController.getHotelVO(vo.hotelAddress);
		
		List<String> roomtype = hotelvo.roomType;
		
		List<Integer> roomnum = hotelvo.roomNum;
		
		if (hotelvo.roomType != null) {
		
			for (int i = 0; i < roomtype.size(); ++i) {
				if (roomtype.get(i) == vo.roomType) {
					if (roomnum.get(i) < vo.roomNum) {
						return ResultMessage.ROOM_NOT_ENOUGH;
					} else {
						hotelController.changeRoom(RoomType.getType(vo.roomType), roomnum.get(i) - vo.roomNum, vo.hotelAddress);
					}
					break;
					
				}
			}
		}
		myorder.setOrder(vo);
		OrderPO po = myorder.getOrderPO();
		try {
			return dao.add(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	public OrderVO getOrder (String orderID) {
		
		if (!checkOrderID(orderID)) {
			OrderVO vo = new OrderVO(ResultMessage.WRONG_FORMAT);
			return vo;
		}
		
		Order myorder = new Order();
		try {
			OrderPO respo = dao.getOrderPO(orderID);
			
			if (respo == null) {
				OrderVO vo = new OrderVO(ResultMessage.NOT_EXIST);
				return vo;
			}
			
			myorder.setOrder(respo);
			
			
			return myorder.getOrderVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			OrderVO vo = new OrderVO(ResultMessage.CONNECTION_FAIL);
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
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
			myorder.setOrder(orderpo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		if (myorder.type != OrderType.UNEXECUTED) {
			return ResultMessage.NOT_EXIST;
		}
		
		myorder.type = OrderType.CANCELED;
		myorder.cancelTime = null;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage executeOrder (String orderID) {
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
			myorder.setOrder(orderpo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		
		if ((myorder.type != OrderType.UNEXECUTED) && (myorder.type != OrderType.ABNORMAL)) {
			return ResultMessage.NOT_EXIST;
		}
		
		myorder.type = OrderType.EXECUTED;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		

		UserVO uservo = userController.findbyID(myorder.userID);
		CreditRecordVO creditrecordvo = new CreditRecordVO(null, myorder.orderID, uservo.ID, myorder.totalPrice, uservo.credit + (myorder.totalPrice), CreditOperation.FINISHORDER.toString());
		userController.addCreditRecord(creditrecordvo);

		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage cancelAbnormalOrder (String orderID,Boolean isHalf) {
		
		if (!checkOrderID(orderID)) {
			return ResultMessage.WRONG_FORMAT;
		}
		
		Order myorder = new Order();
		OrderPO orderpo = null;
		try {
			orderpo = dao.getOrderPO(orderID);
			myorder.setOrder(orderpo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		
		if (myorder.type != OrderType.ABNORMAL) {
			return ResultMessage.NOT_EXIST;
		}
		
		myorder.type = OrderType.UNEXECUTED;
		
		orderpo = myorder.getOrderPO();
		try {
			dao.modify(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		

		UserVO uservo = userController.findbyID(myorder.userID);
		
		double temp = myorder.totalPrice / 2.0;
		if (isHalf) {
			temp = temp / 2.0;
		}
		
		CreditRecordVO creditrecordvo = new CreditRecordVO(null, myorder.orderID, uservo.ID, temp, uservo.credit + temp, CreditOperation.EXCEPTIONORDER.toString());
		userController.addCreditRecord(creditrecordvo);

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
