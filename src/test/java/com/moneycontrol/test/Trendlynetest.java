package com.moneycontrol.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.WaitFor.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.moneycontrol.page.Homepage;
import com.moneycontrol.page.Trendlyne;
import com.moneycontrol.utils.Baseinitialize;

public class Trendlynetest {
	
	public static WebDriver driver;
	public static Trendlyne trendlyne;
	
	@BeforeTest
	public static void initialize() {
		
		try {
			
			driver= Baseinitialize.Initializedriver();
			trendlyne= new Trendlyne(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//log.info("This is infor message after Initialize method");
	}
	
	@Test
	public static void validateHomepage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='close']")).click();
		Assert.assertEquals(trendlyne.trendlyne().isDisplayed(), true);
		
		
	}

}
