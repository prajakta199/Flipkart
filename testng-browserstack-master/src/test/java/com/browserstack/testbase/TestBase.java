package com.browserstack.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.browserstack.utilities.Utility;

import java.io.IOException;
import java.time.Duration;

public class TestBase {
	public String browser, OS;
	public WebDriver driver;
    @BeforeTest(groups = {"Search","Purchase"})
    public void launchBrowser(String browser)throws Exception {
        if(browser.equalsIgnoreCase("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
    }
        else if (browser.equalsIgnoreCase("firefox"))
        {
        	driver= new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
        	driver= new EdgeDriver();
        }
        else
        {throw new Exception("Incorrect Browser");}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
    }
    @AfterMethod(groups = {"Search","Purchase"}) //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
            	Utility util = new Utility(driver);
                util.takeScreenShot();
            }
            catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }
    @AfterTest(groups = {"Search","Purchase"})
    public void logout(){
        driver.close();
    }
}