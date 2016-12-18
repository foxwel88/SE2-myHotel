package org.client.presentation.hotelmanager;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.scene.web.WebView;
import org.client.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.client.vo.HotelVO;

/**
 * FXML Controller
 * 酒店工作人员-主界面
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerMain {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Label timeLabel;

	@FXML
	private WebView hotelImage;

	@FXML
	private Label hotelNameLabel;

	@FXML
    void initialize() {
		assert timeLabel != null : "fx:id=\"timeLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		
		//clock
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						actionEvent -> {
					try {
						timeLabel.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		HotelVO tempVO = HotelManagerController.getInstance().getHotelInfo();

		hotelNameLabel.setText(tempVO.hotelName);

		String imgURL = tempVO.imgURL;

		final com.sun.webkit.WebPage webPage = com.sun.javafx.webkit.Accessor.getPageFor(hotelImage.getEngine());
		webPage.setBackgroundColor(0);

		hotelImage.getEngine().load(imgURL);
	}
	
}



