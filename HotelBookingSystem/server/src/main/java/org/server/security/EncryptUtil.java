package org.server.security;

import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 适用于用户名、密码、姓名、联系方式的加密和解密
 * AES, 128bits, CBC, PKCS5Padding
 * 参考自：http://www.welkinx.com/2016/07/30/10/
 * @author Hirico
 * @version 2016/11/29 Hirico
 */
public class EncryptUtil {
	private static final String KEY_LOCATION = "/hotelSystemKey.txt";
	
	private static final String IV_STRING = "Secure37Enough16";
	
	private static final int KEY_BYTES = 16;
	
	/** 
	 * 从文件中获取key
	 * @return key
	 */
	private static byte[] getKey() {
		byte[] key = new byte[KEY_BYTES];
		InputStream sc = EncryptUtil.class.getResourceAsStream(KEY_LOCATION);
		try {
			sc.read(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	
	/**
	 * 加密
	 * @param content, utf-8
	 * @return 加密后的base64编码密文
	 */
	public static String encrypt(String content) {
		byte[] byteContent = null;
		try {
			byteContent = content.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		byte[] encodeFormat = getKey();
		SecretKeySpec secretKeySpec = new SecretKeySpec(encodeFormat, "AES");
		
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		
		byte[] encryptedBytes = null;
		try {
			encryptedBytes = cipher.doFinal(byteContent);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(encryptedBytes);
	}
	
	/**
	 * 解密
	 * @param content, base64
	 * @return utf-8编码明文
	 */
	public static String decrypt(String content) {
		// base64 解码
		Decoder decoder = Base64.getDecoder();
		byte[] encryptedBytes = decoder.decode(content);
		
		byte[] enCodeFormat = getKey();
		SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
		
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}

		byte[] result = null;
		try {
			result = cipher.doFinal(encryptedBytes);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		try {
			return new String(result, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 用于获得数据库的原始加密数据
	public static void main(String[] args) {
		String username1 = "tom";
		String username2 = "cat";
		String username3 = "mac";
		String username4 = "bob";
		String username5 = "root";
		
		String name1 = "张客户";
		String name2 = "李公司";
		String name3 = "王酒店";
		String name4 = "刘营销";
		String name5 = "白网管";
		
		String password1 = "123456";
		String password2 = "123456";
		String password3 = "123456";
		String password4 = "123456";
		String password5 = "123456";
		
		String phone1 = "13301112944";
		String phone2 = "13824810394";
		String phone3 = "13902920493";
		String phone4 = "13503948102";
		String phone5 = "13639102953";
		
		System.out.println(encrypt(username1));
		System.out.println(encrypt(username2));	
		System.out.println(encrypt(username3));	
		System.out.println(encrypt(username4));	
		System.out.println(encrypt(username5));	
	
		System.out.println("----");
		System.out.println(encrypt(name1));
		System.out.println(encrypt(name2));
		System.out.println(encrypt(name3));
		System.out.println(encrypt(name4));
		System.out.println(encrypt(name5));
		
		System.out.println(encrypt(password1));
		System.out.println(encrypt(password2));
		System.out.println(encrypt(password3));
		System.out.println(encrypt(password4));
		System.out.println(encrypt(password5));
		
		System.out.println(encrypt(phone1));
		System.out.println(encrypt(phone2));
		System.out.println(encrypt(phone3));
		System.out.println(encrypt(phone4));
		System.out.println(encrypt(phone5));
		
		
		
	}
}
