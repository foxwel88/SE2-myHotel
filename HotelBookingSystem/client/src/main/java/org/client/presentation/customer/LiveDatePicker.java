package org.client.presentation.customer;

import java.time.LocalDate;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

public class LiveDatePicker {
	
	public static DatePicker getNewDatePicker() {
		DatePicker datePicker = new DatePicker(LocalDate.now());
		
		return datePicker;
	}
	
	public static DatePicker getNewFollowingDatePicker(DatePicker prePicker) {
		DatePicker datePicker = new DatePicker(prePicker.getValue().plusDays(1));
//		Callback<DatePicker, DateCell>  TODO
		
		return datePicker;
	}
	
}
