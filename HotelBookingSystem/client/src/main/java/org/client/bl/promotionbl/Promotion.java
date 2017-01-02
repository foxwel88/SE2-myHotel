package org.client.bl.promotionbl;

import java.rmi.RemoteException;
import java.util.Date;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.userbl.UserController;
import org.client.rmi.RMIHelper;
import org.client.vo.HotelVO;
import org.client.vo.PromotionVO;
import org.client.vo.UserVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

/**
 * 调用该类的modify()将会修改数据层的持久化数据
 * 可进行VO PO的转换，以及对其保存的促销策略是否适用某类对象的检查方法
 * @author fraliphsoft
 * @version Hirico 2017/01/01
 */
public class Promotion implements Comparable<Promotion> {
	String promotionID;
	
	String provider;
	
	String type; 
	
	Date startTime;
	
	Date endTime;
	
	String hotelName;
	
	String hotelID;
	
	int level;
	
	String city;
	
	String area;
	
	double discount;
	
	String name;
	
	private PromotionStrategy promotionStrategy;

	public void setStrategy(PromotionStrategy strategy) {
		promotionStrategy = strategy;
	}

	public double getPrice(double rawPrice) {
		return promotionStrategy.getPrice(rawPrice);
	}
	
	Promotion(PromotionVO vo) {
		promotionID = vo.promotionID;
		
		provider = vo.provider;
		
		type = vo.type;
		
		startTime = vo.startTime;
		
		endTime = vo.endTime;
		
		hotelName = vo.hotelName;
		
		hotelID = vo.hotelID;
		
		level = vo.level;
		
		city = vo.city;
		
		area = vo.area;
		
		discount = vo.discount;
		
		name = vo.name;
		
		promotionStrategy = PromotionStrategyFactory.getStrategy(type, discount);
	}
	
	Promotion(PromotionPO po) {
		promotionID = po.promotionID;
		
		provider = po.provider;
		
		type = po.type.getString();
		
		startTime = po.startTime;
		
		endTime = po.endTime;
		
		hotelName = po.hotelName;
		
		hotelID = po.hotelID;
		
		level = po.level;
		
		city = po.city;
		
		area = po.area;
		
		discount = po.discount;
		
		name = po.name;
		
		promotionStrategy = PromotionStrategyFactory.getStrategy(type, discount);
	}

	// 默认构造方法，用于构建空的促销策略
	Promotion() {
		discount = 10;		//不打折

		promotionStrategy = PromotionStrategyFactory.getStrategy(type, discount);
	}
	
	PromotionVO toVO() {
		return new PromotionVO(promotionID, provider, type, startTime, endTime, hotelName, hotelID, level, city, area, discount, name);
	}
	
	PromotionPO toPO() {
		return new PromotionPO(promotionID, provider, PromotionType.getType(type), startTime, endTime, hotelName, hotelID, level, city, area, discount, name);
	}
	
	ResultMessage modify (PromotionVO vo) {
		RMIHelper rmihelper = RMIHelper.getInstance();
		PromotionDataService promotionDataService = rmihelper.getPromotionDataServiceImpl();
		
		promotionID = vo.promotionID;
		provider = vo.provider;
		type = vo.type;
		startTime = vo.startTime;
		endTime = vo.endTime;
		hotelName = vo.hotelName;
		hotelID = vo.hotelID;
		level = vo.level;
		city = vo.city;
		area = vo.area;
		discount = vo.discount;
		name = vo.name;
		
		PromotionPO po = new PromotionPO(promotionID, provider, PromotionType.getType(type), startTime, endTime, hotelName, hotelID, level, city, area, discount, name);
		try {
			promotionDataService.modify(po);
			return ResultMessage.SUCCESS;
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
	
	boolean canBeUsed(String hotelID, String userID, int roomNum) {
		UserVO userVO = UserController.getInstance().findbyID(userID);
		HotelVO hotelVO = HotelController.getInstance().getHotelVO(hotelID);
		boolean isAvailable = isInPromotionPeriod();
		if (provider.equals("web")) {
			switch (type) {
				case "特定日期促销":			// nothing to check
					break;
				case "VIP促销":				// level
					if (PromotionController.getInstance().calculateLevel(userVO.credit) < level) {
						isAvailable = false;
					}
					break;
				case "商圈促销":				// level、city、area
					if (PromotionController.getInstance().calculateLevel(userVO.credit) < level) {
						isAvailable = false;
					}
					if (!(hotelVO.city.cityName.equals(city) && hotelVO.area.address.equals(area))) {
						isAvailable = false;
					}
					break;
			}
		} else {							// hotelID
			isAvailable = (isInPromotionHotel(hotelID) && isAvailable);
			switch (type) {
				case "生日促销":				// birthday
					try {
						if (!((userVO.birthday.getMonth() == RMIHelper.getInstance().getTimeServiceImpl().getDate().getMonth())
								&& (userVO.birthday.getDate() == RMIHelper.getInstance().getTimeServiceImpl().getDate().getDate()))) {
							isAvailable = false;
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					break;
				case "企业促销":				// isCompany
					if (!userVO.type.equals(UserType.COMPANYCUSTOMER.getString())) {
						isAvailable = false;
					}
					break;
				case "三间以上促销":			// roomNum
					if (roomNum < 3) {
						isAvailable = false;
					}
					break;
				case "特定日期促销":			// nothing to check
					break;
			}
		}
		return isAvailable;
	}
	
	/**
	 * 现在的promotion均为折扣类型，因此目前只考虑discount的比较
	 */
	@Override
	public int compareTo(Promotion anotherPromotion) {
		if (this.discount > anotherPromotion.discount) {
			return -1;
		} else if (this.discount < anotherPromotion.discount) {
			return 1;
		}
		return 0;
	}

	//当前时间是否在promotion的适用日期范围
	private boolean isInPromotionPeriod() {
		try {
			if (startTime.after(RMIHelper.getInstance().getTimeServiceImpl().getDate())) {
				return false;
			}
			if (endTime.before(RMIHelper.getInstance().getTimeServiceImpl().getDate())) {
				return false;
			}
		} catch (RemoteException remoteException) {
			remoteException.printStackTrace();
		}
		return true;
	}

	//promotion是否是该酒店的
	private boolean isInPromotionHotel(String id) {
		return hotelID.equals(id);
	}
}
