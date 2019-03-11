package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	
	
	@BeforeTest
	public void invokDriver() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		log.info("GIT update 1");
		
	}
	

	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String password, String text)  
	{
		driver.get(url);
		log.info("Clicking on URL");
		LandingPage l=  new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.goButton().click();
		System.out.println(text);
		log.info("Successfully Validated "+userName);
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="Kiran_a@gmail.com";
		obj[0][1]="23213dfds";
		obj[0][2]="Restricted";
		obj[1][0]="aarohi_a@gmail.com";
		obj[1][1]="kjdlksfd";
		obj[1][2]="NonRestricted";
		
		return obj;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		driver=null;
	}

}
