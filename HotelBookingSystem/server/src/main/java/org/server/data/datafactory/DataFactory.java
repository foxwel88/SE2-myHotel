package org.server.data.datafactory;

import java.rmi.RemoteException;

import org.common.utility.TimeService;
import org.server.data.CommentData.CommentDataServiceImpl;
import org.server.data.HotelData.HotelDataServiceImpl;
import org.server.data.OrderData.OrderDataServiceImpl;
import org.server.data.PromotionData.PromotionDataServiceImpl;
import org.server.data.UserData.UserDataServiceImpl;
import org.server.time.TimeServiceImpl;

public class DataFactory {
	private static DataFactory datafactory;
	
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
		return new TimeServiceImpl();
	}
}
