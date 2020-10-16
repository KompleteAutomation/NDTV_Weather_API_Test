package com.temp.utils;

import java.util.ArrayList;

public class TestList {
  public static void main(String[] args) {
//      ArrayList<String> al = new ArrayList<Temper>();
	  SetTemp setTemp = new SetTemp();
	  Temperature temperature = new Temperature();
      setTemp.setTemp("AB", 23, 45);
      setTemp.setTemp("CD", 23, 45);
      setTemp.setTemp("EF", 23, 45);
      setTemp.setTemp("GH", 23, 45);
      setTemp.setTemp("IJ", 23, 45);
      setTemp.setTemp("KL", 23, 45);
      
//	  al.add("AB");
//      al.add("CD");
//      al.add("EF");
//      al.add("GH");
//      al.add("IJ");
//      al.add("KL");
//      al.add("MN");
      System.out.println("-------------");
      System.out.println(setTemp.TEMP.lstTemp.size());
//      System.out.println("Index of 'AB': "+setTemp.TEMP.lstTemp.indexOf("AB));
//      System.out.println("Index of 'AB': "+al.indexOf("AB"));
//      System.out.println("Index of 'KL': "+al.indexOf("KL"));
//      System.out.println("Index of 'AA': "+al.indexOf("AA"));
//      System.out.println("Index of 'EF': "+al.indexOf("EF"));
  
      	Temperature temperature2 = temperature.getIndex("AB");
      	System.out.println(temperature2.getTempApi());
  
  
  }
  
  
  
}