package org.client.bl.userbl;

import java.util.Date;

import org.client.vo.UserVO;
import org.common.po.UserPO;
import org.common.utility.UserType;

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
	
	/**
	 * 初始化领域类
	 * @param po 用来初始化的PO
	 * @return 领域类自身
	 */
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
		this.type = po.type.getString();
		this.userName = po.userName;
		return this;
	}
	
	/**
	 * 初始化领域类
	 * @param vo 用来初始化的VO
	 * @return 初始化后的领域类自身
	 */
	public User initbyVO(UserVO vo) {
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
		return this;
	}
	
	/**
	 * 返回该领域类对应的UserVO
	 * @return
	 */
	public UserVO getUserVO() {
		return new UserVO(type, userName, name, ID, passWord,phoneNumber, credit, birthday, companyName, level,
				creditToNext, hotelAddress);
	}

	/**
	 * 返回该领域类对应的UserPO
	 * @return
	 */
	public UserPO getUserPO() {
		return new UserPO(UserType.getType(type), userName, name, ID, passWord,phoneNumber, credit, birthday, companyName, level,
				creditToNext, hotelAddress);
	}
	
}
