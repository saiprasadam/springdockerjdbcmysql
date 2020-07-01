package com.poc.demo.jdbc.exception;

public class CustomCommonException extends Exception {

	public static String checkBoolen(Boolean b) {
		String s="value already exist";
		if (b==false) {
		return	s="value already exist";
		}
		else
		{
			return s="value inserted successfully";
		}
	}
	
}
