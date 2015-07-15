package com.chf.example.apache.security;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

	public static byte[] decryptBASE64(byte[] key) {
		return Base64.decodeBase64(key);
	}

	public static String decryptBASE64(String key) {
		return new String(Base64.decodeBase64(key));
	}

	public static byte[] encryptBASE64(byte[] key) {
		return Base64.encodeBase64(key);
	}

	public static String encryptBASE64(String key) {
		return new String(Base64.encodeBase64(key.getBytes()));
	}

	public static void main(String[] args) {
		System.out.println(Base64Util.encryptBASE64("123asda"));
		System.out.println(Base64Util.decryptBASE64("MTIzYXNkYQ=="));
	}
}
