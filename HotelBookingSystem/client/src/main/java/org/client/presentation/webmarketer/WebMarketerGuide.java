package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.client.launcher.Resources;
import org.common.utility.ResultMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
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
		
		welcomeLabel.setText("Welcome, " + WebMarketerController.getInstance().getUserName());

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
		FXMLLoader loader = new FXMLLoader();
		try {
			switch(to) {
				case MAIN:
					root = loader.load(getClass().getResource("/网站营销人员/网站营销人员主界面.fxml").openStream());
					break;
				case CREDIT:
					root = loader.load(getClass().getResource("/网站营销人员/信用充值界面.fxml").openStream());
					break;
				case LEVEL:
					root = loader.load(getClass().getResource("/网站营销人员/修改会员等级制度界面.fxml").openStream());
					break;
				case PROMOTION:
					root = loader.load(getClass().getResource("/网站营销人员/管理促销策略界面.fxml").openStream());
					((WebMarketerCheckPromotion)loader.getController()).setParentGridPane(belowGridPane);
					break;
				case ORDER:
					root = loader.load(getClass().getResource("/网站营销人员/浏览异常订单界面.fxml").openStream());
					((WebMarketerAbnormalOrderList)loader.getController()).setParentGridPane(belowGridPane);
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
	
}
