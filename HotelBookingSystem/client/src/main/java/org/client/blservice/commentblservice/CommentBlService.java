package org.client.blservice.commentblservice;

import java.util.List;

import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

/**
 * Comment模块在logic层的接口
 * @author fraphisoft
 */
public interface CommentBlService {

	/**
	 * 获得制定地址的酒店的所有评价
	 * @param hotelAddress
	 * @return
	 */
	public List<CommentVO> getComment(String hotelAddress);

	/**
	 * 向数据库中添加一个评价
	 * @param vo
	 * @return
	 */
	public ResultMessage addComment(CommentVO vo);

}
