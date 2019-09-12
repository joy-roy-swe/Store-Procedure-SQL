package com.codebind.controller;

public class Converter {

	public Converter() {
		
	}
	
	public int to_int(String s) {
		int result = 0;
		
		if(s!= null) {
			result = Integer.valueOf(s);
		}
		return result;
	}
	
	public double to_double(String s) {
		
		double result = 0;
		
		if(s!= null) {
			result = Double.valueOf(s);
		}
		return result;
	}
	

}
