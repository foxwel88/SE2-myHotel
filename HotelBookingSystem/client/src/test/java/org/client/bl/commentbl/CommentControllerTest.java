package org.client.bl.commentbl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * commentbl模块集成测试，用到的commentbl类均为真实类，dataservice为stub
 */
public class CommentControllerTest {
	CommentController commentController;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		commentController = CommentController.getInstance();
	}
	
	@Test(timeout = 1000)
	public void testGetComment() {
		List<CommentVO> commentVOList = commentController.getComment("java从没入门到放弃大酒店");
		
		assertEquals(false, commentVOList.isEmpty());
	}
	
	@Test(timeout = 1000)
	public void testAddComment() {
		assertEquals(ResultMessage.SUCCESS, commentController.addComment(new CommentVO("你的名字", "大酒店", "123456789020080606143055", new Date(), 5, "讲道理，十五个字的评论打起来好累，重要的事情说一遍")));
	}
	
	@After
	public void tearDown() {
		RMIHelper.getinstance().releaseConnection();
	}
}
