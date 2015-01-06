package com.chf.example.apache.fastxml.xml;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUtil {
	private static XmlMapper mapper = new XmlMapper();

	public static String formObject(Object obj) {
		String str = null;
		try {
			str = mapper.writeValueAsString(obj);
		} catch (IOException e) {
		}
		return str;
	}

	public static <T> T toObject(String xml, Class<T> cls) {
		T t = null;
		try {
			t = mapper.readValue(xml, cls);
		} catch (Exception e) {
		}
		return t;
	}
}
