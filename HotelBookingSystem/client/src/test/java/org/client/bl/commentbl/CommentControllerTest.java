package org.client.bl.commentbl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.client.vo.CommentVO;
import org.common.utility.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * commentbl模块集成测试，用到的commentbl类均为真实类，dataservice和其它bl模块的类为stub
 */
public class CommentControllerTest {
	CommentController commentController;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		commentController = new CommentController();
	}
	
	
	
	@Test(timeout = 1000)
	public void testgetComment() {
		List<CommentVO> commentVOList = commentController.getComment("java从没入门到放弃大酒店");
		
		assertEquals(false, commentVOList.isEmpty());
	}
	
	@Test(timeout = 1000)
	public void testaddComment() {
		assertEquals(ResultMessage.SUCCESS, commentController.addComment(new CommentVO("你的名字", "大酒店", new Date(), 5, "讲道理，十五个字的评论打起来好累，重要的事情说一遍")));
	}
	
	@Test(timeout = 1000)
	public void testaddComment2() {
		assertEquals(ResultMessage.WRONGFORMAT, commentController.addComment(new CommentVO("你的名字", "大酒店", new Date(), 5, "噫")));
	}
	
	@After
	public void tearDown() {
		RMIHelper.getinstance().releaseConnection();
	}
}
