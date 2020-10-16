package com.temp.test;
import com.temp.test.Temperature;;

public class SetTemp {

	Temperature TEMP = new Temperature();


	public void setTemp(String city, float tempF,float tempC, float tempAPIC) {
		TEMP.addTemp(city, tempF, tempC, tempAPIC);
	}


}
