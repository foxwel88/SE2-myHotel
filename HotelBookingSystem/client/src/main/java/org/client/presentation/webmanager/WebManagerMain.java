package org.client.presentation.webmanager;

import java.rmi.RemoteException;

import org.client.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * 
 * 网站管理人员-主界面
 * @author Foxwel
 * @version 2016/11/27 Foxwel
 * 
 */

public class WebManagerMain {
	
	@FXML
	private Label timeLabel;
	
	@FXML
    void initialize() {

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent actionEvent) {
								try {
									timeLabel.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
								} catch (RemoteException e) {
									e.printStackTrace();
								}
							}
						}
			    ),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
