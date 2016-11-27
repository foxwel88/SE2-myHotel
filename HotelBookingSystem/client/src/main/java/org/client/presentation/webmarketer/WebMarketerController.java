package org.client.presentation.webmarketer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.blservice.promotionblservice.Promotionblservice;
import org.client.blservice.userblservice.Userblservice;
import org.client.blstub.Order_stub;
import org.client.blstub.Promotion_stub;
import org.client.blstub.User_stub;
import org.client.rmi.RMIHelper;
import org.client.vo.CreditRecordVO;
import org.client.vo.LevelVO;
import org.client.vo.OrderVO;
import org.client.vo.PromotionVO;
import org.client.vo.UserVO;
import org.common.utility.ResultMessage;

/**
 * 
 * 网站营销人员界面的总Controller，负责调用Logic层的方法
 * @author gyue
 *
 */
public class WebMarketerController {

	private static WebMarketerController controller;
	
	private Userblservice userbl;
	
	private Promotionblservice promotionbl;
	
	private Orderblservice orderbl;
	
	private UserVO userVO;
	
	/**
	 * stub version
	 */
	private WebMarketerController() {
		userbl = new User_stub();
		promotionbl = new Promotion_stub();
		orderbl = new Order_stub();
	}
	
	public static WebMarketerController getInstance() {
		if (controller == null) {
			controller = new WebMarketerController();
		}
		return controller;
	}
	
	public ResultMessage setUserVO(String userName) {
		userVO = userbl.findbyUserName(userName);
		if ((userVO.type != "个人客户") && (userVO.type != "企业客户")) {
			return ResultMessage.NOT_EXIST;
		}
		return userVO.resultMessage;
	}
	
	public String getCurrentId() {
		return userVO.ID;
	}
	
	public String getCurrentCreidt() {
		Double creditNum = userVO.credit;
		return creditNum.toString();
	}
	
	public ResultMessage addCredit(double credit) {
		if (userVO == null) {
			return ResultMessage.NOT_EXIST;
		}
		if (userVO.resultMessage != ResultMessage.SUCCESS) {
			return userVO.resultMessage;
		}
		
		userVO.credit += credit;
		
		// add credit record
		Date date = null;
		try {
			date = RMIHelper.getInstance().getTimeServiceImpl().getDate();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CreditRecordVO creditRecordVO = new CreditRecordVO(date, null, userVO.ID
				, credit, userVO.credit, "信用充值");
		ResultMessage info = userbl.addCreditRecord(creditRecordVO);
		if (info != ResultMessage.SUCCESS) { // check
			return info;
		}
		
		// modify user info
		return userbl.modify(userVO);
	}
	
	public String[] getCurrentLevel() {
		String[] levels = new String[]{" --- ", " --- ", " --- ", " --- ", " --- "};
		LevelVO levelVO = promotionbl.showLevel();
		int levelNum = levelVO.levelNum;
		ArrayList<Integer> credits = levelVO.credits; 
		for (int i = 0; i < levelNum; i++) {
			levels[i] = credits.get(i).toString();
		}
		return levels;
	}
	
	public ResultMessage modifyLevel(LevelVO levelVO) {
		return promotionbl.modifyLevel(levelVO);
	}
	
	public List<PromotionVO> getPromotions() {
		return promotionbl.showWebsitePromotion();
	}
	
	public List<OrderVO> getAbnormalOrders() {
		return orderbl.getAbnormalOrder();
	}
	
	public OrderVO getAbnormalOrder(String ID) {
		return orderbl.getOrder(ID);
	}
	
	public ResultMessage cancelOrder(String orderID, boolean isHalf) {
		ResultMessage info;
		info = orderbl.cancelAbnormalOrder(orderID, isHalf);
		return info;
	}
	
	public ResultMessage modifyPromotion(PromotionVO vo) {
		return promotionbl.modify(vo);
	}
	
	public ResultMessage addPromotion(PromotionVO vo) {
		return promotionbl.add(vo);
	}
}
