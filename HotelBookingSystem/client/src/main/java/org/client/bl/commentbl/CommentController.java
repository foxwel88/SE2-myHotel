package org.client.bl.commentbl;

import java.util.List;
import org.client.blservice.commentblservice.Commentblservice;
import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

public class CommentController implements Commentblservice {

	public List<CommentVO> getComment(String hotelAddress) {
		List<CommentVO> commentVOList = CommentUtil.getComment(hotelAddress);
		return commentVOList;
	}

	public ResultMessage addComment(CommentVO vo) {
		return CommentUtil.addComment(vo);
	}

}
