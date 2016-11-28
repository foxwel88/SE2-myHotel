package org.client.bl.promotionbl;

import static org.junit.Assert.assertEquals;

import static org.easymock.EasyMock.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.PromotionPO;
import org.common.utility.PromotionType;
import org.common.utility.ResultMessage;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.server.rmi.RMIHelper;

/**
 * promotionbl模块集成测试，用到的promotionbl类均为真实类，dataservice为stub或mock
 */
public class PromotionControllerTest extends EasyMockSupport {
	PromotionController promotionController;
	
	@Mock
	PromotionDataService promotionDataService;
	
	@Before
	public void setUp() throws Exception {
		RMIHelper.getinstance().buildStubConnection();
		org.client.rmi.RMIHelper.getInstance().init();
		promotionController = PromotionController.getInstance();
		promotionDataService = mock(PromotionDataService.class);
		PromotionUtil.setDAO(null);
	}
	
	// TODO 商圈和酒店名显然不符合规范。。。等数据库建起来了再改
	@Test(timeout = 1000)
	public void testadd() {
		assertEquals(ResultMessage.SUCCESS, promotionController.add(new PromotionVO("生日促销", new Date(100000), new Date(1000000), "!什么东西", "我是地址", 1, "我不信还有", 9.9, "醉了")));
	}
	
	@Test(timeout = 1000)
	public void testadd2() {
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.add(new PromotionVO("生日促销", new Date(1000000), new Date(1000000), "!什么东西", "我是地址", 1, "我不信还有", 9.9, "醉了")));
	}
	
	@Test(timeout = 1000)
	public void testadd3() {
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.add(new PromotionVO("生日促销", new Date(100000), new Date(1000000), "!什么东西", "我是地址", 1, "我不信还有", 10, "醉了")));
	}
	
	@Test(timeout = 1000)
	public void testadd4() {
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.add(new PromotionVO("节日促销", new Date(100000), new Date(1000000), "!什么东西", "我是地址", 1, "我不信还有", 9.9, "醉了")));
	}
	
	@Test(timeout = 1000)
	public void testgetPromotion() {
		assertEquals(false, promotionController.getPromotion("酒店地址", "用户ID").isEmpty());
	}
	
	@Test(timeout = 1000)
	public void testshowHotelPromotion() {
		assertEquals(false, promotionController.showHotelPromotion("酒店地址").isEmpty());
	}
	
	@Test(timeout = 1000)
	public void testshowWebsitePromotion() {
		assertEquals(false, promotionController.showWebsitePromotion().isEmpty());
	}
	
	@Test(timeout = 1000)
	public void testmodify() {
		try {
			PromotionUtil.setDAO(promotionDataService);
			
			ArrayList<PromotionPO> promotionPO = new ArrayList<PromotionPO>();
			
			promotionPO.add(new PromotionPO(PromotionType.BIRTHDAYBONUS, new Date(100000), new Date(1000000), "hotelName", "hotelAddress", 2, "area", 3, "name"));
			
			expect(promotionDataService.showWebsitePromotion()).andReturn(promotionPO);
			
			expect(promotionDataService.showHotelPromotion("hotelAddress")).andReturn(promotionPO);
			
			replayAll();
		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		promotionController.showHotelPromotion("hotelAddress");
		promotionController.showWebsitePromotion();
		PromotionVO vo = new PromotionVO("生日促销", new Date(100000), new Date(1000000), "酒店名字", "hotelAddress", 2, "area", 5, "name");
		assertEquals(ResultMessage.SUCCESS, promotionController.modify(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodify2() {
		try {
			PromotionUtil.setDAO(promotionDataService);
			
			ArrayList<PromotionPO> promotionPO = new ArrayList<PromotionPO>();
			
			promotionPO.add(new PromotionPO(PromotionType.BIRTHDAYBONUS, new Date(100000), new Date(1000000), "hotelName", "hotelAddress", 2, "area", 3, "name"));
			
			expect(promotionDataService.showWebsitePromotion()).andReturn(promotionPO);
			
			expect(promotionDataService.showHotelPromotion("hotelAddress")).andReturn(promotionPO);
			
			replayAll();
		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		promotionController.showHotelPromotion("hotelAddress");
		promotionController.showWebsitePromotion();
		PromotionVO vo = new PromotionVO("节日促销", new Date(100000), new Date(1000000), "酒店名字", "hotelAddress", 2, "area", 5, "name");
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.modify(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodify3() {
		try {
			PromotionUtil.setDAO(promotionDataService);
			
			ArrayList<PromotionPO> promotionPO = new ArrayList<PromotionPO>();
			
			promotionPO.add(new PromotionPO(PromotionType.BIRTHDAYBONUS, new Date(10000000), new Date(1000000), "hotelName", "hotelAddress", 2, "area", 3, "name"));
			
			expect(promotionDataService.showWebsitePromotion()).andReturn(promotionPO);
			
			expect(promotionDataService.showHotelPromotion("hotelAddress")).andReturn(promotionPO);
			
			replayAll();
		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		promotionController.showHotelPromotion("hotelAddress");
		promotionController.showWebsitePromotion();
		PromotionVO vo = new PromotionVO("节日促销", new Date(100000), new Date(1000000), "酒店名字", "hotelAddress", 2, "area", 5, "name");
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.modify(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodify4() {
		try {
			PromotionUtil.setDAO(promotionDataService);
			
			ArrayList<PromotionPO> promotionPO = new ArrayList<PromotionPO>();
			
			promotionPO.add(new PromotionPO(PromotionType.BIRTHDAYBONUS, new Date(100000), new Date(1000000), "hotelName", "hotelAddress", 2, "area", 3, "name"));
			
			expect(promotionDataService.showWebsitePromotion()).andReturn(promotionPO);
			
			expect(promotionDataService.showHotelPromotion("hotelAddress")).andReturn(promotionPO);
			
			replayAll();
		} catch (RemoteException rex) {
			rex.printStackTrace();
		}
		PromotionVO vo = new PromotionVO("节日促销", new Date(100000), new Date(1000000), "酒店名字", "hotelAddress", 2, "area", 5, "一个不存在的name");
		assertEquals(ResultMessage.NOT_EXIST, promotionController.modify(vo));
	}
	
	@Test(timeout = 1000)
	public void testshowLevel() {
		assertEquals(ResultMessage.SUCCESS, promotionController.showLevel().resultMessage);
	}
	
	@Test(timeout = 1000)
	public void testmodifyLevel() {
		ArrayList<Double> credits = new ArrayList<>();
		credits.add(10.0);
		credits.add(10.0);
		credits.add(10.0);
		LevelVO vo = new LevelVO(3, credits);
		assertEquals(ResultMessage.SUCCESS, promotionController.modifyLevel(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodifyLevel2() {
		ArrayList<Double> credits = new ArrayList<>();
		credits.add(10.0);
		credits.add(10.0);
		credits.add(10.0);
		LevelVO vo = new LevelVO(5, credits);
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.modifyLevel(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodifyLevel3() {
		LevelVO vo = new LevelVO(5, new ArrayList<>());
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.modifyLevel(vo));
	}
	
	@Test(timeout = 1000)
	public void testmodifyLevel4() {
		ArrayList<Double> credits = new ArrayList<>();
		credits.add(10.0);
		credits.add(10.0);
		credits.add(10.0);
		LevelVO vo = new LevelVO(0, credits);
		assertEquals(ResultMessage.WRONG_FORMAT, promotionController.modifyLevel(vo));
	}
	
	@Test(timeout = 1000)
	public void testgetPrice() {
		assertEquals(true, (promotionController.getPrice("userID", "hotelAddress", 100)) == 25);
	}
	
	@After
	public void tearDown() {
		RMIHelper.getinstance().releaseConnection();
	}
}
