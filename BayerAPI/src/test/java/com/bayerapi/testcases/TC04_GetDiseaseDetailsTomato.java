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

public class TC04_GetDiseaseDetailsTomato extends TestBase {

	public Response response;

	@BeforeClass
	void getDiseaseDetailsTomato() {
		// Specify base URI
		RestAssured.baseURI = "http://3.6.82.6:9889/getDiseaseDetails";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("pincode", "525252");
		requestParams.put("crop_type", "Tomato");
		requestParams.put("language_code", "en");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString()); // attach above data to the request

		// Response object
		response = httpRequest.request(Method.POST);

		// print response in console window
		String responseBody = response.getBody().asString();
		//System.out.println("Response Body is:" + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}

	
	  @Test void checkDiseaseIDsTomato() { JsonPath jsonpath = response.jsonPath();
	  System.out.println(jsonpath.get("disease_id").toString());
	  Assert.assertEquals(jsonpath.get("disease_id").toString(),
	  "[27, 25, 36, 30, 38, 32, 21, 16, 28, 40, 29, 14, 34, 19, 37, 33, 58, 15, 39, 18, 13, 26, 31, 20, 24, 22, 12, 23, 35, 17]"
	  ); }
	  
	  @Test void checkDiseaseNamesTomato() { JsonPath jsonpath =
	  response.jsonPath();
	  System.out.println(jsonpath.get("disease_name").toString());
	  Assert.assertEquals(jsonpath.get("disease_name").toString(),
	  "[Late Blight, Fruit Borer, Spodoptera, Pinworm - Tuta absoluta, Thrips, Powdery Mildew, Early Blight, Buck eye rot, Leaf Miner, White fly, Lef Curl Virus, Anthracnose leaf spot, Septoria leaf spot, Damping off, Spotted Wilt virus, Red Spider Mites, Root Knot Nematode, Aphids, Trianthema portulacastrum, Dactyloctonium aegyptium, Amaranthus viridis, Gynandropsis pentaphylla, Portulaca oleracea, Digera arvensis, Euphorbia frustratea, Echinochloa colonum, Ageratum conyzoides, Eleusine indica, Setaria glauca, Commelina benghalensis]"
	  ); }
	  
	  @Test void checkDiseaseDescriptionTomato() { JsonPath jsonpath =
	  response.jsonPath();
	  System.out.println(jsonpath.get("disease_description").toString());
	  Assert.assertEquals(jsonpath.get("disease_description").toString(),
	  "[Green/brown lesions, Fruits have round holes filled with excreta. , Holes on fruits & leaves., White color  spots on leaves. Pinholes on  fruits. , Leaves of infected plants gets upward curled., Whitish powdery growth under leaves, Black-brown leaf spots with concentric rings, Brown tissue on fruits near soil, Serpentine white mines on leaves , Honey dew on upper surface of lower leaves, Light-yellow, curled leaves, Small round lesions on Ripe fruits, Small, round spots with dark margins on leaves, Soft, pale & soaked soil level tissue, Yellow/red concentric round marks on fruit, Leaves turn yellow & bronze., Indicative sysmptoms are like deficiency sysmptons , yellow leaves , stunted growth , patch crop apearance and while uprooting the roots Galls /Knots are visible on the roots, Honey dew on twigs & stems , null, null, null, null, null, null, null, null, null, null, null, null]"
	  ); }
	  
	 
	@Test
	void checkImageListTomato() {
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("image_list").toString());
		Assert.assertEquals(jsonpath.get("image_list").toString(),
				"[[{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Late_Blight1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Fruit_borer_Helicoverpa4.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Spodoptera1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Pinworm_Tuta_Absoluta1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Thrips_2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Powdery_Mildew1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Early_Blight1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Buck_Eye_Rot2.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Leaf_Miner1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Whitefly.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Leaf_Curl_Virus1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Anthracnose_Leaf_Spot1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Septoria_Leaf_Spot1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Damping_Off_1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Spotted_Wilt_Virus1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Red_Spider_Mites1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Root_knot_nematode.JPG}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Aphids1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Trianthema_Portulacastrum1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Dactyloctenium_Aegyptium.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Amaranthus_Virdis_Advanced_Stage1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Gynandropsis_pentaphylla_flowering_stage.JPG}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Portulaca_Oleracea_Branched_stage1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Digera_arvensis_young1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Euphorbia_species_branching_stage_.JPG}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Echinochloa_colonum1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Ageratum_conyzoides_young1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Eleusine_Indica_Young_stage1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Setaria_Glauca1.jpg}], [{image=https://farm-advisory.s3.us-east-2.amazonaws.com/Tomato_Commelina_benghalensis_Young_Stage_2.jpg}]]");
	}
}
