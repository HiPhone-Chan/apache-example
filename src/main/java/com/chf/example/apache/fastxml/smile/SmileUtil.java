package com.chf.example.apache.fastxml.smile;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import com.fasterxml.jackson.dataformat.smile.SmileGenerator;
import com.fasterxml.jackson.dataformat.smile.SmileParser;

public class SmileUtil {
	private static final ObjectMapper mapper = smileMapper();

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static byte[] formObject(Object obj) {
		try {
			return mapper.writeValueAsBytes(obj);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static <T> T toObject(byte[] smile, Class<T> cls) {
		T t = null;
		try {
			t = mapper.readValue(smile, cls);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return t;
	}

	protected static ObjectMapper smileMapper() {
		return new ObjectMapper(smileFactory(false, false, false));
	}

	protected static SmileFactory smileFactory(boolean requireHeader,
			boolean writeHeader, boolean writeEndMarker) {
		SmileFactory f = new SmileFactory();
		f.configure(SmileParser.Feature.REQUIRE_HEADER, requireHeader);
		f.configure(SmileGenerator.Feature.WRITE_HEADER, writeHeader);
		f.configure(SmileGenerator.Feature.WRITE_END_MARKER, writeEndMarker);
		return f;
	}

}
