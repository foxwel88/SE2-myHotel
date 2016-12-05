package org.client.bl.commentbl;

import java.util.List;
import org.client.blservice.commentblservice.Commentblservice;
import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

/**
 * bl层comment模块的控制器类
 * @author fraliphsoft
 * @version fraliphsoft 11/27
 */
public class CommentController implements Commentblservice {
	
	private static CommentController commentController;
	
	private CommentController() {
		
	}
	
	public static CommentController getInstance() {
		if (commentController == null) {
			commentController = new CommentController();
		}
		return commentController;
	}

	public List<CommentVO> getComment(String hotelID) {
		List<CommentVO> commentVOList = CommentUtil.getComment(hotelID);
		return commentVOList;
	}

	public ResultMessage addComment(CommentVO vo) {
		return CommentUtil.addComment(vo);
	}

}
