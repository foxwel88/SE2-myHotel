package org.server.launcher;

import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.common.utility.ResultMessage;
import org.server.data.datafactory.DataFactory;
import org.server.util.timer.UpdateOrderTimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

/**
 * Server端的单件服务类
 * 存储当前登录的所有用户的用户名
 * 负责协作UserDao和Server界面，完成当前登录用户情况的显示、对用户已登录的判断以及输出日志文件
 * 也负责维持一个Timer检查超时的异常未执行订单
 */
public class ServerUtil {
	private static ServerUtil util;

	private List<String> nowUsers;
	
	private FileWriter fileWriter;

	private UpdateOrderTimer updateOrderTimer;

	public Parent root;
	
	private ServerUtil() {
		nowUsers = new ArrayList<>();
		updateOrderTimer = new UpdateOrderTimer();
		updateOrderTimer.startTimer();
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

	/**在有用户登录/登出，或服务器启动/停止的时候，更新界面的textArea以及写log文件 */
	public void show(String s) {
		TextArea textarea = (TextArea)root.lookup("#logTextArea");
		KeyFrame frame = new KeyFrame(Duration.millis(1), e -> {
			try {
				String text = DataFactory.getInstance().getTimeServiceImpl().getCurrentTime() + "  " + s;
				writeLog(text);
				textarea.appendText(text);
				textarea.appendText("\n");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		Timeline timeline = new Timeline(frame);
		Platform.runLater(timeline::play);
	}
	
	/**设置当前登录的用户数 */
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
