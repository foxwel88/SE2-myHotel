package org.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.server.data.datafactory.DataFactory;
import org.server.mysql.DatabaseCommunicator;
import org.server.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ServerMainController {

	@FXML
	private Label timeLabel;
	
	@FXML
	private Label userLabel;
	
	@FXML
	private Label ipLabel;
	
	@FXML
	private Button startButton;
	
	private Timeline timeline;
	
	public void changenum() {
		userLabel.setText("00");
	}
	
	
	@FXML
    void initialize() {
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						actionEvent -> {
					try {
						timeLabel.setText("当前时间：" + DataFactory.getInstance().getTimeServiceImpl().getCurrentTime());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ip = addr.getHostAddress().toString();//获得本机IP
		String address = addr.getHostName().toString();//获得本机名称
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ip = ia.getHostAddress();
		ipLabel.setText("服务器ip:" + ip);
	}
	
	@FXML
	void handleStartAction(MouseEvent event) {
		if (startButton.getText().equals("启动服务器")) {
			RMIHelper.getinstance().buildConnection();
			DatabaseCommunicator.databaseInit();
			startButton.setText("停止服务器");
			ServerUtil.getInstance().show("服务器启动服务");


		} else {
			RMIHelper.getinstance().releaseConnection();
			startButton.setText("启动服务器");
			ServerUtil.getInstance().show("服务器停止服务");
			ServerUtil.getInstance().show("所有用户已全部下线");
			ServerUtil.getInstance().cleanUser();
		}
		
	}

}