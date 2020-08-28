package com.web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData_Provider 
{
	/*XSSFWorkbook wb;
	XSSFSheet sheet_no;
	
	public ExcelData_Provider()
	{
		File src=new File("./TestData/TestDataSheet.xlsx");  
		try {
			FileInputStream fis=new FileInputStream(src);		
			wb=new XSSFWorkbook(fis);
				}  catch (IOException e) {
			System.out.println("Capture the error message : "+e.getMessage());
			}		
	 }

	public String getStringdata(int index,int rowval,int cellval)
	{
		return wb.getSheetAt(index).getRow(rowval).getCell(cellval).getStringCellValue();
	}*/
	
	XSSFWorkbook wb;
	XSSFSheet sheet_no;
	
	public ExcelData_Provider()
	{		
		try {
			File source=new File("./TestData/TestDataSheet.xlsx");  // location of the source file
			FileInputStream fis=new FileInputStream(source);     // load the file		
			wb=new XSSFWorkbook(fis);  // for .xslx
		}  catch (IOException e) {
			System.out.println(e.getMessage());
		}					
	}
	
	public String cell_row(int sheet,int row,int cell)
	{
		sheet_no=wb.getSheetAt(sheet);	
		String value=sheet_no.getRow(row).getCell(cell).getStringCellValue();
		return value;		
	}
	
	public int rowCount(int index)
	{
		int r_count=wb.getSheetAt(index).getLastRowNum();
		return (r_count+1);		
	}	
}
