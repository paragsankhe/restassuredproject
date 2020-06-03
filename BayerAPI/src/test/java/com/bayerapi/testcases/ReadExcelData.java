package com.bayerapi.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		
		File excelfile = new File("C:\\Users\\HAP\\Desktop\\Mysheet.xlsx");

		FileInputStream fis = new FileInputStream(excelfile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowit = sheet.iterator();


		while (rowit.hasNext()) {

			Row row = rowit.next();
			Iterator<Cell> celliterator = row.cellIterator();

			while (celliterator.hasNext()) {

				Cell cell = celliterator.next();
				System.out.println(cell.toString());
			}
			
		}
		
			}
		}


