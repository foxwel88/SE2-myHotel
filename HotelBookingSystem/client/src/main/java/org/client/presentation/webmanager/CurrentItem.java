package org.client.presentation.webmanager;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;

/**
 * 导航栏中当前选择的项，用于修改跳转时的视觉变化
 * @author Hirico
 *
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
	
	public void deActive() {
		label.setStyle("-fx-text-fill: white");
		pane.setEffect(null);
		switch(type) {
			case HOME:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.56)");
				break;
			case CUSTOMER:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
				break;
			case HOTEL:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.44)");
				break;
			case WEB:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.38)");
				break;
			case NEW:
				pane.setStyle("-fx-background-color: rgba(0,0,0,0.32)");
				break;
		}		
	}
	
	public void active() {
		label.setStyle("-fx-text-fill: black");
		pane.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
		pane.setEffect(new DropShadow());
	}
	
}
