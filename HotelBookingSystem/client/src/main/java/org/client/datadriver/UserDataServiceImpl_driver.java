package org.client.datadriver;

import java.rmi.RemoteException;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.UserType;
import org.server.datastub.UserDataServiceImpl_stub;

public class UserDataServiceImpl_driver {

	public static void main(String[] args) {
		UserDataServiceImpl_stub stub = new UserDataServiceImpl_stub();
		try {
			stub.init();
			System.out.println(stub.add(new UserPO(UserType.WEBMANAGER, null, null, null, null, null, 0, null, null, 0, 0, null)));
			System.out.println(stub.addCreditRecord(new CreditRecordPO(null, null, 0, 0, null)));
			System.out.println(stub.Check("gz", "123"));
			System.out.println(stub.findbyID("0123456789"));
			System.out.println(stub.findbyUserName("gg"));
			System.out.println(stub.findCreditRecord("0123455678"));
			System.out.println(stub.modify(new UserPO(UserType.CUSTOMER, null, null, null, null, null, 0, null, null, 0, 0, null)));
			stub.finish();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
