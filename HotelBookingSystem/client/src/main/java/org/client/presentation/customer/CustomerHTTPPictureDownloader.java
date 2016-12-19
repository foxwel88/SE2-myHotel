package org.client.presentation.customer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomerHTTPPictureDownloader {
	
	static int fileNameNO = 0;
	
	public static void downLoadImage(String address) {
		CustomerHTTPPictureDownloader.fileNameNO++;
		String filename = new String(fileNameNO + ".jpg");
		
		try {
			
			URL url = new URL(address);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setConnectTimeout(5 * 1000);
			InputStream instream = httpURLConnection.getInputStream();
			byte[] data = readInputStream(instream);
			File tempImage = new File("/temp/" + filename);
			FileOutputStream fileOutputStream = new FileOutputStream(tempImage);
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (MalformedURLException malformedURLException) {
			malformedURLException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	public static void clearTempFile() {
		
	}
	
	private static byte[] readInputStream(InputStream instream) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = instream.read(buffer)) != -1) {
			outStream.write(buffer, 0, length);
		}
		instream.close();
		return outStream.toByteArray();
	}
	
	/**
	 * 这个是用来测试的
	 * @param args
	 */
	public static void main(String[] args) {
		String address = "http://lain.bgm.tv/pic/eden/icon/l/000/00/00/3.jpg";
		downLoadImage(address);
	}
}
