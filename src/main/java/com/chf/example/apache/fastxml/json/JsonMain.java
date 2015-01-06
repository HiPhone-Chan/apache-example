package com.chf.example.apache.fastxml.json;

import com.chf.example.domain.A;
import com.chf.example.domain.D;

public class JsonMain {
	public static void main(String[] args) {
		A a = new A();
		D d = new D("d");
//		a.setA(12);
		a.setD(d);
		String str = JsonUtil.formObject(a);
		System.out.println(a);
		System.out.println(str);
		System.out.println(JsonUtil.formObject2(a));
		A a1 = JsonUtil.toObject(str, A.class);
		System.out.println(a1);
	}
}
