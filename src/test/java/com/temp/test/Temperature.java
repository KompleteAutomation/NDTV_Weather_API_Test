package com.temp.test;

import java.util.ArrayList;

public class Temperature {
	String city;
	float tempF;
	float tempC;
	float tempApi;


//	All getter and setters for City and Temperature
	public float getTempApi() {
		return tempApi;
	}



	public void setTempApi(float tempApi) {
		this.tempApi = tempApi;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public float getTempF() {
		return tempF;
	}



	public void setTempF(float tempF) {
		this.tempF = tempF;
	}



	public float getTempC() {
		return tempC;
	}



	public void setTempC(float tempC) {
		this.tempC = tempC;
	}





	public static ArrayList<Temperature> lstTemp = new ArrayList<Temperature>();


		public Temperature() {
			// TODO Auto-generated constructor stub
		}
	//
	//	

	//






	//	ArrayList<City> lstCity = new ArrayList<City>();

	public Temperature(String city, float tempF, float tempC, float tempAPIC) {
		this.city = city;
		this.tempC = tempC;
		this.tempF = tempF;
		this.tempApi = tempAPIC;
	}



	public Temperature(String city, float tempF,float tempC) {
		this.city = city;
		this.tempC = tempC;
		this.tempF = tempF;
	}



// Add temperature object
	public void addTemp(String city, float tempF,float tempC, float tempAPIC) {
		lstTemp.add(new Temperature(city, tempF, tempC, tempAPIC));
		//		System.out.println(lstTemp.contains(new Temperature(city, tempF, tempC)));

	}



	public ArrayList<Temperature> removeTemp(String city) {
//	ToDo Add the logic to remove the city
		return lstTemp;
	}


// To test - not working as expected
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
