package auto_basecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Basecode {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters("browsername")
	public void startbrow(String browsername)
	
	
	{
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
		   this.driver = new ChromeDriver();
		    driver.get("https://www.zoho.com/crm/login.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./geckdriv/geckodriver");
		    this.driver = new FirefoxDriver();
		    driver.get("https://www.zoho.com/crm/login.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
	
		
	}
	
	@AfterMethod
	public void aftermeth() {
		driver.close();
	}

}
