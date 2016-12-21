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

	private String ip;

	private RMIHelper() {
		ip = "localhost";
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public String getIP() {
		return ip;
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
			String port = "8888";
			System.out.println(ip);
			CommentDataServiceImpl = (CommentDataService)Naming.lookup("rmi://" + ip + ":" + port + "/CommentDataServiceObject");
			HotelDataServiceImpl = (HotelDataService)Naming.lookup("rmi://" + ip + ":" + port + "/HotelDataServiceObject");
			orderDao = (OrderDataService)Naming.lookup("rmi://" + ip + ":" + port + "/ChenTong");
			PromotionDataServiceImpl = (PromotionDataService)Naming.lookup("rmi://" + ip + ":" + port + "/PromotionDataServiceObject");
			UserDataServiceImpl = (UserDataService)Naming.lookup("rmi://" + ip + ":" + port + "/UserDataServiceObject");
			timeServiceImpl = (TimeService)Naming.lookup("rmi://" + ip + ":" + port + "/TimeServiceObject");
			IDUtil = (IDService)Naming.lookup("rmi://" + ip + ":" + port + "/IDServiceObject");
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
