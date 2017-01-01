package org.server.datastub;

import java.rmi.RemoteException;

public class DataStubFactory {
	private static DataStubFactory dataFactory;
	
	public static DataStubFactory getInstance() {
		if (dataFactory == null) {
			dataFactory = new DataStubFactory();
		}
		return dataFactory;
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
