package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;

import org.client.blservice.commentblservice.Commentblservice;
import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;

public class Comment_stub implements Commentblservice {

	public ArrayList<CommentVO> getComment(String hotelAddress) {
		CommentVO vo1 = new CommentVO("Tom","上海路233号XX酒店", "订单号", 
				new Date(2016 - 10 - 1),5,
				"我觉得这一家店的服务很好，我很喜欢，下次再来！");
		CommentVO vo2 = new CommentVO(
				"Mary","中山路100号XX酒店", "订单号", new Date(2016 - 10 - 1)
				,5,"我没有评价哈哈哈哈哈哈哈哈哈哈");
		CommentVO vo3 = new CommentVO(
				"Jack","和园10号XX酒店", "订单号", 
				new Date(2016 - 10 - 1),5,
				"我觉得这一家店的服务一般,我不是很喜欢，下次不来了");
		ArrayList<CommentVO> vo = new ArrayList<>();
		vo.add(vo1);
		vo.add(vo2);
		vo.add(vo3);
		return vo;
	}

	public ResultMessage addComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
