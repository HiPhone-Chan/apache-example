package com.chf.example.apache.fastxml.yaml;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlUtil {
	private static YAMLMapper mapper = new YAMLMapper();

	public static String formObject(Object obj) {
		String str = null;
		try {
			str = mapper.writeValueAsString(obj);
		} catch (IOException e) {
		}
		return str;
	}

	public static <T> T toObject(String yaml, Class<T> cls) {
		T t = null;
		try {
			t = mapper.readValue(yaml, cls);
		} catch (Exception e) {
		}
		return t;
	}
}
