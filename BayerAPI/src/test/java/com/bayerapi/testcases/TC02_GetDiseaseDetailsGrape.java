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

public class TC02_GetDiseaseDetailsGrape extends TestBase {
	
public Response response;
	
	
	@BeforeClass
	 void getDiseaseDetailsGrape()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://3.6.82.6:9889/getDiseaseDetails";
	  
	//Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	   
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("pincode","401404");
	  requestParams.put("crop_type","Grape");
	  requestParams.put("language_code","en");

	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  response=httpRequest.request(Method.POST);
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	 // System.out.println("Response Body is:" +responseBody);
	    
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
    
}
	@Test
	void checkDiseaseIDsGrape(){
		  JsonPath jsonpath = response.jsonPath();
		  System.out.println(jsonpath.get("disease_id").toString());
		 Assert.assertEquals(jsonpath.get("disease_id").toString(), "[1, 5, 4, 6, 3, 2, 9, 7, 8, 10]");
		}
	@Test
	void checkDiseaseNamesGrape(){
		  JsonPath jsonpath = response.jsonPath();
		  System.out.println(jsonpath.get("disease_name").toString());
		 Assert.assertEquals(jsonpath.get("disease_name").toString(), "[Downy Mildew, Thrips, Powdery Mildew, Mealy bug, Anthracnose, Flea Beetle, Botrytis bunch rot or Grey Mould, Rust, Stem borer, Leaf eating caterpillar]");
		}
	@Test
	void checkDiseaseDescriptionGrape(){
		  JsonPath jsonpath = response.jsonPath();
		  System.out.println(jsonpath.get("disease_description").toString());
		 Assert.assertEquals(jsonpath.get("disease_description").toString(), "[Whitish powder on young berries, Silvery scorchy patches on leaves, Whitish powdery growth on leaves, Sooty whitish mold on leaves, shoots & bunches, Dark spots surrounded by dark margins on berries., Rectangular elongated cuts on leaves, Greyish-brown powdery berries, Small yellow pustules  under leaves, Slits on trunk & vines., Leaves become papery white & have irregular holes]");
		}
	@Test
	void checkImageListGrape(){
		  JsonPath jsonpath = response.jsonPath();
		  System.out.println(jsonpath.get("image_list").toString());
		 Assert.assertEquals(jsonpath.get("image_list").toString(), "[[{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grapes_Downy_Mildew_3.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Thrips1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Powdery_Mildew4.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Mealy_Bug2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Anthracnose2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Flea_beetle1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Botrytis_bunch_rot_or_Grey_Mould_1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Rust_1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Stem_borer_1.PNG}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Grape_Leaf_eating_caterpillar_1.jpg}]]");
		}

}
