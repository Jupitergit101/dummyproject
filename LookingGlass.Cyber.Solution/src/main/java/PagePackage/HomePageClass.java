package PagePackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basepackage.BaseClass;

public class HomePageClass extends BaseClass{

	@FindBy(xpath = "(//a[contains(@title,'Dresses')])[5]")
	WebElement Dresseslink;
	
	public HomePageClass() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

    // Actions 	
	public String validatetitle() {
		
		String title = driver.getTitle();
		return title;
	}
	
	//Action 
	public boolean validatelink() {
		
		boolean flag = Dresseslink.isDisplayed();
		return flag;
	}
	
	//Action
	
	public DressesPage navigateToDressespage() throws IOException {
		Dresseslink.click();
		return new DressesPage();
	}
	
	
	

	
}
