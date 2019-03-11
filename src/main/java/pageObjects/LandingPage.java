package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By loginButton=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public WebElement getLogin()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getBar()
	{
		return driver.findElement(navBar);
	}

}
