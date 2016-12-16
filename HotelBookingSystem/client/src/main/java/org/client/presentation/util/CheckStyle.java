package org.client.presentation.util;

/**
 * 
 * 工具类 做格式检查
 * @author Foxwel
 * @version 2016-12-16
 */
public class CheckStyle {
	//判断是否只含字母和数字
	public static boolean containsNumberAndLetter(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (!( ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) ||
					((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) ||
					((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z')) )) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean containsNumber(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (! ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) ) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkUsername(String username) {
		if (! (containsNumberAndLetter(username) && (username.length() > 0)) ) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkPassword(String password) {
		if (! (containsNumberAndLetter(password) && (password.length() >= 6)) ) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkName(String name) {
		if (! (name.length() > 0)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkPhone(String phone) {
		if (! (containsNumber(phone) && (phone.length() == 11))) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkCompanyname(String companyname) {
		if (! (companyname.length() > 0)) {
			return false;
		} else {
			return true;
		}
	}
	
}
