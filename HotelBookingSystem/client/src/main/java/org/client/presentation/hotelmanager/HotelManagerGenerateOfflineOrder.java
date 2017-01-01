package org.client.presentation.hotelmanager;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.client.presentation.util.DateUtil;
import org.client.presentation.util.CheckStyle;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.RoomType;

import java.util.ArrayList;

/**
 * 生成线下订单（线下入住登记）界面
 * @author Hirico
 * @version 2016/12/20 Hirico
 */
public class HotelManagerGenerateOfflineOrder {

	@FXML
	private TextField customerName;

	@FXML
	private TextField phoneNumber;

	@FXML
	private ChoiceBox<String> roomType;

	@FXML
	private CheckBox hasChildren;

	@FXML
	private DatePicker schToDate;

	@FXML
	private TextField roomNum;

	@FXML
	private DatePicker schFromDate;

	@FXML
	private TextField residentNum;

	private Pane parent;

	/**获得Parent的引用，用以完成操作后返回上一界面 */
	public void setParentPane(Pane directParent) {
		parent = directParent;
	}

	@FXML
	void initialize() {
		DateUtil.initDatePicker(null, schFromDate);
		DateUtil.initDatePicker(schFromDate, schToDate);
		setRoomType();
		roomType.setValue("单人间");
		roomNum.setText("1");
	}

	@FXML
	void commitOrder() {
		if (!checkCustomerName()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("请输入客户姓名");
			alert.showAndWait();
		} else if (!checkPhoneNumberFormat()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("电话格式不正确(应为11位中国区号码)");
			alert.showAndWait();
		} else {
			try {
				OrderVO newOrder = new OrderVO("", OrderType.OFFLINE.getString(), null, DateUtil.toDate(schFromDate.getValue()), DateUtil.toDate(schToDate.getValue()),
						null, null, DateUtil.toDate(schFromDate.getValue().plusDays(1)), null, HotelManagerController.getInstance().hotelID,
						HotelManagerController.getInstance().hotelName, "", HotelManagerController.getInstance().hotelAddress, roomType.getValue(), 0, Integer.parseInt(roomNum.getText()), Integer.parseInt(residentNum.getText()),
						hasChildren.isSelected(), customerName.getText(), phoneNumber.getText(), false, false);
				HotelManagerController.getInstance().addOfflineOrder(newOrder);
				cancel();
			} catch (NumberFormatException numberFormatException) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Sorry, please check your entry again.");
				alert.setHeaderText(null);
				alert.setContentText("住宿人姓名、房间数量和入住人数均不能为空");
				alert.showAndWait();
			}
		}
	}

	@FXML
	void cancel() {
		int size = parent.getChildren().size();
		AnchorPane pane = (AnchorPane) parent.getChildren().get(size - 1);
		pane.getChildren().clear();
		parent.getChildren().remove(size - 1);
	}

	private void setRoomType() {
		RoomType[] roomTypeArray = RoomType.values();
		ArrayList<String> roomTypeList = new ArrayList<>();
		for (int i = 0; i < roomTypeArray.length; i++) {
			roomTypeList.add(roomTypeArray[i].getString());
		}
		roomType.setItems(FXCollections.observableArrayList(roomTypeList));
	}

	private boolean checkPhoneNumberFormat() {
		String phoneString = phoneNumber.getText();
		return CheckStyle.checkPhone(phoneString);
	}

	private boolean checkCustomerName() {
		return !customerName.getText().isEmpty();
	}

}
