package org.client.presentation.util;

import com.sun.scenario.DelayedRunnable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.common.utility.ResultMessage;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 根据ResultMessage设置一些界面上的提示信息
 * @author Hirico
 * @version 2016/12/01 Hirico
 */
public class ResultInfoHelper {

    /**将提示信息显示在一个Label上，一定时间后清空label */
	public static void setResultLabel(Label label, ResultMessage resultMessage, long delayMilliSeconds) {
		if (resultMessage == null) {
			label.setText("");
			return;
		}
		switch(resultMessage) {
			case SUCCESS:
				label.setText("编辑成功");
				break;
			case WRONG_FORMAT:
				label.setText("输入信息格式有误");
				break;
			case EXIST:
				label.setText("该名称已被使用");
				break;
			case WRONG_USERNAME:
				label.setText("用户名有误");
				break;
			case WRONG_PASSWORD:
				label.setText("密码有误");
				break;
			default:
				label.setText("错误");
				break;
		}
		setCleanTimer(label, delayMilliSeconds);
	}

	public static void setResultLabel(Label label, String content, long delayMilliSeconds) {
		label.setText(content);
		setCleanTimer(label, delayMilliSeconds);
	}

	/**定时清空label显示的text */
	public static void setCleanTimer(Label label, long delayMilliSeconds) {
		KeyFrame frame = new KeyFrame(Duration.millis(delayMilliSeconds),e -> label.setText(""));
		Timeline timeLine = new Timeline(frame);
		Platform.runLater(timeLine::play);
	}

}
