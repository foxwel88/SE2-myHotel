package org.common.dataservice.UserDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.ResultMessage;

/**
 * user模块在data的接口
 * @author gyue
 */
public interface UserDataService extends Remote {

	/**
	 * 在数据库中增加一个UserPO记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage add(UserPO po) throws RemoteException;

	/**
	 * 按ID进行查找返回相应的UserPO记录
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public UserPO findbyID(String ID) throws RemoteException;

	/**
	 * 按UserName进行查找返回相应的UserPO记录
	 * @param userName
	 * @return
	 * @throws RemoteException
	 */
	public UserPO findbyUserName(String userName) throws RemoteException;

	/**
	 * 更新一个PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modify(UserPO po) throws RemoteException;

	/**
	 * 系统检查是否存在账户账户密码是否对应
	 * @param userName
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage Check (String userName, String password) throws RemoteException;

	/**
	 * 在数据库中增加一个CreditRecordPO记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException;

	/**
	 * 按ID进行查找返回相应的CreditRecordPO记录
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public List<CreditRecordPO> findCreditRecords(String ID) throws RemoteException;

	/**
	 * 删除用户
	 * @param userName
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage deleteUser(String userName) throws RemoteException;

	/**
	 * 增加已登录用户的信息
	 * @param userName
	 * @throws RemoteException
	 */
	public void addNowUser(String userName) throws RemoteException;

	/**
	 * 判断用户是否已登陆
	 * @param userName
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage userIsExist(String userName) throws RemoteException;

	/**
	 * 删除已登陆用户的信息
	 * @param userName
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage deleteNowUser(String userName) throws RemoteException;
}
