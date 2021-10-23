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
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseinitialize {

	
	public static  WebDriver driver;
	public static String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\moneycontrol\\resource\\Resource.properties";


	public static WebDriver Initializedriver(String url) throws IOException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
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
	

}

