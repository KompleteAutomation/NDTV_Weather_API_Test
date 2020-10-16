package com.temp.test;

import java.util.ArrayList;

public class City {

	String city;
	public static ArrayList<City> lstCity = new ArrayList<City>();

	//	ArrayList<City> lstCity = new ArrayList<City>();

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String city) {
		this.city = city;

	}





	public void addCity(String city) {
		lstCity.add(new City(city));
	}

	public ArrayList<City> removeCity(String city) {
		//	ToDo Add the logic to remove the city
		return lstCity;
	}

	public ArrayList<City> retCityLst() {
		return lstCity;
	}



}
