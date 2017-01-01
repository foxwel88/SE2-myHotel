package org.client.presentation.util;

/**
 * 
 * 工具类 做格式检查
 * @author Foxwel
 * @version 2016-12-16
 */
public class CheckStyle {
	//判断是否只含字母和数字
	public static boolean onlyContainsNumberAndLetter(String s) {
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
		return onlyContainsNumberAndLetter(username) && (username.length() > 0);
	}
	
	public static boolean checkPassword(String password) {
		return onlyContainsNumberAndLetter(password) && (password.length() >= 6);
	}
	
	public static boolean checkName(String name) {
		return name.length() > 0;
	}
	
	public static boolean checkPhone(String phone) {
		return containsNumber(phone) && (phone.length() == 11);
	}
	
	public static boolean checkCompanyName(String companyName) {
		return companyName.length() > 0;
	}
	
}
