package com.moneycontrol.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonActions{
	
	public static  WebDriver driver;
	public static String currentDate;
	
	public CommonActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public void mouseHoverAction(WebElement target) {
		
		Actions act= new Actions(driver);
		act.moveToElement(target).click();
		act.build().perform();
	}
	
	public void implicitTimeout(int seconds) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	 public static String getdatetime() {
		 try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss");
				Date date = Calendar.getInstance().getTime();
				currentDate = dateFormat.format(date);
				
				return currentDate;
			} catch (Exception ex) {
				ex.printStackTrace();
			} return null;
		}
	 
	 public void selectValue(WebElement  element, String value) {
		 Select sel = new Select(element);
		 sel.selectByValue(value);
	 }
		
}
