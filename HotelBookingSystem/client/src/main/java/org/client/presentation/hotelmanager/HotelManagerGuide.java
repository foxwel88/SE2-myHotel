package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import org.client.launcher.PwModify;
import org.client.launcher.Resources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.client.vo.HotelVO;

/**
 * FXML Controller
 * 酒店工作人员-导航界面
 * @author Hirico
 * @version 2016/12/16 Hirico
 */
public class HotelManagerGuide {
	
	private static final int AVATAR_SIZE = 48;

	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;

	@FXML
	private Pane rootPane;

	@FXML
    private GridPane belowGridPane;

	@FXML
    private AnchorPane mainLabelPane;

	@FXML
    private Label mainLabel;

	@FXML
    private AnchorPane infoLabelPane;

	@FXML
    private Label infoLabel;

	@FXML
    private AnchorPane executeLabelPane;

	@FXML
    private Label executeLabel;

	@FXML
    private AnchorPane historyLabelPane;

	@FXML
    private Label historyLabel;

	@FXML
    private AnchorPane promotionLabelPane;

	@FXML
    private Label promotionLabel;
	
	@FXML
	private Label welcomeLabel;

	@FXML
	private Menu avatar;
	
	@FXML
	private MenuBar avatarBar;

	@FXML
	private Pane backPane;

	@FXML
	private Label backArrow;
		

	/**
	 * 监听并实现在导航界面完成的跳转
	 * @param event
	 */
	
	@FXML
    void handleSwitch(MouseEvent event) {
		
		//change visual effect and gridpane content
		Label source = (Label)event.getSource();
		if (source == mainLabel) { //main
			changeActive(GuideLabelType.MAIN);
			changeContent(GuideLabelType.MAIN);			
		} else if (source == infoLabel) { //info
			changeActive(GuideLabelType.INFO);
			changeContent(GuideLabelType.INFO);
		} else if (source == executeLabel) { //execute
			changeActive(GuideLabelType.EXECUTE);
			changeContent(GuideLabelType.EXECUTE);
		} else if (source == historyLabel) { //history
			changeActive(GuideLabelType.HISTORY);
			changeContent(GuideLabelType.HISTORY);
		} else if (source == promotionLabel) {  //promotion
			changeActive(GuideLabelType.PROMOTION);
			changeContent(GuideLabelType.PROMOTION);
		}
		
	}

	/**When cursor casually hovers on some item, change the item's look */
	@FXML
	void mouseEnter(MouseEvent event) {
		Label source = (Label)event.getSource();
		if (source == mainLabel) { //main
			CurrentItem.getInstance().active(mainLabel, mainLabelPane);
		} else if (source == infoLabel) { //info
			CurrentItem.getInstance().active(infoLabel, infoLabelPane);
		} else if (source == executeLabel) { //execute
			CurrentItem.getInstance().active(executeLabel, executeLabelPane);
		} else if (source == historyLabel) { //history
			CurrentItem.getInstance().active(historyLabel, historyLabelPane);
		} else if (source == promotionLabel) {  //promotion
			CurrentItem.getInstance().active(promotionLabel, promotionLabelPane);
		}

	}

	@FXML
	void mouseEnterForBack(MouseEvent event) {
		backPane.setStyle("-fx-background-color: rgba(255,255,255,0.5)");
		backArrow.setStyle("-fx-text-fill: Black");
	}

	/**When cursor casually leaves some item, change the item's look unless the item is selected*/
	@FXML
	void mouseExit(MouseEvent event) {
		Label source = (Label)event.getSource();
		if (source == mainLabel) { //main
			CurrentItem.getInstance().deActive(GuideLabelType.MAIN, mainLabel, mainLabelPane);
		} else if (source == infoLabel) { //info
			CurrentItem.getInstance().deActive(GuideLabelType.INFO, infoLabel, infoLabelPane);
		} else if (source == executeLabel) { //execute
			CurrentItem.getInstance().deActive(GuideLabelType.EXECUTE, executeLabel, executeLabelPane);
		} else if (source == historyLabel) { //history
			CurrentItem.getInstance().deActive(GuideLabelType.HISTORY, historyLabel, historyLabelPane);
		} else if (source == promotionLabel) {  //promotion
			CurrentItem.getInstance().deActive(GuideLabelType.PROMOTION, promotionLabel, promotionLabelPane);
		}
	}

	@FXML
	void mouseExitForBack(MouseEvent event) {
		backPane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
		backArrow.setStyle("-fx-text-fill: #bcb8b8");
	}

	/*Visually change current active (actually selected) guideLabel(and its pane) */
	void changeActive(GuideLabelType to) {
		switch(to) {
			case MAIN:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(mainLabel, mainLabelPane, GuideLabelType.MAIN);
				CurrentItem.getInstance().active();
				break;
			case INFO:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(infoLabel, infoLabelPane, GuideLabelType.INFO);
				CurrentItem.getInstance().active();
				break;
			case EXECUTE:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(executeLabel, executeLabelPane, GuideLabelType.EXECUTE);
				CurrentItem.getInstance().active();
				break;
			case HISTORY:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(historyLabel, historyLabelPane, GuideLabelType.HISTORY);
				CurrentItem.getInstance().active();
				break;
			case PROMOTION:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(promotionLabel, promotionLabelPane, GuideLabelType.PROMOTION);
				CurrentItem.getInstance().active();
				break;
		}
	}
	
	/*change the content of the gridpane */
	void changeContent(GuideLabelType to) {
		Parent root = null;
		Resources resources = Resources.getInstance();
		try {
			switch(to) {
				case MAIN:
					root = resources.load(resources.hotelManagerMain);
					((HotelManagerMain)resources.getCurrentController()).setParentPane(rootPane);
					break;
				case INFO:
					root = resources.load(resources.hotelManagerModifyHotel);
					break;
				case EXECUTE:
					root = resources.load(resources.hotelManagerExecute);
					((HotelManagerExecute)resources.getCurrentController()).setParentGridPane(belowGridPane);
					break;
				case HISTORY:
					root = resources.load(resources.hotelManagerHistoryOrder);
					((HotelManagerHistoryOrder)resources.getCurrentController()).setParentGridPane(belowGridPane);
					break;
				case PROMOTION:
					root = resources.load(resources.hotelManagerCheckPromotion);
					((HotelManagerCheckPromotion)resources.getCurrentController()).setParentGridPane(belowGridPane);
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (root != null) {
			belowGridPane.getChildren().set(1, root);
			GridPane.setConstraints(root, 1, 0);
		}


	}

	@FXML
	void initialize() {
		assert belowGridPane != null : "fx:id=\"belowGridPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabelPane != null : "fx:id=\"mainLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert infoLabelPane != null : "fx:id=\"infoLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert infoLabel != null : "fx:id=\"infoLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert executeLabelPane != null : "fx:id=\"executeLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert executeLabel != null : "fx:id=\"executeLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert historyLabelPane != null : "fx:id=\"historyLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert historyLabel != null : "fx:id=\"historyLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabelPane != null : "fx:id=\"promotionLabelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert welcomeLabel != null : "fx:id=\"welcomeLabel\" was not injected: check your FXML file 'guide.fxml'.";
        assert avatarBar != null : "fx:id=\"avatarBar\" was not injected: check your FXML file 'guide.fxml'.";
		assert avatar != null : "fx:id=\"avatar\" was not injected: check your FXML file 'guide.fxml'.";
		assert backPane != null : "fx:id=\"backPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert backArrow != null : "fx:id=\"backArrow\" was not injected: check your FXML file 'guide.fxml'.";

		Resources resources = Resources.getInstance();
		//默认显示主界面，如果酒店信息中房间总数量为0且无房间入住信息，则弹出提示并显示编辑信息界面
		if (infoNotEnough()) {
			try {
				belowGridPane.add(resources.load(resources.hotelManagerModifyHotel), 1, 0);
				CurrentItem.setInstance(infoLabel, infoLabelPane, GuideLabelType.INFO);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("请先补全酒店基本信息");

				alert.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				belowGridPane.add(resources.load(resources.hotelManagerMain), 1, 0);
				((HotelManagerMain)resources.getCurrentController()).setParentPane(rootPane);
				CurrentItem.setInstance(mainLabel, mainLabelPane, GuideLabelType.MAIN);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		CurrentItem.getInstance().active();
		
		welcomeLabel.setText("Welcome, " + HotelManagerController.getInstance().managerName);

		Image avatarImg = new Image(resources.avatar.toString());
		ImageView avatarImgView = new ImageView();

		avatarImgView.setImage(avatarImg);
		avatarImgView.setFitHeight(AVATAR_SIZE);
		avatarImgView.setFitWidth(AVATAR_SIZE);
		avatar.setGraphic(avatarImgView);
	}

	/**检测酒店信息是否不全 */
	boolean infoNotEnough() {
		HotelVO hotelVO = HotelManagerController.getInstance().getHotelInfo();
		List<Integer> roomNum = hotelVO.roomNum;
		int totalNum = 0;
		for (int i = 0; i < roomNum.size(); i++) {
			totalNum += roomNum.get(i);
		}
		return totalNum == 0 && hotelVO.checkInInfos.isEmpty();
	}
	
	@FXML
	void goBack(MouseEvent event) {
		String currentId = belowGridPane.getChildren().get(1).getId();
		if (currentId == null) {
			return;
		}
		switch (currentId) {
			case "executed":
			case "abnormal":
			case "cancelled":
				changeContent(GuideLabelType.HISTORY);
				break;
			case "unexecuted":
				changeContent(GuideLabelType.EXECUTE);
				break;
			case "promotion":
				changeContent(GuideLabelType.PROMOTION);
				break;				
		}
	}
	
	@FXML
	void logOut(ActionEvent event) {
		Stage stage = (Stage)mainLabel.getScene().getWindow();
		Resources resources = Resources.getInstance();
		try {
			Parent root = resources.load(resources.login);
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			HotelManagerController.getInstance().logOut();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void modifyPassword() {
		AnchorPane mask = new AnchorPane();
		mask.setStyle("-fx-background-color:rgba(0,0,0,0.9)");
		mask.setLayoutX(0);
		mask.setLayoutY(0);
		mask.setPrefSize(1103.0, 683.0);
		rootPane.getChildren().add(mask);
		Resources resources = Resources.getInstance();
		Parent root = null;
		try {
			root = resources.load(resources.modify);
			((PwModify)resources.getCurrentController()).setParentPane(rootPane);
			((PwModify)resources.getCurrentController()).setUserName(HotelManagerController.getInstance().managerUserName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mask.getChildren().add(root);
		AnchorPane.setLeftAnchor(root, 352.0);
		AnchorPane.setRightAnchor(root, 351.0);
		AnchorPane.setTopAnchor(root, 99.0);
	}
}

