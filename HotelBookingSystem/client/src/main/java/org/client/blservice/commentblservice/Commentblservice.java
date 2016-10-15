package org.client.blservice.commentblservice;

import java.util.ArrayList;

import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

public interface Commentblservice {
	public ArrayList<CommentVO> getComment(String hotelAddress);
	
	public ResultMessage addComment(CommentVO vo);

}
