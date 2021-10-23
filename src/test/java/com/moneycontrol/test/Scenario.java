package com.moneycontrol.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
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
	
	 public static Logger log = LogManager.getLogger(Scenario.class.getName());
	
	@BeforeTest
	public static void initialize() {
		
		try {
			
			driver= Baseinitialize.Initializedriver("Url");
			hp= new Homepage(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		log.info("This is infor message after Initialize method");
	}
	
	//To validate the moneycontrol homepage is loaded
	@Test(priority=0)
	public void validateHomepage() {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(hp.validateFPtitle().isDisplayed(),true);
		
		log.trace("This is trace message after validateHomepage");
	}
	
	//To click on all stats button and validate the same
	@Test(priority=1)
	public void validateAllstatpage() {
		
		
		hp.allStat().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(hp.statpage().isDisplayed(), true);
		hp.pvIncrease().click();
		hp.selectDate().click();
		AssertJUnit.assertEquals(hp.lpTitle().isDisplayed(), true);
		
		log.error("This is error message after validatestat method");
	}
	
	//To fetch data and extract into excel
	@Test(priority=2)
	public void extractData() throws IOException, InvalidFormatException {
		
		moneyControlExcel mexcel = new moneyControlExcel(driver);
		
		WebElement table=driver.findElement(By.xpath("//table[@id='cnstv-gainer-up']/tbody"));
		
		int rows=table.findElements(By.xpath("tr")).size();
		System.out.println(rows);
		
		  mexcel.createExcel("Moneycontrol",0,0,"Company");
		  mexcel.createExcel("Moneycontrol",0,1,"Price");
		  mexcel.createExcel("Moneycontrol",0,2,"Change");
		  mexcel.createExcel("Moneycontrol",0,3,"%Change");
		  mexcel.createExcel("Moneycontrol",0,4,"Price");
		  mexcel.createExcel("Moneycontrol", 0, 5, "Change");
		  mexcel.createExcel("Moneycontrol", 0, 6, "%Change");
		  mexcel.createExcel("Moneycontrol", 0, 7, "Volumes");
		  
		  log.fatal("fatal message after excel column creation");
		 
		  //to fetch data from 1 body or table 
		  for(int i=2;i<=rows-1;i++) {
			  String company=table.findElement(By.xpath("tr["+i+"]/td[1]")).getText();
			  String price=table.findElement(By.xpath("tr["+i+"]/td[2]")).getText();
			  String change=table.findElement(By.xpath("tr["+i+"]/td[3]")).getText();
			  String percentchange=table.findElement(By.xpath("tr["+i+"]/td[4]")).getText();
			  
			  mexcel.createExcel("Moneycontrol",i,0,company);
			  mexcel.createExcel("Moneycontrol",i,1,price);
			  mexcel.createExcel("Moneycontrol",i,2,change);
			  mexcel.createExcel("Moneycontrol",i,3,percentchange);
			  
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
			  
			  mexcel.createExcel("Moneycontrol",j,4,secndPrice);
			  mexcel.createExcel("Moneycontrol",j,5,secndChange);
			  mexcel.createExcel("Moneycontrol",j,6,secndpercentchange);
			  mexcel.createExcel("Moneycontrol",j,7,secndVolumes);
			  
			  log.info("Final info message after moneycontrol test successfully done");
		  }
		
	}
	
	
}
