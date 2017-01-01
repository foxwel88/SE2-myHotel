package org.client.datadriver;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.CreditOperation;
import org.common.utility.UserType;

public class UserDataServiceImpl_driver {

	public static void main(String[] args) {
		UserDataService stub = RMIHelper.getInstance().getUserDataServiceImpl();
		try {
			System.out.println(stub.add(new UserPO(UserType.PERSONALCUSTOMER, 
					"誰説我不會編程", "QinLiu", "0101010101", "njuse",
					"13344456789", 0, null, null, null, null)));
			System.out.println(stub.addCreditRecord(new CreditRecordPO(null,
					"012345678920161015211206",
					0, 0, CreditOperation.EXCEPTIONORDER, null)));
			System.out.println(stub.Check("gz", "123"));
			System.out.println(stub.findbyID("0123456789"));
			System.out.println(stub.findbyUserName("gg"));
			System.out.println(stub.findCreditRecords("0123455678"));
			System.out.println(stub.modify(new UserPO(UserType.WEBMANAGER,
					"阿喀琉斯", "一名香港記者",
					null, "runningNews", null, 0, null, null, null, null)));
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	}

}
