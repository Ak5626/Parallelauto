package auto.pagecrm;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Crmpage {
	
	WebDriver driver ;
	public Crmpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void signin() {
		
	 driver.findElement(By.xpath("//a[@class='zlogin-apps']")).click();
	 Assert.assertEquals(true, false);
	}	 
	
	public void email(String usr) {
		driver.findElement(By.id("login_id")).sendKeys(usr);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	public void pwd(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@class='btn blue' and @id='nextbtn']")).click();
	}
	public void Lead() {
		driver.findElement(By.xpath("//a[text()='Leads']/parent::li")).click();	
		driver.findElement(By.xpath("//a[text()='Leads']/parent::li")).click();	
	}
	public void createlead() {
	    WebDriverWait waits = new WebDriverWait(driver, 20);
	    waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='NOT NOW']"))));
	    driver.findElement(By.xpath("//span[text()='NOT NOW']")).click();
	    waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@title='Quick Actions']"))));
	    driver.findElement(By.xpath("//i[@title='Quick Actions']")).click();
		driver.findElement(By.xpath("//li[text()='+ Lead']")).click();
	}
    public void phnfd(String Phone) {
	 driver.findElement(By.xpath("//input[@id='Crm_Leads_PHONE_LInput']")).sendKeys("Phone");
    }
    public void comfd(String company) {
   	 driver.findElement(By.xpath("//input[@id='inputId' and @tabindex='8']")).sendKeys("company");
       }
    public void lastnmfd(String lastname) {
   	 driver.findElement(By.xpath("//input[@id='Crm_Leads_LASTNAME_LInput']")).sendKeys("lastname");
       }
    public void emailfd(String emailid) {
   	 driver.findElement(By.xpath("//input[@id='Crm_Leads_EMAIL_LInput']")).sendKeys("emailid");
       }
    public void leadsts() {
    	Actions act = new Actions(driver);
    	act.sendKeys(Keys.PAGE_DOWN).build().perform();
    	driver.findElement(By.xpath("//div[@class='lyteDummyEventContainer' and @tabindex='20']")).click();
    	driver.findElement(By.xpath("//lyte-drop-item[@data-value='Attempted to Contact']")).click();
    }
}
