package com.moneycontrol.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.moneycontrol.utils.Baseinitialize;

public class Homepage extends Baseinitialize {
	
	
	private By allStats=By.xpath("//a[@href='http://www.moneycontrol.com/stocks/marketstats/index.php']");
	private By statPage=By.xpath("//tbody//tr//td//h1");
	private By fptitle=By.xpath("//h2[@class='sub_title FL']");
	private By pricevolIncrease=By.xpath("//a[@href='/india/stockmarket/price-increase-volume-increase/marketstatistics/nse/2days.html']");
	private By lptitle=By.xpath("//h1[@class='title']");
	private By daySelect=By.xpath("//a[contains(text(),'Day 2')]");

	
	public  WebDriver driver;

	
	public Homepage (WebDriver driver) {
		this.driver=driver;
	}
	

	public  WebElement validateFPtitle() {
		
		
		return driver.findElement(fptitle);
		
	}
	
	public WebElement allStat() {
		
		return driver.findElement(allStats);
		
	}
	
	public WebElement statpage() {
		
		return driver.findElement(statPage);
	}
	
	public WebElement pvIncrease() {
		
		return driver.findElement(pricevolIncrease);
		
	}
	
	public WebElement selectDate() {
		
		return driver.findElement(daySelect);
	}
	
	public WebElement lpTitle() {
		
		return driver.findElement(lptitle);
	}
	
	
	
}
