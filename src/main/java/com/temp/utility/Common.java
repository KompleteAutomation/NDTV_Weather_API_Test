package com.temp.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.temp.utility.Constants;



public class Common {


	static WebDriver driver;

	public Common(WebDriver driver) {
		this.driver = driver;
	}
	//	Constants constants = new Constants();
	//	Mouse Hover
	public void mouseHover(String xpath){
		Actions hold = new Actions(driver);
		hold.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}

	//	Switch to Frame
	public void switchToFrame(String frmValue){
		driver.switchTo().frame(frmValue);
	}

	//	Action: move to element
	public void moveToElement(String xpath){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}

	//	Select value from Options
	public void selectvalueFromDropDown(String xpath,String value){
		List<WebElement> Options = driver.findElements(By.xpath(xpath));
		for(WebElement option : Options){
			if(option.getText().equals(value)){
				option.click();
				break;
			}
		}
	}

	//	Select value from List
	public void selectvalueFromList(String xpath,String value){
		List<WebElement> Options = driver.findElements(By.xpath(xpath));
		for(WebElement option : Options){
			if(option.getText().equals(value)){
				option.click();
				break;
			}
		}
	}




	//	Take Screen shot and save
	public static String takeScreenshot(String TC, String TestRun) throws IOException {
		//Take screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//output type is file type//coverting driver to take a screen shot TakesScreenshot(I) and then getScreenshotAs this method will execute 
		//Copy to a file		

		String currentDir = System.getProperty("user.dir");
		String filName = currentDir + "/Screenshots/"+TestRun+"_"+TC+"_"+ System.currentTimeMillis() + ".png";
		FileUtils.copyFile(scrFile, new File(filName));
		return filName;
	}

	//	Select Value by Visible Text
	public void selectValue(WebElement element,String value){
		Select options = new Select(element);
		options.selectByVisibleText(value);
	}
	public String saveResp(String city, String resp, String TestRun) throws IOException {
		String currentDir = System.getProperty("user.dir");
		String filName = currentDir + "/JSON_Resp/"+TestRun+"_"+city+"_"+ System.currentTimeMillis() + ".txt";
		
			FileWriter myWriter = new FileWriter(filName);
			myWriter.write(resp);
			myWriter.close();
			return "Saved file successfully for "+city;
		

	}


}
