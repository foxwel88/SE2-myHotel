package org.client.presentation.customer;

import java.util.ArrayList;

import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.HotelFilter;
import org.common.utility.RoomType;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		showHotelList();
		setCity();
		setArea();
		setLowerStar();
		setUpperStar();
		setLowerScore();
		setUpperScore();
		setStartDate();
		setEndDate();
		setRoomType();
		LiveDatePicker.initDatePicker(null, fromDate);
		LiveDatePicker.initDatePicker(fromDate, toDate);
		
		SwitchSceneUtil.isBackToDetail = false;
		if (SwitchSceneUtil.isBack) {
			HotelFilter previousFilter = SwitchSceneUtil.previousHotelSceneInfo.hotelFilter;
			currentPage.setText(String.valueOf(SwitchSceneUtil.previousHotelSceneInfo.currentPage));
			showHotelList();
			if (previousFilter.city != null) {
				city.setValue(previousFilter.city);
			}
			if (previousFilter.area != null) {
				area.setValue(previousFilter.area);
			}
			if (previousFilter.minStar != -1) {
				lowerStar.setValue(previousFilter.minStar);
			}
			if (previousFilter.maxStar != -1) {
				upperStar.setValue(previousFilter.maxStar);
			}
			if (previousFilter.minRank != -1) {
				lowerScore.setValue(previousFilter.minRank);
			}
			if (previousFilter.maxRank != -1) {
				upperScore.setValue(previousFilter.maxRank);
			}
			if (previousFilter.minPrice != -1) {
				fromPrice.setText(String.valueOf(previousFilter.minPrice));
			}
			if (previousFilter.maxPrice != -1) {
				toPrice.setText(String.valueOf(previousFilter.maxPrice));
			}
			if (previousFilter.roomType != null) {
				roomType.setValue(previousFilter.roomType.getString());
			}
			if (previousFilter.roomNum != -1) {
				roomNum.setText(String.valueOf(previousFilter.roomNum));
			}
//			fromDate.setValue(previousFilter.);
		}
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
		String hotelAddress;
		int page = Integer.parseInt(currentPage.getText());
		try {
			for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
				Label clickedLabel = (Label)(event.getSource());
				if (clickedLabel.equals(getNameLabel(i))) {
					hotelAddress = hotelList.get((page - 1) * MAX_HOTEL_ONE_OAGE + i).address;
					SwitchSceneUtil.currentScene = CustomerBackableScene.HOTEL_INFO_SCENE;
					SwitchSceneUtil.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
					SwitchSceneUtil.turnToDetailedHotelScene((GridPane)root.getParent(), hotelAddress);
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
		String hotelAddress;
		int page = Integer.parseInt(currentPage.getText());
		for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
			Label clickedLabel = (Label)(event.getSource());
			if (clickedLabel.equals(getMakeOrderLabel(i))) {
				if (clickedLabel.getText() != null) {
					hotelAddress = hotelList.get((page - 1) * MAX_HOTEL_ONE_OAGE + i).address;
					SwitchSceneUtil.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
					SwitchSceneUtil.isBackToDetail = false;
					SwitchSceneUtil.currentScene = CustomerBackableScene.GENERATE_ORDER_SCENE;
					SwitchSceneUtil.turnToGenerateOrderScene((GridPane)root.getParent(), hotelAddress);
					break;
				}
			}
		}
	}
	
	@FXML
	void search() {
		// TODO
	}
	
	private void showHotelList() {
		HotelFilter filter = getCurrentFilter();
		boolean searchHistoryOnly = everOrdered.isSelected();
		hotelList = new ArrayList<>(SwitchSceneUtil.getFilteredHotels(filter, searchHistoryOnly));
		
		for (int i = 0; i < MAX_HOTEL_ONE_OAGE; i++) {
			if (getName(i) != null) {
				getNameLabel(i).setText(getName(i));
				getStarLabel(i).setText(String.valueOf(getStar(i)));
				getScoreLabel(i).setText(String.valueOf(getScore(i)));
				getAddressLabel(i).setText(getAddress(i));
				getPriceLabel(i).setText(String.valueOf(getPrice(i)));
				getRoomNumLabel(i).setText(String.valueOf(getRoomNum(i)));
				getMakeOrderLabel(i).setText("预订此酒店");
			} else {
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
		ArrayList<AreaVO> areaVOList = SwitchSceneUtil.getAreas();
		for (AreaVO vo : areaVOList) {
			areaNameList.add(vo.address);
		}
		area.setItems(FXCollections.observableArrayList(areaNameList));
	}
	
	private void setLowerStar() {
		lowerStar.setItems(FXCollections.observableArrayList(1,2,3,4,5));
	}
	
	private void setUpperStar() {
		upperStar.setItems(FXCollections.observableArrayList(1,2,3,4,5));
	}
	
	private void setLowerScore() {
		ArrayList<Double> scores = new ArrayList<>();
		for (double i = 0; i <= 5; i += 0.5) {
			scores.add(i);
		}
		lowerScore.setItems(FXCollections.observableArrayList(scores));
	}
	
	private void setUpperScore() {
		ArrayList<Double> scores = new ArrayList<>();
		for (double i = 0; i <= 5; i += 0.5) {
			scores.add(i);
		}
		upperScore.setItems(FXCollections.observableArrayList(scores));
	}
	
	private void setStartDate() {
		// TODO
	}
	
	private void setEndDate() {
		// TODO
	}
	
	private void setRoomType() {
		RoomType[] roomTypeArray = RoomType.values();
		ArrayList<String> roomTypeList = new ArrayList<>();
		for (int i = 0; i < roomTypeArray.length; i++) {
			roomTypeList.add(roomTypeArray[i].getString());
		}
		roomType.setItems(FXCollections.observableArrayList(roomTypeList));
	}
	
	/**
	 * city和area可能为null，需要filter查找的时候自行判断
	 * 星级的上下界值均可能为-1，表示无上下界
	 * 评分的上下界值均可能为-1，表示无上下界
	 * 价格的上下界值均可能为-1，表示无上下界
	 */
	private HotelFilter getCurrentFilter() {
		HotelFilter filter = new HotelFilter();
		
		filter.setLocation(city.getValue(), area.getValue());
		
		// 设置星级
		if (lowerStar.getValue() != null) {
			filter.setLowerStar(lowerStar.getValue());
		}
		if (upperStar.getValue() != null) {
			filter.setUpperStar(upperStar.getValue());
		}
		
		// 设置评分
		if (lowerScore.getValue() != null) {
			filter.setLowerRank(lowerScore.getValue());
		}
		if (upperScore.getValue() != null) {
			filter.setUpperRank(upperScore.getValue());
		}
		
		// 设置价格
		try {
			filter.setLowerPrice(Double.parseDouble(fromPrice.getText()));
		} catch (NumberFormatException numberFormatException) { }
		try {
			filter.setUpperPrice(Double.parseDouble(toPrice.getText()));
		} catch (NumberFormatException numberFormatException) { }
		
		if (roomType.getValue() != null) {
			filter.setRoomType(RoomType.getType(String.valueOf(roomType.getValue())));
		}
		
		try {
			filter.setRoomNum(Integer.parseInt(roomNum.getText()));
		} catch (NumberFormatException numberFormatException) { }
		
		// TODO 酒店地址有问题，应该是根据酒店名称包含的关键字搜索
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
	 * 下面7个方法分别用于获得单个酒店的不同信息字段的Label的引用
	 * @param i 取值为0到MAX_HOTEL_ONE_OAGE - 1 表示页面上的第i个酒店
	 */
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
	 * 下面六种方法分别用来获得某个酒店的酒店名称、星级、评分、酒店地址、最低价格、剩余房间数量
	 * @param i 范围是 0 到 MAX_HOTEL_ONE_OAGE - 1
	 */
	private String getName(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return hotelList.get(seq).hotelName;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private int getStar(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).star;
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	
	private double getScore(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).rank;
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	
	private String getAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + i;
		try {
			return hotelList.get(seq).address;
		} catch (IndexOutOfBoundsException nullex) {
			return null;
		}
	}
	
	private double getPrice(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_OAGE + 1;
		try {
			ArrayList<Double> priceList = new ArrayList<>(hotelList.get(seq).roomPrice);
			double minPrice = priceList.get(0);
			for (int j = 1; j < priceList.size(); j++) {
				if (priceList.get(j) < minPrice) {
					minPrice = priceList.get(j);
				}
			}
			return minPrice;
		} catch (IndexOutOfBoundsException nullex) {
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
		} catch (IndexOutOfBoundsException nullex) {
			return -1;
		}
	}
	/**************************************************************************************/
}
