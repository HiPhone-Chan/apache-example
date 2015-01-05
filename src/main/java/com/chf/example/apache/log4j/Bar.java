package com.chf.example.apache.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bar {
	private static final Logger logger = LogManager.getLogger(Bar.class);

	public static boolean doIt() {
		logger.entry();
		logger.error("Did it again!");
		return logger.exit(false);
	}
}
