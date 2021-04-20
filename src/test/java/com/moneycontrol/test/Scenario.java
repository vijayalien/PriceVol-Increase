package com.moneycontrol.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.moneycontrol.page.Homepage;
import com.moneycontrol.utils.Baseinitialize;
import com.moneycontrol.utils.moneyControlExcel;

public class Scenario extends Baseinitialize {

	public static WebDriver driver;
	
	public static Homepage hp;
	
	@BeforeTest
	public static void initialize() {
		
		try {
			
			driver= Baseinitialize.Initializedriver();
			hp= new Homepage(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//To validate the moneycontrol homepage is loaded
	@Test(priority=0)
	public void validateHomepage() {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals(hp.validateFPtitle().isDisplayed(),true);
				
	}
	
	//To click on all stats button and validate the same
	@Test(priority=1)
	public void validateAllstatpage() {
		
		
		hp.allStat().click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		Assert.assertEquals(hp.statpage().isDisplayed(), true);
		hp.pvIncrease().click();
		hp.selectDate().click();
		Assert.assertEquals(hp.lpTitle().isDisplayed(), true);
	}
	
	//To fetch data and extract into excel
	@Test(priority=2)
	public void extractData() throws IOException, InvalidFormatException {
		
		moneyControlExcel mexcel = new moneyControlExcel(driver);
		
		WebElement table=driver.findElement(By.xpath("//table[@id='cnstv-gainer-up']/tbody"));
		
		int rows=table.findElements(By.xpath("tr")).size();
		System.out.println(rows);
		
				////table[@id='cnstv-gainer-up']/tbody/tr[2]
		////table[@id='cnstv-gainer-up']/tbody/tr/td[1]
		
		/*
		 * for(int i=1;i<=rows;i++) { for(int j=0;j<=rows-1;j++) { String
		 * columnElement=table.findElement(By.xpath("tr/th["+i+"]")).getText();
		 * mexcel.createExcel("moneycontrol",0,j,columnElement);
		 * System.out.println(columnElement); break; }
		 * 
		 * }
		 */
	
		  mexcel.createExcel("moneycontrol",0,0,"Company");
		  mexcel.createExcel("moneycontrol",0,1,"Price");
		  mexcel.createExcel("moneycontrol",0,2,"Change");
		  mexcel.createExcel("moneycontrol",0,3,"%Change");
		  mexcel.createExcel("moneycontrol",0,4,"Price");
		  mexcel.createExcel("moneycontrol", 0, 5, "Change");
		  mexcel.createExcel("moneycontrol", 0, 6, "%Change");
		  mexcel.createExcel("moneycontrol", 0, 7, "Volumes");
		 
		  //to fetch data from 1 body or table 
		  for(int i=2;i<=rows-1;i++) {
			  String company=table.findElement(By.xpath("tr["+i+"]/td[1]")).getText();
			  String price=table.findElement(By.xpath("tr["+i+"]/td[2]")).getText();
			  String change=table.findElement(By.xpath("tr["+i+"]/td[3]")).getText();
			  String percentchange=table.findElement(By.xpath("tr["+i+"]/td[4]")).getText();
			  
			  mexcel.createExcel("moneycontrol",i,0,company);
			  mexcel.createExcel("moneycontrol",i,1,price);
			  mexcel.createExcel("moneycontrol",i,2,change);
			  mexcel.createExcel("moneycontrol",i,3,percentchange);
			  
		  }
		  
		  //to fetch data from 2 body or table
		  //table[@id='cnstv-gainer-up1']/tbody
		  ////table[@id='cnstv-gainer-up1']/tbody/tr[2]/td[5]
		
		  WebElement table2= driver.findElement(By.xpath("//table[@id='cnstv-gainer-up1']/tbody"));
		  int secndRow= table2.findElements(By.xpath("tr")).size();
		  System.out.println(secndRow);
		
		  for(int j=2;j<=secndRow;j++) {
			  String secndPrice=table2.findElement(By.xpath("tr["+j+"]/td[1]")).getText();
			  String secndChange=table2.findElement(By.xpath("tr["+j+"]/td[2]")).getText();
			  String secndpercentchange=table2.findElement(By.xpath("tr["+j+"]/td[3]")).getText();
			  String secndVolumes=table2.findElement(By.xpath("tr["+j+"]/td[4]")).getText();
			  
			  mexcel.createExcel("moneycontrol",j,4,secndPrice);
			  mexcel.createExcel("moneycontrol",j,5,secndChange);
			  mexcel.createExcel("moneycontrol",j,6,secndpercentchange);
			  mexcel.createExcel("moneycontrol",j,7,secndVolumes);
			  
			  
		  }
		
	}
	
}
