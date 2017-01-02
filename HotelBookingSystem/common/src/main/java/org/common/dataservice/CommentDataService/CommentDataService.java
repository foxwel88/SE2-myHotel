package org.common.dataservice.CommentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

/**
 * comment模块在data的接口
 */
public interface CommentDataService extends Remote {

	/**
	 * 按地址进行查找返回相应的CommentPO结果
	 * @param hotelAddress
	 * @return
	 * @throws RemoteException
	 */
	public List<CommentPO> find(String hotelAddress) throws RemoteException;

	/**
	 * 在数据库中插入一个评价
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage insert(CommentPO po) throws RemoteException;

}
