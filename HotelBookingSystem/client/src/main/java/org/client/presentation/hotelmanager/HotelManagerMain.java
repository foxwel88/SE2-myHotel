package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import org.client.launcher.Resources;
import org.client.presentation.util.DateUtil;
import org.client.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.client.vo.HotelVO;
import org.common.utility.RoomType;


/**
 * FXML Controller
 * 酒店工作人员-主界面
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerMain {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
	private AnchorPane root;

	private Pane parentPane;

	@FXML
    private Label timeLabel;

	@FXML
	private ImageView hotelImage;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Label singleTotalLabel;

	@FXML
	private Label doubleTotalLabel;

	@FXML
	private Label bigTotalLabel;

	@FXML
	private Label singleBookedLabel;

	@FXML
	private Label doubleBookedLabel;

	@FXML
	private Label bigBookedLabel;

	@FXML
	private DatePicker startTimePicker;

	@FXML
	private DatePicker endTimePicker;

	@FXML
	private Button searchNum;

	@FXML
	private Button offlineButton;

	@FXML
	void generateOfflineOrder(ActionEvent event) {
		AnchorPane mask = new AnchorPane();
		mask.setStyle("-fx-background-color:rgba(0,0,0,0.9)");
		mask.setLayoutX(0);
		mask.setLayoutY(0);
		mask.setPrefSize(1103.0, 683.0);
		parentPane.getChildren().add(mask);
		Resources resources = Resources.getInstance();
		Parent newRoot = null;
		try {
			newRoot = resources.load(resources.hotelManagerGenerateOfflineOrder);
			((HotelManagerGenerateOfflineOrder)resources.getCurrentController()).setParentPane(parentPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mask.getChildren().add(newRoot);
		AnchorPane.setLeftAnchor(newRoot, 352.0);
		AnchorPane.setRightAnchor(newRoot, 351.0);
		AnchorPane.setTopAnchor(newRoot, 80.0);
	}


	/** 持有导航界面Pane的引用，为了实现登记线下入住时覆盖全窗口的效果 */
	void setParentPane(Pane parent) {
		parentPane = parent;
	}

	@FXML
	void searchRoomNum(ActionEvent event) {
		refreshBookedRoomNum();
	}

	void refreshBookedRoomNum() {
		Date fromDate = DateUtil.toDate(startTimePicker.getValue());
		Date toDate = DateUtil.toDate(endTimePicker.getValue());

		if (toDate.before(fromDate)) {
			return;
		}

		singleBookedLabel.setText(String.valueOf(HotelManagerController.getInstance().getBookedRoomNum(RoomType.SINGLE, fromDate, toDate)));
		bigBookedLabel.setText(String.valueOf(HotelManagerController.getInstance().getBookedRoomNum(RoomType.BIG, fromDate, toDate)));
		doubleBookedLabel.setText(String.valueOf(HotelManagerController.getInstance().getBookedRoomNum(RoomType.DOUBLE, fromDate, toDate)));
	}

	@FXML
    void initialize() {
		assert timeLabel != null : "fx:id=\"timeLabel\" was not injected: check your FXML file '酒店工作人员主界面.fxml'.";
		
		//clock
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						actionEvent -> {
					try {
						timeLabel.setText("当前时间：" + RMIHelper.getInstance().getTimeServiceImpl().getCurrentTime());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		//房间数量
		HotelVO hotelVO = HotelManagerController.getInstance().getHotelInfo();
		List<Integer> roomNums = hotelVO.roomNum;
		List<String> roomTypes = hotelVO.roomType;
		for (int i = 0; i < roomTypes.size(); i++) {
			switch (roomTypes.get(i)) {
				case "单人间":
					singleTotalLabel.setText(roomNums.get(i).toString());
					break;
				case "套间":
					bigTotalLabel.setText(roomNums.get(i).toString());
					break;
				case "标间":
					doubleTotalLabel.setText(roomNums.get(i).toString());
					break;
			}
		}

		//auto-refresh roomNum every 10 seconds
		Timeline refreshRoomNumTimeline = new Timeline(
				new KeyFrame(Duration.seconds(0), actionEvent -> refreshBookedRoomNum()),
				new KeyFrame(Duration.seconds(10))
		);
		refreshRoomNumTimeline.setCycleCount(Animation.INDEFINITE);
		refreshRoomNumTimeline.play();


		//Hotel name and image
		hotelNameLabel.setText(hotelVO.hotelName);

		String imgURL = hotelVO.imgURL;

		try {
			Image image = new Image(imgURL, 100, 60, false, true);
			hotelImage.setImage(image);
		} catch (IllegalArgumentException e) {
			//fail to load image, hotelImage won't show
		}

		//时间默认值，显示接下来一周房源情况，不可查看超过一年后的预订情况
		startTimePicker.setValue(LocalDate.now());
		Callback<DatePicker, DateCell> startDayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(LocalDate.now())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		startTimePicker.setDayCellFactory(startDayCellFactory);

		endTimePicker.setValue(LocalDate.now().plusDays(7));
		Callback<DatePicker, DateCell> endDayCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isAfter(LocalDate.now().plusYears(1))) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		endTimePicker.setDayCellFactory(endDayCellFactory);

	}

}



