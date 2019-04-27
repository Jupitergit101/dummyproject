package PagePackage;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Basepackage.BaseClass;

public class SummaryPage extends BaseClass {

	public ArrayList<String> array;
	
	@FindBy(xpath ="//a[@title='View my shopping cart']/span[1]")
	WebElement getquantity;
	
	@FindBy(xpath ="//*[@id='total_product_price_3_13_0']")
	WebElement Totalpriceitem1;
	
	@FindBy(xpath ="//*[@id='total_product_price_6_31_0']")
	WebElement Totalpriceitem2;
	
	@FindBy(xpath ="//*[@id='total_product_price_7_34_0']")
	WebElement Totalpriceitem3;
	
	@FindBy(xpath ="//*[@id='total_product_price_4_16_0']")
	WebElement Totalpriceitem4;
	
	@FindBy(xpath ="//*[@id='total_product_price_5_19_0']")
	WebElement Totalpriceitem5;
	
	public SummaryPage() throws IOException {
		
     PageFactory.initElements(driver, this);
		
	}
	// Validate the quantity of the total items selected 
	public int validateQuantity() {
		
		String conv = getquantity.getText();
		int quantity = Integer.parseInt(conv);
		return quantity;
	}
	
	// Validate the price of the each item in the cart 
	public ArrayList validatepriceEachItemInCart() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		array = new ArrayList<String>();
		array.add(Totalpriceitem1.getText());
		array.add(Totalpriceitem2.getText());
		array.add(Totalpriceitem3.getText());
		array.add(Totalpriceitem4.getText());
		array.add(Totalpriceitem5.getText());
	//	System.out.println(array);
		return array;
	}
	
	
	
	}
	
	

//}
