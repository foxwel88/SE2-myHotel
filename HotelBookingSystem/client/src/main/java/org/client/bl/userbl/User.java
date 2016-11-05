package org.client.bl.userbl;

import java.util.Date;

import org.client.vo.UserVO;
import org.common.po.UserPO;

public class User {
	
	public String type;
	
	public String userName;
	
	public String name;
	
	public String ID;
	
	public String passWord;
	
	public String phoneNumber;
	
	public double credit;
	
	public Date birthday;
	
	public String companyName;
	
	public int level;
	
	public double creditToNext;
	
	public String hotelAddress;
	
	/**
	 * 修改密码
	 * @param newPassword 修改的密码
	 * @return 修改后的UserPO
	 */
	public UserPO modifyPassword(String newPassword) {
		this.passWord = newPassword;
		return getUserPO();
	}
	
	/**
	 * 修改用户信息
	 * @param vo 修改后的VO
	 * @return 修改后的PO
	 */
	public UserPO modify(UserVO vo) {
		this.birthday = vo.birthday;
		this.companyName = vo.companyName;
		this.credit = vo.credit;
		this.creditToNext = vo.creditToNext;
		this.hotelAddress = vo.hotelAddress;
		this.ID = vo.ID;
		this.level = vo.level;
		this.name = vo.name;
		this.passWord = vo.passWord;
		this.phoneNumber = vo.phoneNumber;
		this.type = vo.type;
		this.userName = vo.userName;
		return getUserPO();
	}
	
	public User initbyPO(UserPO po) {
		this.birthday = po.birthday;
		this.companyName = po.companyName;
		this.credit = po.credit;
		this.creditToNext = po.creditToNext;
		this.hotelAddress = po.hotelAddress;
		this.ID = po.ID;
		this.level = po.level;
		this.name = po.name;
		this.passWord = po.passWord;
		this.phoneNumber = po.phoneNumber;
		this.type = po.type;
		this.userName = po.userName;
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
