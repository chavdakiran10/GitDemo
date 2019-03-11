package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void browserInvok() throws IOException
	{
		driver=initializeDriver();
		driver.get(url);
		log.info("Driver is initialized and url is hit");
	}
	
	
	@Test
	public void checkTitle() 
	{
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Validated title");
		
		
	}
	
	@Test
	public void checkBar()
	{
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getBar().isDisplayed(), false);
		log.info("Navigation bar is displayed");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
