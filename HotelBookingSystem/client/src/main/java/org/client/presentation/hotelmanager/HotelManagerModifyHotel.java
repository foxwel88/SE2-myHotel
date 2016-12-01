package org.client.presentation.hotelmanager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.ResultMessage;

import javafx.beans.value.ChangeListener;
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
    private ChoiceBox<String> roomType;

	@FXML
	private TextField roomNum;

	@FXML
    private TextField roomPrice;
	
	private ObservableList<String> roomTypes;
	
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
		
		vo.address = address.getText().trim();
		vo.area = new AreaVO(area.getValue());
		vo.checkInInfos += newCheckInInfos;
		vo.city = new CityVO(city.getValue());
		vo.cooperators = new ArrayList<String>(currentCooperators);
		vo.facility = facility.getText().trim();
		vo.hotelName = name.getText().trim();
		vo.introduce = intro.getText().trim();
		
		vo.roomNum = new ArrayList<Integer>(roomNums);
		vo.roomPrice = new ArrayList<Double>(roomPrices);
		
		vo.star = star.getValue();
		
		ResultMessage result = HotelManagerController.getInstance().modifyHotel(vo);
		ResultInfoHelper.setResultLabel(resultLabel, result);
	}

	/**保存当前选择的房间信息 */
	@FXML
    void saveRoom(ActionEvent event) {
		int index = roomTypes.indexOf(roomType.getValue());
		try {
			roomNums.set(index, Integer.parseInt(roomNum.getText().trim()));
			roomPrices.set(index, Double.parseDouble(roomPrice.getText().trim()));
		} catch (NumberFormatException e) {
			ResultInfoHelper.setResultLabel(resultLabel, ResultMessage.WRONG_FORMAT);
		}

	}
	
	/**保存（添加）当前输入的入住信息 */
	@FXML
	void saveCheckIn(ActionEvent event) {
		newCheckInInfos += (roomNumber.getText() + "," + startTime.getText() + "," + endTime.getText() + ";");
	}

	@FXML
    void initialize() {
		assert city != null : "fx:id=\"city\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert area != null : "fx:id=\"area\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert address != null : "fx:id=\"address\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert name != null : "fx:id=\"name\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert star != null : "fx:id=\"star\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert intro != null : "fx:id=\"intro\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert facility != null : "fx:id=\"facility\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert roomType != null : "fx:id=\"roomType\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert roomNum != null : "fx:id=\"roomNum\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert roomPrice != null : "fx:id=\"roomPrice\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert startTime != null : "fx:id=\"startTime\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert endTime != null : "fx:id=\"endTime\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert cooperatorBox != null : "fx:id=\"cooperatorBox\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert cooperatorField != null : "fx:id=\"cooperatorField\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert changeButton != null : "fx:id=\"changeButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert handInButton != null : "fx:id=\"handInButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert roomNumber != null : "fx:id=\"roomNumber\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert roomSaveButton != null : "fx:id=\"roomSaveButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";

		
		vo = HotelManagerController.getInstance().getHotelInfo();
		
		//set values
				
		//city
		List<CityVO> cityVOs = HotelManagerController.getInstance().getCitys();
		ArrayList<String> cityList = new ArrayList<String>();
		for (CityVO v: cityVOs) {
			cityList.add(v.cityName);
		}
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
		
		//facility, name, intro
		facility.setText(vo.facility);
		facility.setStyle("-fx-text-fill: black;");
		name.setText(vo.hotelName);
		intro.setText(vo.introduce);
		intro.setStyle("-fx-text-fill: black;");
		
		//roomNum roomPrice roomType
		roomTypes = FXCollections.observableArrayList(vo.roomType);
		roomType.setItems(roomTypes);
		
		roomNums = new ArrayList<Integer>(vo.roomNum);
		roomPrices = new ArrayList<Double>(vo.roomPrice);

		//房间数量和房间价格的编辑与当前所选房间类型绑定
		roomType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue< ? extends Number> observableValue, Number oldIndex, Number newIndex) {
				roomNum.setText(roomNums.get((Integer)newIndex).toString());
				roomPrice.setText(roomPrices.get((Integer)newIndex).toString());
			}
		});
		
		//设置可选星级
		ObservableList<Integer> stars = FXCollections.observableArrayList(1,2,3,4,5);
		star.setItems(stars);
		star.setValue(vo.star);
	}
}


