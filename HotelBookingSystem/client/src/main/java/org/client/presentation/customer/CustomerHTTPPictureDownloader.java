package org.client.presentation.customer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomerHTTPPictureDownloader {
	
	public static void downLoadImage(String address, String hotelID) {
		String filename = new String(hotelID + ".jpg");
		
		try {
			URL url = new URL(address);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setConnectTimeout(5 * 1000);
			InputStream instream = httpURLConnection.getInputStream();
			byte[] data = readInputStream(instream);
			File tempImage = new File(CustomerHTTPPictureDownloader.class.getResource("/") + "temp");
			if (!tempImage.exists()) {
				tempImage.mkdirs();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(tempImage.getPath().substring(6) + File.separator + filename);
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (MalformedURLException malformedURLException) {
			malformedURLException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	public static void clearTempFile() {
		String FileFolderPath = new String((CustomerHTTPPictureDownloader.class.getResource("/") + "temp").substring(6));
		File fileFolder = new File(FileFolderPath);
		String[] fileList = fileFolder.list();
		File tempFile = null;
		for (int i = 0; i < fileList.length; i++) {
			tempFile = new File(FileFolderPath + File.separator + fileList[i]);
			// 只会删除文件，所以文件夹可以放心(？)的保存在这里面
			if (tempFile.isFile()) {
				tempFile.delete();
			}
		}
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
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String address = "http://p1.bpimg.com/567571/ec6618599bf66d79.jpg";
		downLoadImage(address, "00000");
	}
}
