package org.common.utility;

public enum PromotionType {
	BIRTHDAYBONUS("生日促销"), COMPANYBONUS("企业促销"), TRIPLEROOMBONUS("三间以上促销"), SPECIALDATE("特定日期促销"), VIPLEVEL("VIP促销"), SPECIALAREA("商圈促销");
	
	private String s;
	
	private PromotionType(String s) {
		this.s = s;
	}
	
	public String getString() {
		return s;
	}
	
	public static PromotionType getType(String ss) {
		if (ss.equals("生日促销")) {
			return PromotionType.BIRTHDAYBONUS;
		}
		if (ss.equals("企业促销")) {
			return PromotionType.COMPANYBONUS;
		}
		if (ss.equals("三间以上促销")) {
			return PromotionType.TRIPLEROOMBONUS;
		}
		if (ss.equals("特定日期促销")) {
			return PromotionType.SPECIALDATE;
		}
		if (ss.equals("VIP促销")) {
			return PromotionType.VIPLEVEL;
		}
		if (ss.equals("商圈促销")) {
			return PromotionType.SPECIALAREA;
		}
		return null;
	}
}
