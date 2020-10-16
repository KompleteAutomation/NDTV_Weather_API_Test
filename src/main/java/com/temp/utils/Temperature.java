package com.temp.utils;

import java.util.ArrayList;

public class Temperature {
	String city;
	int tempF;
	int tempC;
	int tempApi;

	public int getTempApi() {
		return tempApi;
	}



	public void setTempApi(int tempApi) {
		this.tempApi = tempApi;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getTempF() {
		return tempF;
	}



	public void setTempF(int tempF) {
		this.tempF = tempF;
	}



	public int getTempC() {
		return tempC;
	}



	public void setTempC(int tempC) {
		this.tempC = tempC;
	}





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

	public Temperature() {
		// TODO Auto-generated constructor stub
	}



	public Temperature(String city, int tempF,int tempC) {
		this.city = city;
		this.tempC = tempC;
		this.tempF = tempF;
	}




	public void addTemp(String city, int tempF,int tempC) {
		lstTemp.add(new Temperature(city, tempF, tempC));
		//		System.out.println(lstTemp.contains(new Temperature(city, tempF, tempC)));

	}



	public ArrayList<Temperature> removeTemp(String city) {
		//	ToDo Add the logic to remove the city
		return lstTemp;
	}


	public Temperature getIndex(String city) {
		//			Temperature retTemp;
		
		
		for (Temperature temperature : lstTemp) 
		{
			if(temperature.getCity().equals(city)) {
				temperature.setTempApi(400);
				return temperature;
			}


		}
		return null;


		//
		//	public ArrayList<Temperature> retTempLst() {
		//		return lstTemp;
		//	}

	}

}
