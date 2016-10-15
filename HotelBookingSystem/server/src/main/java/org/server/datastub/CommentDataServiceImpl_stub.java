package org.server.datastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentDataServiceImpl_stub implements CommentDataService{

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public ArrayList<CommentPO> find(String hotelAddress) throws RemoteException {
		ArrayList<CommentPO> comments = new ArrayList<CommentPO>();
		comments.add(new CommentPO(hotelAddress, hotelAddress, null, 1, hotelAddress));
		return comments;
	}

	public ResultMessage insert(CommentPO po) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	public void finish() throws RemoteException {
		System.out.println("finish");
	}

}
