package com.temp.utils;

public class Utils {
	
	public float getCelcius(Float tempK) {
		// Kelvin to Degree Celsius Conversion
		float celsius = tempK - 273.15F;
		System.out.println("Celsius: "+ celsius);
		return celsius;
	}

	
//	public static void main(String[] args) {
//		
//		Utils utils = new Utils();
//		System.out.println(utils.getCelcius(299.15F));
//	}
	
	
}
