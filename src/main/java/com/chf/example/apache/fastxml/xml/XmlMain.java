package com.chf.example.apache.fastxml.xml;

import com.chf.example.domain.A;
import com.chf.example.domain.D;

public class XmlMain {
	public static void main(String[] args) throws Exception {
		A a = new A();
		D d = new D("d");
		a.setA(12);
//		a.setD(d);
		String str = XmlUtil.formObject(a);
		System.out.println(a);
		System.out.println(str);
		A a1 = XmlUtil.toObject(str, A.class);
		System.out.println(a1);
	}
}
