package org.client.presentation.hotelmanager;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import org.client.rmi.RMIHelper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.client.vo.HotelVO;

import javax.imageio.ImageIO;

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

	@FXML
    private Label timeLabel;

	@FXML
	private ImageView hotelImage;

	@FXML
	private Label hotelNameLabel;

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

		HotelVO tempVO = HotelManagerController.getInstance().getHotelInfo();

		hotelNameLabel.setText(tempVO.hotelName);

		String imgURL = tempVO.imgURL;


		try {
			Image image = new Image(imgURL, 100, 60, false, true);
			hotelImage.setImage(image);
		} catch (IllegalArgumentException e) {

		}
	}

}



