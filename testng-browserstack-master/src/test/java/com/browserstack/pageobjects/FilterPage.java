package com.browserstack.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FilterPage{
	WebDriver driver;
	
	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	//Page Objects
	
		@FindBy(xpath=FilterPageLocators.MOBILE_ACCESSORIES)
		public WebElement mobileAccessories;
		
		@FindBy(xpath=FilterPageLocators.MOBILES)
		public WebElement mobile;
		
	/*This method is used to search product
	 * @param product is the string containing name of product to be searched
	 */
		public boolean clickMobileCategory()
		{try {
			if (mobile.isDisplayed() & mobileAccessories.isDisplayed())
			{
			Assert.assertTrue(mobile.isDisplayed(),"Categories are displayed");
			mobile.click();
			return true;
			}
			else
			{
				System.out.println("Failed to click mobiles categories");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Failed, unable to check whether mobiles and mobilesb accessories categories are present or not");
			return false;
		}
		}
	public static class ADDITIONAL_SORT {
		public static final String RELEVANCE = "Relevance";
		public static final String POPULARITY = "Popularity";
		public static final String PRICE_LOW_TO_HIGH = "Price -- Low to High";
		public static final String PRICE_HIGH_TO_LOW = "Price -- High to Low";
		public static final String NEWEST_FIRST = "Newest First";
	}
}
