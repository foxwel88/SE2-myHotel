package org.server.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

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
	private static final String KEY_LOCATION = "D://hotelSystemKey.txt";
	
	private static final String IV_STRING = "Secure37Enough16";
	
	private static final int KEY_BYTES = 16;
	
	/** 
	 * 从文件中获取key
	 * @return key
	 */
	private static byte[] getKey() {
		byte[] key = new byte[KEY_BYTES];
		FileInputStream sc = null;
		try {
			sc = new FileInputStream(KEY_LOCATION);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
}
