package com.bayerapi.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataSpecificLocation {

	public static void main(String[] args) throws IOException {
	
		
		InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\HAP\\Desktop\\Mysheet.xlsx");
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook(); 
        XSSFSheet sheet = wb.getSheetAt(0);
        
        
        for (int rownum = 1 ; rownum < 3 ; rownum ++) {
       System.out.println(sheet.getRow(rownum).getCell(0).toString());
       System.out.println(sheet.getRow(rownum).getCell(1).toString());
       System.out.println(sheet.getRow(rownum).getCell(2).toString());
       System.out.println(sheet.getRow(rownum).getCell(3).toString());
       System.out.println(sheet.getRow(rownum).getCell(4).toString());
       System.out.println(sheet.getRow(rownum).getCell(5).toString());
       System.out.println(sheet.getRow(rownum).getCell(6).toString());
       System.out.println(sheet.getRow(rownum).getCell(7).toString());
       
        }
	
	}

}
