package org.client.launcher;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * 存储本地文件路径，提供FXML载入服务
 * @author Hirico
 * @version 2016/11/30 Hirico
 */
public class Resources {
	private static Resources instance;

	//Launcher UI
	public URL login = getClass().getResource("/登录界面.fxml");
	
	public URL register = getClass().getResource("/注册界面.fxml");
	
	public URL modify = getClass().getResource("/修改密码界面.fxml");

	//Images
	public URL avatar = getClass().getResource("/profile.png");

	public URL icon = getClass().getResource("/icon.png");
	
	//HotelManager UI
	public URL hotelManagerGuide = getClass().getResource("/酒店工作人员/guide.fxml");
	
	public URL hotelManagerMain = getClass().getResource("/酒店工作人员/酒店工作人员主界面.fxml");
	
	public URL hotelManagerModifyHotel = getClass().getResource("/酒店工作人员/维护酒店信息界面.fxml");
	
	public URL hotelManagerExecute = getClass().getResource("/酒店工作人员/执行订单界面.fxml");
	
	public URL hotelManagerHistoryOrder = getClass().getResource("/酒店工作人员/浏览酒店历史订单界面.fxml");
	
	public URL hotelManagerCheckPromotion = getClass().getResource("/酒店工作人员/管理酒店促销策略界面.fxml");
	
	public URL hotelManagerUnexecutedOrder = getClass().getResource("/酒店工作人员/未执行订单详细信息界面.fxml");
	
	public URL hotelManagerExecutedOrder = getClass().getResource("/酒店工作人员/已执行订单详细信息界面.fxml");
	
	public URL hotelManagerCancelledOrder = getClass().getResource("/酒店工作人员/已撤销订单详细信息界面.fxml");
	
	public URL hotelManagerAbnormalOrder = getClass().getResource("/酒店工作人员/异常订单详细信息界面.fxml");
	
	public URL hotelManagerModifyPromotion = getClass().getResource("/酒店工作人员/修改酒店促销策略界面.fxml");

	public URL hotelManagerOfflineOrder = getClass().getResource("/酒店工作人员/线下订单详细信息界面.fxml");

	public URL hotelManagerGenerateOfflineOrder = getClass().getResource("/酒店工作人员/线下订单生成界面.fxml");
		
	//Customer UI
	public URL customerGuide = getClass().getResource("/客户/导航_主界面.fxml");
	
	public URL customerMain = getClass().getResource("/客户/主界面.fxml");
	
	public URL customerCheckInfo = getClass().getResource("/客户/查看客户信息界面.fxml");
	
	public URL customerCheckComment = getClass().getResource("/客户/查看订单评价界面.fxml");
	
	public URL customerModifyInfo = getClass().getResource("/客户/修改客户信息界面.fxml");
	
	public URL customerCheckCredits = getClass().getResource("/客户/查看信用记录界面.fxml");
	
	public URL customerCheckHotel = getClass().getResource("/客户/酒店详细信息界面.fxml");
	
	public URL customerCheckHotelList = getClass().getResource("/客户/浏览酒店界面.fxml");
	
	public URL customerCheckHistoryOrderList = getClass().getResource("/客户/浏览客户历史订单界面.fxml");
	
	public URL customerCheckUnexecutedOrderList = getClass().getResource("/客户/浏览客户未执行订单界面.fxml");
	
	public URL customerMakeComments = getClass().getResource("/客户/评价订单.fxml");
	
	public URL customerGenerateOrder = getClass().getResource("/客户/生成订单界面.fxml");
	
	public URL customerConfirmGenerateOrder = getClass().getResource("/客户/生成订单确认界面.fxml");
	
	public URL customerCheckUnexecutedOrder = getClass().getResource("/客户/未执行订单详细信息界面.fxml");
	
	public URL customerCheckCanceledOrder = getClass().getResource("/客户/已撤销订单详细信息界面.fxml");
	
	public URL customerCheckExecutedOrder = getClass().getResource("/客户/已执行订单详细信息界面.fxml");
	
	public URL customerCheckAbnormalOrder = getClass().getResource("/客户/异常订单详细信息界面.fxml");
	
	//WebMarketer UI
	public URL webMarketerGuide = getClass().getResource("/网站营销人员/guide.fxml");
	
	public URL webMarketerAbnormalOrder = getClass().getResource("/网站营销人员/异常订单详细信息界面.fxml");
	
	public URL webMarketerAbnormalOrderList = getClass().getResource("/网站营销人员/浏览异常订单界面.fxml");
	
	public URL webMarketerCheckPromotion = getClass().getResource("/网站营销人员/管理促销策略界面.fxml");
	
	public URL webMarketerMain = getClass().getResource("/网站营销人员/网站营销人员主界面.fxml");
	
	public URL webMarketerModifyCredit = getClass().getResource("/网站营销人员/信用充值界面.fxml");
	
	public URL webMarketerModifyLevel = getClass().getResource("/网站营销人员/修改会员等级制度界面.fxml");
	
	public URL webMarketerModifyPromotion = getClass().getResource("/网站营销人员/修改促销策略界面.fxml");
	
	private FXMLLoader loader;
	
	private Resources() {
		
	}
	
	public static Resources getInstance() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}
	
	public Parent load(URL url) throws IOException {
		loader = new FXMLLoader();
		return loader.load(url.openStream());
	}
	
	public Object getCurrentController() {
		return loader.getController();
	}
	
	
}
