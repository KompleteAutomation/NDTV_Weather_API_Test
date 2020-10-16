package com.temp.todo;

import java.util.ArrayList;

import com.temp.test.Temperature;

public class TemperatureOLD {
	String city;
	int tempF;
	int tempC;
	int tempAPI;


	public static ArrayList<Temperature> lstTemp = new ArrayList<Temperature>();


	//	
	//	
	////	ArrayList<ArrayList<Temperature>> lstTemp = new ArrayList<ArrayList<Temperature>>();
	//	public void addItem() {
	//		ArrayList<Temperature> temp = new ArrayList<Temperature>();
	//		temp.add(new Temperature(city, tempF, tempC));
	////		lstTemp.add();
	//	}
	//	
	//	
	//	
	//
	//	public Temperature() {
	//		// TODO Auto-generated constructor stub
	//	}
	//
	//	

	//






	//	ArrayList<City> lstCity = new ArrayList<City>();

	public TemperatureOLD() {
		// TODO Auto-generated constructor stub
	}



	public TemperatureOLD(String city, int tempF,int tempC) {
		this.city = city;
		this.tempC = tempC;
		this.tempF = tempF;
	}




	public void addTemp(String city, int tempF,int tempC) {
		lstTemp.add(new Temperature(city, tempF, tempC));
	}


	
		public ArrayList<Temperature> removeTemp(String city) {
			//	ToDo Add the logic to remove the city
			return lstTemp;
		}


	
	//
	//	public ArrayList<Temperature> retTempLst() {
	//		return lstTemp;
	//	}



}
