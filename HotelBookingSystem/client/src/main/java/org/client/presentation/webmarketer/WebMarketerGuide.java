package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.client.launcher.PwModify;
import org.client.launcher.Resources;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

/**
 * FXML Controller
 * controller of webMarketer's guide
 * @author gyue
 * @version 2016/11/27 gyue
 * 
 */
public class WebMarketerGuide {
	
	private static final int AVATAR_SIZE = 48;

	@FXML
	private Pane parent;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane belowGridPane;

	@FXML
	private AnchorPane orderPane;

	@FXML
	private Label orderLabel;

	@FXML
	private AnchorPane levelPane;

	@FXML
	private Label levelLabel;

	@FXML
	private AnchorPane promotionPane;

	@FXML
	private Label promotionLabel;

	@FXML
	private AnchorPane creditPane;

	@FXML
	private Label creditLabel;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private Label mainLabel;

	@FXML
	private Label welcomeLabel;

	@FXML
	private Pane backPane;

	@FXML
	private Label backArrow;

	@FXML
	private MenuBar avatarBar;

	@FXML
	private Menu avatar;
	
	private String userName;
	
	@FXML
	void initialize() {
		assert belowGridPane != null : "fx:id=\"belowGridPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert orderPane != null : "fx:id=\"orderPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert orderLabel != null : "fx:id=\"orderLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert levelPane != null : "fx:id=\"levelPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert levelLabel != null : "fx:id=\"levelLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionPane != null : "fx:id=\"promotionPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert creditPane != null : "fx:id=\"creditPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert creditLabel != null : "fx:id=\"creditLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert welcomeLabel != null : "fx:id=\"welcomeLabel\" was not injected: check your FXML file 'guide.fxml'.";
		assert backPane != null : "fx:id=\"backPane\" was not injected: check your FXML file 'guide.fxml'.";
		assert backArrow != null : "fx:id=\"backArrow\" was not injected: check your FXML file 'guide.fxml'.";
		assert avatarBar != null : "fx:id=\"avatarBar\" was not injected: check your FXML file 'guide.fxml'.";
		assert avatar != null : "fx:id=\"avatar\" was not injected: check your FXML file 'guide.fxml'.";
		try {
			belowGridPane.add((Node) FXMLLoader.load(getClass().getResource("/网站营销人员/网站营销人员主界面.fxml")), 1, 0);
			CurrentItem.setInstance(mainLabel, mainPane, GuideLabelType.MAIN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		userName = WebMarketerController.getInstance().getUserName();
		welcomeLabel.setText("Welcome, " + userName);

		Resources resources = Resources.getInstance();
		Image avatarImg = new Image(resources.avatar.toString());
		ImageView avatarImgView = new ImageView();

		avatarImgView.setImage(avatarImg);
		avatarImgView.setFitHeight(AVATAR_SIZE);
		avatarImgView.setFitWidth(AVATAR_SIZE);
		avatar.setGraphic(avatarImgView);
	}

	@FXML
    void handleSwitch(MouseEvent event) {

		Label source = (Label)event.getSource();
		if (source == mainLabel) {
			changeActive(GuideLabelType.MAIN);
			changeContent(GuideLabelType.MAIN);			
		} else if (source == creditLabel) {
			changeActive(GuideLabelType.CREDIT);
			changeContent(GuideLabelType.CREDIT);
		} else if (source == levelLabel) {
			changeActive(GuideLabelType.LEVEL);
			changeContent(GuideLabelType.LEVEL);
		} else if (source == promotionLabel) {
			changeActive(GuideLabelType.PROMOTION);
			changeContent(GuideLabelType.PROMOTION);
		} else if (source == orderLabel) {
			changeActive(GuideLabelType.ORDER);
			changeContent(GuideLabelType.ORDER);
		}
		
	}
	
	/**When cursor casually hovers on some item, change the item's look */
	@FXML
	void mouseEnter(MouseEvent event) {
		Label source = (Label)event.getSource();
		if (source == mainLabel) {
			CurrentItem.getInstance().active(mainLabel, mainPane);
		} else if (source == creditLabel) {
			CurrentItem.getInstance().active(creditLabel, creditPane);
		} else if (source == levelLabel) {
			CurrentItem.getInstance().active(levelLabel, levelPane);
		} else if (source == promotionLabel) {
			CurrentItem.getInstance().active(promotionLabel, promotionPane);
		} else if (source == orderLabel) {
			CurrentItem.getInstance().active(orderLabel, orderPane);
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
		if (source == mainLabel) {
			CurrentItem.getInstance().deActive(GuideLabelType.MAIN, mainLabel, mainPane);
		} else if (source == creditLabel) { 
			CurrentItem.getInstance().deActive(GuideLabelType.CREDIT, creditLabel, creditPane);
		} else if (source == levelLabel) { 
			CurrentItem.getInstance().deActive(GuideLabelType.LEVEL, levelLabel, levelPane);
		} else if (source == orderLabel) {
			CurrentItem.getInstance().deActive(GuideLabelType.ORDER, orderLabel, orderPane);
		} else if (source == promotionLabel) {
			CurrentItem.getInstance().deActive(GuideLabelType.PROMOTION, promotionLabel, promotionPane);
		}
	}

	@FXML
	void mouseExitForBack(MouseEvent event) {
		backPane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
		backArrow.setStyle("-fx-text-fill: #bcb8b8");
	}
	
	@FXML
	void goBack(MouseEvent event) {
		String currentId = belowGridPane.getChildren().get(1).getId();
		if (currentId == null) {
			return;
		}
		switch (currentId) {
			case "orderDetail":
				changeContent(GuideLabelType.ORDER);
				break;
			case "modifyPromotion":
				changeContent(GuideLabelType.PROMOTION);
				break;
		}
	}
	
	void changeActive(GuideLabelType to) {
		switch(to) {
			case MAIN:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(mainLabel, mainPane, GuideLabelType.MAIN);
				CurrentItem.getInstance().active();
				break;
			case CREDIT:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(creditLabel, creditPane, GuideLabelType.CREDIT);
				CurrentItem.getInstance().active();
				break;
			case LEVEL:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(levelLabel, levelPane, GuideLabelType.LEVEL);
				CurrentItem.getInstance().active();
				break;
			case PROMOTION:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(promotionLabel, promotionPane, GuideLabelType.PROMOTION);
				CurrentItem.getInstance().active();
				break;
			case ORDER:
				CurrentItem.getInstance().deActive();
				CurrentItem.setInstance(orderLabel, orderPane, GuideLabelType.ORDER);
				CurrentItem.getInstance().active();
				break;
		}
	}
	
	void changeContent(GuideLabelType to) {
		Parent root = null;
		Resources resources = Resources.getInstance();
		try {
			switch(to) {
				case MAIN:
					root = resources.load(resources.webMarketerMain);
					break;
				case CREDIT:
					root = resources.load(resources.webMarketerModifyCredit);
					break;
				case LEVEL:
					root = resources.load(resources.webMarketerModifyLevel);
					break;
				case PROMOTION:
					root = resources.load(resources.webMarketerCheckPromotion);
					((WebMarketerCheckPromotion)resources.getCurrentController()).setParentGridPane(belowGridPane);
					break;
				case ORDER:
					root = resources.load(resources.webMarketerAbnormalOrderList);
					((WebMarketerAbnormalOrderList)resources.getCurrentController()).setParentGridPane(belowGridPane);
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		belowGridPane.getChildren().set(1, root);
		GridPane.setConstraints(root, 1, 0);
	}
	
	@FXML
	void logOut(ActionEvent event) {
		ResultMessage info = WebMarketerController.getInstance().logout();
		if (info != ResultMessage.SUCCESS) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText(null);
			alert.setContentText(info.toString());

			alert.showAndWait();
			return;
		}
		
		Stage stage = (Stage)mainLabel.getScene().getWindow();
		Resources resources = Resources.getInstance();
		try {
			Parent root = resources.load(resources.login);
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void modifyPassword() {
		AnchorPane mask = new AnchorPane();
		mask.setStyle("-fx-background-color:rgba(0,0,0,0.5)");
		mask.setLayoutX(0);
		mask.setLayoutY(0);
		mask.setPrefSize(1103.0, 683.0);
		parent.getChildren().add(mask);
		Resources resources = Resources.getInstance();
		Parent root = null;
		try {
			root = resources.load(resources.modify);
			((PwModify)resources.getCurrentController()).setParentPane(parent);
			((PwModify)resources.getCurrentController()).setUserName(userName);;
		} catch (IOException e) {
			e.printStackTrace();
		}
		mask.getChildren().add(root);
		AnchorPane.setLeftAnchor(root, 352.0);
		AnchorPane.setRightAnchor(root, 351.0);
		AnchorPane.setTopAnchor(root, 99.0);
	}
	
}
