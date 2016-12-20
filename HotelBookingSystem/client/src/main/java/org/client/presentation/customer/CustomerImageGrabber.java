package org.client.presentation.customer;

import java.io.File;
import java.io.FileNotFoundException;

import org.client.bl.hotelbl.HotelController;
import org.client.blservice.hotelblservice.Hotelblservice;
import org.client.vo.HotelVO;

import javafx.scene.image.Image;

public class CustomerImageGrabber {
	
	private static Hotelblservice hotelController = null;
	
	public static Image gethotelImage(String hotelID) {
		try {
			if (hotelController == null) {
				hotelController = HotelController.getInstance();
			}
			HotelVO hotelVO = hotelController.getHotelVO(hotelID);
			String httpAddress = hotelVO.imgURL;
			CustomerHTTPPictureDownloader.downLoadImage(httpAddress, hotelID);
			Image hotelImage = new Image(CustomerImageGrabber.class.getResource("/") + "temp" + File.separator + hotelID + ".jpg", 100, 60, false, false);
			return hotelImage;
		} catch (FileNotFoundException fileNotFoundException) {
			return null;
		}
	}
	
}
