package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By uname=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[id='user_password']");
	By goButton=By.cssSelector("input[value='Log In']");
	
	public WebElement getUserName()
	{
		return driver.findElement(uname);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement goButton()
	{
		return driver.findElement(goButton);
	}
	

}
