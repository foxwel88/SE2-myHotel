package org.server.datastub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentDataServiceImpl_stub extends UnicastRemoteObject implements CommentDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3808864191694388252L;

	protected CommentDataServiceImpl_stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		System.out.println("init!");
	}

	public ArrayList<CommentPO> find(String hotelAddress) throws RemoteException {
		ArrayList<CommentPO> comments = new ArrayList<>();
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
