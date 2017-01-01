package org.server.data.datafactory;

import java.rmi.RemoteException;

import org.server.data.commentdata.CommentDataServiceImpl;
import org.server.data.hoteldata.HotelDataServiceImpl;
import org.server.data.orderdata.OrderDataServiceImpl;
import org.server.data.promotiondata.PromotionDataServiceImpl;
import org.server.data.userdata.UserDataServiceImpl;
import org.server.id.IDUtil;
import org.server.time.TimeServiceImpl;

/**
 * 负责各类dao的创建工作
 * 
 */
public class DataFactory {
	private static DataFactory datafactory;
	
	private static TimeServiceImpl timeServiceImpl;
	
	private static IDUtil idUtil;
	
	public static DataFactory getInstance() {
		if (datafactory == null) {
			datafactory = new DataFactory();
		}
		return datafactory;
	}
	
	public CommentDataServiceImpl getCommentDataServiceImpl() throws RemoteException {
		return new CommentDataServiceImpl();
	}
	
	public HotelDataServiceImpl getHotelDataServiceImpl() throws RemoteException {

		return new HotelDataServiceImpl();
	}
	
	public OrderDataServiceImpl getOrderDataServiceImpl() throws RemoteException {
		return new OrderDataServiceImpl();
	}
	
	public PromotionDataServiceImpl getPromotionDataServiceImpl() throws RemoteException {
		return new PromotionDataServiceImpl();
	}
	
	public UserDataServiceImpl getUserDataServiceImpl() throws RemoteException {
		return new UserDataServiceImpl();
	}

	public TimeServiceImpl getTimeServiceImpl() throws RemoteException {
		if (timeServiceImpl == null) {
			timeServiceImpl = new TimeServiceImpl();
		}
		return timeServiceImpl;
	}
	
	public IDUtil getIDUtil() throws RemoteException {
		if (idUtil == null) {
			idUtil = new IDUtil();
		}
		return idUtil;
	}
}
