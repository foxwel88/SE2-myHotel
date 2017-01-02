package org.client.presentation.customer;

import java.io.File;

import org.client.vo.HotelVO;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomerImageGrabber {
	
	public static ImageView getHotelImageView(String hotelID, double width, double height) {
		HotelVO hotelVO = CustomerController.getHotelVO(hotelID);
		String httpAddress = hotelVO.imgURL;

		Image hotelImage = new Image("file:hotelimgtemp" + File.separator + hotelID + ".jpg");
		if (hotelImage.isError()) {
			CustomerHTTPPictureDownloader.downLoadImage(httpAddress, hotelID);
			hotelImage = new Image("file:hotelimgtemp" + File.separator + hotelID + ".jpg");

		}
		// imageWidth 和  imageHeight 表示图像Image在resize后的长和宽，保持原图比例
		double imageWidth;
		double imageHeight;
		if (hotelImage.getWidth() * height > hotelImage.getHeight() * width) {
			imageWidth = height * hotelImage.getWidth() / hotelImage.getHeight(); 
			imageHeight = height;
		} else {
			imageWidth = width;
			imageHeight = width * hotelImage.getHeight() / hotelImage.getWidth();
		}
		hotelImage = new Image("file:hotelimgtemp" + File.separator + hotelID + ".jpg", imageWidth, imageHeight, false, false);
		ImageView hotelImageView = new ImageView(hotelImage);
		hotelImageView.setPreserveRatio(true);
		double x = (imageWidth - width) / 2;
		double y = (imageHeight - height) / 2;
		hotelImageView.setViewport(new Rectangle2D(x, y, width, height));
		return hotelImageView;
	}
	
}
