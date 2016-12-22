package org.server;

import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.common.utility.ResultMessage;
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

	private static List<String> nowUsers;
	
	private FileWriter fileWriter;

	public Parent root;
	
	private ServerUtil() {
		nowUsers = new ArrayList<>();
	}
	
	public static ServerUtil getInstance() {
		if (util == null) {
			util = new ServerUtil();
		}
		return util;
	}
	
	public void setParent(Parent root) {
		this.root = root;
		if (fileWriter == null) {
			try {
				fileWriter = new FileWriter("server_log.txt", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addNowUser(String userName) {
		nowUsers.add(userName);
		show("用户: " + userName + " 登录");
		setUserNum(nowUsers.size());
	}

	public ResultMessage userIsExist(String userName) {
		if (nowUsers.indexOf(userName) != -1) {
			return ResultMessage.EXIST;
		}
		return ResultMessage.NOT_EXIST;
	}

	public ResultMessage deleteNowUser(String userName) {
		if (userIsExist(userName) == ResultMessage.NOT_EXIST) {
			return ResultMessage.NOT_EXIST;
		}
		nowUsers.remove(userName);
		show("用户: " + userName + " 登出");
		setUserNum(nowUsers.size());
		return ResultMessage.SUCCESS;
	}

	public void show(String s) {
		TextArea textarea = (TextArea)root.lookup("#logTextArea");
		KeyFrame frame = new KeyFrame(Duration.millis(1), e -> {
			try {
				writeLog(s);
				textarea.appendText(DataFactory.getInstance().getTimeServiceImpl().getCurrentTime() + "  " + s + "\n");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		Timeline timeline = new Timeline(frame);
		Platform.runLater(timeline::play);
	}
	
	public void setUserNum(int x) {
		Label userLabel = (Label)root.lookup("#userLabel");
		KeyFrame frame = new KeyFrame(Duration.millis(1),e -> userLabel.setText("当前登录用户数: " + Integer.toString(x)));
		Timeline timeline = new Timeline(frame);
		Platform.runLater(timeline::play);
	}

	public void cleanUser() {
		nowUsers = new ArrayList<>();
		setUserNum(0);
	}
	
	private void writeLog(String s) {
		try {
			fileWriter.write(s + System.getProperty("line.separator"));
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
