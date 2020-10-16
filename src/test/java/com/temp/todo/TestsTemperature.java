package com.temp.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.temp.test.City;

public class TestsTemperature {
	
	static ArrayList<String> lstStrTempC;
	static ArrayList<String> lstStrTempF;
	static ArrayList<String> lstCity;
	public static void main(String[] args) throws InterruptedException {
		City CITY = new City();
		System.out.println(System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ndtv.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//a[@id='h_sub_menu']")).click();
		driver.findElement(By.xpath("//a[text()='WEATHER']")).click();
		
//		private static 
		ArrayList<ArrayList<String>> biDemArrList = new ArrayList<ArrayList<String>>();
		lstCity = new ArrayList<String>(); 
		lstStrTempF = new ArrayList<String>(); 
		lstStrTempC = new ArrayList<String>(); 
		
//		driver.switchTo().frame("twitter-widget-0");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@id='more']"));
		System.out.println(findElements.size());
		List<WebElement> lstWECity = driver.findElements(By.xpath("//div[@class='message']//label"));
		
		for (WebElement objCity : lstWECity) {
			lstCity.add(objCity.getText().trim());
			
			
		}
		
		
		for (WebElement objCity : lstWECity) {
			if (objCity.findElement(By.id(objCity.getText().trim())).isSelected()) {
				objCity.findElement(By.id(objCity.getText().trim())).click();
			}
			
		}
		
		biDemArrList.add(lstCity);
//		biDemArrList.add(lstCity);
		System.out.println(biDemArrList.size());
		System.out.println(biDemArrList.get(0).size());
//		System.out.println(biDemArrList.get(1).size());
		
		System.out.println(lstCity.size());
//		System.out.println(lstCity.size());
//		System.out.println(lstCity.get(0).getText().trim());
//		System.out.println(lstCity.get(85).getText().trim());
		
		
		
		for (WebElement objCity : lstWECity) {
//			if (objCity.findElement(By.id(objCity.getText().trim())).isSelected()) {
				String sCity = objCity.getText().trim();
				objCity.findElement(By.id(sCity)).click();
				
				WebElement prntTemp = driver.findElement(By.xpath("//*[@class='cityText' and text()='"+sCity+"']//preceding-sibling::div"));
				String tempC = prntTemp.findElement(By.className("tempRedText")).getText().replaceAll(".$", "");
				String tempF = prntTemp.findElement(By.className("tempWhiteText")).getText().replaceAll(".$", "");
				System.out.println(tempC);
				System.out.println(tempF);
				lstStrTempC.add(tempC);
				lstStrTempF.add(tempF);
				
				
//				System.out.println(prntTemp.findElement(By.className("tempRedText")).getText());
//				System.out.println(prntTemp.findElement(By.className("tempWhiteText")).getText());
//			}
			
		}
		biDemArrList.add(lstStrTempC);
		biDemArrList.add(lstStrTempF);
		
		System.out.println(biDemArrList.get(0).get(0));
		System.out.println(biDemArrList.get(1).get(0));
		System.out.println(biDemArrList.get(2).get(0));
		
		
		System.out.println(biDemArrList.get(0).get(1));
		System.out.println(biDemArrList.get(1).get(1));
		System.out.println(biDemArrList.get(2).get(1));
	
		
		
		
	}

}
