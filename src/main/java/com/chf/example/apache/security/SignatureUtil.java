package com.chf.example.apache.security;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignatureUtil {
	private static final String HMAC_MD5_ALGORITHM = "HmacMD5";
	
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

	public static byte[] encryptMD5(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(data);
			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static String encryptMD5(String data) {
		return data == null ? null
				: byte2Hexstring(encryptMD5(data.getBytes()));
	}
	
	public static byte[] encryptHmacMD5(byte[] key, byte[] data) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key,
					HMAC_MD5_ALGORITHM);

			Mac mac = Mac.getInstance(HMAC_MD5_ALGORITHM);
			mac.init(signingKey);

			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
		}
		return null;
	}

	public static String encryptHmacMD5(String key, String data) {
		return (key == null || data == null) ? null
				: byte2Hexstring(encryptHmacMD5(key.getBytes(),
						data.getBytes()));
	}

	public static byte[] encryptSHA1(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(data);

			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static String encryptSHA1(String data) {
		return data == null ? null
				: byte2Hexstring(encryptSHA1(data.getBytes()));
	}

	public static byte[] encryptHmacSHA1(byte[] key, byte[] data) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key,
					HMAC_SHA1_ALGORITHM);

			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);

			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
		}
		return null;
	}

	public static String encryptHmacSHA1(String key, String data) {
		return (key == null || data == null) ? null
				: byte2Hexstring(encryptHmacSHA1(key.getBytes(),
						data.getBytes()));
	}

	public static byte[] encryptSHA256(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(data);

			return digest.digest();
		} catch (NoSuchAlgorithmException e) {
		}

		return null;
	}

	public static String encryptSHA256(String data) {
		return data == null ? null : byte2Hexstring(encryptSHA256(data
				.getBytes()));
	}

	public static byte[] encryptHmacSHA256(byte[] key, byte[] data) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key,
					HMAC_SHA256_ALGORITHM);

			Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
			mac.init(signingKey);

			return mac.doFinal(data);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
		}
		return null;
	}

	public static String encryptHmacSHA256(String key, String data) {
		return (key == null || data == null) ? null
				: byte2Hexstring(encryptHmacSHA256(key.getBytes(),
						data.getBytes()));
	}

	public static String byte2Hexstring(byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			int i = b & 0XFF;
			if (i < 0x10) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(SignatureUtil.encryptMD5("asd"));
		System.out.println(SignatureUtil.encryptSHA1("asd"));
		System.out.println(SignatureUtil.encryptSHA256("asd"));
		System.out.println(SignatureUtil.encryptHmacMD5("asd", "asd"));
		System.out.println(SignatureUtil.encryptHmacSHA1("asd", "asd"));
		System.out.println(SignatureUtil.encryptHmacSHA256("asd", "asd"));
	}
}
