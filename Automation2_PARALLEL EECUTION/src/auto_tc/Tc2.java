package auto_tc;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import auto.pagecrm.Crmpage;

import auto.property.Propertyread;
import auto_basecode.Basecode;
import auto_datadriven.Datareader;



public class Tc2 extends Basecode{
	
	
	@Test(dataProvider="excel", dataProviderClass=Datareader.class)
	public void tc2(String usr, String pass, String Phone, String Company, String lastname, String emailid) throws InterruptedException, IOException {
		 test = reports.startTest("Test case 2 started");
		   
		
		test.log(LogStatus.INFO, "Test case2 validation");
		
		test.log(LogStatus.INFO, test.addScreenCapture(Propertyread.snapshot(driver,"TC02")) + "Success");
		Crmpage crm = new Crmpage(driver);
		crm.signin();
		crm.email(usr);
		Thread.sleep(2000);
		System.out.println("Thread id: " + Thread.currentThread().getId());
		System.out.println("Test name:" + "Test2");
		//Assert.assertEquals(false, true);
	/*	crm.pwd(pass);
		crm.Lead();
		Thread.sleep(5000);
		crm.createlead();
		//crm.phnfd(Phone);
		crm.comfd(Company);
		crm.lastnmfd(lastname);
		crm.emailfd(lastname);
		crm.leadsts();
		//added new code
		*/
	}

}
