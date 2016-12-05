package org.client.presentation.webmarketer;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import org.client.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * 
 * FXML Controller
 * 网站营销人员-主界面
 * @author gyue
 * @version 2016/11/27
 *
 */
public class WebMarketerMain {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
	private Label timeLabel;

	@FXML
    void initialize() {
		assert timeLabel != null : "fx:id=\"timeLabel\" was not injected: check your FXML file '网站营销人员主界面.fxml'.";
		//clock
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), actionEvent -> {
			try {
				timeLabel.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
}
