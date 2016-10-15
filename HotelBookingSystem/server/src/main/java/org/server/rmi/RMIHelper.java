package org.server.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.server.data.datafactory.DataFactory;
public class RMIHelper {
	
	public static RMIHelper rmihelper;
	Remote reg;
	
	public static RMIHelper getinstance()
	{
		if(rmihelper == null){
			rmihelper=new RMIHelper();
		}
		return rmihelper;
	}

	public void releaseConnection(){
		try {
			
			java.rmi.server.UnicastRemoteObject.unexportObject(reg,true);
		}  	catch (NoSuchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		reg=null;
	}
	
	public void buildConnection() {
		try {
			reg=LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/CommentDataServiceObject",DataFactory.getInstance().getCommentDataServiceImpl());
			System.out.println("Comment succed");
			Naming.bind("rmi://localhost:8888/HotelDataServiceObject",DataFactory.getInstance().getHotelDataServiceImpl());
			System.out.println("hotel succed");
			Naming.bind("rmi://localhost:8888/OrderDataServiceObject",DataFactory.getInstance().getOrderDataServiceImpl());
			System.out.println("order succed");
			Naming.bind("rmi://localhost:8888/PromotionDataServiceObject",DataFactory.getInstance().getPromotionDataServiceImpl());
			System.out.println("promotion succed");
			Naming.bind("rmi://localhost:8888/UserDataServiceObject",DataFactory.getInstance().getUserDataServiceImpl());
			System.out.println("user succeed");
			System.out.println("Connect successfully");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
