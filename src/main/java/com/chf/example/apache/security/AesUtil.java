package com.chf.example.apache.security;

import static org.apache.commons.codec.binary.Hex.encodeHexString;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class AesUtil {

	private AesUtil() {
	}

	public static final String AES = "AES";

	public static byte[] encrypt(byte[] content, byte[] secretKey) {

		try {

			SecretKeySpec key = generateKey(secretKey);
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(content);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException
				| InvalidKeyException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param content
	 * @param secretKey
	 * @return
	 */
	public static String decrypt(String content, String secretKey) {
		try {
			return new String(decrypt(Hex.decodeHex(content.toCharArray()),
					secretKey.getBytes()));
		} catch (DecoderException e) {
		}
		return null;
	}

	public static byte[] decrypt(byte[] content, byte[] secretKey) {

		try {
			SecretKeySpec key = generateKey(secretKey);
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(content);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException
				| InvalidKeyException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param content
	 * @param secretKey
	 * @return
	 */
	public static String encrypt(String content, String secretKey) {

		return encodeHexString(encrypt(content.getBytes(), secretKey.getBytes()));
	}

	private static SecretKeySpec generateKey(byte[] sk)
			throws NoSuchAlgorithmException {
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		kgen.init(128, new SecureRandom(sk));
		SecretKey secretKey = kgen.generateKey();
		return new SecretKeySpec(secretKey.getEncoded(), AES);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(AesUtil.encrypt("asd", "1234"));
		System.out.println(AesUtil.decrypt("c45988ae1edc128db1f9df75ae603f79",
				"1234"));

		byte[] data = { 0x0f, 12, (byte) 0xab };
		System.out.println(new String(Hex.encodeHex(data)));

		String hexString = "0f02";
		System.out.println(hexString.toCharArray());
		System.out.println(Arrays.toString(Hex.decodeHex(hexString
				.toCharArray())));
	}

}
