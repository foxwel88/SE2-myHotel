package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.rmi.RMIHelper;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.ResultMessage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller
 * 酒店工作人员-维护酒店信息
 *
 */
public class HotelManagerModifyHotel {

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
    private Label mainLabel;

	@FXML
    private Label executeLabel;

	@FXML
    private Label historyLabel;

	@FXML
    private Label promotionLabel;
	
	@FXML
    private Button saveButton;

	@FXML
    private Button addButton;

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
	
	@FXML
    private ChoiceBox<String> roomNumber;

	@FXML
    private TextField startTime;

	@FXML
    private TextField endTime;
    
	@FXML
    private ChoiceBox<String> cooperatorBox;

	@FXML
    private TextField cooperatorField;
	
	private HotelVO vo;

	@FXML
    void handleSwitch(MouseEvent event) throws IOException {
		Parent root = null;
		Label source = (Label)event.getSource();

		if (source == executeLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/执行订单界面.fxml"));
		} else if (source == historyLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/浏览酒店历史订单界面.fxml"));
		} else if (source == mainLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/酒店工作人员主界面.fxml"));
		} else if (source == promotionLabel) {
			root = FXMLLoader.load(getClass().getResource("/酒店工作人员/管理酒店促销策略界面.fxml"));
		}
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)executeLabel.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	void addCooperator(ActionEvent event) {

	}

	@FXML
    void changeCooperator(ActionEvent event) {

	}

	@FXML
    void deleteCooperator(ActionEvent event) {

	}

	@FXML
    void handIn(ActionEvent event) {
		
		vo.address = address.getText().trim();
		vo.area = new AreaVO(area.getValue());
		//vo.checkInInfos
		vo.city = new CityVO(city.getValue());
		//vo.cooperators
		vo.facility = facility.getText().trim();
		vo.hotelName = name.getText().trim();
		vo.introduce = intro.getText().trim();
		//vo.roomNum
		//vo.roomPrice
		//vo.roomType
		vo.star = star.getValue();
		
		ResultMessage result = HotelManagerController.getInstance().modifyHotel(vo);
		
	}

	@FXML
    void saveRoom(ActionEvent event) {

	}

	@FXML
    void initialize() {
		assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert changeButton != null : "fx:id=\"changeButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		assert handInButton != null : "fx:id=\"handInButton\" was not injected: check your FXML file '维护酒店信息界面.fxml'.";
		
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
		
		//area
		List<AreaVO> areaVOs = HotelManagerController.getInstance().getAreas(vo.city);
		ArrayList<String> areaList = new ArrayList<String>();
		for (AreaVO v: areaVOs) {
			areaList.add(v.address);
		}
		ObservableList<String> areas = FXCollections.observableArrayList(areaList);
		area.setItems(areas);
		area.setValue(vo.area.address);
		
		//address
		address.setText(vo.address);
		
		//checkInInfos
		
		//cooperators		
		ObservableList<String> cooperators = FXCollections.observableArrayList(vo.cooperators);
		cooperatorBox.setItems(cooperators);
		
		//facility, name, intro
		facility.setText(vo.facility);
		facility.setStyle("-fx-text-fill: black;");
		name.setText(vo.hotelName);
		intro.setText(vo.introduce);
		intro.setStyle("-fx-text-fill: black;");
		
		//roomNum roomPrice roomType
		ObservableList<String> roomTypes = FXCollections.observableArrayList(vo.roomType);
		roomType.setItems(roomTypes);
		
		//star
		ObservableList<Integer> stars = FXCollections.observableArrayList(1,2,3,4,5);
		star.setItems(stars);
		star.setValue(vo.star);
	}
}


