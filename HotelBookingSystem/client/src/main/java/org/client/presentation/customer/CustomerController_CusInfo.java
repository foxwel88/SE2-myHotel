package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CustomerController_CusInfo {
	@FXML
	public GridPane gridpane;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	void turnToCusController_Main() {
		SwitchSceneUtil.turnToCusController_Main();
	}
	
	@FXML
	void turnToCusController_CusInfo() {
		SwitchSceneUtil.turnToCusController_CusInfo();
	}
	
	@FXML
	void turnToCusController_HotelList() {
		SwitchSceneUtil.turnToCusController_HotelList();
	}
	
	@FXML
	void turnToCusController_HistoryOrderList() {
		SwitchSceneUtil.turnToCusController_HistoryOrderList();
	}
	
	@FXML
	void turnToCusController_UnexcutedOrderList() {
		SwitchSceneUtil.turnToCusController_UnexcutedOrderList();
	}
}
