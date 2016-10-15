package org.client.datadriver;

import java.rmi.RemoteException;

import org.common.po.CommentPO;
import org.server.datastub.CommentDataServiceImpl_stub;

public class CommentDataServiceImpl_driver {

	public static void main(String[] args) {
		CommentDataServiceImpl_stub stub = new CommentDataServiceImpl_stub();
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
