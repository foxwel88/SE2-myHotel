package org.client.presentation.customer;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.HotelFilter;
import org.common.utility.RoomType;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * 客户-浏览酒店
 * @author fraliphsoft
 * @version fraliphsoft 11/30
 */

public class CustomerCheckHotelList {
	@FXML
	AnchorPane root;
	
	@FXML
	ChoiceBox<String> city;
	
	@FXML
	ChoiceBox<String> area;
	
	@FXML
	ChoiceBox<Integer> lowerStar;
	
	@FXML
	ChoiceBox<Integer> upperStar;
	
	@FXML
	ChoiceBox<Double> lowerScore;
	
	@FXML
	ChoiceBox<Double> upperScore;
	
	@FXML
	DatePicker fromDate;
	
	@FXML
	DatePicker toDate;
	
	@FXML
	ChoiceBox<String> roomType;
	
	@FXML
	TextField hotelName;
	
	@FXML
	TextField fromPrice;
	
	@FXML
	TextField toPrice;
	
	@FXML
	TextField roomNum;
	
	@FXML
	CheckBox everOrdered;
	
	@FXML
	Button searchButton;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	@FXML
	TextField toPage;
	
	/*
	 * 接下来的7个成员变量是酒店信息的容器
	 */
	@FXML
	VBox pictureBox;			// 酒店缩略示意图列表
	
	@FXML
	VBox hotelNameBox;			// 酒店姓名列表
	
	@FXML
	VBox starAndScoreBox;		// 酒店星级和评分列表，注意：这个VBox的子组件比其他多
	
	@FXML
	VBox hotelAddressBox;		// 酒店地址列表
	
	@FXML
	VBox priceBox;				// 酒店最低价
	
	@FXML
	VBox leftRoomNumBox;		// 酒店剩余房间
	
	@FXML
	VBox makeOrderBox;			// 预定该酒店
	/******************************************************************/
	
	private ArrayList<HotelVO> hotelList;
	
	// 该字段表示同时显示的最大酒店数量
	private static final int MAX_HOTEL_ONE_OAGE = 5;
	
	@FXML
	void initialize() {
		SwitchSceneUtil.canBack = false;
		setCity();
		setArea();
		setLowerStar();
		setUpperStar();
		setLowerScore();
		setUpperScore();
		setStartDate();
		setEndDate();
		setRoomType();
		
		SwitchSceneUtil.isBackToDetail = false;
		if (SwitchSceneUtil.isBack) {
			HotelFilter previousFilter = SwitchSceneUtil.previousHotelSceneInfo.hotelFilter;
			currentPage.setText(String.valueOf(SwitchSceneUtil.previousHotelSceneInfo.currentPage));
			if (previousFilter.city != null) {
				city.setValue(previousFilter.city);
			}
			refreshAreas();
			if (previousFilter.area != null) {
				area.setValue(previousFilter.area);
			}
			if (previousFilter.minStar != 0) {
				lowerStar.setValue(previousFilter.minStar);
			}
			if (previousFilter.maxStar != 5) {
				upperStar.setValue(previousFilter.maxStar);
			}
			if (previousFilter.minRank != 0) {
				lowerScore.setValue(previousFilter.minRank);
			}
			if (previousFilter.maxRank != 5) {
				upperScore.setValue(previousFilter.maxRank);
			}
			if (previousFilter.minPrice != 0) {
				fromPrice.setText(String.valueOf(previousFilter.minPrice));
			}
			if (previousFilter.maxPrice != Double.MAX_VALUE) {
				toPrice.setText(String.valueOf(previousFilter.maxPrice));
			}
			if (previousFilter.roomType != null) {
				roomType.setValue(previousFilter.roomType.getString());
			}
			if (previousFilter.roomNum != 1) {
				roomNum.setText(String.valueOf(previousFilter.roomNum));
			}
//			fromDate.setValue(previousFilter.);
		}
		showHotelList();
	}
	
	@FXML
	void refreshAreas() {
		setArea();
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(currentPage.getText()) < calMaxPage(hotelList)) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
			showHotelList();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(currentPage.getText()) > 1) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
			showHotelList();
		}
	}
	
	@FXML
	void turnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage();
			currentPage.setText(String.valueOf(goalPage));
			showHotelList();
		}
	}
	
	/*
	 * 此方法用于跳转到某个详细酒店信息界面
	 */
	@FXML
	void checkDetailedHotel(MouseEvent event) {
		String hotelID;
		int page = Integer.parseInt(currentPage.getText());
		try {
			for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
				Label clickedLabel = (Label)(event.getSource());
				if (clickedLabel.equals(getNameLabel(i))) {
					hotelID = hotelList.get((page - 1) * MAX_HOTEL_ONE_OAGE + i).id;
					SwitchSceneUtil.currentScene = CustomerBackableScene.HOTEL_INFO_SCENE;
					SwitchSceneUtil.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
					SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), hotelID);
					break;
				}
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// 点击无酒店的酒店列表区域会出现此异常，可以忽略
		}
	}
	
	/*
	 * 此方法用于跳转到某个酒店的生成订单界面
	 */
	@FXML
	void turnToGenerateOrderScene(MouseEvent event) {
		String hotelID;
		int page = Integer.parseInt(currentPage.getText());
		for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
			Label clickedLabel = (Label)(event.getSource());
			if (clickedLabel.equals(getMakeOrderLabel(i))) {
				if (clickedLabel.getText() != null) {
					hotelID = hotelList.get((page - 1) * MAX_HOTEL_ONE_OAGE + i).id;
					SwitchSceneUtil.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
					SwitchSceneUtil.isBackToDetail = false;
					SwitchSceneUtil.currentScene = CustomerBackableScene.GENERATE_ORDER_SCENE;
					SwitchSceneUtil.turnToGenerateOrderScene((GridPane)root.getParent(), hotelID);
					break;
				}
			}
		}
	}
	
	@FXML
	void search_causedByMouse() {
		search();
	}
	
	@FXML
	void search_causedByKeyboard(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.ENTER) {
			search();
		}
	}
	
	private void search() {
		if (city.getValue() == null || area.getValue() == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sorry, please check your entry again.");
			alert.setHeaderText(null);
			alert.setContentText("You must choose both city and area before starting search!");
			alert.showAndWait();
		} else {
			showHotelList();
		}
	}
	
	private void showHotelList() {
		HotelFilter filter = getCurrentFilter();
		boolean searchHistoryOnly = everOrdered.isSelected();
		hotelList = new ArrayList<>(SwitchSceneUtil.getFilteredHotels(filter, searchHistoryOnly));
		
		for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
			if (getName(i) != null) {
				getImageLabel(i).setGraphic(new ImageView(getImage(i)));
				getNameLabel(i).setText(getName(i));
				getStarLabel(i).setText(String.valueOf(getStar(i)));
				getScoreLabel(i).setText(String.valueOf(getScore(i)));
				getAddressLabel(i).setText(getAddress(i));
				getPriceLabel(i).setText(String.valueOf(getPrice(i)));
				getRoomNumLabel(i).setText(String.valueOf(getRoomNum(i)));
				getMakeOrderLabel(i).setText("预订此酒店");
			} else {
				getImageLabel(i).setText("");
				getNameLabel(i).setText("");
				getStarLabel(i).setText("");
				getScoreLabel(i).setText("");
				getAddressLabel(i).setText("");
				getPriceLabel(i).setText("");
				getRoomNumLabel(i).setText("");
				getMakeOrderLabel(i).setText("");
			}
		}
	}
	
	private void setCity() {
		ArrayList<String> cityNameList = new ArrayList<>();
		ArrayList<CityVO> cityVOList = SwitchSceneUtil.getCities();
		for (CityVO vo : cityVOList) {
			cityNameList.add(vo.cityName);
		}
		city.setItems(FXCollections.observableArrayList(cityNameList));
	}
	
	private void setArea() {
		ArrayList<String> areaNameList = new ArrayList<>();
		try {
			ArrayList<AreaVO> areaVOList = SwitchSceneUtil.getAreas(city.getValue());
			for (AreaVO vo : areaVOList) {
				areaNameList.add(vo.address);
			}
			area.setItems(FXCollections.observableArrayList(areaNameList));
		} catch (NullPointerException nullPointerException) {
			area.setItems(null);
		}
	}
	
	private void setLowerStar() {
		lowerStar.setItems(FXCollections.observableArrayList(1,2,3,4,5));
		lowerStar.setValue(1);
	}
	
	private void setUpperStar() {
		upperStar.setItems(FXCollections.observableArrayList(1,2,3,4,5));
		upperStar.setValue(5);
	}
	
	private void setLowerScore() {
		ArrayList<Double> scores = new ArrayList<>();
		for (double i = 0; i <= 5; i += 0.5) {
			scores.add(i);
		}
		lowerScore.setItems(FXCollections.observableArrayList(scores));
		lowerScore.setValue(0.0);
	}
	
	private void setUpperScore() {
		ArrayList<Double> scores = new ArrayList<>();
		for (double i = 0; i <= 5; i += 0.5) {
			scores.add(i);
		}
		upperScore.setItems(FXCollections.observableArrayList(scores));
		upperScore.setValue(5.0);
	}
	
	private void setStartDate() {
		LiveDatePicker.initDatePicker(null, fromDate);
	}
	
	private void setEndDate() {
		LiveDatePicker.initDatePicker(fromDate, toDate);
	}
	
	private void setRoomType() {
		RoomType[] roomTypeArray = RoomType.values();
		ArrayList<String> roomTypeList = new ArrayList<>();
		for (int i = 0; i < roomTypeArray.length; i++) {
			roomTypeList.add(roomTypeArray[i].getString());
		}
		roomType.setItems(FXCollections.observableArrayList(roomTypeList));
	}
	
	private HotelFilter getCurrentFilter() {
		HotelFilter filter = new HotelFilter();
		
		filter.setLocation(city.getValue(), area.getValue());
		
		if (lowerStar.getValue() != null) {
			filter.setLowerStar(lowerStar.getValue());
		}
		if (upperStar.getValue() != null) {
			filter.setUpperStar(upperStar.getValue());
		}
		
		if (lowerScore.getValue() != null) {
			filter.setLowerRank(lowerScore.getValue());
		}
		if (upperScore.getValue() != null) {
			filter.setUpperRank(upperScore.getValue());
		}
		
		try {
			filter.setLowerPrice(Double.parseDouble(fromPrice.getText()));
		} catch (NumberFormatException numberFormatException) { }
		try {
			filter.setUpperPrice(Double.parseDouble(toPrice.getText()));
		} catch (NumberFormatException numberFormatException) { }
		
		if (roomType.getValue() != null) {
			filter.setRoomType(RoomType.getType(roomType.getValue()));
		}
		
		try {
			filter.setRoomNum(Integer.parseInt(roomNum.getText()));
		} catch (NumberFormatException numberFormatException) { }

		filter.hotelName = hotelName.getText();

//		try {
//			filter.set
//			System.out.println(fromDate.getValue());
//		} catch (NullPointerException nullPointerException) {
//			nullPointerException.printStackTrace();
//		}
		// TODO 没有办法根据入住日期区间搜索
		// TODO try-catch没有写（格式检查）
		return filter;
	}
	
	/*
	 * 此方法用于检查用户输入的目标跳转页面是否合法 （在第1页和最后一页之间）
	 * 此方法在用户敲击回车确认输入时被调用
	 * 此方法被调用之后会把文本框中的内容变为合法值
	 */
	int checkGoalPage() {
		int goalPage;
		try {
			goalPage = Integer.parseInt(toPage.getText());
		} catch (NumberFormatException numFormex) {
			goalPage = (int)Double.parseDouble(toPage.getText());
		}
		if (goalPage < 1) {
			goalPage = 1;
		}
		if (goalPage > calMaxPage(hotelList)) {
			goalPage = calMaxPage(hotelList);
		}
		toPage.setText(String.valueOf(goalPage));
		return goalPage;
	}
	
	/*
	 * 此方法用于计算订单列表能够展开的最大页数
	 */
	private int calMaxPage(ArrayList<HotelVO> voList) {
		return (voList.size() / MAX_HOTEL_ONE_OAGE) + 1;
	}
	
	/**
	 * 下面8个方法分别用于获得单个酒店的不同信息字段的Label的引用
	 * @param i 取值为0到MAX_HOTEL_ONE_OAGE - 1 表示页面上的第i个酒店
	 */
	private Label getImageLabel(int i) {
		return (Label)(pictureBox.getChildren().get(i + 1));
	}
	
	private Label getNameLabel(int i) {
		return (Label)((Pane)(hotelNameBox.getChildren().get(i + 1))).getChildren().get(0);
	}
	
	private Label getStarLabel(int i) {
		return (Label)(starAndScoreBox.getChildren().get(2 * i + 1));
	}
	
	private Label getScoreLabel(int i) {
		return (Label)(starAndScoreBox.getChildren().get(2 * i + 2));
	}
	
	private Label getAddressLabel(int i) {
		return (Label)(hotelAddressBox.getChildren().get(i + 1));
	}
	
	private Label getPriceLabel(int i) {
		return (Label)(priceBox.getChildren().get(i + 1));
	}
	
	private Label getRoomNumLabel(int i) {
		return (Label)(leftRoomNumBox.getChildren().get(i + 1));
	}
	
	private Label getMakeOrderLabel(int i) {
		return (Label)((Pane)(makeOrderBox.getChildren().get(i + 1))).getChildren().get(0);
	}
	/********************************************************/
	
	/**
	 * 下面6种方法分别用来获得某个酒店的酒店图片、名称、星级、评分、酒店地址、最低价格、剩余房间数量
	 * @param i 范围是 0 到 MAX_HOTEL_ONE_OAGE - 1
	 */
	private Image getImage(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return CustomerImageGrabber.gethotelImage(hotelList.get(seq).id);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		} catch (NullPointerException nullPointerException) {
			return null;
		}
	}
	
	private String getName(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).hotelName;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	private int getStar(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).star;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return -1;
		}
	}
	
	private double getScore(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			DecimalFormat formator = new DecimalFormat("0.00");
			return Double.parseDouble(formator.format(hotelList.get(seq).rank));
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return -1;
		}
	}
	
	private String getAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).address;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	private double getPrice(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			ArrayList<Double> priceList = new ArrayList<>(hotelList.get(seq).roomPrice);
			double minPrice = priceList.get(0);
			for (int j = 1; j < priceList.size(); j++) {
				if (priceList.get(j) < minPrice) {
					minPrice = priceList.get(j);
				}
			}
			return minPrice;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return -1;
		}
	}
	
	private int getRoomNum(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			ArrayList<Integer> roomNumList = new ArrayList<>(hotelList.get(seq).roomNum);
			int totalRoomNum = 0;
			for (int j = 0; j < roomNumList.size(); j++) {
				totalRoomNum += roomNumList.get(j);
			}
			return totalRoomNum;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return -1;
		}
	}
	/**************************************************************************************/
}
