package com.poc.demo.jdbc.exception;

import java.util.Scanner;

public class Test_NotCond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test to enter the value");
		String grid = "19";
		
		if(!("19".equals(grid) || "32".equals(grid))){
		System.out.println("error inside the we not block"+grid);	
		}
		else
		{
			System.out.println("success");
		}

	}

}
