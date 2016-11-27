package org.client.presentation.hotelmanager;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * 浏览历史订单界面中当前所选的tab(订单类型)
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class CurrentTabItem {
	Pane pane;
	
	Label label;
	
	private static CurrentTabItem current;
	
	private CurrentTabItem(Pane p, Label l) {
		pane = p;
		label = l;
	}
	
	public static CurrentTabItem getInstance() {
		return current;
	}
	
	public static void setInstance(Pane p, Label l) {
		current = new CurrentTabItem(p, l);
	}
	
	public void deActive() {
		pane.setStyle(null);
		label.setStyle(null);
	}
	
	public void active() {
		pane.setStyle("-fx-background-color: rgba(0,0,0,0.4)");
		label.setStyle("-fx-text-fill: white");
	}
	
	
}
