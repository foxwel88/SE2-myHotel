package org.client.presentation.customer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.client.rmi.RMIHelper;

import java.rmi.RemoteException;

public class CustomerMain {
	@FXML
	Label time;

	@FXML
	void initialize() {
		assert time != null : "fx:id=\"time\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";

		// clock
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), actionEvent -> {
			try {
				time.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
