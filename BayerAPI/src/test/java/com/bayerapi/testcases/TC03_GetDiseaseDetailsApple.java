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

public class TC03_GetDiseaseDetailsApple extends TestBase {
	
public Response response;
	
	
	@BeforeClass
	 void getDiseaseDetailsApple()
	 {
	  //Specify base URI
	  RestAssured.baseURI="http://3.6.82.6:9889/getDiseaseDetails";
	  
	//Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	   
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("pincode","173205");
	  requestParams.put("crop_type","Apple");
	  requestParams.put("language_code","en");

	  
	  httpRequest.header("Content-Type","application/json");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  response=httpRequest.request(Method.POST);
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	//  System.out.println("Response Body is:" +responseBody);
	    
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
    
}

	
	  @Test void checkDiseaseIDsApple(){ JsonPath jsonpath = response.jsonPath();
	  System.out.println(jsonpath.get("disease_id").toString());
	  Assert.assertEquals(jsonpath.get("disease_id").toString(),
	  "[52, 41, 43, 45, 51, 56, 57, 47, 54, 49, 55, 44, 42, 48, 50, 53, 46]"); }
	  
	  @Test void checkDiseaseNamesApple(){ JsonPath jsonpath = response.jsonPath();
	  System.out.println(jsonpath.get("disease_name").toString());
	  Assert.assertEquals(jsonpath.get("disease_name").toString(),
	  "[Marssonina Blotch (Premature leaf fall), Alternaria leaf spot/blight, Apple Powdery Mildew, Apple Scab, Europian red mite, Two spotted spider mite, Wooly Apple Aphid, Blossom Thrips, Sanjose Scale, Coddling Moth, Sooty blotch & Fly Speck, Apple root borer, Apple Maggot, Canker Diseases, Collar Rot, Root Rot, Apple Scrapper or Apple Leaf folder]"
	  ); }
	  
	  @Test void checkDiseaseDescriptionApple(){ JsonPath jsonpath =
	  response.jsonPath();
	  System.out.println(jsonpath.get("disease_description").toString());
	  Assert.assertEquals(jsonpath.get("disease_description").toString(),
	  "[Dark green-brown patches on leaves, Greyish brown necrotic leaf spots, White powdery mass on leaves, twigs, flower parts & clusters, Brown-black circular spots on leaves & fruits, White small specks on & loss of color of leaves, Yellow spots & curling & bronzing of leaves., Large knots on roots. , Crinkled & silveryleaf surface, Pink-purple measles spots on fruits., Fruits lose shape & are brighter than normal, Olive green blotches & scattered black shiny round dots on fruits, Leaves are small, branches wither & tree becomes shaky, Small pinpoint sting marks on fruit, Brown-red sunken lesions on bark of trunks & branches, Brown, soft, mushy or girdled lower area of trunk, Small leaves & fruits. Wet rot at bark at soil level., Curled leaves & scrapping marks on apple bunches]"
	  ); }
	 
	@Test
	void checkImageListApple() {
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("image_list").toString());
		Assert.assertEquals(jsonpath.get("image_list").toString(),"[[{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Marsonina_premature_leaf_fall1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Alternaria_Leaf_Spot.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Powdery_mildew1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Scab1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Europian_red_mite_1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Two_spotted_spider_mite1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Wolly_Aphid1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Blossom_Thrips_1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_San_Jose_Scale1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Codling_Moth3.jpeg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Fly_speck.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Root_Borer1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Apple_Maggot1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Canker1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Collar_Rot2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Root_Rot2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Apple_Scrapper1.jpg}]]");
}
}