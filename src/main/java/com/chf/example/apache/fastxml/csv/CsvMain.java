package com.chf.example.apache.fastxml.csv;

import com.chf.example.domain.SimplePojo;

public class CsvMain {
	public static void main(String[] args) {
		SimplePojo a = new SimplePojo();
		a.setStr("hi");
		String str = CsvUtil.formObject(a);
		System.out.println(a);
		System.out.println(str);
		SimplePojo a1 = CsvUtil.toObject(str, SimplePojo.class);
		System.out.println(a1);
	}
}
