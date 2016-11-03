package org.client.bl.userbl;

import java.util.ArrayList;
import java.util.List;

import org.client.vo.CreditRecordVO;
import org.common.utility.ResultMessage;

public class CreditRecordList {
	
	private ArrayList<CreditRecord> list;
	
	public ResultMessage initList(String ID){
		return null;
	}
	
	public List<CreditRecordVO> getVOs(){
		if(list != null) {
			List<CreditRecordVO> voList = new ArrayList<CreditRecordVO>();
			for(CreditRecord c: list) {
				voList.add(c.getCreditRecordVO());
			}
			return voList;
		} else {
			return null;
		}
	}
}
