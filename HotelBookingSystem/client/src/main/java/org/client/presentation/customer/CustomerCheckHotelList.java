package org.client.presentation.customer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.client.launcher.Resources;
import org.client.presentation.util.DateUtil;
import org.client.presentation.util.HotelComparatorFactory;
import org.client.vo.AreaVO;
import org.client.vo.CityVO;
import org.client.vo.HotelVO;
import org.common.utility.HotelFilter;
import org.common.utility.RoomType;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
	AnchorPane curtain;
	
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
	Button starSort;
	
	@FXML
	Button rankSort;

	@FXML
	Button priceSort;
	
	@FXML
	Label previousPage;
	
	@FXML
	Label currentPage;
	
	@FXML
	Label nextPage;
	
	@FXML
	TextField toPage;
	
	/*
	 * 接下来的5个成员变量是酒店信息的容器
	 */
	@FXML
	HBox hotel1;
	
	@FXML
	HBox hotel2;
	
	@FXML
	HBox hotel3;
	
	@FXML
	HBox hotel4;
	
	@FXML
	HBox hotel5;
	/******************************************************************/
	
	@FXML
	Pane hitoryMark1;
	
	@FXML
	Pane hitoryMark2;
	
	@FXML
	Pane hitoryMark3;
	
	@FXML
	Pane hitoryMark4;
	
	@FXML
	Pane hitoryMark5;
	
	private ArrayList<HotelVO> hotelList;
	
	private ArrayList<HBox> hotelBoxList;
	
	private ArrayList<Pane> historyMarkList;
	
	// 该字段表示同时显示的最大酒店数量
	private static final int MAX_HOTEL_ONE_PAGE = 5;

	private static final double IMAGE_WIDTH = 100;
	
	private static final double IMAGE_HEIGHT = 60;
	
	//记录当前的酒店排序方式，0表示无排序，1表示按星级排序，2表示按评分排序，3表示按价格排序
	private int currentSort = 0;
	
	// 点击预订酒店按钮的时候，同样会触发显示酒店详细信息的监听从而报线程异常（无法catch，不影响正常运行），
	// 因此特设此值，每当调用跳转到生成订单界面的方法时调用，将此值设为1，阻止调用查看酒店详细信息界面的方法
	private int isTargetInOrder = 0;
	
	@FXML
	void initialize() {
		hotelBoxList = new ArrayList<>();
		hotelBoxList.add(hotel1);
		hotelBoxList.add(hotel2);
		hotelBoxList.add(hotel3);
		hotelBoxList.add(hotel4);
		hotelBoxList.add(hotel5);
		
		historyMarkList = new ArrayList<>();
		historyMarkList.add(hitoryMark1);
		historyMarkList.add(hitoryMark2);
		historyMarkList.add(hitoryMark3);
		historyMarkList.add(hitoryMark4);
		historyMarkList.add(hitoryMark5);
		
		CustomerController.canBack = false;
		setCity();
		setArea();
		setLowerStar();
		setUpperStar();
		setLowerScore();
		setUpperScore();
		setStartDate();
		setEndDate();
		setRoomType();
		
		CustomerController.isBackToDetail = false;
		if (CustomerController.isBack) {
			HotelFilter previousFilter = CustomerController.previousHotelSceneInfo.hotelFilter;
			currentPage.setText(String.valueOf(CustomerController.previousHotelSceneInfo.currentPage));
			everOrdered.setSelected(CustomerController.previousHotelSceneInfo.everOrdered);
			if (previousFilter.city != null) {
				city.setValue(previousFilter.city);
			}
			refreshAreas();
			if (previousFilter.area != null) {
				area.setValue(previousFilter.area);
			}
			if (previousFilter.hotelName != null) {
				if (!previousFilter.hotelName.isEmpty()) {
					hotelName.setText(previousFilter.hotelName);
				}
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
			fromDate.setValue(DateUtil.toLocalDate(previousFilter.schFrom));
			toDate.setValue(DateUtil.toLocalDate(previousFilter.schTo));
			CustomerController.isBack = false;
		}
		showHotelList();
		CustomerController.showGuideAnimation(root, 0);
	}
	
	@FXML
	void refreshAreas() {
		setArea();
	}
	
	/**
	 * 保证todate一定实时保持在fromdate之后
	 */
	@FXML
	void refreshDatePicker() {
		if (!toDate.getValue().isAfter(fromDate.getValue())) {
			toDate.setValue(fromDate.getValue().plusDays(1));
		}
	}
	
	@FXML
	void turnToNextPage() {
		if (Integer.parseInt(currentPage.getText()) < calMaxPage(hotelList)) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) + 1));
			refreshHotelList();
		}
	}
	
	@FXML
	void turnToPreviousPage() {
		if (Integer.parseInt(currentPage.getText()) > 1) {
			currentPage.setText(String.valueOf(Integer.parseInt(currentPage.getText()) - 1));
			refreshHotelList();
		}
	}
	
	@FXML
	void turnToSpecialPage(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int goalPage = checkGoalPage();
			currentPage.setText(String.valueOf(goalPage));
			refreshHotelList();
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
			for (int i = 0; i < MAX_HOTEL_ONE_PAGE; i++) {
				HBox hbox = (HBox)(event.getSource());
				if (hbox.equals(hotelBoxList.get(i)) && isTargetInOrder != 1) {
					hotelID = hotelList.get((page - 1) * MAX_HOTEL_ONE_PAGE + i).id;
					KeyFrame animationFrame = new KeyFrame(Duration.seconds(0), actionEvent -> {
						CustomerController.showOldSceneAnimation(root);
					});
					KeyFrame changeSceneFrame = new KeyFrame(Duration.seconds(0.4), actionEvent -> {
						CustomerController.currentScene = CustomerBackableScene.HOTEL_INFO_SCENE;
						CustomerController.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
						CustomerController.turnToDetailedHotelScene((GridPane)root.getParent(), hotelID);
					});
					Timeline timeline = new Timeline(animationFrame, changeSceneFrame);
					timeline.play();
					break;
				}
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			// 点击无酒店的酒店列表区域会出现此异常，可以忽略
		} catch (NullPointerException nullPointerException) {
			// 点击预订酒店同样会检测到并调用此方法从而抛出此异常
		}
	}
	
	/*
	 * 此方法用于跳转到某个酒店的生成订单界面
	 */
	@FXML
	void turnToGenerateOrderScene(MouseEvent event) {
		String hotelID;
		int page = Integer.parseInt(currentPage.getText());
		for (int i = 0; i < MAX_HOTEL_ONE_PAGE; i++) {
			Label clickedLabel = (Label)(event.getSource());
			if (clickedLabel.equals(getMakeOrderLabel(i))) {
				if (clickedLabel.getText() != null) {
					isTargetInOrder = 1;
					hotelID = hotelList.get((page - 1) * MAX_HOTEL_ONE_PAGE + i).id;
					CustomerController.previousHotelSceneInfo = new PreviousHotelSceneInfo(getCurrentFilter(), everOrdered.isSelected(), Integer.parseInt(currentPage.getText()));
					CustomerController.isBackToDetail = false;
					CustomerController.currentScene = CustomerBackableScene.GENERATE_ORDER_SCENE;
					CustomerController.turnToGenerateOrderScene((GridPane)root.getParent(), hotelID);
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
	void showByStar() {
		if (hotelList != null && hotelList.size() > 0) {
			currentSort = 1;
			deactiveRankSortButton();
			deactivePriceSortButton();
			sortByStar(hotelList);
			refreshHotelList();
		}
	}
	
	@FXML
	void showByRank() {
		if (hotelList != null && hotelList.size() > 0) {
			currentSort = 2;
			deactiveStarSortButton();
			deactivePriceSortButton();
			sortByRank(hotelList);
			refreshHotelList();
		}
	}
	
	@FXML
	void showByPrice() {
		if (hotelList != null && hotelList.size() > 0) {
			currentSort = 3;
			deactiveStarSortButton();
			deactiveRankSortButton();
			sortByPrice(hotelList);
			refreshHotelList();
		}
	}
	
	@FXML
	void active(MouseEvent mouseEvent) {
		HBox hbox = (HBox)mouseEvent.getSource();
		if (!((Label)hbox.getChildren().get(2)).getText().isEmpty()) {
			hbox.setStyle("-fx-background-color: rgba(255,255,255,0.14)");
			DropShadow shadow = new DropShadow();
			shadow.setColor(Color.color(0.4, 0.4, 0.4));
			hbox.setEffect(shadow);
		}
	}
	
	@FXML
	void deactive(MouseEvent mouseEvent) {
		HBox hbox = (HBox)mouseEvent.getSource();
		if (!((Label)hbox.getChildren().get(2)).getText().isEmpty()) {
			hbox.setStyle(null);
			hbox.setEffect(null);
		}
	}
	
	@FXML
	void activeMakeOrderButton(MouseEvent mouseEvent) {
		Label label = (Label)mouseEvent.getSource();
		if (label.isVisible()) {
			label.setStyle("-fx-border-color:#4599ff;-fx-background-color:#4599ff;-fx-text-fill: rgb(255,255,255)");
		}
	}
	
	@FXML
	void deactiveMakeOrderButton(MouseEvent mouseEvent) {
		Label label = (Label)mouseEvent.getSource();
		if (label.isVisible()) {
			label.setStyle("-fx-border-color:#21e9ff;-fx-text-fill:#21e9ff");
		}
	}
	
	@FXML
	void activeStarSortButton() {
		starSort.setStyle("-fx-background-color:rgba(0,0,0,0.4);-fx-text-fill:white");
	}
	
	@FXML
	void activeRankSortButton() {
		rankSort.setStyle("-fx-background-color:rgba(0,0,0,0.4);-fx-text-fill:white");
	}
	
	@FXML
	void activePriceSortButton() {
		priceSort.setStyle("-fx-background-color:rgba(0,0,0,0.4);-fx-text-fill:white");
	}
	
	@FXML
	void deactiveStarSortButton() {
		if (currentSort != 1) {
			starSort.setStyle("-fx-background-color:rgba(255,255,255,0.4);-fx-text-fill:black");
		}
	}
	
	@FXML
	void deactiveRankSortButton() {
		if (currentSort != 2) {
			rankSort.setStyle("-fx-background-color:rgba(255,255,255,0.4);-fx-text-fill:black");
		}
	}
	
	@FXML
	void deactivePriceSortButton() {
		if (currentSort != 3) {
			priceSort.setStyle("-fx-background-color:rgba(255,255,255,0.4);-fx-text-fill:black");
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
			currentPage.setText("1");
			showHotelList();
		}
	}
	
	private void showHotelList() {
		HotelFilter filter = getCurrentFilter();
		boolean searchHistoryOnly = everOrdered.isSelected();
		hotelList = new ArrayList<>(CustomerController.getFilteredHotels(filter, searchHistoryOnly));
		
		refreshHotelList();
	}
	
	private void refreshHotelList() {
		for (int i = 0; i < MAX_HOTEL_ONE_PAGE; i++) {
			if (getName(i) != null) {
				getImageLabel(i).setGraphic(getImageView(i));
				getNameLabel(i).setText(getName(i));
				getStarLabel(i).setGraphic(getStar(i));
				getScoreHeadLabel(i).setText("评分：");
				getScoreLabel(i).setText(String.valueOf(getScore(i)));
				getAddressLabel(i).setText(getAddress(i));
				getPriceLabel(i).setText("¥" + String.valueOf(getPrice(i)));
				getPriceTailLabel(i).setText("起");
				getMakeOrderLabel(i).setVisible(true);
				getHistoryMarkPane(i).setVisible(getHistoryMark(i));
			} else {
				getImageLabel(i).setGraphic(null);
				getNameLabel(i).setText("");
				getStarLabel(i).setGraphic(null);
				getScoreHeadLabel(i).setText("");
				getScoreLabel(i).setText("");
				getAddressLabel(i).setText("");
				getPriceLabel(i).setText("");
				getPriceTailLabel(i).setText("");
				getMakeOrderLabel(i).setVisible(false);
			}
		}
	}
	
	private ArrayList<HotelVO> sortByPrice(ArrayList<HotelVO> rawHotelList) {
		Collections.sort(rawHotelList, HotelComparatorFactory.getPriceComparator());
		return rawHotelList;
	}
	
	private ArrayList<HotelVO> sortByStar(ArrayList<HotelVO> rawHotelList) {
		Collections.sort(rawHotelList, HotelComparatorFactory.getStarComparator());
		return rawHotelList;
	}

	private ArrayList<HotelVO> sortByRank(ArrayList<HotelVO> rawHotelList) {
		Collections.sort(rawHotelList, HotelComparatorFactory.getRankComparator());
		return rawHotelList;
	}
	
	private void setCity() {
		ArrayList<String> cityNameList = new ArrayList<>();
		ArrayList<CityVO> cityVOList = CustomerController.getCities();
		for (CityVO vo : cityVOList) {
			cityNameList.add(vo.cityName);
		}
		city.setItems(FXCollections.observableArrayList(cityNameList));
	}
	
	private void setArea() {
		ArrayList<String> areaNameList = new ArrayList<>();
		try {
			ArrayList<AreaVO> areaVOList = CustomerController.getAreas(city.getValue());
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
		DatePicker banBeforeTodayPicker = new DatePicker();
		banBeforeTodayPicker.setValue(LocalDate.now().minusDays(1));
		DateUtil.initDatePicker(banBeforeTodayPicker, fromDate);
	}
	
	private void setEndDate() {
		DateUtil.initDatePicker(fromDate, toDate);
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

		filter.setSchFromDate(DateUtil.toDate(fromDate.getValue()));
		filter.setSchToDate(DateUtil.toDate(toDate.getValue()));
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
		return (voList.size() / MAX_HOTEL_ONE_PAGE) + 1;
	}
	
	/**
	 * 下面几个方法分别用于获得单个酒店的不同信息字段的Label的引用
	 * @param i 取值为0到MAX_HOTEL_ONE_PAGE - 1 表示页面上的第i个酒店
	 */
	private Label getImageLabel(int i) {
		return (Label)hotelBoxList.get(i).getChildren().get(0);
	}
	
	// get pane including labels of name/star/address/rank
	private Pane getMostHotelInfoPane(int i) {
		return (Pane)hotelBoxList.get(i).getChildren().get(1);
	}
	
	private Label getNameLabel(int i) {
		return (Label)((HBox)getMostHotelInfoPane(i).getChildren().get(0)).getChildren().get(0);
	}
	
	private Label getStarLabel(int i) {
		return (Label)((HBox)getMostHotelInfoPane(i).getChildren().get(0)).getChildren().get(1);
	}
	
	private Label getAddressLabel(int i) {
		return (Label)(getMostHotelInfoPane(i).getChildren().get(1));
	}
	
	//用来获得“好评：”标签
	private Label getScoreHeadLabel(int i) {
		return (Label)(getMostHotelInfoPane(i).getChildren().get(2));
	}
	
	private Label getScoreLabel(int i) {
		return (Label)(getMostHotelInfoPane(i).getChildren().get(3));
	}
	
	private Label getMakeOrderLabel(int i) {
		return (Label)(getMostHotelInfoPane(i).getChildren().get(4));
	}
	
	private Label getPriceLabel(int i) {
		return (Label)hotelBoxList.get(i).getChildren().get(2);
	}
	
	// 用于获得那个“起”字
	private Label getPriceTailLabel(int i) {
		return (Label)hotelBoxList.get(i).getChildren().get(3);
	}
	
	private Pane getHistoryMarkPane(int i) {
		return historyMarkList.get(i);
	}
	/********************************************************/
	
	/**
	 * 下面5种方法分别用来获得某个酒店的酒店图片、名称、星级、评分、酒店地址、最低价格
	 * @param i 范围是 0 到 MAX_HOTEL_ONE_PAGE - 1
	 */
	private ImageView getImageView(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;	// 计算当前页面第i个信息字段在arraylist中的实际位置；
		try {
			return CustomerImageGrabber.getHotelImageView((hotelList.get(seq).id), IMAGE_WIDTH, IMAGE_HEIGHT);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		} catch (NullPointerException nullPointerException) {
			return null;
		}
	}
	
	private String getName(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
		try {
			return hotelList.get(seq).hotelName;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	private ImageView getStar(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
		try {
			int starNum = hotelList.get(seq).star;
			switch (starNum) {
				case 1:
					return new ImageView(new Image(Resources.getInstance().starIcon1.toString()));
				case 2:
					return new ImageView(new Image(Resources.getInstance().starIcon2.toString()));
				case 3:
					return new ImageView(new Image(Resources.getInstance().starIcon3.toString()));
				case 4:
					return new ImageView(new Image(Resources.getInstance().starIcon4.toString()));
				case 5:
					return new ImageView(new Image(Resources.getInstance().starIcon5.toString()));
			}
			return null;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	private double getScore(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
		try {
			DecimalFormat formator = new DecimalFormat("0.00");
			return Double.parseDouble(formator.format(hotelList.get(seq).rank));
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return -1;
		}
	}
	
	private String getAddress(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
		try {
			return hotelList.get(seq).address;
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			return null;
		}
	}
	
	private double getPrice(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
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
	
	private boolean getHistoryMark(int i) {
		int seq = (Integer.parseInt(currentPage.getText()) - 1) * MAX_HOTEL_ONE_PAGE + i;
		ArrayList<HotelVO> historyHotels = CustomerController.getFilteredHotels(getCurrentFilter(), true);
		HotelVO tempHotel = hotelList.get(seq);
		for (int j = 0; j < historyHotels.size(); j++) {
			if (historyHotels.get(j).id.equals(tempHotel.id)) {
				return true;
			}
		}
		return false;
	}
/**************************************************************************************/
}
