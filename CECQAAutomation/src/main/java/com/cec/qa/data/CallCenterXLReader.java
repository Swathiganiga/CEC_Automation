package com.cec.qa.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CallCenterXLReader {
	public  String path;
	public  FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row   =null;
	public XSSFCell cell = null;
	

	public static Object[][] ReadExcelData(String fileName,int sheetIndex) throws Exception  
	 {
		File f = new File(fileName); 
		FileInputStream fis = new FileInputStream(f); 
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); 
		XSSFSheet sheet = myWorkBook.getSheetAt(sheetIndex); 
		int Row = sheet.getLastRowNum();
		int Col = sheet.getRow(0).getLastCellNum();
		Object data[][]= new Object[Row][Col];
		  	
		for(int i=0;i<Row;i++)
		{
			for (int j=0;j<Col ;j++) 
			{
				data[i][j]=(sheet.getRow(i+1).getCell(j).getStringCellValue());
				System.out.println(data[i][j]);
			}
		}
		return data;	
	}

	}
