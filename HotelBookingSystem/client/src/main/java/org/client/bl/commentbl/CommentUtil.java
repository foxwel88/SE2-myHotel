package org.client.bl.commentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.client.rmi.RMIHelper;
import org.client.vo.CommentVO;
import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;

/**
 * bl层comment模块的工具类，实现comment模块的逻辑
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class CommentUtil {
	
	public static List<CommentVO> getComment(String hotelID) {
		RMIHelper rmiHelper = RMIHelper.getInstance();
		
		CommentDataService commentDataService = rmiHelper.getCommentDataServiceImpl();
		
		List<CommentVO> commentVOList = new ArrayList<CommentVO>();;
		
		try {
			List<CommentPO> commentPOList = commentDataService.find(hotelID);
			
			CommentPO po;
			
			for (int i = 0; i < commentPOList.size(); i++) {
				po = commentPOList.get(i);
				commentVOList.add(new CommentVO(po.userName, po.hotelID, po.orderID, po.date, po.rank, po.comment));
			}
		} catch (RemoteException rex) {
			commentVOList.add(new CommentVO(ResultMessage.CONNECTION_FAIL));
		}
		return commentVOList;
	}
	
	public static ResultMessage addComment(CommentVO vo) {
		RMIHelper rmiHelper = RMIHelper.getInstance();
		
		CommentDataService commentDataService = rmiHelper.getCommentDataServiceImpl();
		
		try {
			CommentPO po = new CommentPO(vo.userName, vo.hotelID, vo.orderID, vo.date, vo.rank, vo.comment);
			return commentDataService.insert(po);
		} catch (RemoteException rex) {
			return ResultMessage.CONNECTION_FAIL;
		}
	}
}
