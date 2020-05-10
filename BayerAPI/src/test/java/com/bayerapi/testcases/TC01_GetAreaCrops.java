package com.bayerapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bayerapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GetAreaCrops extends TestBase {
	
	
	@Test
	void  getAreaCropGrape() {
		
		
		logger.info("**************started testcase getAreaCropGrape ****************");
		
		//Specify base URI
		  RestAssured.baseURI="http://3.6.82.6:9889/getAreaCrops";
		//Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("pincode","401404");
		  requestParams.put("language_code","en");
          httpRequest.header("Content-Type","application/json");
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST);
		    //commmit2
		  //status code validation
		  int statusCode=response.getStatusCode();
		  logger.info("**************started status code validation ****************");
		  Assert.assertEquals(statusCode, 200);
		  logger.info("**************statuscode is ****************"+statusCode);
		  logger.info("**************status code validated ****************");	  
		  JsonPath jsonpath = response.jsonPath();
          Assert.assertEquals(jsonpath.get("pincode_supported"), "True");
		  Assert.assertEquals(jsonpath.get("location_name"), "Maharashtra");
		  logger.info("**************Ended testcase getAreaCropGrape ****************");
		
	}
	
	@Test
	 void getAreaCropApple()
	 {
		logger.info("**************started testcase getAreaCropApple ****************");
	  //Specify base URI
	  RestAssured.baseURI="http://3.6.82.6:9889/getAreaCrops";
	  
	//Request object
	  RequestSpecification httpRequest=RestAssured.given();
	   
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("pincode","173205");
	  requestParams.put("language_code","en");

	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST);
	    
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  JsonPath jsonpath = response.jsonPath();
	  
	
	 Assert.assertEquals(jsonpath.get("pincode_supported"), "True");
	 Assert.assertEquals(jsonpath.get("location_name"), "Himachal Pradesh");
	
	 logger.info("**************Ended testcase getAreaCropApple ****************");
}
	
	@Test
	 void getAreaCropTomato()
	 {
		logger.info("**************started testcase getAreaCropTomato ****************");
	  //Specify base URI
	  RestAssured.baseURI="http://3.6.82.6:9889/getAreaCrops";
	  
	  
	//Request object
	  RequestSpecification httpRequest=RestAssured.given(); 
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("pincode","525252");
	  requestParams.put("language_code","en");

	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST);
	    
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  JsonPath jsonpath = response.jsonPath();
	  
	
	 Assert.assertEquals(jsonpath.get("pincode_supported"), "True");
	 Assert.assertEquals(jsonpath.get("location_name"), "Telangana");
	 logger.info("**************started testcase getAreaCropTomato ****************");

}
	@Test
	void checkUnsupportedPincodeApple() {
		
		
logger.info("**************started testcase checkUnsupportedPincode ****************");
		
		//Specify base URI
		  RestAssured.baseURI="http://3.6.82.6:9889/getAreaCrops";
		//Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("pincode","121121");
		  requestParams.put("language_code","en");
          httpRequest.header("Content-Type","application/json");
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST);
		    
		  //status code validation
		  int statusCode=response.getStatusCode();
		  logger.info("**************started status code validation ****************");
		  Assert.assertEquals(statusCode, 500);
		  logger.info("**************statuscode is ****************"+statusCode);
		  logger.info("**************status code validated ****************");	  
		  JsonPath jsonpath = response.jsonPath();
          Assert.assertEquals(jsonpath.get("pincode_supported"), "False");
		 
		  logger.info("**************Ended testcase pincodesuppoerted ****************");
		
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


