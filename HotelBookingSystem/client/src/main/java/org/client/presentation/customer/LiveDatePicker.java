package org.client.presentation.customer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;


/**
 * 用来控制时间的显示格式的工具类，包括初始化datepicker和把date转化成string的方法
 * @author fraliphsoft
 * @version fraliphsoft 11/29
 */
public class LiveDatePicker {
	
	/**
	 * 此方法用于初始化时间选择器
	 * @param fromDate 如果被初始化的时间选择器的时间必须在另一个时间选择器的时间之后，此参数为限制条件，否则为null
	 * @param toDate 被初始化的时间选择器
	 * @return
	 */
	public static DatePicker initDatePicker(DatePicker fromDate, DatePicker toDate) {
		if (fromDate == null) {
			toDate.setValue(LocalDate.now());
		} else {
			toDate.setValue(fromDate.getValue().plusDays(1));
			Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
				@Override
				public DateCell call(DatePicker toDate) {
					return new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);
							if (item.isBefore(fromDate.getValue().plusDays(1))) {
								setDisable(true);
								setStyle("-fx-background-color: #ffc0cb;");
							}
						}
					};
				}
			};
			toDate.setDayCellFactory(dayCellFactory);
		}
		return toDate;
	}
	
	/**
	 * 
	 * @param date
	 * @return "yyyy/MM/dd HH:mm:ss"
	 */
	public static String dateToDetaildString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return "yyyy/MM/dd"
	 */
	public static String dateToCoarseString(Date date) {
		return (dateToDetaildString(date).split(" "))[0];
	}
}
