package com.temp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.temp.test.City;
import com.temp.test.Temperature;
import com.temp.utils.Utils;
import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.temp.api.ApiUtils;
import com.temp.utility.Common;
import com.temp.log4j.MyLogger;

import com.temp.utility.Constants;

import io.restassured.RestAssured;

public class TestsWeather {

	WebDriver driver;

	City oCITY = new City();
	Temperature oTemp = new Temperature();
	SetCity setCity = new SetCity();
	SetTemp setTemp =   new SetTemp();
	Utils utils = new Utils();
	ApiUtils apiutls = new ApiUtils();
	Common common;// = new Common(driver);
	MyLogger logger = new MyLogger();
	String T_Run;
	List<WebElement> lstWECity;

	static Logger mainLogger ;
	// LogManager.getLogger("- - - - - - Logger for test- - - - - - ");
	Constants constants = new Constants();

	ExtentReports eReport;
	ExtentTest extentTest;
	@Parameters({ "T_Run" })
	@BeforeTest
	public void beforeTest(String T_Run) {
		
		this.T_Run = T_Run;
		this.mainLogger = logger.getMainLogger();
		
		eReport = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html", true);
		extentTest = eReport.startTest("TestRun "+T_Run);

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver_86.exe");
		driver = new ChromeDriver();
		mainLogger.info("Opening Chrome Browser");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(constants.URL_NDTV);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("No Thanks"))));
			driver.findElement(By.linkText("No Thanks")).click();
			mainLogger.info("Clicked on 'No Thanks' Prompt");
		} catch (Exception e) {
			System.out.println("Link does not exist");
		}

		if (driver.findElements(By.linkText("No Thanks")).size()>0) {
			driver.findElement(By.linkText("No Thanks")).click();
		}

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='h_sub_menu']")).click();
		mainLogger.info("Open Weather Menu");
//		extentTest.log(LogStatus.INFO, "Close the Browser");
		driver.findElement(By.xpath("//a[text()='WEATHER']")).click();

		common = new Common(driver);

	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context) {
		
	}

	
	@AfterTest
	public void afterTest() {
		mainLogger.info("Close the Browser");
//		extentTest.log(LogStatus.INFO, "Close the Browser");
		driver.quit();
		eReport.endTest(extentTest);

		// writing everything to document.
		eReport.flush();
	}




	@Test
	public void TestAddCity() {
		System.out.println("Getting list of Cities");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@id='more']"));
		System.out.println(findElements.size());
		lstWECity = driver.findElements(By.xpath("//div[@class='message']//label"));

		for (int iCOunt = 0; iCOunt < lstWECity.size(); iCOunt++) {
			setCity.setCity(lstWECity.get(iCOunt).getText().trim());
		}
		mainLogger.info("List of City captured successfully "+lstWECity.size());
		extentTest.log(LogStatus.INFO, "List of City captured successfully "+lstWECity.size());


	}

	@Test(dependsOnMethods = "TestAddCity")
	public void TestPrintCities() {
		ArrayList<City> retCityLst = oCITY.retCityLst();
		//		oCITY.retCityLst();
		for (City city : retCityLst) {
			System.out.println(city.city);
		}
		mainLogger.info("Displayed cities successfully");
		extentTest.log(LogStatus.INFO, "Displayed cities successfully");
	}

	@Test(dependsOnMethods = "TestAddCity")
	public void unCheckCities() {
		List<WebElement> lstWECity = driver.findElements(By.xpath("//div[@class='message']//label"));
		mainLogger.info("Uncheck all cities ");
		
		for (WebElement objCity : lstWECity) {
			if (objCity.findElement(By.id(objCity.getText().trim())).isSelected()) {
				objCity.findElement(By.id(objCity.getText().trim())).click();
				extentTest.log(LogStatus.INFO, "Uncheck the city "+objCity.getText().trim());
			}

		}
	}


	
	@Test(dataProvider = "DataCity", dependsOnMethods = "unCheckCities")
	public void getTemp(City city) {

		String sCity = city.city;
		String scrnName = ""; 
		mainLogger.info("Select the city on the pin menu");
		//	Select the city
		if (!driver.findElement(By.xpath("//div[@class='message']//label//input[@id='"+sCity+"']")).isSelected()) {
			driver.findElement(By.xpath("//div[@class='message']//label//input[@id='"+sCity+"']")).click();
		}


		//Get the temp for the city selected
		WebElement prntTemp = driver.findElement(By.xpath("//*[@class='cityText' and text()='"+sCity+"']//preceding-sibling::div"));
		float tempC = Integer.valueOf(prntTemp.findElement(By.className("tempRedText")).getText().replaceAll(".$", ""));
		float tempF = Integer.valueOf(prntTemp.findElement(By.className("tempWhiteText")).getText().replaceAll(".$", ""));
		
		try {
			 scrnName = common.takeScreenshot(sCity, T_Run);
		} catch (IOException e) {
			mainLogger.info("Could not capture the screenshot for city "+sCity);
			extentTest.log(LogStatus.FAIL, "Could not capture the screenshot for city "+sCity);
		}
		mainLogger.info("Temperature on UI is "+tempC+" for City "+sCity);
		

		// Get Temp using API
		mainLogger.info("Get Temp using API");
		String resp = apiutls.getResponseString(sCity);
		Float tempAPIK = apiutls.getTemp(resp);
		try {
			common.saveResp(sCity,resp, T_Run);
		} catch (IOException e) {
			mainLogger.info("Could not save JSON Resp for city "+sCity);
			extentTest.log(LogStatus.FAIL, "Could not save JSON Resp for city "+sCity);

			
		}
		// Convert Kelvin to Celcius
		float tempApiC = utils.getCelcius(tempAPIK);
		mainLogger.info("Temperature from API is "+tempApiC+" for City "+sCity);
		setTemp.setTemp(sCity, tempF, tempC, tempApiC);

		// Compare the differences with variance set
		if (Math.abs(tempC - tempApiC) > constants.variance    ) {
			mainLogger.error("FAIL: Difference between the API "+tempApiC+" and UI "+tempC+" temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is greater than variance set:"+constants.variance);
//			extentTest.log(LogStatus.FAIL, "Difference between the API and UI temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is greater than "+constants.variance);
			extentTest.log(LogStatus.FAIL,"FAIL: Difference between the API "+tempApiC+" and UI "+tempC+" temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is greater than variance set:"+constants.variance+ extentTest.addScreenCapture(scrnName));
		} else {
			mainLogger.info("PASS: Difference between the API "+tempApiC+" and UI "+tempC+" temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is less than variance set: "+constants.variance);
//			extentTest.log(LogStatus.PASS, "PASS: Difference between the API and UI temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is less than "+constants.variance);
			extentTest.log(LogStatus.PASS,"PASS: Difference between the API "+tempApiC+" and UI "+tempC+" temp: "+Math.abs(tempC - tempApiC)+" for City "+sCity+" is less than variance set: "+constants.variance+ extentTest.addScreenCapture(scrnName));
			
		}
		driver.findElement(By.xpath("//div[@class='message']//label//input[@id='"+sCity+"']")).click();
		assertEquals(tempApiC, tempC,constants.variance,"For city "+sCity+": The Actual temp is "+tempApiC+" and expected is "+tempC);

	}




	//Data provider to return list of cities
	@DataProvider(name = "DataCity", parallel = true ) //,,  parallel = true
	public Iterator<City> DataCity() {
		return oCITY.retCityLst().iterator();
	}



	//	@Test(dataProvider = "DataCity", dependsOnMethods = "getTemp")
	public void getWeatherTemp(City city) {
		String sCity = city.city;
		mainLogger.info("Get temperature using API");
		String respString =  apiutls.getResponseString(sCity);
		Float tempK  = apiutls.getTemp(respString);
		System.out.println(tempK);
		float tempApiC = utils.getCelcius(tempK);
		mainLogger.info("Temperature from API is "+tempApiC+" for City "+sCity);
		extentTest.log(LogStatus.INFO, "Temperature from API is "+tempApiC+" for City "+sCity);
	}


	//	private static 
	//	ArrayList<ArrayList<String>> biDemArrList = new ArrayList<ArrayList<String>>();
	//	lstCity = new ArrayList<String>(); 
	//	lstStrTempF = new ArrayList<String>(); 
	//	lstStrTempC = new ArrayList<String>(); 

	//	driver.switchTo().frame("twitter-widget-0");


	//	for (WebElement objCity : lstWECity) {
	//		if (objCity.findElement(By.id(objCity.getText().trim())).isSelected()) {
	//			objCity.findElement(By.id(objCity.getText().trim())).click();
	//		}
	//
	//	}
	//
	//	biDemArrList.add(lstCity);
	//	biDemArrList.add(lstCity);
	//	System.out.println(biDemArrList.size());
	//	System.out.println(biDemArrList.get(0).size());
	//	System.out.println(biDemArrList.get(1).size());

	//	System.out.println(lstCity.size());
	//	System.out.println(lstCity.size());
	//	System.out.println(lstCity.get(0).getText().trim());
	//	System.out.println(lstCity.get(85).getText().trim());



	//	for (WebElement objCity : lstWECity) {
	//		//		if (objCity.findElement(By.id(objCity.getText().trim())).isSelected()) {
	//		String sCity = objCity.getText().trim();
	//		objCity.findElement(By.id(sCity)).click();
	//


	//		System.out.println(driver.findElements(By.xpath("//*[@class='cityText' and text()='"+sCity+"']")).size());
	//		WebElement prntTemp = driver.findElement(By.xpath("//*[@class='cityText' and text()='"+sCity+"']//preceding-sibling::div"));
	//		String tempC = prntTemp.findElement(By.className("tempRedText")).getText().replaceAll(".$", "");
	//		String tempF = prntTemp.findElement(By.className("tempWhiteText")).getText().replaceAll(".$", "");
	//		System.out.println(tempC);
	//		System.out.println(tempF);
	//		lstStrTempC.add(tempC);
	//		lstStrTempF.add(tempF);


	//			System.out.println(prntTemp.findElement(By.className("tempRedText")).getText());
	//			System.out.println(prntTemp.findElement(By.className("tempWhiteText")).getText());
	//		}

	//	}
	//	biDemArrList.add(lstStrTempC);
	//	biDemArrList.add(lstStrTempF);
	//
	//	System.out.println(biDemArrList.get(0).get(0));
	//	System.out.println(biDemArrList.get(1).get(0));
	//	System.out.println(biDemArrList.get(2).get(0));
	//
	//
	//	System.out.println(biDemArrList.get(0).get(1));
	//	System.out.println(biDemArrList.get(1).get(1));
	//	System.out.println(biDemArrList.get(2).get(1));
	//
	//


	//}


}
