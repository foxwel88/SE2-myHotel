package org.client.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.dataservice.HotelDataService.HotelDataService;
import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.utility.IDService;
import org.common.utility.TimeService;

public class RMIHelper {
	
	private static RMIHelper rmihelper;
	
	private RMIHelper() {
		
	}
	
	public static RMIHelper getInstance() {
		if (rmihelper == null) {
			rmihelper = new RMIHelper();
		}
		return rmihelper;
	}
	
	private static UserDataService UserDataServiceImpl;
	
	private static HotelDataService HotelDataServiceImpl;
	
	private static OrderDataService orderDao;
	
	private static PromotionDataService PromotionDataServiceImpl;
	
	private static CommentDataService CommentDataServiceImpl;
	
	private static TimeService timeServiceImpl;
	
	private static IDService IDUtil;
	
	public void init() {
		try {
			CommentDataServiceImpl = (CommentDataService)Naming.lookup("rmi://localhost:8888/CommentDataServiceObject");
			//System.out.println("Comment succed");
			HotelDataServiceImpl = (HotelDataService)Naming.lookup("rmi://localhost:8888/HotelDataServiceObject");
			//System.out.println("hotel succed");
			orderDao = (OrderDataService)Naming.lookup("rmi://localhost:8888/ChenTong");
			//System.out.println("order succed");
			PromotionDataServiceImpl = (PromotionDataService)Naming.lookup("rmi://localhost:8888/PromotionDataServiceObject");
			//System.out.println("promotion succed");
			UserDataServiceImpl = (UserDataService)Naming.lookup("rmi://localhost:8888/UserDataServiceObject");
			//System.out.println("user succeed");
			//System.out.println("Connect successfully");
			timeServiceImpl = (TimeService)Naming.lookup("rmi://localhost:8888/TimeServiceObject");
			IDUtil = (IDService)Naming.lookup("rmi://localhost:8888/IDServiceObject");
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public UserDataService getUserDataServiceImpl() {
		return UserDataServiceImpl;
	}
	
	public HotelDataService getHotelDataServiceImpl() {
		return HotelDataServiceImpl;
	}
	
	public OrderDataService getOrderDataServiceImpl() {
		return orderDao;
	}
	
	public PromotionDataService getPromotionDataServiceImpl() {
		return PromotionDataServiceImpl;
	}
	
	public CommentDataService getCommentDataServiceImpl() {
		return CommentDataServiceImpl;
	}
	
	public TimeService getTimeServiceImpl() {
		return timeServiceImpl;
	}

	public IDService getIDUtil() {
		return IDUtil;
	}
}
