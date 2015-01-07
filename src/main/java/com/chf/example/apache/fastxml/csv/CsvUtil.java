package com.chf.example.apache.fastxml.csv;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public class CsvUtil {
	private static final CsvMapper mapper = new CsvMapper();

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String formObject(Object obj) {
		String str = null;
		try {
			if (obj != null) {
				Class<?> clz = obj.getClass();
				str = mapper.writerFor(clz).with(mapper.schemaFor(clz))
						.writeValueAsString(obj);
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return str;
	}

	public static <T> T toObject(String csv, Class<T> cls) {
		T t = null;
		try {
			t = mapper.reader(cls).with(mapper.schemaFor(cls)).readValue(csv);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return t;
	}
}
