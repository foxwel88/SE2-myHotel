package org.server.time;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.common.utility.TimeService;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class TimeServiceImpl extends UnicastRemoteObject implements TimeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060614742404108924L;
	
	private Timeline timeline;
	
	private SimpleDateFormat dateFormat;
	
	private String currentTime;

	public TimeServiceImpl() throws RemoteException {
		super();
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent actionEvent) {
								Calendar time = Calendar.getInstance();
								dateFormat = new SimpleDateFormat("HH:mm:ss");
								currentTime = dateFormat.format(time.getTime());
							}
						}
			    ),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public String getCurrentTime() throws RemoteException {
		timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
							@Override public void handle(ActionEvent actionEvent) {
								Calendar time = Calendar.getInstance();
								dateFormat = new SimpleDateFormat("HH:mm:ss");
								currentTime = dateFormat.format(time.getTime());
							}
						}
			    ),
			    new KeyFrame(Duration.seconds(1))
			  );
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		if (currentTime == null) {
			currentTime = "Null!!!";
		}
		return currentTime;
	}

}
