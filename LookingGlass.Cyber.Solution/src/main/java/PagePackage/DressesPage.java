package PagePackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basepackage.BaseClass;

public class DressesPage extends BaseClass {
	
	Actions action;
	String[] ar = new String[5];
	
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[1]")
	WebElement item1;
	
	@FindBy(xpath =".//*[@id='center_column']/ul/li[2]")
	WebElement item2;
	
	@FindBy(xpath =".//*[@id='center_column']/ul/li[3]")
	WebElement item3;
	

	@FindBy(xpath =".//*[@id='center_column']/ul/li[4]")
	WebElement item4;
	

	@FindBy(xpath =".//*[@id='center_column']/ul/li[5]")
	WebElement item5;
	
	
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElement addtocart1;
	@FindBy(xpath=".//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]/span")
    WebElement addtocart2;
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span")
    WebElement addtocart3;
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span")
    WebElement addtocart4;
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li[5]/div/div[2]/div[2]/a[1]/span")
    WebElement addtocart5;
	
	@FindBy(xpath = ".//span[@class='cross']")
	WebElement continueShopping;
	
	@FindBy(xpath=".//a[@title='View my shopping cart']")
	WebElement cartIcon;
	
	public DressesPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Action
	public String validateDressPageTitle() {
		
		String title = driver.getTitle();
		return title;
	}
	
	
	//Action 
	public void selectTheFiveDress() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		action = new Actions(driver);
		
		
 		action.moveToElement(item1);
 		action.perform();
 		Thread.sleep(2000);
 		addtocart1.click();
 		Thread.sleep(2000);
 		continueShopping.click();
	    
 		Thread.sleep(1000);
 		action.moveToElement(item2);
 		action.perform();
 		Thread.sleep(2000);
 		addtocart2.click();
 		Thread.sleep(2000);
 		continueShopping.click();
 		Thread.sleep(1000);
 		
 		action.moveToElement(item3);
 		action.perform();
 		Thread.sleep(2000);
 		addtocart3.click();
 		Thread.sleep(2000);
 		continueShopping.click();
 		Thread.sleep(1000);
 		
 		
 		
 		action.moveToElement(item4);
 		action.perform();
 		Thread.sleep(2000);
 		addtocart4.click();
 		Thread.sleep(2000);
 		continueShopping.click();
 		Thread.sleep(1000);
 		
 		action.moveToElement(item5);
 		action.perform();
 		Thread.sleep(2000);
 		addtocart5.click();
 		Thread.sleep(2000);
 		continueShopping.click();
 		
 		
 		
	}
	// Action
	public SummaryPage navigateToSummaryPage() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000,0)");
		cartIcon.click();
		return new SummaryPage();
	}
}
