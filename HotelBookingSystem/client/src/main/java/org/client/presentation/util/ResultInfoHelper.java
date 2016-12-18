package org.client.presentation.util;

import javafx.scene.control.Label;
import org.common.utility.ResultMessage;

/**
 * 根据ResultMessage设置一些界面上的提示信息
 * @author Hirico
 * @version 2016/12/01 Hirico
 */
public class ResultInfoHelper {

    /**将提示信息显示在一个Label上 */
	public static void setResultLabel(Label label, ResultMessage resultMessage) {
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
	}
}
