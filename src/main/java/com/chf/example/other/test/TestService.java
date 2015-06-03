package com.chf.example.other.test;

public class TestService {

	public static String test(MockDao dao) {

		return dao.getValue(1);
	}

	public static String getValue() {
		return "1";
	}

	public static String getValue(String str) {
		return "1" + str;
	}
}
