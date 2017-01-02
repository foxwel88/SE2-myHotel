package org.client.blservice.userblservice;

import java.util.List;

import org.client.vo.CreditRecordVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

/**
 * User模块在logic层的接口
 * @author foxwel
 */
public interface UserBlService {
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public ResultMessage login(String userName, String password);

	/**
	 * 登出
	 * @param userName
	 * @return
	 */
	public ResultMessage logout(String userName);

	/**
	 * 添加一个用户
	 * @param vo
	 * @return
	 */
	public ResultMessage add(UserVO vo);

	/**
	 * 根据userID查询获得一个用户vo
	 * @param ID
	 * @return
	 */
	public UserVO findbyID(String ID);

	/**
	 * 根据用户名查询获得一个用户vo
	 * @param userName
	 * @return
	 */
	public UserVO findbyUserName(String userName);

	/**
	 * 修改指定用户的密码
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public ResultMessage modifyPassword(String userName, 
			String oldPassword, String newPassword);

	/**
	 * 修改用户信息
	 * @param vo
	 * @return
	 */
	public ResultMessage modify(UserVO vo);

	/**
	 * 添加一条信用记录
	 * @param vo， 包括userId, orderId等信息作为标志
	 * @return
	 */
	public ResultMessage addCreditRecord (CreditRecordVO vo);

	/**
	 * 获得指定id用户的所有信用记录
	 * @param ID
	 * @return
	 */
	public List<CreditRecordVO> findCreditRecord(String ID);

	/**
	 * 获得指定ID的用户等级
	 * @param ID
	 * @return
	 */
	public UserLevelVO getLevel(String ID);

	/**
	 * 根据用户名删除一个用户
	 * @param userName
	 * @return
	 */
	public ResultMessage deleteUser(String userName);

}
