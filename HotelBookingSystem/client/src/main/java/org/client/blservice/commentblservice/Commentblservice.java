package org.client.blservice.commentblservice;

import java.util.List;

import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

public interface Commentblservice {
	public List<CommentVO> getComment(String hotelAddress);
	
	public ResultMessage addComment(CommentVO vo);

}
