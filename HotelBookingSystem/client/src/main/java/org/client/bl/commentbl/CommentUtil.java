package org.client.bl.commentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.CommentVO;
import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

public class CommentUtil {
	
	public static List<CommentVO> getComment(String hotelAddress) {
		RMIHelper rmiHelper = RMIHelper.getInstance();
		
		CommentDataService commentDataService = rmiHelper.getCommentDataServiceImpl();
		
		List<CommentVO> commentVOList = new ArrayList<CommentVO>();;
		
		try {
			List<CommentPO> commentPOList = commentDataService.find(hotelAddress);
			
			CommentPO po;
			
			for (int i = 0; i < commentPOList.size(); i++) {
				po = commentPOList.get(i);
				commentVOList.add(new CommentVO(po.userName, po.hotelAddress, po.date, po.rank, po.comment));
			}
		} catch (RemoteException rex) {
			commentVOList.add(new CommentVO(ResultMessage.CONNECTIONFAIL));
		}
		return commentVOList;
	}
	
	public static ResultMessage addComment(CommentVO vo) {
		RMIHelper rmiHelper = RMIHelper.getInstance();
		
		CommentDataService commentDataService = rmiHelper.getCommentDataServiceImpl();
		
		try {
			if (checkFormat(vo)) {
				CommentPO po = new CommentPO(vo.userName, vo.hotelAdrress, vo.date, vo.rank, vo.comment);
				
				return commentDataService.insert(po);
			} else {
				return ResultMessage.WRONGFORMAT;
			}
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTIONFAIL;
		}
	}
	
	private static boolean checkFormat(CommentVO vo) {
		if (vo.comment.length() >= 15) {
			return true;
		} else {
			return false;
		}
	}
}
