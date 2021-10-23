package com.trendlyn.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.tools.ant.taskdefs.WaitFor.Unit;
import org.awaitility.Awaitility;
import org.hamcrest.core.Is;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.moneycontrol.page.Homepage;
import com.moneycontrol.page.Trendlyne;
import com.moneycontrol.utils.Baseinitialize;
import com.moneycontrol.utils.CommonActions;
import com.moneycontrol.utils.Logcheck;
import com.moneycontrol.utils.moneyControlExcel;

import jdk.internal.org.jline.utils.Log;

public class Trendlynetest {

	public static WebDriver driver;
	public static Trendlyne trendlyne;
	public static CommonActions commonActions;
	public static Logger log = (Logger) LogManager.getLogger(Logcheck.class.getName());

	@BeforeTest
	public static void initialize() {

		try {

			driver = Baseinitialize.Initializedriver("Url2");
			trendlyne = new Trendlyne(driver);
			commonActions = new CommonActions(driver);
		} catch (IOException e) {

			e.printStackTrace();
		}
		log.info("This is info message after Initialize method");
	}

	@Test(priority = 0)
	public static void validateHomepage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		AssertJUnit.assertEquals(trendlyne.trendlyne().isDisplayed(), true);

	}

	@Test(priority = 1)
	public static void market() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonActions.mouseHoverAction(trendlyne.markets());
		//trendlyne.marketsTod().click();

		Awaitility.await().pollInterval(5, TimeUnit.SECONDS).timeout(20, TimeUnit.SECONDS).untilAsserted(() -> 
			Assert.assertEquals(trendlyne.highVolgain().isDisplayed(), true)
			);

		trendlyne.highVolgain().click();
		log.info("After clicking high volume High gain page");
		Select sel = new Select(trendlyne.selectval());
		sel.selectByValue("100");

		commonActions.implicitTimeout(5);
		int i = trendlyne.table().size();
		log.info("Total size is : " + i);

	}

	@Test(priority = 2)
	public static void exportData() throws IOException {

		
		moneyControlExcel mexcel = new moneyControlExcel(driver);
		try {
			mexcel.createExcel("Trendlyn", 0, 0, "Name");
			mexcel.createExcel("Trendlyn", 0, 1, "LTP");
			mexcel.createExcel("Trendlyn", 0, 2, "Change %");
			mexcel.createExcel("Trendlyn", 0, 3, "Volume (day)");
			mexcel.createExcel("Trendlyn", 0, 4, "Avg volume (Week)");

			mexcel.createExcel("Trendlyn", 0, 6, "High Volume High Gain");
			//// table[@id='DataTables_Table_0']

			for (int i = 1; i <= trendlyne.table().size();) {
				mexcel.createExcel("Trendlyn", i, 0, driver
						.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[1]")).getText());
				mexcel.createExcel("Trendlyn", i, 1, driver
						.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[2]")).getText());
				mexcel.createExcel("Trendlyn", i, 2, driver
						.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[3]")).getText());
				mexcel.createExcel("Trendlyn", i, 3, driver
						.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[4]")).getText());
				mexcel.createExcel("Trendlyn", i, 4, driver
						.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody/tr[" + i + "]/td[5]")).getText());
				i++;
			}

		} catch (InvalidFormatException e) {
			log.error("Issue at exporting data to excel");
		}

	}

}
