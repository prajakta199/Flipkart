package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	//Page Objects
	
	@FindBy(xpath=HomePageLocators.FLIPKART_ICON)
	public WebElement flipkartIcon;
	
	@FindBy(xpath=HomePageLocators.SEARCH_BAR)
	public WebElement searchBar;

	//This method is used to verify whether Flipkart's icon is displayed or not
	public boolean verifyIconDisplayed()
	{try {
		System.out.println("Flipkart icon is displayed");
		return true;
	}
	catch(Exception e) {
		System.out.println("Failed to display Flipkart icon");
		return false;
	}
	}
	
	//This method is used to verify whether Search bar is displayed or not
	public boolean verifySearchBarDisplayed()
	{try {
		System.out.println("Flipkart icon is displayed");
		return true;
	}
	catch(Exception e) {
		return false;
	}
	}
	
	//This method is used to verify whetehr we have landed on Flipkart's home page or not
	public boolean verifyLandedOnHomePage()
	{ try {
		if(verifyIconDisplayed() & verifySearchBarDisplayed())
		{
			return true;
		}
		System.out.println("Failed to verify whether landed onHome page or not");
		return false;
	}
	catch(Exception e) {
		System.out.println("Unable to verify whether landed onHome page or not "+e);
		return false;
	}
	}
	
	/*This method is used to search product
	 * @param product is the string containing name of product to be searched
	 */
		public boolean searchProduct(String product)
		{try {
			if(verifySearchBarDisplayed())
			{searchBar.sendKeys(product);
			searchBar.sendKeys(Keys.ENTER);
			System.out.println(product+" is searched successfully");
			return true;
			}
			System.out.println("Searchbar not present hence cannot perform search operation");
			return false;
		}
		catch(Exception e) {
			return false;
		}
		}
}
