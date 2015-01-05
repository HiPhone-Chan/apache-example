package com.chf.example.apache.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogApp {
	private static final Logger logger = LogManager.getLogger(LogApp.class);

	public static void main(final String... args) {

		logger.trace("Entering application.");
		if (!Bar.doIt()) {
			logger.error("Didn't do it.");
		}
		logger.trace("Exiting application.");
	}
}
