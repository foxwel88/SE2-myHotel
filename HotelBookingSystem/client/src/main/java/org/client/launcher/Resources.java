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
