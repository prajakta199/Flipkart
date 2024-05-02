package TestCases;

import javax.annotation.CheckForNull;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Page.FilterPage;
import Page.FilterPage.ADDITIONAL_SORT;
import Page.HomePage;


public class TCG_Flipkart {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	HomePage hp;
	FilterPage fp;
	String projectPath=System.getProperty("user.dir");
	WebDriver driver=null;
	
	@BeforeSuite
	public void setUpMe() {

		htmlReporter =new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeTest
//	@Parameters({"browserName"})
	public void setupTest()
	{
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver =new ChromeDriver();
			fp=new FilterPage(driver);
			hp=new HomePage(driver);
	}
	
	@Test
	public  void navigateFlipkart() {

		String prod="Samsung Galaxy S10" ;
				
		//Navigate to flipkart's page
		ExtentTest test=extent.createTest("Flipkart test", "Sample test");
		driver.get("https://flipkart.com");
		
		//verified landed on correct page or not
		boolean landedOnHomePage=hp.verifyLandedOnHomePage();
		Assert.assertTrue("Successfully landed on Home Page",landedOnHomePage);
		
		//searched for samsung galaxy s-10
		boolean searchProduct=hp.searchProduct(prod);
		Assert.assertTrue("Successfully searched for "+prod,searchProduct);
		
		//click mobile categories
		boolean clickMobileCategory=fp.clickMobileCategory();
		Assert.assertTrue("Successfully clicked on Mobile Categories  ",clickMobileCategory);
		
			
		//click fassured
		boolean clickFAssured=fp.clickFAssured();
		Assert.assertTrue("Successfully clicked on Flipkart Assured  ",clickFAssured);
		
		//click samsung brand
				boolean clickSamsungBrand=fp.clickSamsungBrand();
				Assert.assertTrue("Successfully clicked on Samsung brand  ",clickSamsungBrand);
			
		//select price high to low
		boolean priceH2L=fp.clickPrice(ADDITIONAL_SORT.PRICE_HIGH_TO_LOW);
		Assert.assertTrue("Successfully clicked on price high to low  ",priceH2L);
		
		System.out.println("Printing Product  Name, Display Price, Link to Product details page");
		fp.printData();
		
	}
	@AfterTest
	public void teardown()
	{
		extent.flush();
		driver.close();
		driver.quit();
		System.out.println("Closing browser");
	}
}
