package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
		@FindBy(xpath=FilterPageLocators.BRAND_FILTER)
		public WebElement brandFilter;
		
		@FindBy(xpath=FilterPageLocators.BRAND_SAMSUNG)
		public WebElement brandSamsung;
		
		@FindBy(xpath=FilterPageLocators.BRAND_SAMSUNG_CHCKBX)
		public WebElement brandSamsungChckbx;
		
		@FindBy(xpath=FilterPageLocators.FLIPKART_ASSURED_CHCKBX)
		public WebElement flipkartAssuredChckbx;
		
		@FindBy(xpath=FilterPageLocators.APPLIED_FILTERS)
		public WebElement appliedFilters;
		
		@FindBy(xpath=FilterPageLocators.FASSURED)
		public WebElement fAssured;
		
		@FindBy(xpath=FilterPageLocators.ADDITIONAL)
		public WebElement additional;
		
		@FindBy(xpath=FilterPageLocators.CLEARALL)
		public WebElement clearAll;
		
		@FindBy(xpath=FilterPageLocators.PAGE)
		public WebElement page;
		
		@FindBy(xpath=FilterPageLocators.PROD_NAME)
		public List<WebElement> prodName;
		
		@FindBy(xpath=FilterPageLocators.PROD_PRICE)
		public List<WebElement> prodPrice;
		
		@FindBy(xpath=FilterPageLocators.PROD_LINK)
		public List<WebElement> prodLink;
		
		
	/*This method is used to search product
	 * @param product is the string containing name of product to be searched
	 */
		public boolean clickMobileCategory()
		{try {
			if (mobile.isDisplayed() & mobileAccessories.isDisplayed())
			{
			System.out.println("Categories are displayed");
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
		
		/*This method is used to click Brand Samsung
		 */
		public boolean clickSamsungBrand()
		{try {
			int i=1;
			System.out.println(brandFilter.isDisplayed()+" "+brandSamsung.isDisplayed()+" "+ brandSamsungChckbx.isDisplayed());
			if (brandFilter.isDisplayed() & brandSamsung.isDisplayed())
			{
				System.out.println("Samsung Brand is present with checkbox to it's left");
				Thread.sleep(30000);
				brandSamsungChckbx.click();
				System.out.println("successfully clciked on Samsung brand checkbox");
				return true;
			}
				System.out.println("Failed to click Samsung brand checkbox");
				return false;
		}
		catch(Exception e) {
			System.out.println("Failed, unable to check whether Samsung checkbox is present or not");
			return false;
		}
		}
		
		/*This method is used to click Flipkart Assured
		 */
		public boolean clickFAssured()
		{try {
			Thread.sleep(20000);
			if (flipkartAssuredChckbx.isDisplayed() )
			{
				System.out.println("Flipkart Assured is present with checkbox to it's left");
				flipkartAssuredChckbx.click();
				System.out.println("successfully clicked on Flipkart Assured checkbox");
				return true;
			}
			System.out.println("Failed to click Flipkart Assured checkbox");
			return false;
		}
		catch(Exception e) {
			System.out.println("Failed, unable to check whether Flipkart Assured checkbox is present or not");
			return false;
		}
		}
		/*This method is used to click Flipkart Assured
		 */
		public boolean clickPrice(String val )
		{
			WebElement xpath=null;
			String finalXpath=null;
		
			try {
				//createdynamic xpath for additional price 
					finalXpath=FilterPageLocators.ADDITIONAL.replace("ADDTNL", val);
					xpath =driver.findElement(By.xpath(finalXpath));
			
			if (xpath.isDisplayed() )
			{
				xpath.click();
				System.out.println("successfully clicked on required price sorting");
				return true;
			}
			System.out.println("Failed to click on required price sorting");
			return false;
		}
		catch(Exception e) {
			System.out.println("Failed, price sorting option not present or not");
			return false;
		}
		}
		
		/*
		 * This method is used to print product data 
		 */
		public void printData()
		{
			try {
			int n=prodName.size();
			
			if (n>0)
			{
				for(int i=0; i<n;i++)
				{
					System.out.println("Product Name "+prodName.get(i).getText());
					System.out.println("Product Display Price "+prodPrice.get(i).getText());
					System.out.println("Product Link "+prodLink.get(i).getAttribute("href"));
				}
			}
			else
			System.out.println("No data to display");
		}
			catch(Exception e) {
				System.out.println("Failed, to get list of products");
			}
			
		}
		
		
		
	public class ADDITIONAL_SORT {
		public static final String RELEVANCE = "Relevance";
		public static final String POPULARITY = "Popularity";
		public static final String PRICE_LOW_TO_HIGH = "Price -- Low to High";
		public static final String PRICE_HIGH_TO_LOW = "Price -- High to Low";
		public static final String NEWEST_FIRST = "Newest First";
	}
}
