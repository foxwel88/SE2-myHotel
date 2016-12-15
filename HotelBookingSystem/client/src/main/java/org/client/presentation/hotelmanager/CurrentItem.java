package org.client.presentation.hotelmanager;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;

/**
 * 导航栏中当前选择的项，用于修改跳转时的视觉变化
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class CurrentItem {
	public Label label;
	
	public AnchorPane pane;
	
	public GuideLabelType type;
	
	private static CurrentItem current;
	
	private CurrentItem(Label l, AnchorPane p, GuideLabelType t) {
		label = l;
		pane = p;
		type = t;
	}
	
	public static CurrentItem getInstance() {
		return current;
	}
	
	public static CurrentItem setInstance(Label l, AnchorPane p, GuideLabelType t) {
		return current = new CurrentItem(l, p, t);
	}

	/**视觉上deActive当前所选的item  */
	public void deActive() {
		label.setStyle("-fx-text-fill: white");
		pane.setEffect(null);
		switch(type) {
			case MAIN:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.56)");
				break;
			case INFO:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
				break;
			case EXECUTE:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.44)");
				break;
			case HISTORY:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.38)");
				break;
			case PROMOTION:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.32)");
				break;
		}		
	}

	/**辅助函数，只deActive参数指定的item，且若item是当前所选项则不会被deActive */
	public void deActive(GuideLabelType t, Label l, AnchorPane p) {
		if (t != type) {
			l.setStyle("-fx-text-fill: white");
			p.setEffect(null);
			switch (t) {
				case MAIN:
					p.setStyle("-fx-background-color: rgba(0,0,0,0.56)");
					break;
				case INFO:
					p.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
					break;
				case EXECUTE:
					p.setStyle("-fx-background-color: rgba(0,0,0,0.44)");
					break;
				case HISTORY:
					p.setStyle("-fx-background-color: rgba(0,0,0,0.38)");
					break;
				case PROMOTION:
					p.setStyle("-fx-background-color: rgba(0,0,0,0.32)");
					break;
			}
		}
	}

	/**辅助函数，只active参数指定的item */
	public void active(Label l, AnchorPane p) {
		l.setStyle("-fx-text-fill: black");
		p.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
		p.setEffect(new DropShadow());
	}

	/**视觉上active当前选定的item */
	public void active() {
		label.setStyle("-fx-text-fill: black");
		pane.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
		pane.setEffect(new DropShadow());
	}
	
}
