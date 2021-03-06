package org.client.presentation.webmarketer;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.client.bl.hotelbl.HotelController;
import org.client.bl.orderbl.OrderController;
import org.client.bl.promotionbl.PromotionController;
import org.client.bl.userbl.UserController;
import org.client.blservice.hotelblservice.HotelBlService;
import org.client.blservice.orderblservice.OrderBlService;
import org.client.blservice.promotionblservice.PromotionBlService;
import org.client.blservice.userblservice.UserBlService;
import org.client.rmi.RMIHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
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
 * @version 2016/11/27
 */
public class WebMarketerController {

	private static WebMarketerController controller;
	
	private UserBlService userbl;
	
	private PromotionBlService promotionbl;
	
	private OrderBlService orderbl;
	
	private HotelBlService hotelbl;
	
	private String userName;
	
	private String name;
	
//	private UserVO userVO;
	
	private WebMarketerController() {
		userbl = UserController.getInstance();
		promotionbl = PromotionController.getInstance();
		orderbl = OrderController.getInstance();
		hotelbl = HotelController.getInstance();
	}
	
	public static WebMarketerController getInstance() {
		if (controller == null) {
			controller = new WebMarketerController();
		}
		return controller;
	}
	
	/**
	 * should be called right after login
	 * @param vo
	 */
	public void init(UserVO vo) {
		this.userName = vo.userName;
		this.name = vo.name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * 根据用户名获得用户的VO
	 * @param userName
	 * @return
	 */
	public UserVO searchUser(String userName) {
		UserVO userVO = userbl.findbyUserName(userName);
		if ((!Objects.equals(userVO.type, "个人客户")) && (!Objects.equals(userVO.type, "企业客户"))) {
			return new UserVO(ResultMessage.NOT_EXIST);
		}
		return userVO;
	}
	
	/**
	 * 增加当前用户的信用值
	 * @param vo 
	 * @return 结果信息
	 */
	public ResultMessage addCredit(UserVO vo, double credit) {
		if (vo == null) {
			return ResultMessage.NOT_EXIST;
		}
		if (vo.resultMessage != ResultMessage.SUCCESS) {
			return vo.resultMessage;
		}
		
		vo.credit += credit;
		
		// add credit record
		Date date = null;
		try {
			date = RMIHelper.getInstance().getTimeServiceImpl().getDate();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CreditRecordVO creditRecordVO = new CreditRecordVO(date, null, vo.ID
				, credit, vo.credit, "信用充值");
		ResultMessage info = userbl.addCreditRecord(creditRecordVO);
		if (info != ResultMessage.SUCCESS) { // check
			return info;
		}
		
		// modify user info
		return userbl.modify(vo);
	}
	
	/**
	 * 获得现在的等级制度所需信用值
	 * @return 等级制度的list
	 */
	public List<Double> getCurrentLevel() {
		return promotionbl.showLevel().credits;
	}
	
	/**
	 * 改变现有的等级制度
	 * @param levelVO
	 * @return 结果信息
	 */
	public ResultMessage modifyLevel(LevelVO levelVO) {
		return promotionbl.modifyLevel(levelVO);
	}
	
	/**
	 * 获得现有的促销策略
	 * @return 促销策略的list
	 */
	public List<PromotionVO> getPromotions() {
		return promotionbl.showWebsitePromotion();
	}
	
	/**
	 * 获得异常订单的VO的list
	 * @return 异常订单VO的list
	 */
	public List<OrderVO> getAbnormalOrders() {
		return orderbl.getAbnormalOrder();
	}
	
	/**
	 * 获得指定异常订单
	 * @param ID 订单号
	 * @return 异常订单的VO
	 */
	public OrderVO getAbnormalOrder(String ID) {
		return orderbl.getOrder(ID);
	}
	
	/**
	 * 撤销异常订单
	 * @param orderID 订单号
	 * @param isHalf 是否恢复一般信用值
	 * @return 结果信息
	 */
	public ResultMessage cancelOrder(String orderID, boolean isHalf) {
		ResultMessage info;
		info = orderbl.cancelAbnormalOrder(orderID, isHalf);
		return info;
	}
	
	/**
	 * 改变促销策略
	 * @param vo 促销策略的VO
	 * @return 结果信息
	 */
	public ResultMessage modifyPromotion(PromotionVO vo) {
		return promotionbl.modify(vo);
	}
	
	/**
	 * 增加促销策略
	 * @param vo 促销策略的VO
	 * @return 结果信息
	 */
	public ResultMessage addPromotion(PromotionVO vo) {
		return promotionbl.add(vo);
	}
	
	/**
	 * 登出
	 * @return
	 */
	public ResultMessage logout() {
		return userbl.logout(userName);
	}
	
	/**
	 * 获得所有城市
	 * @return
	 */
	public List<CityVO> getCitys() {
		return hotelbl.getCitys();
	}
	
	/**
	 * 获得某一城市的所有商圈
	 * @param vo
	 * @return
	 */
	public List<AreaVO> getAreas(CityVO vo) {
		return hotelbl.getAreas(vo);
	}
	
	public ResultMessage deletePromotion(String promotionID) {
		return promotionbl.delete(promotionID);
	}
}
