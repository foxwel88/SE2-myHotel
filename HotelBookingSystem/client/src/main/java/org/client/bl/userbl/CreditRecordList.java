package org.client.bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;

public class CreditRecordList {

	private ArrayList<CreditRecord> list;
	
	private UserDataService dao;
	
	public void setDao(UserDataService dao) {
		this.dao = dao;
	}
	
	public CreditRecordList initList(String ID) {
		list = new ArrayList<CreditRecord>();
		if (dao == null) {
			dao = RMIHelper.getInstance().getUserDataServiceImpl();
		}
		List<CreditRecordPO> poList = new ArrayList<CreditRecordPO>();
		try {
			poList = dao.findCreditRecords(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (CreditRecordPO c : poList) {
			CreditRecord creditRecord = new CreditRecord();
			creditRecord = creditRecord.initbyPO(c);
			list.add(creditRecord);
		}
		return this;
	}
	
	public List<CreditRecordVO> getVOs() {
		if (list != null) {
			List<CreditRecordVO> voList = new ArrayList<CreditRecordVO>();
			for (CreditRecord c: list) {
				voList.add(c.getCreditRecordVO());
			}
			return voList;
		} else {
			return null;
		}
	}
}
