package Steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Basepackage.BaseClass;
import PagePackage.DressesPage;
import PagePackage.HomePageClass;
import PagePackage.SummaryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class StepDefinition extends BaseClass {

	HomePageClass homepage;
	DressesPage dresspage;
	SummaryPage summarypage;
	
	public StepDefinition() throws IOException {
		super();
		
	}

	
	
	@Given("^Open the browser and enter the url$")
	public void open_the_browser_and_enter_the_url() throws IOException{
	    
		initialization();
		 homepage = new HomePageClass();
		 dresspage= new DressesPage();
		 summarypage = new SummaryPage();
	}

	@Then("^user at homepage$")
    public void user_at_homepage() { 
		
		String title = homepage.validatetitle();
		Assert.assertEquals(title, "My Store","Title Not Matched");
		driver.quit();
		}
	
	@Then("^Dresses link is Displayed$")
	public void verify_dresses_link_is_displayed() {
	    
		boolean flag = homepage.validatelink();
		Assert.assertTrue(flag);
		driver.quit();
	}
	
	@Then("^Dresses menu option clicked and navigated to dresses homepage$")
	public void dresses_menu_option_clicked_and_navigate_to_dresses_homepage() throws IOException {
	    
		dresspage = homepage.navigateToDressespage();
		String actual_title = dresspage.validateDressPageTitle();
		Assert.assertEquals(actual_title,"Dresses - My Store");
		driver.quit();
	}
	
	@When("^Dresses menu option clicked and navigated to dresses page$")
	public void dresses_menu_option_clicked_and_navigated_to_dresses_page() throws IOException {
		dresspage = homepage.navigateToDressespage();
	}

	@When("^select the five dresses$")
	public void select_the_five_dresses() throws InterruptedException {
	   
		dresspage.selectTheFiveDress();
	}

	@When("^click on Shopping cart and navigate to summary page$")
	public void click_on_Shopping_cart_and_navigate_to_summary_page() throws IOException {
		
		summarypage = dresspage.navigateToSummaryPage();
	    
	}

	@Then("^five dresses listed on summary page$")
	public void five_dresses_listed_on_summary_page() {
	    
		int Actualquantity = summarypage.validateQuantity();
		Assert.assertEquals(Actualquantity, 5);
		driver.quit();
	}
	
	
	@Then("Total each item Price matched")
	public void total_Price_matched(){
	
	    // Initialize data table
	//	List<List>String>>  data = credential.raw();
		
	    ArrayList list  = summarypage.validatepriceEachItemInCart(); // [$26.00, $30.50, $16.40, $50.99, $28.98]
	  
	    Assert.assertEquals(list.get(0),"$26.00","Item 1 Price Not Matched");
	    Assert.assertEquals(list.get(1),"$30.50","Item 2 Price Not Matched");
	    Assert.assertEquals(list.get(2),"$16.40","Item 3 Price Not Matched");
	    Assert.assertEquals(list.get(3),"$50.99","Item 4 Price Not Matched");
	    Assert.assertEquals(list.get(4),"$28.98","Item 5 Price Not Matched");
	    
	    driver.quit();
	}
	
	
	@Then("^total product price is the sum of the total price of each address$")
	public void total_product_price_is_the_sum_of_the_total_price_of_each_address() {
	    
		ArrayList<String> list  = summarypage.validatepriceEachItemInCart(); // [$26.00, $30.50, $16.40, $50.99, $28.98]
		double sum = 0; 
		
		for (int x=0; x<5; x++) {
			
		     Double.parseDouble(list.get(x).substring(1));
	         sum = sum + Double.parseDouble(list.get(x).substring(1));
				
	     }
	     Assert.assertEquals(sum, 152.87);
	     driver.quit();
	}
	
	}