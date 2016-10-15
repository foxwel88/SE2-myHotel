package org.server.datastub;

import java.rmi.RemoteException;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentDataServiceImpl_stub implements CommentDataService{

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public CommentPO find(String hotelAddress) throws RemoteException {
		return new CommentPO(hotelAddress, hotelAddress, null, 1, hotelAddress);
	}

	public ResultMessage insert(CommentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
