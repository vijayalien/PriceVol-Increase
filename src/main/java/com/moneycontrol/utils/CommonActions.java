package com.moneycontrol.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonActions{
	
	public WebDriver driver;
	
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
	
		
}
