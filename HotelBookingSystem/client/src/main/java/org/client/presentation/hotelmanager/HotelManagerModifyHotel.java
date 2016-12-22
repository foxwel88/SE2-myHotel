package org.client.presentation.hotelmanager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.client.presentation.util.ResultInfoHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.ResultMessage;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller
 * 酒店工作人员-维护酒店信息
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerModifyHotel {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private Button saveButton;

	@FXML
    private Button addButton; //check in info

	@FXML
    private Button changeButton;

	@FXML
    private Button deleteButton;

	@FXML
    private Button handInButton;
	
	@FXML
    private ChoiceBox<String> city;

	@FXML
    private ChoiceBox<String> area;

	@FXML
    private TextField address;

	@FXML
    private TextField name;

	@FXML
    private ChoiceBox<Integer> star;

	@FXML
    private TextArea intro;

	@FXML
    private TextArea facility;

	@FXML
	private TextField imageURLField;

	@FXML
    private ChoiceBox<String> roomType;

	private ObservableList<String> roomTypes;

	@FXML
	private TextField roomNum;

	@FXML
    private TextField roomPrice;
	
	private ArrayList<Integer> roomNums;
	
	private ArrayList<Double> roomPrices;
	
	@FXML
    private TextField roomNumber;

	@FXML
    private TextField startTime;

	@FXML
    private TextField endTime;
	
	private String newCheckInInfos = "";
    
	@FXML
    private ChoiceBox<String> cooperatorBox;
	
	private ObservableList<String> currentCooperators;

	@FXML
    private TextField cooperatorField;
	
	@FXML
	private Label resultLabel;
	
	@FXML
    private Button roomSaveButton;
	
	private HotelVO vo;

	@FXML
	private Pane placePane;

	@FXML
	private ImageView placeImage;

	@FXML
	private Pane infoPane;

	@FXML
	private ImageView infoImage;

	@FXML
	private Pane groupPane;

	@FXML
	private ImageView groupImage;

	@FXML
	private Pane roomPane;

	@FXML
	private ImageView roomImage;

	private boolean placeFolded;

	private boolean roomFolded;

	private boolean infoFolded;

	private boolean groupFolded;

	@FXML
	private Label placeLabel;

	@FXML
	private Label infoLabel;

	@FXML
	private Label roomLabel;

	@FXML
	private Label groupLabel;
	
	@FXML
	void addCooperator(ActionEvent event) {
		
		//检查是否已经存在
		String newCooperator = cooperatorField.getText().trim();
		for (String c: currentCooperators) {
			if (c.equals(newCooperator)) {
				return;
			}
		}
		
		currentCooperators.add(newCooperator);
	}

	@FXML
    void changeCooperator(ActionEvent event) {
		
		//检查是否已经存在
		String editedCooperator = cooperatorField.getText().trim();
		for (String c: currentCooperators) {
			if (c.equals(editedCooperator)) {
				return;
			}
		}

		if (cooperatorBox.getValue() == null) {
			return;
		}
		
		int index = currentCooperators.indexOf(cooperatorBox.getValue());
		
		currentCooperators.set(index, editedCooperator);
		cooperatorBox.setValue(editedCooperator);
	}

	@FXML
    void deleteCooperator(ActionEvent event) {
		currentCooperators.remove(cooperatorBox.getValue());
	}

	/**最终提交，只有提交才会保存所有修改的信息 */
	@FXML
    void handIn(ActionEvent event) {
		if (!basicInfoCorrect()) {
			ResultInfoHelper.setResultLabel(resultLabel, "基本信息不能为空", 2000);
			return;
		}
		if (!urlFormatCorrect()) {
			ResultInfoHelper.setResultLabel(resultLabel, "请填写完整的URL", 2000);
			return;
		}

		vo.address = address.getText().trim();
		vo.area = new AreaVO(area.getValue());
		vo.checkInInfos += newCheckInInfos;
		vo.city = new CityVO(city.getValue());
		vo.cooperators = new ArrayList<>(currentCooperators);
		vo.facility = facility.getText().trim();
		vo.imgURL = imageURLField.getText();
		vo.hotelName = name.getText().trim();
		vo.introduction = intro.getText().trim();
		
		vo.roomNum = new ArrayList<>(roomNums);
		vo.roomPrice = new ArrayList<>(roomPrices);
		
		vo.star = star.getValue();
		
		ResultMessage result = HotelManagerController.getInstance().modifyHotel(vo);
		ResultInfoHelper.setResultLabel(resultLabel, result, 2000);
	}

	/**检查名称、地址、城市、商圈是否不为空 */
	boolean basicInfoCorrect() {
		if (name.getText().isEmpty() || address.getText().isEmpty() || city.getValue() == null || area.getValue() == null) {
			return false;
		}
		return true;
	}

	/**图片链接格式是否正确 */
	boolean urlFormatCorrect() {
		if (!imageURLField.getText().isEmpty() && !imageURLField.getText().contains("http")) {
			return false;
		}
		return true;
	}

	/**保存当前选择的房间信息 */
	@FXML
    void saveRoom(ActionEvent event) {
		int index = roomTypes.indexOf(roomType.getValue());
		try {
			roomNums.set(index, Integer.parseInt(roomNum.getText().trim()));
			roomPrices.set(index, Double.parseDouble(roomPrice.getText().trim()));
		} catch (NumberFormatException e) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT, 2000);
		}
		ResultInfoHelper.setResultLabel(resultLabel, "", 2000);
	}
	
	/**保存（添加）当前输入的入住信息 */
	@FXML
	void saveCheckIn(ActionEvent event) {
		if (!roomNumber.getText().isEmpty() && !startTime.getText().isEmpty() && !endTime.getText().isEmpty())
		newCheckInInfos += (roomNumber.getText() + "," + startTime.getText() + "," + endTime.getText() + ";");
		ResultInfoHelper.setResultLabel(resultLabel, "", 2000);
		roomNumber.setText("");
		startTime.setText("");
		endTime.setText("");
	}

	@FXML
    void initialize() {

		vo = HotelManagerController.getInstance().getHotelInfo();
		
		//set values
				
		//city
		List<String> cityList = HotelManagerController.getInstance().getCitys();
		ObservableList<String> citys = FXCollections.observableArrayList(cityList);
		city.setItems(citys);
		city.setValue(vo.city.cityName);
		city.getSelectionModel().selectedItemProperty()
    			.addListener( (ObservableValue< ? extends String> observable, String oldValue, String newValue) 
    				-> area.setItems(FXCollections.observableArrayList(HotelManagerController.getInstance().getAreas(city.getValue()))));
		
		//area
		List<String> areaList = HotelManagerController.getInstance().getAreas(city.getValue());
		ObservableList<String> areas = FXCollections.observableArrayList(areaList);
		area.setItems(areas);
		area.setValue(vo.area.address);
		
		//address
		address.setText(vo.address);
		
		//cooperators		
		currentCooperators = FXCollections.observableArrayList(vo.cooperators);
		cooperatorBox.setItems(currentCooperators);
		cooperatorBox.getSelectionModel().selectedItemProperty()
	    	.addListener( (ObservableValue< ? extends String> observable, String oldValue, String newValue) -> cooperatorField.setText(newValue) );
		
		//facility, name, intro, imgURL
		facility.setText(vo.facility);
		name.setText(vo.hotelName);
		intro.setText(vo.introduction);
		imageURLField.setText(vo.imgURL);
		
		//roomNum roomPrice roomType
		roomTypes = FXCollections.observableArrayList(vo.roomType);
		roomType.setItems(roomTypes);

		roomNums = new ArrayList<>(vo.roomNum);
		roomPrices = new ArrayList<>(vo.roomPrice);

		//房间数量和房间价格的编辑与当前所选房间类型绑定
		roomType.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldIndex, newIndex) -> {
			roomNum.setText(roomNums.get((Integer)newIndex).toString());
			roomPrice.setText(roomPrices.get((Integer)newIndex).toString());
		});
		
		//设置可选星级
		ObservableList<Integer> stars = FXCollections.observableArrayList(1,2,3,4,5);
		star.setItems(stars);
		star.setValue(vo.star);

		switchGroupState(null);
		switchInfoState(null);
		switchPlaceState(null);
		switchRoomState(null);

	}

	@FXML
	void switchGroupState(MouseEvent event) {
		if (!groupFolded) {
			setDisappearTransition(groupPane, groupLabel);
			setFoldMoveTransition(groupImage, groupImage.getX() + 170, groupImage.getY() + 78);
		} else {
			setAppearTransition(groupPane, groupLabel);
			setUnfoldMoveTransition(groupImage, groupImage.getX(), groupImage.getY());
		}
		groupFolded = !groupFolded;
	}

	@FXML
	void switchInfoState(MouseEvent event) {
		if (!infoFolded) {
			setDisappearTransition(infoPane, infoLabel);
			setFoldMoveTransition(infoImage, infoImage.getX() - 170, infoImage.getY() + 78);
		} else {
			setAppearTransition(infoPane, infoLabel);
			setUnfoldMoveTransition(infoImage, infoImage.getX(), infoImage.getY());
		}
		infoFolded = !infoFolded;
	}

	@FXML
	void switchPlaceState(MouseEvent event) {
		if (!placeFolded) {
			setDisappearTransition(placePane, placeLabel);
			setFoldMoveTransition(placeImage, placeImage.getX() - 170, placeImage.getY() - 78);
		} else {
			setAppearTransition(placePane, placeLabel);
			setUnfoldMoveTransition(placeImage, placeImage.getX(), placeImage.getY());
		}
		placeFolded = !placeFolded;
	}

	@FXML
	void switchRoomState(MouseEvent event) {
		if (!roomFolded) {
			setDisappearTransition(roomPane, roomLabel);
			setFoldMoveTransition(roomImage, roomImage.getX() + 170, roomImage.getY() - 78);
		} else {
			setAppearTransition(roomPane, roomLabel);
			setUnfoldMoveTransition(roomImage, roomImage.getX(), roomImage.getY());
		}
		roomFolded = !roomFolded;
	}

	/**显示完整的编辑内容 */
	void setAppearTransition(Pane pane, Label label) {
		for (Node node: pane.getChildren()) {
			node.setDisable(false);
		}

		FadeTransition ft = new FadeTransition(Duration.millis(100), pane);
		ft.setRate(0.6);
		ft.setFromValue(0);
		ft.setToValue(1.0);
		ft.play();

		label.setVisible(false);
	}

	/**隐去完整的编辑内容 */
	void setDisappearTransition(Pane pane, Label label) {
		for (Node node: pane.getChildren()) {
			node.setDisable(true);
		}

		FadeTransition ft = new FadeTransition(Duration.millis(100), pane);
		ft.setRate(0.6);
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.play();

		label.setVisible(true);
		label.setOpacity(0);
		FadeTransition labelFt = new FadeTransition(Duration.millis(400), label);
		labelFt.setRate(0.5);
		labelFt.setFromValue(0);
		labelFt.setToValue(1.0);
		labelFt.play();
	}

	void setFoldMoveTransition(ImageView image, double toX, double toY) {
		FadeTransition fadeTransition =
				new FadeTransition(Duration.millis(100), image);
		fadeTransition.setRate(0.7);
		fadeTransition.setFromValue(0.3f);
		fadeTransition.setToValue(1f);

		TranslateTransition translateTransition =
				new TranslateTransition(Duration.millis(100), image);
		translateTransition.setToX(toX);
		translateTransition.setToY(toY);

		ScaleTransition scaleTransition =
				new ScaleTransition(Duration.millis(100), image);
		scaleTransition.setToX(2f);
		scaleTransition.setToY(2f);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(
				fadeTransition,
				translateTransition,
				scaleTransition
		);
		parallelTransition.play();
	}

	void setUnfoldMoveTransition(ImageView image, double toX, double toY) {
		FadeTransition fadeTransition =
				new FadeTransition(Duration.millis(100), image);
		fadeTransition.setRate(0.7);
		fadeTransition.setFromValue(1f);
		fadeTransition.setToValue(0.3f);

		TranslateTransition translateTransition =
				new TranslateTransition(Duration.millis(100), image);
		translateTransition.setToX(toX);
		translateTransition.setToY(toY);

		ScaleTransition scaleTransition =
				new ScaleTransition(Duration.millis(100), image);
		scaleTransition.setToX(1f);
		scaleTransition.setToY(1f);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(
				fadeTransition,
				translateTransition,
				scaleTransition
		);
		parallelTransition.play();
	}
}


