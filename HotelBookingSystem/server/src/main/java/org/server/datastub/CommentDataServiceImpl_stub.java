package org.server.datastub;

import java.rmi.RemoteException;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentDataServiceImpl_stub implements CommentDataService{

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public CommentPO find(String hotelAddress) throws RemoteException {
		if(hotelAddress == null || hotelAddress.length() == 0) {
			return null;
		}
		return new CommentPO(hotelAddress, hotelAddress, null, 1, hotelAddress);
	}

	public ResultMessage insert(CommentPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}

}
