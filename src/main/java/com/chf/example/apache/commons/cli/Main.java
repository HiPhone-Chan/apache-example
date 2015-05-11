package com.chf.example.apache.commons.cli;

public class Main {
	public static void main(String[] args) throws Exception {
		MyCmd.execute(new String[] { "-buildfile", "asd.txt" });
		MyCmd.execute(new String[] { "-help" });
		MyCmd.execute(new String[] { "-version" });
		MyCmd.execute(new String[] { "--user=10" });

	}
}
