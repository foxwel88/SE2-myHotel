package org.client.bl.commentblservice;

import java.util.ArrayList;

public interface Commentblservice {
	public ArrayList<CommentVO> getComment(String hotelAddress);
	
	public ResultMessage addComment(CommentVO vo);

}
