package org.client.bl.userbl;

import java.util.List;

import org.client.blservice.userblservice.Userblservice;
import org.client.vo.CreditRecordVO;
import org.client.vo.UserLevelVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

/**
 * userbl模块的controller
 * @author gyue
 * @version 2016/11/27 gyue
 *
 */
public class UserController implements Userblservice {
	
	private static UserController controller;
	
	private UserController() {
		
	}
	
	/**
	 * 单件设计模式
	 */
	public static UserController getInstance() {
		if (controller == null) {
			controller = new UserController();
		}
		return controller;
	}

	/**
	 * 登录
	 */
	public ResultMessage login(String userName, String password) {
		return Account.getInstance().login(userName, password);
	}

	/**
	 * 登出
	 */
	public ResultMessage logout(String ID) {
		return Account.getInstance().logout(ID);
	}

	/**
	 * 增加用户
	 */
	public ResultMessage add(UserVO vo) {
		return UserUtil.getInstance().add(vo);
	}

	/**
	 * 用ID获取用户VO
	 */
	public UserVO findbyID(String ID) {
		return UserUtil.getInstance().findbyID(ID);
	}

	/**
	 * 用UserName获取用户VO
	 */
	public UserVO findbyUserName(String userName) {
		return UserUtil.getInstance().findbyUserName(userName);
	}

	/**
	 * 更改用户密码
	 */
	public ResultMessage modifyPassword(String userName, String oldPassword, String newPassword) {
		return UserUtil.getInstance().modifyPassword(userName, oldPassword, newPassword);
	}

	/**
	 * 更改用户VO
	 */
	public ResultMessage modify(UserVO vo) {
		return UserUtil.getInstance().modify(vo);
	}

	/**
	 * 增加信用记录
	 */
	public ResultMessage addCreditRecord(CreditRecordVO vo) {
		return UserUtil.getInstance().addCreditRecord(vo);
	}

	/**
	 * 查找信用记录列表
	 */
	public List<CreditRecordVO> findCreditRecord(String ID) {
		return UserUtil.getInstance().findCreditRecord(ID);
	}

	/**
	 * 获得该用户的等级VO
	 */
	public UserLevelVO getLevel(String userName) {
		return UserUtil.getInstance().getLevel(userName);
	}

	/**
	 * 删除用户
	 */
	public ResultMessage deleteUser(String userName) {
		return UserUtil.getInstance().deleteUser(userName);
	}

}
