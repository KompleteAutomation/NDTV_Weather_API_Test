package com.temp.todo;

import org.testng.annotations.Test;
//import org.yaml.snakeyaml.util.ArrayUtils;
import org.testng.annotations.BeforeMethod;
//import org.apache.commons.lang.ArrayUtils;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class TestWeather {


//	Object arTemp[][] = new Object[20][3];
//	@Test
//	public void createList() {
//		
//		for (int j = 0; j < 3; j++) {
//			Object[] tmp = new Object[20];
//			for (int i = 0; i < 20; i++) {
//				tmp[i] = "a"; //+Integer.toString(j)+" - "+Integer.toString(i);
////				tmp.add();
//			}
//			arTemp[j] = tmp;
//		}
//	}
//
//	@Test(dependsOnMethods = "createList")
//	public void TestGetCities() {
////		System.out.println("Test City");
////		System.out.println(arTemp.length);
////		System.out.println(arTemp[0][3]);
////		System.out.println(arTemp[1][3]);
////		System.out.println(arTemp[2][3]);
////		
////		System.out.println(arTemp[0][5]);
////		System.out.println(arTemp[1][8]);
////		System.out.println(arTemp[2][10]);
//	}
//
//	@Test(dataProvider = "DP1", dependsOnMethods = "TestGetCities")
//	public void TestGetTemp(Object city, Object temp1, Object temp2) {
//		System.out.println(city+" - "+temp1+" - "+temp2);
//		
//
//	}	
//	
//	
////    @DataProvider(name = "excel_provider")
////    public Object[][] getDataFromExcel() throws Exception {
////        Object[][] data = new Object[][] {};
////        
////        
////        Workbook book = new XSSFWorkbook(new FileInputStream(new File("./src/test/resources/book.xlsx")));
////        Sheet sheet = book.getSheet("Locations");
////        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
////            Row row = sheet.getRow(i);
////            String city = row.getCell(0).getStringCellValue();
////            boolean isBusiness = row.getCell(1).getBooleanCellValue();
////            
////            data = (Object[][]) ArrayUtils.add(data, new Object[] {city, isBusiness});
////            
////        }
////        book.close();
////        return data;
////    }
//	
//	
//	
//	 @DataProvider
//	 
//	    public Object[][] Authentication() throws Exception{
//	 
//	         Object[][] testObjArray = ExcelUtils.getTableArray("D://ToolsQA//OnlineStore//src//testData//TestData.xlsx","Sheet1");
//	 
//	         return (testObjArray);
//	 
//	 }
//	@DataProvider(name = "DP1")
//	public Object[] DP() {
//		System.out.println("Test City");
//		System.out.println(arTemp.length);
//		System.out.println(arTemp[0][3]);
//		System.out.println(arTemp[1][3]);
//		System.out.println(arTemp[2][3]);
//		
//		System.out.println(arTemp[0][5]);
//		System.out.println(arTemp[1][8]);
//		System.out.println(arTemp[2][10]);
//		return arTemp;
//				
//	}
//	
//	
//	 @DataProvider(name="DataContainer")
//	    public Object[] myDataProvider() {
//	         
//	        Object data[][]=  new Object[5][3];
//	        // First student details
//	        data[0][0]= "Mukesh"; 
//	        data[0][1]= "Otwani";
//	        data[0][2]= "Motwani@gmail.com";
//	         
//	        // Second student details
//	        data[1][0]= "Amod";
//	        data[1][1]= "Mahajan";
//	        data[1][2]= "amahajan@hotmail.com";
//	         
//	        // Third student details
//	        data[2][0]= "Animesh";
//	        data[2][1]= "Prashant";
//	        data[2][2]= "aprashant@gmail.com";
//	         
//	        // Fourth student details
//	        data[3][0]= "Ankur";
//	        data[3][1]= "Singh";
//	        data[3][2]= "asingh@gmail.com";
//	         
//	        // Fifth student details
//	        data[4][0]= "Amritansh";
//	        data[4][1]= "Kumar";
//	        data[4][2]= "akumar@gmail.com";
//	         
//	        return data;
//	         
//	         
//	    }
//	
//
//
//	@BeforeMethod
//	public void beforeMethod() {
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//	}
//
//	@AfterTest
//	public void afterTest() {
//	}
//
}
