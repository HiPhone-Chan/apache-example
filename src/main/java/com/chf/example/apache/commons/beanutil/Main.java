package com.chf.example.apache.commons.beanutil;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.chf.example.domain.A;
import com.chf.example.domain.B;
import com.chf.example.domain.C;
import com.chf.example.domain.D;

public class Main {
	public static void main(String[] args) throws Exception {

		A a = new A();
		a.setA(1);
		a.setStr("asd asd");
		a.setStrA("A");
		a.setD(new D("D"));
		B b = new B();

		System.out.println(a);
		System.out.println(b);

		// BeanUtils.copyProperties(b, a);
		Map<String, C> properties = new HashMap<String, C>();
		properties.put("c", new C("c"));
		properties.put("d", new C("d"));
		BeanUtils.populate(b, properties);

		String stra = ConvertUtils.convert(a);
		System.out.println("++" + stra + "++");

		System.out.println(a);
		System.out.println(b);
	}
}
