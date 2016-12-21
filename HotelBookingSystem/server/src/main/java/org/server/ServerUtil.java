package org.server;

import java.rmi.RemoteException;

import org.server.data.datafactory.DataFactory;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class ServerUtil {
	private static ServerUtil util;
	
	public Parent root;
	
	private ServerUtil() {
		
	}
	
	public static ServerUtil getInstance() {
		if (util == null) {
			util = new ServerUtil();
		}
		return util;
	}
	
	public void setParent(Parent root) {
		this.root = root;
	}
	
	public void show(String s) {
		TextArea textarea = (TextArea)root.lookup("#logTextArea"); 
		try {
			textarea.appendText(DataFactory.getInstance().getTimeServiceImpl().getCurrentTime() + "  " + s + "\n");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setUserNum(int x) {
		Label userLabel = (Label)root.lookup("#userLabel");
		KeyFrame frame = new KeyFrame(Duration.millis(1),e -> userLabel.setText("当前登录用户数: " + Integer.toString(x)));
		Timeline timeline = new Timeline(frame);
		Platform.runLater(timeline::play);
	}
}
