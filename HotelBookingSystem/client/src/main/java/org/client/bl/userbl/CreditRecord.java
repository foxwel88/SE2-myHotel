package org.client.bl.userbl;

import java.util.Date;
import java.util.List;

import org.client.vo.CreditRecordVO;
import org.common.po.CreditRecordPO;

public class CreditRecord {
	
	public Date date;
	
	public String orderID;
	
	public double change;
	
	public double result;
	
	public String op;
	
	public CreditRecordPO getCreditRecordPO(CreditRecordVO vo) {
		return null;
	}
	
	public CreditRecordVO getCreditRecordVO() {
		return null;
	}
	
	public List<CreditRecordVO> findCreditRecord(String ID) {
		return null;
	}
	
	public CreditRecord initbyVO(CreditRecordVO vo) {
		return this;
	}
	
	public CreditRecord initbyPO(CreditRecordPO po) {
		return this;
	}
}
