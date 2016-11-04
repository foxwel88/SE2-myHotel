package org.client.bl.commentbl;

import java.util.List;
import java.util.*;
import org.client.blservice.commentblservice.Commentblservice;
import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

public class CommentController implements Commentblservice {

	public List<CommentVO> getComment(String hotelAddress) {
		ArrayList<CommentVO> commentVOList = new ArrayList();
		return commentVOList;
	}

	public ResultMessage addComment(CommentVO vo) {
		return null;
	}

}
