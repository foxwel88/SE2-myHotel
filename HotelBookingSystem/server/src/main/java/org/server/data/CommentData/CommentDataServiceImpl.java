package org.server.data.CommentData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentDataServiceImpl extends UnicastRemoteObject implements CommentDataService 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5618743255476533176L;

	public CommentDataServiceImpl() throws RemoteException {
		System.out.println("comment start");
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<CommentPO> find(String hotelAddress) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage insert(CommentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
