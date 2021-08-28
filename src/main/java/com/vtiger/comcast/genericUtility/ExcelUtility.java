package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
		
			 /**
			  * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
			  * @author Test
			  *
			  */
			 
			
			public class ExcelUtility {
				
				/**
				 * its used read the data from excel base don below arguments 
				 * @param sheetName
				 * @param rowNum
				 * @param celNum
				 * @return
				 * @throws Throwable
				 */
				
				public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws FileNotFoundException, IOException {
					FileInputStream fis= new FileInputStream("./data/testScriptData.xlsx");
					Workbook wb = WorkbookFactory.create(fis);
					String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
					wb.close();
					return data;
				
				}
				/**
				 * used to get the last used row number on specified Sheet
				 * @param sheetName
				 * @return
				 * @throws Throwable
				 */
				
				public int getRowCount(String sheetName) throws Throwable {
					FileInputStream fis  = new FileInputStream("./data/testScriptData.xlsx");
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheet(sheetName);
					wb.close();
					return sh.getLastRowNum();
				}
				
				/**
				 * To write the data into particular cell
				 * @param sheetName
				 * @param rowNum
				 * @param cellNum
				 * @param data
				 * @throws Throwable
				 * @throws IOException
				 */
				public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable, IOException {
					FileInputStream fis= new FileInputStream("./data/testScriptData.xlsx");
					Workbook wb = WorkbookFactory.create(fis);
					wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
					FileOutputStream fos= new FileOutputStream("./data/testScriptData.xlsx");
					wb.write(fos);
					wb.close();
				
					
				}
			}
	
