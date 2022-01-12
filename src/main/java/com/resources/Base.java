package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties property;

	public WebDriver intializeDriver() throws Exception {
		property = new Properties();
		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\data.properties");
		property.load(inputStream);
		 String browserName = property.getProperty("browser");
		//String browserName = System.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if(browserName.contains("headless"))
				options.addArguments("headless");
			driver = new FirefoxDriver(options);
		} else {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			if(browserName.contains("headless"))
				options.addArguments("headless");
			driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;

		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
}
