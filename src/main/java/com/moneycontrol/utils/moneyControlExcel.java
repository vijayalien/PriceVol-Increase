package com.moneycontrol.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableColumn;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class moneyControlExcel extends Baseinitialize{

	public static  WebDriver driver;
	
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	public static FileInputStream fis;
	
	
	
	public static String path=System.getProperty("user.dir")+"\\Reports\\test.xlsx";
	

	
	
	public  moneyControlExcel(WebDriver driver) throws IOException {
		this.driver=driver;
	}
	
	public  void createExcel(String sheetname,int rownum,int colNum,String value) throws IOException, InvalidFormatException {
	
	File file= new File(path);	
	if(!file.exists()) {
		wb =new XSSFWorkbook();
		fos=new FileOutputStream(path);
		wb.write(fos);
	}
	
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	
	if(wb.getSheetIndex(sheetname)==-1) {
		wb.createSheet(sheetname);
	}
	sheet=wb.getSheet(sheetname);
	
	if(sheet.getRow(rownum)==null)
	sheet.createRow(rownum);
	
	row=sheet.getRow(rownum);
	cell=row.createCell(colNum);
	cell.setCellValue(value);
	fos=new FileOutputStream(path);
	
	wb.write(fos);
	wb.close();
	
	fis.close();
	fos.close();
	
	}
	
	/*
	 * public static void fetchExceldata() throws IOException {
	 * 
	 * 
	 * 
	 * for(int i=0;i<=7;) {
	 * 
	 * if(i==0) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(firstColumn)
	 * .getText().toString()); wb.write(fos);
	 * 
	 * } else if(i==1) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(secondColumn
	 * ).getText().toString());
	 * 
	 * wb.write(fos); } else if(i==2) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(thirdColumn)
	 * .getText().toString()); wb.write(fos);
	 * 
	 * } else if(i==3) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(fourthColumn
	 * ).getText().toString()); wb.write(fos); } else if(i==4) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(fifthColumn)
	 * .getText().toString()); wb.write(fos); } else if(i==5) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(sixthColumn)
	 * .getText().toString()); wb.write(fos); } else if(i==6) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(sevnthColumn
	 * ).getText().toString()); wb.write(fos); } else if(i==7) {
	 * sheet.createRow(0).createCell(i).setCellValue(driver.findElement(eigthColumn)
	 * .getText().toString()); wb.write(fos); }
	 * 
	 * i++; }
	 * 
	 * wb.close();
	 * 
	 * }

	 */

	public static void setExcel() throws IOException {
		
		
		
		wb.write(fos);
		wb.close();
		fos.close();	
		}
		
	}





