package com.moneycontrol.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.moneycontrol.utils.Baseinitialize;

public class Trendlyne {
	
	public   WebDriver driver;
	
	private By Trendlyneimg = By.xpath("//body/div[2]/div[2]/div[1]/img[1]");
	private By Markets =      By.xpath("//body/div[1]/div[1]/div[12]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]");
	private By marketsToday=  By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
	private By highvol =      By.xpath("//a[contains(text(),'High Volume, High Gain')]");
	
	public Trendlyne(WebDriver driver) {
	 this.driver=driver;
	}
	
	public  WebElement trendlyne() {
		
		return	driver.findElement(Trendlyneimg);
				
	}
	
	public WebElement markets() {
		return driver.findElement(Markets);
	}
	
	public  WebElement marketsTod() {
		return driver.findElement(marketsToday);
	}
}
