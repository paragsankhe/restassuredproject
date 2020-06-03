package com.bayerapi.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bayerapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AmrutaPOC extends TestBase {

	@Test
	

	public void getAreaCropGrape() throws IOException {
		
		InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\HAP\\Desktop\\Mysheet.xlsx");
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook(); 
        XSSFSheet sheet = wb.getSheetAt(0);
		
        for (int rownum = 1 ; rownum < 253 ; rownum ++) {
			
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + rownum );

		logger.info("**************started testcase **************** for " + rownum );

		RestAssured.baseURI = "https://tataasset.com/taml_ws/api/chatbot/GetSchemeNAV_By_CAMS_Code";
		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestParams = new JSONObject();

		// requestParams.q("cams_scheme_code","BAFDZ");
		requestParams.put("ClientId", "455642a8-54bb-4963-8223-3706237ec2a4");
		requestParams.put("SecretKey", "YuyIL2xdsYT=");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString()); // attach above data to the request

		// Response object
		// Response response=httpRequest.request(Method.POST);
		// commmit2
		Response response = httpRequest.queryParam("cams_scheme_code", sheet.getRow(rownum).getCell(4).toString()).request(Method.POST);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		logger.info("**************started status code validation ****************");
		Assert.assertEquals(statusCode, 200);
		logger.info("**************statuscode is ****************" + statusCode);
		logger.info("**************status code validated ****************");
		JsonPath jsonpath = response.jsonPath();

		Assert.assertEquals(jsonpath.get("SCHEME"), sheet.getRow(rownum).getCell(0).toString());
		Assert.assertEquals(jsonpath.get("SCHEME_NAME"), sheet.getRow(rownum).getCell(1).toString());
		Assert.assertEquals(jsonpath.get("SCH_CLASS"), sheet.getRow(rownum).getCell(2).toString());
		Assert.assertEquals(jsonpath.get("SCH_CLASS_NAME"), sheet.getRow(rownum).getCell(3).toString());
		Assert.assertEquals(jsonpath.get("CAMS_CODE"), sheet.getRow(rownum).getCell(4).toString());
		Assert.assertEquals(jsonpath.get("SCHEME_TYPE"), sheet.getRow(rownum).getCell(5).toString());
		Assert.assertEquals(jsonpath.get("OPTION_NAME"),sheet.getRow(rownum).getCell(6).toString());
		Assert.assertEquals(jsonpath.get("OPT_TYPE"),sheet.getRow(rownum).getCell(7).toString());

		logger.info("**************Ended rowwwwwww ****************" + rownum); }
	
	}
}
