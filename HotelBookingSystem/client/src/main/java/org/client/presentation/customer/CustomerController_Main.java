package org.client.presentation.customer;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class CustomerController_Main {
	@FXML
	private GridPane gridpane;
	
	@FXML
	private AnchorPane root;
	
	@FXML
	void turnToCusController_Main() {
		SwitchSceneUtil.turnToCusController_Main(gridpane);
	}
	
	@FXML
	void turnToCusController_CusInfo() {
		SwitchSceneUtil.turnToCusController_CusInfo(gridpane);
	}
	
	@FXML
	void turnToCusController_HotelList() {
		SwitchSceneUtil.turnToCusController_HotelList(gridpane);
	}
	
	@FXML
	void turnToCusController_HistoryOrderList() {
		SwitchSceneUtil.turnToCusController_HistoryOrderList(gridpane);
	}
	
	@FXML
	void turnToCusController_UnexcutedOrderList() {
		SwitchSceneUtil.turnToCusController_UnexcutedOrderList(gridpane);
	}
}
