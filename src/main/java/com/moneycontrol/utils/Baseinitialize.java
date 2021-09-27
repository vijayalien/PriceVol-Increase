package com.moneycontrol.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseinitialize {

	public static String currentDate;
	public static  WebDriver driver;
	public static String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\moneycontrol\\resource\\Resource.properties";


	public static WebDriver Initializedriver(String url) throws IOException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(getProperties(url));
		driver.manage().window().maximize();
		return driver;

	}


	public static  String getProperties(String value) throws IOException {

		FileInputStream fis= new FileInputStream(proppath);
		Properties prop= new Properties();
		prop.load(fis);
		String propkey=prop.getProperty(value);
		return propkey;


	}
	

	 public String getdatetime() {
		 try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss");
				Date date = Calendar.getInstance().getTime();
				currentDate = dateFormat.format(date);
				
				return currentDate;
			} catch (Exception ex) {
				ex.printStackTrace();
			} return null;
		}

}

