package com.chf.example.apache.commons.cli;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class MyCmd {

	private static Options options;

	private static CommandLineParser parser;

	/**
	 * private constructor to prevent instances being created
	 */
	private MyCmd() {
	}

	static {
		init();
	}

	private static void init() {
		options = new Options();
		parser = new BasicParser();

		Option help = new Option("help", "print help message");

		Option version = new Option("version",
				"print the version information and exit");

		OptionBuilder.withArgName("file");
		OptionBuilder.hasArg();
		OptionBuilder.withDescription("use given buildfile");
		Option buildfile = OptionBuilder.create("buildfile");

		OptionBuilder.withLongOpt("user");
		OptionBuilder.withDescription("use username");
		OptionBuilder.hasArg();
		OptionBuilder.withArgName("USERNAME");
		Option user = OptionBuilder.create();

		options.addOption(help);
		options.addOption(version);
		options.addOption(buildfile);
		options.addOption(user);
	}

	public static void execute(String[] args) {
		try {
			CommandLine cmdLine = parser.parse(options, args);

			if (cmdLine.hasOption("help")) {
				help();
			} else if (cmdLine.hasOption("version")) {
				version();
			} else if (cmdLine.hasOption("buildfile")) {
				System.out.println("filename is :"
						+ cmdLine.getOptionValue("buildfile"));
			} else if (cmdLine.hasOption("user")) {
				System.out.println("username is :"
						+ cmdLine.getOptionValue("user"));
			}
		} catch (ParseException e) {
			System.err.println("Parsing failed.  Reason: " + e.getMessage());
			System.err.println("type -help for usage.");
		}
	}

	protected static void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("mycmd", options);
	}

	protected static void version() {
		System.out.println("version 1.0");
	}

}
