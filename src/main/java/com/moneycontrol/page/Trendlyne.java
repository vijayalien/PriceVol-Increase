package com.moneycontrol.page;

import java.util.List;

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
	private By selectvalue=   By.xpath("//select[@name='DataTables_Table_0_length']");
	private By highvoltable=  By.xpath("//table[@id='DataTables_Table_0']/tbody/tr");
	private By volShockers =  By.xpath("/html/body/div[2]/div/div/div[1]/h3/text()");
	
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
	
	public WebElement highVolgain() {
		return driver.findElement(highvol);
	}
	
	public WebElement selectval() {
		return driver.findElement(selectvalue);
	}

	public List<WebElement> table() {
		return driver.findElements(highvoltable);
	}
	
	public WebElement volumeShocker() {
		return driver.findElement(volShockers);
	}
}
