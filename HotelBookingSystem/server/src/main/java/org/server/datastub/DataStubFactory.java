package org.server.datastub;

import java.rmi.RemoteException;

public class DataStubFactory {
	private static DataStubFactory datafactory;
	
	public static DataStubFactory getInstance() {
		if (datafactory == null) {
			datafactory = new DataStubFactory();
		}
		return datafactory;
	}
	
	public CommentDataServiceImpl_stub getCommentDataServiceImpl() throws RemoteException {
		return new CommentDataServiceImpl_stub();
	}
	
	public HotelDataServiceImpl_stub getHotelDataServiceImpl() throws RemoteException {

		return new HotelDataServiceImpl_stub();
	}
	
	public OrderDataServiceImpl_stub getOrderDataServiceImpl() throws RemoteException {
		return new OrderDataServiceImpl_stub();
	}
	
	public PromotionDataServiceImpl_stub getPromotionDataServiceImpl() throws RemoteException {
		return new PromotionDataServiceImpl_stub();
	}
	
	public UserDataServiceImpl_stub getUserDataServiceImpl() throws RemoteException {
		return new UserDataServiceImpl_stub();
	}

}
