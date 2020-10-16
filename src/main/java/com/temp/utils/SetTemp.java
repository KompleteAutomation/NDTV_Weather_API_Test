package com.temp.utils;
import com.temp.utils.Temperature;

public class SetTemp {
	
	Temperature TEMP = new Temperature();
	
	
	public void setTemp(String city, int tempF,int tempC) {
		TEMP.addTemp(city, tempF, tempC);
//		System.out.println(TEMP.lstTemp.size());
	}


}
