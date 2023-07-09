package auto_basecode;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import auto.property.Propertyread;

public class Basecode {
	
	public  WebDriver driver;
	
	public  static ExtentReports reports;
	 public static ExtentTest test;
	@BeforeClass
	@Parameters("browsername")
	public void startbrow(String browsername)
	
	
	
	{
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
		   this.driver = new ChromeDriver();
		   
		   //Extent reports
		   reports = new ExtentReports("./test-output/reports.html",true);
		  
		    driver.get("https://www.zoho.com/crm/login.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./geckdriv/geckodriver");
		   this. driver = new FirefoxDriver();
		    driver.get("https://www.zoho.com/crm/login.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	
		
	}
	
	@AfterMethod
	public void aftermeth(ITestResult result) {
	
		if (ITestResult.FAILURE==result.getStatus()) {
			try {
				Propertyread propertyread = new Propertyread();
				propertyread.snapshotforfailed(driver, result.getName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		reports.endTest(test);
		reports.flush();
		driver.close();
	}
	



}
