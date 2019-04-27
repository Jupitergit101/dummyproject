package Basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import TestUtilpackage.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Properties prop;
	public static WebDriver driver;
	public WebDriverListener eventListener;
	public EventFiringWebDriver e_driver;
	
	public BaseClass() throws IOException {  ///home/hassan/eclipse-workspace/LookingGlass.Cyber.Solution/
		
		prop = new Properties();
		FileInputStream fs = new FileInputStream("src/main/java/configurationPackage/config.properties");
		prop.load(fs);
	}
	
	public void initialization() throws IOException {
		
		String brows = prop.getProperty("browser");
		if (brows.equals("Chrome")) {
			
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
			
		} else if (brows.equals("firefox")) {
			
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
		}
		// Register the WebDriver Listener To generate the logs 
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebDriverListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));

	     
	     
	     driver.manage().deleteAllCookies();
	}
	
	
}
