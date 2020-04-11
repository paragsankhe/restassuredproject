package com.bayerapi.base;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	

	public Logger logger; 
	
	
	@BeforeClass 
	
	public void setup() {
		
		logger = Logger.getLogger("BayerAPI");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		System.out.println("Loggggggggggggggggggggggger settttttttttt");
		
	}
	
	
		
}
		