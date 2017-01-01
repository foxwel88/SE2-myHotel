package org.server.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.server.data.datafactory.DataFactory;
import org.server.datastub.DataStubFactory;

public class RMIHelper {
		
	public static RMIHelper rmihelper;
	
	Remote reg;

	private String ip;

	private RMIHelper() {
		ip = "localhost";
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public static RMIHelper getinstance() {
		if (rmihelper == null) {
			rmihelper = new RMIHelper();
		}
		return rmihelper;
	}

	public void releaseConnection() {
		try {
			
			java.rmi.server.UnicastRemoteObject.unexportObject(reg,true);
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}
	
		reg = null;
	}
	
	public void buildStubConnection() {
		try {
			reg = LocateRegistry.createRegistry(8888);
			Naming.rebind("rmi://localhost:8888/CommentDataServiceObject",DataStubFactory.getInstance().getCommentDataServiceImpl());
			System.out.println("comment succeed");
			Naming.rebind("rmi://localhost:8888/HotelDataServiceObject",DataStubFactory.getInstance().getHotelDataServiceImpl());
			System.out.println("hotel succeed");
			Naming.rebind("rmi://localhost:8888/ChenTong",DataStubFactory.getInstance().getOrderDataServiceImpl());
			System.out.println("order succeed");
			Naming.rebind("rmi://localhost:8888/PromotionDataServiceObject",DataStubFactory.getInstance().getPromotionDataServiceImpl());
			System.out.println("promotion succeed");
			Naming.rebind("rmi://localhost:8888/UserDataServiceObject",DataStubFactory.getInstance().getUserDataServiceImpl());
			System.out.println("user succeed");
			Naming.rebind("rmi://localhost:8888/TimeServiceObject",DataFactory.getInstance().getTimeServiceImpl());
			
			Naming.rebind("rmi://localhost:8888/IDServiceObject",DataFactory.getInstance().getIDUtil());
			System.out.println("Connect successfully");
			System.out.println();
		} catch (RemoteException e) {
			e.printStackTrace();
	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildConnection() {
		try {
			reg = LocateRegistry.createRegistry(8888);
			Naming.rebind("rmi://" + ip + ":8888/CommentDataServiceObject",DataFactory.getInstance().getCommentDataServiceImpl());
			System.out.println("comment succeed");
			Naming.rebind("rmi://" + ip + ":8888/HotelDataServiceObject",DataFactory.getInstance().getHotelDataServiceImpl());
			System.out.println("hotel succeed");
			Naming.rebind("rmi://" + ip + ":8888/ChenTong",DataFactory.getInstance().getOrderDataServiceImpl());
			System.out.println("order succeed");
			Naming.rebind("rmi://" + ip + ":8888/PromotionDataServiceObject",DataFactory.getInstance().getPromotionDataServiceImpl());
			System.out.println("promotion succeed");
			Naming.rebind("rmi://" + ip + ":8888/UserDataServiceObject",DataFactory.getInstance().getUserDataServiceImpl());
			System.out.println("user succeeed");
			Naming.rebind("rmi://" + ip + ":8888/TimeServiceObject",DataFactory.getInstance().getTimeServiceImpl());

			Naming.rebind("rmi://" + ip + ":8888/IDServiceObject",DataFactory.getInstance().getIDUtil());
			System.out.println("Connect successfully");
			System.out.println();
		} catch (RemoteException e) {
			e.printStackTrace();
	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
