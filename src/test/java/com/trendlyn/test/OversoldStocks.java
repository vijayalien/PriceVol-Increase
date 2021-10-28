package com.trendlyn.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.moneycontrol.page.OversoldStocksPage;
import com.moneycontrol.utils.Baseinitialize;
import com.moneycontrol.utils.CommonActions;
import com.moneycontrol.utils.Logcheck;
import com.moneycontrol.utils.moneyControlExcel;

public class OversoldStocks extends Baseinitialize {

	public static OversoldStocksPage oversold;
	public static CommonActions commonActions;
	public static Logger log = (Logger) LogManager.getLogger(Logcheck.class.getName());
	public static moneyControlExcel mexcel;

	@BeforeTest
	public static void initialize() {

		try {

			driver = Baseinitialize.Initializedriver("Url3");
			oversold = new OversoldStocksPage(driver);
			commonActions = new CommonActions(driver);
			mexcel = new moneyControlExcel(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("This is info message after Initialize method");
	}

	@Test(priority = 0)
	public static void getLargeCapOversoldStocks() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30); // you can reuse this one

			WebElement modalButton = oversold.modalCloseButton();
			wait.until(ExpectedConditions.visibilityOf(modalButton));
			modalButton.click();

			Assert.assertEquals(oversold.pageTitle().isDisplayed(), true);

			oversold.selectFilterBox().click();
			oversold.inputFilterValue().sendKeys("Large Cap");
			oversold.inputFilterValue().sendKeys(Keys.ENTER);

			Assert.assertEquals("Oversold by Relative Strength Index (RSI) in S&P BSE Largecap",
					oversold.getLargeCapHeader().getText().trim().toString());

			commonActions.selectValue(oversold.selectTableSize(), "50");

			wait.until(ExpectedConditions.visibilityOfAllElements(oversold.tableHead()));

			int i = 0;
			for (WebElement header : oversold.tableHead()) {
				System.out.println("header is :" + header.getText());
				mexcel.createExcel("Oversold Large Cap", 0, i, header.getText());
				i++;
				log.info("Message: Header of the body is added to the excel sheet");
			}

			int rowSize = oversold.getTableRowSize().size();

			String firstPart = "//table[@id='DataTables_Table_0']/tbody/tr[";
			String secondPart = "]/td";
			for (int a = 1; a <= rowSize;) {
				int colSize = 0;
				String finalPart = firstPart + a + secondPart;
				for (WebElement row : driver.findElements(By.xpath(finalPart))) {
					String rowDetails = row.getText();
					System.out.println("The oversold stocks are : " + rowDetails);
					mexcel.createExcel("Oversold Large Cap", a, colSize, rowDetails);
					colSize++;
				}
				a++;
				log.info("Message: Oversold stocks are added to the excel sheet");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public static void getMidCapOversoldStocks() {
		try {
				
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			
			oversold.selectFilterBox().click();
			oversold.inputFilterValue().sendKeys("Mid Caps");
			oversold.inputFilterValue().sendKeys(Keys.ENTER);

			Assert.assertEquals("Oversold by Relative Strength Index (RSI) in BSE Mid-Cap",oversold.getLargeCapHeader().getText().trim().toString());
			
			wait.until(ExpectedConditions.elementToBeClickable(oversold.selectTableSize()));
			commonActions.selectValue(oversold.selectTableSize(), "50");
			wait.until(ExpectedConditions.visibilityOfAllElements(oversold.tableHead()));

			int i = 0;
			for (WebElement header : oversold.tableHead()) {
				System.out.println("header is :" + header.getText());
				mexcel.createExcel("Oversold Mid Cap", 0, i, header.getText());
				i++;
				log.info("Message: Header of the body is added to the excel sheet");
			}

			int rowSize = oversold.getTableRowSize().size();

			String firstPart = "//table[@id='DataTables_Table_0']/tbody/tr[";
			String secondPart = "]/td";
			for (int a = 1; a <= rowSize;) {
				int colSize = 0;
				String finalPart = firstPart + a + secondPart;
				for (WebElement row : driver.findElements(By.xpath(finalPart))) {
					String rowDetails = row.getText();
					System.out.println("The oversold stocks are : " + rowDetails);
					mexcel.createExcel("Oversold Mid Cap", a, colSize, rowDetails);
					colSize++;
				}
				a++;
				log.info("Message: Oversold stocks are added to the excel sheet");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public static void getNiftySmallCapOversoldStocks() {
		try {
				
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			
			oversold.selectFilterBox().click();
			oversold.inputFilterValue().sendKeys("Nifty small cap");
			oversold.inputFilterValue().sendKeys(Keys.ENTER);

			Assert.assertEquals("Oversold by Relative Strength Index (RSI) in Nifty Smallcap 100",oversold.getLargeCapHeader().getText().trim().toString());
			
			wait.until(ExpectedConditions.elementToBeClickable(oversold.selectTableSize()));
			commonActions.selectValue(oversold.selectTableSize(), "50");
			wait.until(ExpectedConditions.visibilityOfAllElements(oversold.tableHead()));

			int i = 0;
			for (WebElement header : oversold.tableHead()) {
				System.out.println("header is :" + header.getText());
				mexcel.createExcel("Oversold SmallCap", 0, i, header.getText());
				i++;
				log.info("Message: Header of the body is added to the excel sheet");
			}

			int rowSize = oversold.getTableRowSize().size();

			String firstPart = "//table[@id='DataTables_Table_0']/tbody/tr[";
			String secondPart = "]/td";
			for (int a = 1; a <= rowSize;) {
				int colSize = 0;
				String finalPart = firstPart + a + secondPart;
				for (WebElement row : driver.findElements(By.xpath(finalPart))) {
					String rowDetails = row.getText();
					System.out.println("The oversold stocks are : " + rowDetails);
					mexcel.createExcel("Oversold SmallCap", a, colSize, rowDetails);
					colSize++;
				}
				a++;
				log.info("Message: Oversold stocks are added to the excel sheet");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
