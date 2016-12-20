package org.client.presentation.hotelmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * @author Hirico
 * @version 2016/12/20 Hirico
 */
public class HotelManagerOfflineOrder {

	@FXML
	private AnchorPane offline;

	@FXML
	private GridPane gridPane;

	@FXML
	private Label orderIDLabel;

	@FXML
	private Label roomTypeLabel;

	@FXML
	private Label roomNumLabel;

	@FXML
	private Label numOfPeopleLabel;

	@FXML
	private Label childrenLabel;

	@FXML
	private Label orderTypeLabel;

	@FXML
	private Label priceLabel;

	@FXML
	private Label actFromLabel;

	@FXML
	private Label customerNameLabel;

	@FXML
	private Button updateButton;

	@FXML
	void checkOut(ActionEvent event) {

	}
}
