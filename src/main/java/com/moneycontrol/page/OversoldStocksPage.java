package com.moneycontrol.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OversoldStocksPage {

	public WebDriver driver;

	private By oversoldTitle = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/h3[1]");
	private By selectFilter = By.xpath("//select[@id='JS_diviGroupSelector']");
	private By largeCap = By.xpath("//option[contains(text(),'Large Caps')]");
	private By modalButton = By.xpath("//button[@class='close']");
	private By filter = By.xpath("//span[@class='select2-selection__rendered']");
	private By inputCapValues =By.xpath("//input[@class='select2-search__field']");
	private By largeCapHeader = By.xpath("//div[@class='bbdr m-b-1']/h3");
	private By tableHeader =By.xpath("//table[@id='DataTables_Table_0']/thead/tr/th");
	private By tableRowSize = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr");
	private By selectTableSize = By.xpath("//select[@name='DataTables_Table_0_length']");

	public OversoldStocksPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement pageTitle() {
		return driver.findElement(oversoldTitle);
	}

	public WebElement selectFilter() {
		return driver.findElement(selectFilter);
	}

	public WebElement selectLargeCap() {
		return driver.findElement(largeCap);
	}

	public WebElement modalCloseButton() {
		return driver.findElement(modalButton);
	}
	
	public WebElement selectFilterBox() {
		return driver.findElement(filter);
	}
	
	public WebElement inputFilterValue() {
		return driver.findElement(inputCapValues);
	}
	
	public WebElement getLargeCapHeader() {
		return driver.findElement(largeCapHeader);
	}
	
	public List<WebElement> tableHead() {
		return driver.findElements(tableHeader);
	}
	
	public List<WebElement> getTableRowSize() {
		return driver.findElements(tableRowSize);
	}
	
	public WebElement selectTableSize() {
		return driver.findElement(selectTableSize);
	}
}
