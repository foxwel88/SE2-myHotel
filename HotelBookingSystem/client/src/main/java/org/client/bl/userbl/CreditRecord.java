package org.client.bl.userbl;

import java.util.Date;
import org.client.vo.CreditRecordVO;
import org.common.po.CreditRecordPO;
import org.common.utility.CreditOperation;

/**
 * 信用记录领域类
 * @author gyue
 * @version 2016/11/27 gyue
 */
public class CreditRecord {
	
	public Date date;
	
	public String orderID;
	
	public String userId;
	
	public double change;
	
	public double result;
	
	public String op;
	
	public CreditRecordPO getCreditRecordPO(CreditRecordVO vo) {
		CreditOperation op = CreditOperation.getType(this.op);
		return new CreditRecordPO(date, orderID, change, result, op, userId);
	}
	
	public CreditRecordVO getCreditRecordVO() {
		return new CreditRecordVO(date, orderID, userId, change, result, op);
	}
	
	public CreditRecord initbyVO(CreditRecordVO vo) {
		this.change = vo.change;
		this.date = vo.date;
		this.op = vo.op;
		this.orderID = vo.orderID;
		this.result = vo.result;
		this.userId = vo.userId;
		return this;
	}
	
	public CreditRecord initbyPO(CreditRecordPO po) {
		this.change = po.change;
		this.date = po.date;
		this.op = po.op.getString();
		this.orderID = po.orderID;
		this.result = po.result;
		this.userId = po.userId;
		return this;
	}
}
