package com.browserstack.testcases;

import org.apache.commons.logging.impl.Log4JLogger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.browserstack.pageobjects.FilterPage;
import com.browserstack.pageobjects.HomePage;
import com.browserstack.testbase.TestBase;

public class TCG_Filter_Page extends TestBase{

	HomePage hp;
	FilterPage fp;
	
	@BeforeClass(alwaysRun=true)
	public void groupInit()
	{
		hp=new HomePage(driver);
		fp=new FilterPage(driver);
		
		driver.get("https://flipkart.com");
		System.out.println("Successfully navigated to Flipkart's Home page");
	}


	@Test(description = "End to end flow for checking Filter work")
	public void addMultipleColor() throws InterruptedException {
		try {
			String prod="Samsung galaxy S10";
			//verify landed on homepage
			hp.verifyLandedOnHomePage();
			
			//search for samsung galaxy s10 product
			hp.searchProduct(prod);
			//click on mobile categories
			fp.clickMobileCategory();
			//apply filters (Brand: Samsung, Select Flipkart assured, Sort the entries with Price -> High to Low.)
			
			//Read the set of results that show up on page 1.
			//Create a list with the following parameters, and print this on the console.,Product Name, Display Price, 
			//Link to Product Details Page
		}
		finally {
			driver.close();
			System.out.println("Closed browser");
		}

	}

}


