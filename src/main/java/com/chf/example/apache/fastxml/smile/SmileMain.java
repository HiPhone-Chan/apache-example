package com.chf.example.apache.fastxml.smile;

import java.util.Arrays;

import com.chf.example.domain.SimplePojo;

public class SmileMain {
	public static void main(String[] args) {
		SimplePojo a = new SimplePojo();
		a.setStr("hi");
		byte[] str = SmileUtil.formObject(a);
		System.out.println(a);
		System.out.println(Arrays.toString(str));
		SimplePojo a1 = SmileUtil.toObject(str, SimplePojo.class);
		System.out.println(a1);
	}
}
