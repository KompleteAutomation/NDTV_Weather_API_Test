package com.temp.test;

import java.util.ArrayList;

public class TestCity {

	public static void main(String[] args) {
		City CITY = new City();
		SetCity setCity = new SetCity();
		for (int i = 0; i < 10; i++) {
			setCity.setCity(Integer.toString(i));
		}
		System.out.println("Test City");
		ArrayList<City> retCityLst = CITY.retCityLst();
		for (City city2 : retCityLst) {
			System.out.println(city2.city);
		}
		
	}
	
	
	
	

}
