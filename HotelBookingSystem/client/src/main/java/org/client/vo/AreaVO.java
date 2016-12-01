package org.client.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.common.po.AreaPO;
import org.common.utility.ResultMessage;

public class AreaVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305700000750388977L;
	
	public String address;
	
	public ResultMessage resultMessage;
	
	public AreaVO(String address) {
		this.address = address;
		resultMessage = ResultMessage.SUCCESS;
	}
	
	public static List<AreaVO> generateVOList(List<AreaPO> pos) {
		List<AreaVO> vos = new ArrayList<>();
		for (AreaPO p: pos) {
			AreaVO vo = new AreaVO(p.address);
			vos.add(vo);
		}
		return vos;
	}
	
	public AreaVO(ResultMessage resultMessage) {
		this.resultMessage = resultMessage;
	}
}
