package org.client.bl.userbl;

import org.client.vo.UserVO;
import org.common.po.UserPO;

public class User {
	public UserPO modifyPassword(String userName, 
			String oldPassword, String newPassword) {
		return null;
	}
	
	public UserPO modify(UserVO vo) {
		return null;
	}
	
	public UserPO addUser(UserVO vo) {
		return null;
	}
	
	public User initbyPO(UserPO po) {
		return this;
	}
	
	public User initbyVO(UserVO vo) {
		return this;
	}
	
	public UserVO getUserVO() {
		return null;
	}

	public UserPO getUserPO() {
		return null;
	}
	
}
