package com.callor.classes.config;

public class Line {
	public static int lineNum = 60;
	public static final String dLine = "=".repeat(lineNum);
	public static final String sLine = "-".repeat(lineNum);
	
	public static final String dLine(int length) {
		return "=".repeat(length);
	}
	public static final String sLine(int length) {
		return "-".repeat(length);
	}
}
