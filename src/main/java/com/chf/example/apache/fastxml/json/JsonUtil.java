package com.chf.example.apache.fastxml.json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static String formObject(Object obj) {
		OutputStream os = new ByteArrayOutputStream();
		JsonGenerator generator;
		try {
			generator = mapper.getFactory().createGenerator(os,
					JsonEncoding.UTF8);
			generator.writeObject(obj);
		} catch (IOException e) {
		}
		return os.toString();
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String formObject2(Object obj) {
		String str = null;
		try {
			str = mapper.writeValueAsString(obj);
		} catch (IOException e) {
		}
		return str;
	}

	public static <T> T toObject(String json, Class<T> cls) {
		T t = null;
		try {
			t = mapper.readValue(json, cls);
		} catch (Exception e) {
		}
		return t;
	}
}
