package org.client.datadriver;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;
import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;

public class CommentDataServiceImpl_driver {

	public static void main(String[] args) {
		CommentDataService stub = RMIHelper.getInstance().getCommentDataServiceImpl();
		try {
			stub.init();
			System.out.println(stub.find("7days"));
			System.out.println(stub.insert(new CommentPO(null, null, null, 0, null)));
			stub.finish();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
