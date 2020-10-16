package com.temp.api;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.temp.utility.Constants;

public class ApiUtils {

	Constants constants = new Constants();
	public String getResponseString(String sCity) {
		//Get Response for a city
		String jsonString = 
				getResponse(sCity)
				.then()
				//				.extract().path("main.temp");	//Get Temperature
				//				.log().body();					//Log Body Response
				.extract()
				.asString();

		System.out.println(jsonString);
		return jsonString;
	}

	
	public Response getResponse(String sCity) {
		//Get Response for a city
		Response response = RestAssured.
				given().queryParam("q",sCity)
				.queryParam("appid",constants.APIKey)
				.when()
				.get(constants.URL_API);

		System.out.println(response);
		return response;
	}

	
	
	
	
	public int getStatusCode(String sCity) {
		int statusCode = 
		getResponse(sCity).getStatusCode();
		System.out.println(statusCode);
		return statusCode;
	}

	
	public String getStatusLine(String sCity) {

		String statusLine =
				getResponse(sCity)
				.getStatusLine();
		System.out.println(statusLine);
		return statusLine;
	}
	
	public String getcontentType(String sCity) {
		// Header named Server
		 String contentType =  
				 getResponse(sCity)
				 .header("Content-Type");
		 System.out.println("Content-Type value: " + contentType);

		 return contentType;

	}
	
	
	public String getAcceptLanguage(String sCity) {
	// Header named Content-Encoding
		String acceptLanguage = getResponse(sCity).header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
		return acceptLanguage;
	}
	
	public String getResponseHeader(String sCity) {
		// Header named Server
		 String serverType =  
				 getResponse(sCity)
				 .header("Server");
		 System.out.println("Server value: " + serverType);
		 return serverType;

	}
	

	public Float getTemp(String jsonString) {
		JSONObject obj = new JSONObject(jsonString);
		//		Get Temperature from response 
		Float tempAPIK = obj.getJSONObject("main").getFloat("temp");
		System.out.println(tempAPIK);
		return tempAPIK;




	}


}
